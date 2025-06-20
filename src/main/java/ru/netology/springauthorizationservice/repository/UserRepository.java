package ru.netology.springauthorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springauthorizationservice.service.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private static final Map<String, String> USER_PASSWORDS = Map.of(
            "alice", "password123",
            "bob", "qwerty",
            "charlie", "letmein"
    );

    private static final Map<String, List<Authorities>> USER_AUTHORITIES = Map.of(
            "alice", List.of(Authorities.READ, Authorities.WRITE),
            "bob", List.of(Authorities.READ),
            "charlie", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        String storedPassword = USER_PASSWORDS.get(user);
        if (storedPassword != null && storedPassword.equals(password)) {
            return USER_AUTHORITIES.getOrDefault(user, Collections.emptyList());
        }
        return Collections.emptyList();
    }
}

