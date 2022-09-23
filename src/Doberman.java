import behaviors_and_realizations.Intellect_realizations.Trained;
import behaviors_and_realizations.lifestyle_realizations.Street;
import behaviors_and_realizations.mood_realizations.Aggressive;
import behaviors_and_realizations.size_realizations.Big;

public class Doberman extends Dog {
    @Override
    public void display() {
        System.out.println("You should peek Doberman");
        System.out.println("Doberman features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Aggressive().mood() + "\n" +
                "4. " + new Street().lifestyle());
    }
}
