package kata.spring_security.service;

import kata.spring_security.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    boolean add(Role role);

    List<Role> getList();

    Role getRole(int id);

    void deleteRole(int id);

    void editRole(Role role);


    List<Role> listByRole(List<String> name);
}
