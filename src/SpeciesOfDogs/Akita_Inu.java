package SpeciesOfDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Big;

public class Akita_Inu extends Dog {
    private final String dogSpeecy = "Akita Inu";

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Calm().mood() + "\n" +
                "4. " + new Street().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }
}
