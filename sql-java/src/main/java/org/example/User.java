package org.example;

import java.sql.Connection;

public class User {

    private Connection connection;

    public void UserDAO(Connection conn) {
        connection = conn;
    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    private String name;
    private String phone;
    private Long id;

    public User(String username, String phone) {
        this.name = username;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
