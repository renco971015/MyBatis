package renco.mapper;

import renco.po.User;
import renco.po.UserCustom;
import renco.po.UserQueryVo;

import java.util.List;

public interface UserMapper {

    public User findUserById(int id);

    public List<User> findUserByName(String username);

    public void addUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);

    public List<User> findUserList(UserQueryVo userQueryVo);

    public int findUserCount(UserQueryVo userQueryVo);
}
