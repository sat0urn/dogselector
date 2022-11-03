package Controllers;

import Behaviors_and_Realizations.IntellectBehavior;
import Behaviors_and_Realizations.LifestyleBehavior;
import Behaviors_and_Realizations.MoodBehavior;
import Behaviors_and_Realizations.SizeBehavior;
import DBProperties.DBConfig;
import com.sun.tools.javac.Main;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DogController {
    public static String getDogName(SizeBehavior sizeBehavior, MoodBehavior moodBehavior, LifestyleBehavior lifestyleBehavior, IntellectBehavior intellectBehavior) {
        String dogBreed = null;
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             Statement st = con.createStatement()) {
            String query = "SELECT * FROM dog_breeds " +
                    "WHERE " +
                    "dog_size = \'" + sizeBehavior.size() + "\' AND " +
                    "dog_mood = \'" + moodBehavior.mood() + "\' AND " +
                    "dog_lifestyle = \'" + lifestyleBehavior.lifestyle() + "\' AND " +
                    "dog_intellect = \'" + intellectBehavior.intellect() + "\'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
                dogBreed = rs.getString("dog_name");
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return dogBreed;
    }
}
