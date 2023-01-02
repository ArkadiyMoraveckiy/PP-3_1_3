package kata.spring_security.service;

import kata.spring_security.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(User user);

    List<User> getList();

    User getUser(int id);

    void deleteUser(int id);

    void editUser(User user);
}
