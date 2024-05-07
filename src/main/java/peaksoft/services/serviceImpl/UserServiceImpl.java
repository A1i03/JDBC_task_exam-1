package peaksoft.services.serviceImpl;

import peaksoft.dao.UserDao;
import peaksoft.dao.daoImpl.UserDaoImpl;
import peaksoft.models.User;
import peaksoft.services.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void createUserTable() {
        userDao.createUserTable();
    }

    @Override
    public User getUserById(Long UserId) {
        return userDao.getUserById(UserId);
    }

    @Override
    public void updateUser(Long id, User newUser) {
    userDao.updateUser(id,newUser);
    }

    @Override
    public void deleteUserByID(Long id) {
    userDao.deleteUserByID(id);
    }

    @Override
    public void getUserRole(String role) {
    userDao.getUserRole(role);
    }
}
