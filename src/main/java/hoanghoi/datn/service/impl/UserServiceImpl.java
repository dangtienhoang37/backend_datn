package hoanghoi.datn.service.impl;

import hoanghoi.datn.dto.request.Creation.UserCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.User;
import hoanghoi.datn.exception.CustomException;
import hoanghoi.datn.exception.ErrorCode;
import hoanghoi.datn.mapper.UserMapper;
import hoanghoi.datn.repository.AccountRepository;
import hoanghoi.datn.repository.UserRepository;
import hoanghoi.datn.service.CloudinaryService;
import hoanghoi.datn.service.UserService;
import hoanghoi.datn.util.JWToken;
import hoanghoi.datn.util.UserUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JWToken jwToken;
    @Autowired
    private UserUtils userUtils;
    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public ApiResponse adminGetAllUser() {
        return null;
    }

    @Override
    public ApiResponse adminGetDetailUser() {
        return null;
    }

    @Override
    public ApiResponse booking() {
        return null;
    }

    @Override
    public ApiResponse getListParking() {
        return null;
    }

    @Override
    @Transactional
    public ApiResponse updateAvatar(String token, MultipartFile file) {
        try {
            User targetUser = userUtils.findUserFromToken(token);
            var imgUrl = cloudinaryService.uploadImg(file);
            targetUser.setUserImg(imgUrl);
            new ApiResponse<User>();
            return ApiResponse.builder()
                    .code(1000)
                    .message("upload img sucessfully")
                    .isSucess(true)
                    .data(userRepository.save(targetUser))
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public ApiResponse addInfor(String token, UserCreationRequest request) {
        try {
            var idAccount = jwToken.getIdFromToken(token);
            var Account = accountRepository.findById(idAccount).orElse(null);
            if (Objects.isNull(Account)) {
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            UUID idUser = Account.getUser().getId();
            User targetUser = userRepository.findById(idUser).orElse(null);
            if(Objects.isNull(targetUser)) {
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            var user = userMapper.toUser(request);
            user.setUserImg(targetUser.getUserImg());
            user.setId(targetUser.getId());
            // setinit false
            new ApiResponse<User>();
            Account.setInit(false);
            accountRepository.save(Account);
            return ApiResponse.builder()
                    .code(1000)
                    .message("create User infor Sucessfully")
                    .isSucess(true)
                    .data(userRepository.save(user))
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    @Override
    public ApiResponse updatePersonalInformation(String token, UserCreationRequest request) {
        try {
            var id = jwToken.getIdFromToken(token);
            var Account = accountRepository.findById(id).orElse(null);
            if (Objects.isNull(Account)) {
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            UUID idUser = Account.getUser().getId();
            User targetUser = userRepository.findById(idUser).orElse(null);
            if(Objects.isNull(targetUser)) {
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            var user = userMapper.toUser(request);
            user.setId(targetUser.getId());
            user.setTransactionWallet(targetUser.getTransactionWallet());
            user.setUserImg(targetUser.getUserImg());
            var obj = userRepository.save(user);
            // setinit false
            Account.setInit(false);
            accountRepository.save(Account);
            new ApiResponse<User>();

            // save img

            return ApiResponse.builder()
                    .code(1000)
                    .message("admin create User infor Sucessfully")
                    .isSucess(true)
                    .data(obj)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("loi tai day", e);
        }
    }

    @Override
    public ApiResponse getDetailUser(String token) {
        try {
            var AccountId = jwToken.getIdFromToken(token);
            var account = accountRepository.findById(AccountId).orElse(null);
            if(Objects.isNull(account)) {
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            var user = userRepository.findById(account.getUser().getId()).orElse(null);
            if(Objects.isNull(user)) {
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            new ApiResponse<User>();
            return ApiResponse.builder()
                    .code(1000)
                    .isSucess(true)
                    .message("get detail sucessfully!")
                    .data(user)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public ApiResponse adminCreateUserInfor(String token, UserCreationRequest request, UUID id, MultipartFile file) {

        try {
            var Account = accountRepository.findById(id).orElse(null);
            if (Objects.isNull(Account)) {
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            UUID idUser = Account.getUser().getId();
            User targetUser = userRepository.findById(idUser).orElse(null);
            if(Objects.isNull(targetUser)) {
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            var user = userMapper.toUser(request);
            user.setId(targetUser.getId());
            user.setTransactionWallet(targetUser.getTransactionWallet());
            var obj = userRepository.save(user);
            // setinit false
            Account.setInit(false);
            accountRepository.save(Account);
            new ApiResponse<User>();

            // save img
            var imgUrl = cloudinaryService.uploadImg(file);
            targetUser.setUserImg(imgUrl);
            return ApiResponse.builder()
                    .code(1000)
                    .message("admin create User infor Sucessfully")
                    .isSucess(true)
                    .data(obj)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("loi tai day", e);
        }
    }
}
