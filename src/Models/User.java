package Models;

import java.sql.Array;

public class User {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private Array messages;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String firstname, String lastname, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }

    public User(String firstname, String lastname, String login, String password, Array messages) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.messages = messages;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Array getMessages() {
        return this.messages;
    }
}
