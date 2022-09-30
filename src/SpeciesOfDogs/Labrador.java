package SpeciesOfDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Big;

public class Labrador extends Dog {
    private final String dogSpeecy = "Labrador";

    public String getDogSpeecy() {
        return this.dogSpeecy;
    }

    @Override
    public void display() {
        System.out.println("You should peek Labrador");
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Calm().mood() + "\n" +
                "4. " + new Domestic().lifestyle());
    }
}
