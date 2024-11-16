package hoanghoi.datn.service;

import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.loginRequest;
import hoanghoi.datn.dto.request.Update.AccountUpdatePassword;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.enumvar.Role;
import org.springframework.http.ResponseEntity;

import java.util.UUID;


public interface AccountService {

    // nhớ truyền params ********************

    //admin Space
    ApiResponse adminGetAllAccount(Role role);
    ApiResponse adminGetDetailAccount();
    ApiResponse adminDisableAccount();
    //end Admin Space


    ApiResponse login(loginRequest req);

    ApiResponse register(AccountCreationRequest req);
    ApiResponse logout();

    ApiResponse regCard();

    ApiResponse getDetailAccount(String Token);

    ApiResponse changePassword(String Token, AccountUpdatePassword request);

    ApiResponse createStaffAccount(AccountCreationRequest request);
}
