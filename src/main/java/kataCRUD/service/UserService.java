package kataCRUD.service;

import kataCRUD.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
