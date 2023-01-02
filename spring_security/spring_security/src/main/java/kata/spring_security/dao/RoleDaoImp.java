package kata.spring_security.dao;

import kata.spring_security.model.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao, Converter<String, Role> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean add(Role role) {
        entityManager.persist(role);
        return true;
    }

    @Override
    public Role convert(String id) {
        Role role = new Role();
        role.setId(Integer.valueOf(id));
        return role;
    }

    @Override
    public Role getRole(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> getList() {
        return entityManager.createQuery("select s from Role s", Role.class).getResultList();
    }

    @Override
    public void deleteRole(int id) {
        entityManager.remove(getRole(id));
    }

    @Override
    public void editRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public List<Role> listByName(List<String> name) {
        return entityManager.createQuery("select u from Role u where u.role in (:id)", Role.class)
                .setParameter("id", name)
                .getResultList();
    }

    @Override
    public Role findByName(String name) {
        return entityManager.createQuery("select u from Role where u.role = :id", Role.class)
                .setParameter("id", name)
                .getResultList().stream().findAny().orElse(null);
    }
}