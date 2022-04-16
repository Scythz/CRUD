package kataCRUD.dao;

import kataCRUD.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    private static int PEOPLE_COUNT;
    private final List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++PEOPLE_COUNT, "Tom", 1, "Davis@gmail.com"));
        users.add(new User(++PEOPLE_COUNT, "Bob", 2, "Wallow@gmail.com"));
        users.add(new User(++PEOPLE_COUNT, "Mike", 3, "Casey@gmail.com"));
        users.add(new User(++PEOPLE_COUNT, "Katy", 4, "Garcia@gmail.com"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser){
        User toBeUpdated = show(id);
        toBeUpdated.setName(updatedUser.getName());
        toBeUpdated.setAge(updatedUser.getAge());
        toBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId()==id);
    }
}
