package Behaviors_and_Realizations.size_realizations;

import Behaviors_and_Realizations.SizeBehavior;

public class Medium implements SizeBehavior {
    @Override
    public String size() {
        return "MEDIUM";
    }

    @Override
    public boolean size(String size) {
        return size().equals(size);
    }
}
