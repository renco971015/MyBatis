package renco.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import renco.po.User;

/**
 * Copyright (C), 2012-2013, 上海睿民互联网科技有限公司
 * FileName: T101011.java
 *
 * @author: Renco
 * @Date: 2018-11-26 10:27
 * Description:
 * History: //修改记录
 * Renco 2013-07-02 16:46:23 0.1
 */
public class UserDaoImpl implements UserDao{

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = (User)sqlSession.selectOne("findUserById",1);
        sqlSession.close();
        return user;
    }
}
