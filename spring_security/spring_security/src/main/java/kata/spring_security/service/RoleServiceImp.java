package kata.spring_security.service;

import kata.spring_security.dao.RoleDao;
import kata.spring_security.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public boolean add(Role role) {
        roleDao.add(role);
        return true;
    }

    @Override
    @Transactional
    public List<Role> getList() {
        return roleDao.getList();
    }

    @Override
    @Transactional
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        roleDao.deleteRole(id);
    }

    @Override
    @Transactional
    public void editRole(Role role) {
        roleDao.editRole(role);
    }

    @Override
    @Transactional
    public List<Role> listByRole(List<String> name) {
        return roleDao.listByName(name);
    }
}
