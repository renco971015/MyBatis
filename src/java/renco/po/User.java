package renco.po;

/**
 * Copyright (C), 2012-2013, 上海睿民互联网科技有限公司
 * FileName: T101011.java
 *
 * @author: Renco
 * @Date: 2018-11-25 13:23
 * Description:
 * History: //修改记录
 * Renco 2013-07-02 16:46:23 0.1
 */
public class User {
    private int id;
    private String username;
    private int age;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public User(int id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
