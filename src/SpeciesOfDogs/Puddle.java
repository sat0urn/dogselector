package SpeciesOfDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Big;
import Behaviors_and_Realizations.size_realizations.Medium;

public class Puddle extends Dog {
    private final String dogSpeecy = "Puddle";

    @Override
    public void display() {
        System.out.println("You should peek " + dogSpeecy);
        System.out.println(dogSpeecy + " features are \n" +
                "1. " + new NoTrained().intellect() + "\n" +
                "2. " + new Medium().size() + "\n" +
                "3. " + new Calm().mood() + "\n" +
                "4. " + new Domestic().lifestyle());
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }
}
