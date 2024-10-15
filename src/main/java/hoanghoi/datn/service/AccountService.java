package hoanghoi.datn.service;

import hoanghoi.datn.dto.AccountCreationRequest;
import hoanghoi.datn.dto.ApiResponse;
import hoanghoi.datn.dto.loginRequest;
import hoanghoi.datn.enumvar.Role;
import hoanghoi.datn.entity.Account;
import hoanghoi.datn.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public ApiResponse createUserAccount(AccountCreationRequest req) {
        ApiResponse res = new ApiResponse();
        try {
            Account account= new Account();

            account.setUserName(req.getUserName());
            account.setPassword(req.getPassword());
            account.setRole(Role.USER);
            account.setIdUser(req.getIdUser());
            accountRepository.save(account);
            res.setCode(1000);
            res.setMessage("Create User Sucessfully");
            res.setResult(account);
        } catch (DataIntegrityViolationException e) {
            res.setCode(1001);
            res.setMessage("Failed to create user account: Data Integrity Violation - " + e.getMessage());
        } catch (Exception e) {
            res.setCode(1002);  // General error code
            res.setMessage("Failed to create user account: " + e.getMessage());
        }

        return res;

    }

//    public Account login(LoginRequest request) {
//
//    }
}
