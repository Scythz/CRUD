package kataCRUD.dao;

import kataCRUD.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> index() {
        return em.createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return em.createQuery("select u from User u where u.id=: param", User.class)
                .setParameter("param", id).getSingleResult();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(int id, User updatedUser){
        User toBeUpdated = show(id);
        toBeUpdated.setName(updatedUser.getName());
        toBeUpdated.setAge(updatedUser.getAge());
        toBeUpdated.setEmail(updatedUser.getEmail());
        em.merge(toBeUpdated);
    }

    @Override
    public void delete(int id) {
        em.createQuery("DELETE FROM User u where u.id = :param")
                .setParameter("param", id).executeUpdate();
    }
}
