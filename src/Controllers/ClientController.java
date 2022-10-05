package Controllers;

import DBProperties.DBConfig;
import Models.Client;
import Observer.Observer;
import com.sun.tools.javac.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientController {
    public List<Observer> getAllClients() {
        List<Observer> observers = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             PreparedStatement st = con.prepareStatement("SELECT * FROM clients");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Client client = new Client(
                        rs.getString("dog_buyer"),
                        rs.getString("dog_speecy"),
                        rs.getString("date")
                );
                observers.add(client);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return observers;
    }

    public void addNewClient(Observer o) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            Client client = (Client) o;
            String query = "INSERT INTO clients VALUES (\'" + client.getDogBayer() + "\', \'"
                    + client.getDogSpeecy() + "\', \'" + client.getDate() + "\')";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void removeClient(Observer o) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            Client client = (Client) o;
            ResultSet rs = st.executeQuery("SELECT * FROM clients");
            while (rs.next()) {
                String full_name = rs.getString("user_firstname") + " " + rs.getString("user_lastname");
                if (full_name.equals(client.getName())) {
                    String query = "DELETE FROM clients WHERE login = \'" + rs.getString("login") + "\'";
                    st.executeUpdate(query);
                }
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

   /* public void sendMessageToClient(Observer.Observer o) {
        try (Connection con = DriverManager.getConnection(Controllers.DBProperties.URL, Controllers.DBProperties.NAME, Controllers.DBProperties.PASSWORD);
             Statement st = con.createStatement()) {
            Models.Client client = (Models.Client) o;
            ResultSet rs = st.executeQuery("SELECT * FROM clients");
            while (rs.next()) {
                if (client.getName().equals(rs.getString("dog_buyer")) &&
                    client.getDogSpeecy().equals(rs.getString("dog_speecy"))) {
                    String message = client.getName() + " is waiting for " +
                            client.getDogSpeecy() + ", date to pickup is: " + client.getDate();

                    String[] splits = client.getName().split(" ");

                    String query = "UPDATE users SET messages = array_append(messages, " + message.toString() + ")" +
                            " WHERE user_firstname = " + splits[0] + " AND WHERE user_lastname = " + splits[1];
                    st.executeQuery(query);
                }
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }*/

}
