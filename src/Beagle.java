import behaviors_and_realizations.Intellect_realizations.Trained;
import behaviors_and_realizations.lifestyle_realizations.Domestic;
import behaviors_and_realizations.mood_realizations.Active;
import behaviors_and_realizations.size_realizations.Medium;

public class Beagle extends Dog {
    @Override
    public void display() {
        System.out.println("You should peek Beagle");
        System.out.println("Beagle features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Medium().size() + "\n" +
                "3. " + new Active().mood() + "\n" +
                "4. " + new Domestic().lifestyle());
    }
}
