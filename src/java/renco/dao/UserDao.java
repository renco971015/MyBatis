package renco.dao;

import renco.po.User;

public interface UserDao {

    public User findUserById(int id) throws Exception;
}
