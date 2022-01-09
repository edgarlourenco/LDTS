package com.aor.refactoring.example4;

public class Worker extends Person {
    private final String username;
    private final String password;

    public Worker(String name, String phone, String username, String password) {
        super(name, phone);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }
}
