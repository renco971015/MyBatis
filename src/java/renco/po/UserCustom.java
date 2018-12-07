package renco.po;

/**
 * Copyright (C), 2012-2013, 上海睿民互联网科技有限公司
 * FileName: T101011.java
 *
 * @author: Renco
 * @Date: 2018-11-26 14:02
 * Description:
 * History: //修改记录
 * Renco 2013-07-02 16:46:23 0.1
 */
public class UserCustom extends User{

    //用户信息
    private User user;

    //自定义user的扩展对象

    private UserCustom userCustom;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
