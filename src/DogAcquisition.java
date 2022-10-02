import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DogAcquisition implements Observable {

    List<Observer> observers = new ArrayList<>();

    public DogAcquisition() {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dogacquisition", "postgres", "1234");
             PreparedStatement st = con.prepareStatement("SELECT * FROM clients");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Client client = new Client(rs.getString("user_name"), rs.getString("dog_speecy"));
                observers.add(client);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dogacquisition", "postgres", "1234");
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

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dogacquisition", "postgres", "1234");
             Statement st = con.createStatement()) {
            Client client = (Client) o;
            String query = "DELETE FROM clients WHERE user_name = \'" + client.getName() + "\'";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void notifyObserver(String observerName) {
        for (Observer observer : observers) {
            if (observer.getName().equals(observerName)) {
                observer.update();
            }
        }
    }
}
