package services;

import model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(String id);

    User saveUser(User user);

    void deleteUser(String id);
}
