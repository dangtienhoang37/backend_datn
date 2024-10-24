package hoanghoi.datn.service;

import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.loginRequest;
import hoanghoi.datn.dto.request.Update.AccountUpdatePassword;
import hoanghoi.datn.dto.response.ApiResponse;

import java.util.UUID;


public interface AccountService {

    // nhớ truyền params ********************

    //admin Space
    ApiResponse adminGetAllAccount();
    ApiResponse adminGetDetailAccount();
    ApiResponse adminDisableAccount();
    //end Admin Space


    ApiResponse login(loginRequest req);

    ApiResponse register(AccountCreationRequest req);
    ApiResponse logout();

    ApiResponse regCard();

    ApiResponse getDetailAccount(UUID id);

    ApiResponse changePassword(AccountUpdatePassword request);
}
