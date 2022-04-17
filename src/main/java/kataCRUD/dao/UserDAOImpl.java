package kataCRUD.dao;

import kataCRUD.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
//    private static int PEOPLE_COUNT;
//    private final List<User> users;
//
//    {
//        users = new ArrayList<>();
//
//        users.add(new User(++PEOPLE_COUNT, "Tom", 1, "Davis@gmail.com"));
//        users.add(new User(++PEOPLE_COUNT, "Bob", 2, "Wallow@gmail.com"));
//        users.add(new User(++PEOPLE_COUNT, "Mike", 3, "Casey@gmail.com"));
//        users.add(new User(++PEOPLE_COUNT, "Katy", 4, "Garcia@gmail.com"));
//    }

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
