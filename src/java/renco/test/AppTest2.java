package renco.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import renco.po.User;

import java.io.IOException;
import java.io.InputStream;
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
public class AppTest2 {

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
    public void testAddUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User("Marisha",20);
        sqlSession.insert("addUser",user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("当前插入用户的id"+user.getId());
    }
}
