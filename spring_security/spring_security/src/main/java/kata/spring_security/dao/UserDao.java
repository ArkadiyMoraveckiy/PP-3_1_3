package kata.spring_security.dao;



import kata.spring_security.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getList();

    User getUser(int id);

    void deleteUser(int id);

    void editUser(User user);

    UserDetails getUser(String username);
}
