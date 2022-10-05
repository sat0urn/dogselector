package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Akita_Inu extends SelectedDog {

    public Akita_Inu() {
        description = "Akita Inu";
    }

    @Override
    public double cost() {
        return 1.24;
    }
}
