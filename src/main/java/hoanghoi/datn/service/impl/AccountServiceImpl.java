package hoanghoi.datn.service.impl;

import hoanghoi.datn.config.CustomPasswordEncoder;
import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.loginRequest;
import hoanghoi.datn.dto.request.Update.AccountUpdatePassword;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.Account;
import hoanghoi.datn.entity.TransactionWallet;
import hoanghoi.datn.entity.User;
import hoanghoi.datn.enumvar.Role;
import hoanghoi.datn.exception.CustomException;
import hoanghoi.datn.exception.ErrorCode;
import hoanghoi.datn.mapper.AccountMapper;
import hoanghoi.datn.repository.AccountRepository;
import hoanghoi.datn.repository.UserRepository;
import hoanghoi.datn.repository.WalletRepository;
import hoanghoi.datn.service.AccountService;
import hoanghoi.datn.util.JWToken;
import hoanghoi.datn.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CustomPasswordEncoder passwordEncoder;
    @Autowired
    private JWToken jwToken;
    @Autowired
    private UserUtils userUtils;


    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse adminGetAllAccount(Role role) {

        ApiResponse res = new ApiResponse();
        res.setCode(1000);
        res.setMessage("get all Sucessfully!");
        res.setSucess(true);
        res.setData(accountRepository.findAllByRole(role));
        return res;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse adminGetDetailAccount() {
        return null;
    }


    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse adminDisableAccount(UUID id) {
        var targetAcc = accountRepository.findById(id).orElse(null);
        if(Objects.isNull(targetAcc)){
            throw new RuntimeException("cant find acc");
        }
        targetAcc.setActive(false);
        ApiResponse res = new ApiResponse();
        res.setCode(1000);
        res.setMessage("get all Sucessfully!");
        res.setSucess(true);
        res.setData(accountRepository.save(targetAcc));
        return res;
    }

    @Override
    public ApiResponse login(loginRequest req) {

        String username = req.getUserName();
        String password = req.getPassword();
        try {
            Optional<Account> existedAccount =  accountRepository.findByUserName(username);
            if(existedAccount.isEmpty()) {

                throw new CustomException(ErrorCode.USER_NOT_EXISTED);
            }
            Account acc  = existedAccount.get();
            if(passwordEncoder.checkPassword(password, acc.getPassword())) {
                String token = jwToken.genJWT(acc);
                // return res
                ApiResponse res = new ApiResponse();
                res.setCode(1000);
                res.setMessage("login Sucessfully!");
                res.setSucess(true);
                res.setData(token);

                return res;
            } else {

               throw new CustomException(ErrorCode.INVALID_PASSWORD);
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public ApiResponse register(AccountCreationRequest request) {
        try {
            String username = request.getUserName();
            if (accountRepository.existsByUserName(username))
                throw new CustomException(ErrorCode.USER_EXISTED);

            User newUser = new User();
            newUser.setUserImg("https://cdn-icons-png.flaticon.com/128/456/456212.png");
            userRepository.save(newUser);
            Account account = accountMapper.toAccount(request, passwordEncoder);
//            account.setIdUser(newUser.getId());
            account.setUser(newUser);
            var targetAccount = accountRepository.save(account);
            ApiResponse res = new ApiResponse();
            res.setCode(1000);
            res.setMessage("Register Sucessfully!");
            res.setSucess(true);
            res.setData(targetAccount);

            TransactionWallet wallet = new TransactionWallet().builder()
                    .balance(0)
                    .accountId(targetAccount.getId())
                    .build();
            newUser.setTransactionWallet(wallet);
            walletRepository.save(wallet);
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public ApiResponse logout() {
        return null;
    }

    @Override
    public ApiResponse regCard() {
        return null;
    }

    @Override
    public ApiResponse getDetailAccount(String token) {
        log.info(token);
        var AccountId = jwToken.getIdFromToken(token);
        var targetAcc = accountRepository.findById(AccountId).orElse(null);
        if(Objects.isNull(targetAcc)){
            throw new CustomException(ErrorCode.NOT_EXISTED);
        }

        ApiResponse res = new ApiResponse();
        res.setCode(1000);
        res.setSucess(true);
        res.setMessage("get detail sucessfully");
        res.setData(targetAcc);

        return res;
    }

    @Override
    public ApiResponse<?> changePassword(String Token,AccountUpdatePassword request) {
        // tu token lay ra userId
//        log.warn(        SecurityContextHolder.getContext().getAuthentication().getName());
        String currentPassword = request.getCurrentPassword();
        String newPassword = request.getNewPassword();
        String cofirmPassword = request.getConfirmPassword();

        if(Objects.equals(currentPassword, newPassword)){
            ApiResponse res = new ApiResponse();
            res.setSucess(false);
            res.setCode(1001);
            res.setMessage("please type another Password ");

            return res;
        }
        if(!Objects.equals(newPassword, cofirmPassword)) {
            ApiResponse res = new ApiResponse();
            res.setCode(1001);
            res.setSucess(false);

            res.setMessage("please type corect confirm Password ");

            return res;
        }

        try {

            var jwtClaims = jwToken.jwtDecoder(jwToken.TokenConcat(Token)).getClaims();
            UUID AccountId = UUID.fromString( (String) jwtClaims.get("Id"));
            var Account = accountRepository.findById(AccountId).orElse(null);
            if(Account != null) {
                if(!passwordEncoder.checkPassword(currentPassword,Account.getPassword())) {
                    throw new RuntimeException("Wrong current password");
                }
                Account.setPassword(passwordEncoder.encode(newPassword));

                ApiResponse res = new ApiResponse();
                res.setCode(1000);
                res.setSucess(true);
                res.setMessage("sucessfully");
                res.setData(accountRepository.save(Account));

                return res;
            } else {
                throw new RuntimeException("error");
            }



        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse createStaffAccount(AccountCreationRequest request) {
        try {
            String username = request.getUserName();
            if (accountRepository.existsByUserName(username))
                throw new CustomException(ErrorCode.USER_EXISTED);

            User newUser = new User();
            userRepository.save(newUser);
            Account account = accountMapper.toStaffAccount(request, passwordEncoder);

            account.setUser(newUser);
            account.setRole(Role.STAFF);
            ApiResponse res = new ApiResponse();
            res.setCode(1000);
            res.setSucess(true);
            res.setMessage("Register Sucessfully!");
            res.setData(accountRepository.save(account));

            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse forgotPassword(String email)  {


        try{
            var acc = userUtils.findAccountFromEmail(email);
            var resetToken = jwToken.genResetPasswordToken(acc);
            // send email
            new  ApiResponse<>();

            return ApiResponse.builder()
                    .isSucess(true)
                    .code(1000)
                    .message("send email sucessfully")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public ApiResponse getDetailAccByAdmin(UUID id) {
        var targetAcc = accountRepository.findById(id).orElse(null);
        if(Objects.isNull(targetAcc)){
            throw new CustomException(ErrorCode.NOT_EXISTED);
        }

        ApiResponse res = new ApiResponse();
        res.setCode(1000);
        res.setSucess(true);
        res.setMessage("get detail sucessfully");
        res.setData(targetAcc);

        return res;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse adminCreateAccount(AccountCreationRequest request) {
        try {
            String username = request.getUserName();
            if (accountRepository.existsByUserName(username))
                throw new CustomException(ErrorCode.USER_EXISTED);

            User newUser = new User();
            userRepository.save(newUser);
            Account account = accountMapper.toAccount(request, passwordEncoder);
//        Account acc = Account.builder().build();

//        Account account = new Account();
//        account.setUserName(request.getUserName());
//        account.setPassword(passwordEncoder.encode(request.getPassword()));
//        account.setRole(Role.USER);       ac
//            account.setIdUser(newUser.getId());
            account.setUser(newUser);
            ApiResponse res = new ApiResponse();
            res.setCode(1000);
            res.setSucess(true);
            res.setMessage("Register Sucessfully!");
            res.setData(accountRepository.save(account));

            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}