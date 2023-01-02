package kata.spring_security.dao;

import kata.spring_security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getList() {
        return entityManager.createQuery("select distinct u from User u left join fetch  u.roleList", User.class)
                .getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("delete User where id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public UserDetails getUser(String username) {
        return entityManager.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}