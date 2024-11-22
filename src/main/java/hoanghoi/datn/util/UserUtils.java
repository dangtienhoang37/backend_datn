package hoanghoi.datn.util;


import hoanghoi.datn.entity.Account;
import hoanghoi.datn.entity.User;
import hoanghoi.datn.repository.AccountRepository;
import hoanghoi.datn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;


@Component
public class UserUtils {
    @Autowired
    private JWToken jwToken;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;

    public User findUserFromToken(String token) {
        var AccountId = jwToken.getIdFromToken(token);
        var acc = accountRepository.findById(AccountId);

        User targetUser = userRepository.findById(acc.get().getUser().getId()).orElse(null);
        if(Objects.isNull(targetUser)){
            throw new RuntimeException("some thing wrong");
        }
        return targetUser;

    }
    public Account findAccountFromEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if(Objects.isNull(user)) {
            throw new RuntimeException("cant find user by email");

        }
        Account acc = accountRepository.findByUser(user).orElse(null);
        if(Objects.isNull(acc)) {
            throw new RuntimeException("cant find Account by userID");

        }
        return acc;
    }
}
