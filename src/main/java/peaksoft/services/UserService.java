package peaksoft.services;

import peaksoft.models.User;

public interface UserService {
    String addUser(User user);
    void createUserTable();
    User getUserById(Long UserId);
    void updateUser(Long id,User newUser);
    void deleteUserByID(Long id);
    void getUserRole(String role);
}
