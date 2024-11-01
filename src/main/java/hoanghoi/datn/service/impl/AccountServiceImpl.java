package hoanghoi.datn.service.impl;

import hoanghoi.datn.config.CustomPasswordEncoder;
import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.loginRequest;
import hoanghoi.datn.dto.request.Update.AccountUpdatePassword;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.Account;
import hoanghoi.datn.exception.CustomException;
import hoanghoi.datn.exception.ErrorCode;
import hoanghoi.datn.mapper.AccountMapper;
import hoanghoi.datn.repository.AccountRepository;
import hoanghoi.datn.service.AccountService;
import hoanghoi.datn.util.JWToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CustomPasswordEncoder passwordEncoder;
    @Autowired
    private JWToken jwToken;


    @Override
    public ApiResponse adminGetAllAccount() {
        ApiResponse res = new ApiResponse();
        res.setCode(1000);
        res.setMessage("Register Sucessfully!");
        res.setResult(accountRepository.findAll());
        return res;
    }

    @Override
    public ApiResponse adminGetDetailAccount() {
        return null;
    }

    @Override
    public ApiResponse adminDisableAccount() {
        return null;
    }

    @Override
    public ApiResponse login(loginRequest req) {

        String username = req.getUserName();
        String password = req.getPassword();
        try {
            Optional<Account> existedAccount =  accountRepository.findByUserName(username);
            if(existedAccount.isEmpty()) {
                ApiResponse resE = new ApiResponse();
                resE.setCode(1001);
                resE.setMessage("Account not found");
                resE.setResult("");
                return resE;
            }
            Account acc  = existedAccount.get();
            if(passwordEncoder.checkPassword(password, acc.getPassword())) {
                String token = jwToken.genJWT(acc);
                // return res
                ApiResponse res = new ApiResponse();
                res.setCode(1000);
                res.setMessage("login Sucessfully!");
                res.setResult(token);

                return res;
            } else {
                ApiResponse resE = new ApiResponse();
                resE.setCode(1001);
                resE.setMessage("Wrong information");
                resE.setResult("");
                return resE;
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


            Account account = accountMapper.toAccount(request, passwordEncoder);
//        Account acc = Account.builder().build();

//        Account account = new Account();
//        account.setUserName(request.getUserName());
//        account.setPassword(passwordEncoder.encode(request.getPassword()));
//        account.setRole(Role.USER);
            ApiResponse res = new ApiResponse();
            res.setCode(1000);
            res.setMessage("Register Sucessfully!");
            res.setResult(accountRepository.save(account));

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
    public ApiResponse getDetailAccount(UUID id) {

        ApiResponse res = new ApiResponse();
        res.setCode(1000);
        res.setMessage("Register Sucessfully!");
        res.setResult(accountRepository.findById(id));

        return res;
    }

    @Override
    public ApiResponse<?> changePassword(String Token,AccountUpdatePassword request) {
        // tu token lay ra userId
        String currentPassword = request.getCurrentPassword();
        String newPassword = request.getNewPassword();
        String cofirmPassword = request.getConfirmPassword();


        if(!Objects.equals(newPassword, cofirmPassword)) {
            ApiResponse res = new ApiResponse();
            res.setCode(1001);
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
                accountRepository.save(Account);
                ApiResponse res = new ApiResponse();
                res.setCode(1000);
                res.setMessage("sucessfully");

                return res;
            } else {
                throw new RuntimeException("error");
            }



        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}