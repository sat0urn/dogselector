import behaviors_and_realizations.Intellect_realizations.NoTrained;
import behaviors_and_realizations.lifestyle_realizations.Domestic;
import behaviors_and_realizations.mood_realizations.Aggressive;
import behaviors_and_realizations.size_realizations.Small;

public class Spitz extends Dog {
    @Override
    public void display() {
        System.out.println("You should peek Spitz");
        System.out.println("Spitz features are \n" +
                "1. " + new NoTrained().intellect() + "\n" +
                "2. " + new Small().size() + "\n" +
                "3. " + new Aggressive().mood() + "\n" +
                "4. " + new Domestic().lifestyle());
    }
}
