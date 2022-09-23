import behaviors_and_realizations.Intellect_realizations.Trained;
import behaviors_and_realizations.lifestyle_realizations.Domestic;
import behaviors_and_realizations.mood_realizations.Calm;
import behaviors_and_realizations.size_realizations.Big;

public class Labrador extends Dog {
    @Override
    public void display() {
        System.out.println("You should peek Labrador");
        System.out.println("Labrador features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Calm().mood() + "\n" +
                "4. " + new Domestic().lifestyle());
    }
}
