package kataCRUD.service;

import kataCRUD.dao.UserDAO;
import kataCRUD.dao.UserDAOImpl;
import kataCRUD.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override

    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);

    }

    @Override
    public void update(int id, User updatedUser) {
        userDAO.update(id,updatedUser);

    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
