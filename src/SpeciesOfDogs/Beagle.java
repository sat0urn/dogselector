package SpeciesOfDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.size_realizations.Medium;
import Behaviors_and_Realizations.size_realizations.Small;

public class Beagle extends Dog {
    private final String dogSpeecy = "Beagle";

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Small().size() + "\n" +
                "3. " + new Active().mood() + "\n" +
                "4. " + new Street().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }
}
