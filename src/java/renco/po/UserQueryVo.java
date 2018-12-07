package renco.po;

import java.util.List;

/**
 * Copyright (C), 2012-2013, 上海睿民互联网科技有限公司
 * FileName: T101011.java
 *
 * @author: Renco
 * @Date: 2018-11-26 13:53
 * Description:
 * History: //修改记录
 * Renco 2013-07-02 16:46:23 0.1
 */
public class UserQueryVo {

    //用户信息

    private User user;

    private List<Integer> ids;

    private UserCustom userCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }


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
