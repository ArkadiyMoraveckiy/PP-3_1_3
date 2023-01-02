package kata.spring_security.dao;

import kata.spring_security.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    boolean add(Role role);


    Role convert(String id);

    Role getRole(int id);


    List<Role> getList();

    void deleteRole(int id);

    void editRole(Role role);

    List<Role> listByName(List<String> name);

    Role findByName(String name);
}
