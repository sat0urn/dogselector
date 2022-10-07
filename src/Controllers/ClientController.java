package Controllers;

import DBProperties.DBConfig;
import Models.Client;
import Models.User;
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

    public void setServicesAndItsCost(Client client, String description, double cost) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM clients");
            while (rs.next()) {
                if (rs.getString("dog_buyer").equals(client.getName()) &&
                    rs.getString("dog_speecy").equals(client.getDogSpeecy())) {
                    String updateDescription = "UPDATE clients SET description = \'" + description + "\'" + " WHERE dog_speecy = \'" + client.getDogBreed() + "\'";
                    String updateCost = "UPDATE clients SET cost = \'" + cost + "$\'" + " WHERE dog_speecy = \'" + client.getDogBreed() + "\'";
                    st.executeUpdate(updateDescription);
                    st.executeUpdate(updateCost);
                    System.out.println("Client " + client.getName() + " is waiting for " + client.getDogBreed() + ", " +
                            "date to pickup is: " + client.getDate());
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static boolean hasThatDog(String dog_buyer, String dog_speecy) {
        boolean gate = true;
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM clients");
            while (rs.next()) {
                if (rs.getString("dog_buyer").equals(dog_buyer) &&
                    rs.getString("dog_speecy").equals(dog_speecy)) {
                    return gate;
                }
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return !gate;
    }
}
