package renco.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import renco.dao.UserDao;
import renco.dao.UserDaoImpl;
import renco.mapper.UserMapper;
import renco.po.User;
import renco.po.UserCustom;
import renco.po.UserQueryVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2012-2013, 上海睿民互联网科技有限公司
 * FileName: T101011.java
 *
 * @author: Renco
 * @Date: 2018-11-25 13:55
 * Description:
 * History: //修改记录
 * Renco 2013-07-02 16:46:23 0.1
 */
public class AppTest {

    SqlSessionFactory sqlSessionFactory = null;

    //测试通过id得到用户信息

    @Before
    public void init() throws IOException {
        InputStream inputStream =
                Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println("sqlSessionFactory----"+sqlSessionFactory);
    }
    @Test
    public void test(){
        System.out.println("sqlSession----"+sqlSessionFactory.openSession());
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //第一个参数是statement
        List<User> users = sqlSession.selectList("foundUserByName2","R");
        sqlSession.close();
        for(User user : users){
            System.out.println(user.getId()+","+user.getAge()+","+user.getUsername());
        }
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user.getId()+","+user.getUsername());
    }
    @Test
    public void testFindUserById2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user.getId()+","+user.getUsername());
    }

    @Test
    public void testFindUserByUsername(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserByName("Renco");
        for(User user:users){
            System.out.println(user.getId()+","+user.getUsername()+","+user.getAge());
        }
        sqlSession.close();
    }

    @Test
    public void testAddUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("Sasuke",19);
        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testdeleteUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(3);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindUserList() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom =  new UserCustom();
        userCustom.setUsername("R");
        userCustom.setAge(15);
        userQueryVo.setUserCustom(userCustom);
        List<User> users = userMapper.findUserList(userQueryVo);
        sqlSession.close();
        for(User user:users){
            System.out.println(user.getId()+","+user.getUsername());
        }
    }

    @Test
    public void testFindUserCount(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserCustom userCustom = new UserCustom();
        UserQueryVo userQueryVo = new UserQueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(5);
        userQueryVo.setIds(ids);
        userCustom.setUsername("R");
        userQueryVo.setUserCustom(userCustom);
        int count = userMapper.findUserCount(userQueryVo);
        System.out.println("包含R的个数"+count);
        sqlSession.close();
    }
}
