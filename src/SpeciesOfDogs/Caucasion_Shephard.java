package SpeciesOfDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Big;

public class Caucasion_Shephard extends Dog {
    private final String dogSpeecy = "Caucasian Shephard";

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new NoTrained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Aggressive().mood() + "\n" +
                "4. " + new Street().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }
}
