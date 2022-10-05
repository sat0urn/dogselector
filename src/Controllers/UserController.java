package Controllers;

import DBProperties.DBConfig;
import Models.User;
import com.sun.tools.javac.Main;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController {

    private boolean isLogin = false;
    private boolean adminIsLogin = false;

    public void login(User user) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            String query = "SELECT * FROM users WHERE login = \'" + user.getLogin() + "\'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("login").equals(user.getLogin())) {
                    if (rs.getString("password").equals(user.getPassword())) {
                        if (rs.getString("role").equals("ADMIN")) {
                            System.out.println("You are in admin account!");
                            this.adminIsLogin = true;
                        } else {
                            System.out.println("You are in account!");
                            this.isLogin = true;
                        }
                        return;
                    } else
                        System.out.println("Wrong password!");
                }
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        System.out.println("You don't have an account, please, do registration!");
    }

    public void register(User user) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {

            String allQuery = "SELECT * FROM users";
            ResultSet rs = st.executeQuery(allQuery);
            boolean hasLogin = false;

            while (rs.next()) {
                if (rs.getString("login").equals(user.getLogin())) {
                    System.out.println("This login is already have an account!");
                    hasLogin = true;
                    break;
                }
            }

            if (!hasLogin) {
                this.isLogin = true;
                String query = "INSERT INTO users (user_firstname, user_lastname, login, password, role) VALUES (\'" +
                        user.getFirstname() + "\', \'" +
                        user.getLastname() + "\', \'" +
                        user.getLogin() + "\', \'" +
                        user.getPassword() + "\', 'USER')";
                st.executeUpdate(query);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public User getUser(User user) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                if (user.getLogin().equals(rs.getString("login"))) {
                    user = new User(
                            rs.getString("user_firstname"),
                            rs.getString("user_lastname"),
                            rs.getString("login"),
                            rs.getString("password"),
                            rs.getArray("messages"));
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return user;
    }

    public void sendMessageToAdmin(User user, String dogBreed) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            String message = user.getFirstname() + " " +
                    user.getLastname() + " is waiting for " +
                    dogBreed + " , what date dog will be available to pick up?";

            String query = "UPDATE users SET messages = array_append(messages, \'" + message.toString() + "\')" +
                    " WHERE role = 'ADMIN'";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void setLoginStatement(boolean isLogin) {
        this.isLogin = isLogin;
    }
    public boolean getLoginStatement() {
        return this.isLogin;
    }

    public void setAdminIsLogin(boolean adminIsLogin) {
        this.adminIsLogin = adminIsLogin;
    }
    public boolean getAdminIsLogin() {
        return this.adminIsLogin;
    }
}
