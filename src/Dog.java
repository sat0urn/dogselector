import behaviors_and_realizations.*;
import behaviors_and_realizations.Intellect_realizations.NoTrained;
import behaviors_and_realizations.Intellect_realizations.Trained;
import behaviors_and_realizations.lifestyle_realizations.Domestic;
import behaviors_and_realizations.lifestyle_realizations.Street;
import behaviors_and_realizations.mood_realizations.Active;
import behaviors_and_realizations.mood_realizations.Aggressive;
import behaviors_and_realizations.mood_realizations.Calm;
import behaviors_and_realizations.size_realizations.Big;
import behaviors_and_realizations.size_realizations.Medium;
import behaviors_and_realizations.size_realizations.Small;

public abstract class Dog {

    public abstract void display();

    private IntellectBehavior intellectBehavior;
    private SizeBehavior sizeBehavior;
    private MoodBehavior moodBehavior;
    private LifestyleBehavior lifestyleBehavior;

    public void defineTypeOfDog(String[] dogs) {
        if (dogs[0].equals(new Calm().mood()) &&
            dogs[1].equals(new Big().size()) &&
            dogs[2].equals(new Domestic().lifestyle()) &&
            dogs[3].equals(new Trained().intellect()))
            new Labrador().display();
        else if (dogs[0].equals(new Aggressive().mood()) &&
                dogs[1].equals(new Small().size()) &&
                dogs[2].equals(new Domestic().lifestyle()) &&
                dogs[3].equals(new NoTrained().intellect()))
            new Spitz().display();
        else if (dogs[0].equals(new Calm().mood()) &&
                dogs[1].equals(new Medium().size()) &&
                dogs[2].equals(new Domestic().lifestyle()) &&
                dogs[3].equals(new Trained().intellect()))
            new Corgi().display();
        else if (dogs[0].equals(new Active().mood()) &&
                dogs[1].equals(new Medium().size()) &&
                dogs[2].equals(new Domestic().lifestyle()) &&
                dogs[3].equals(new Trained().intellect()))
            new Beagle().display();
        else if (dogs[0].equals(new Aggressive().mood()) &&
                dogs[1].equals(new Big().size()) &&
                dogs[2].equals(new Street().lifestyle()) &&
                dogs[3].equals(new Trained().intellect()))
            new Doberman().display();
        else
            System.out.println("We don't have that dog, sorry...");
    }

    public void setIntellectBehavior(IntellectBehavior intellectBehavior) {
        this.intellectBehavior = intellectBehavior;
    }
    public String getIntellectBehavior() {
        return this.intellectBehavior.intellect();
    }

    public void setSizeBehavior(SizeBehavior sizeBehavior) {
        this.sizeBehavior = sizeBehavior;
    }
    public String getSizeBehavior() {
        return this.sizeBehavior.size();
    }

    public void setMoodBehavior(MoodBehavior moodBehavior) {
        this.moodBehavior = moodBehavior;
    }
    public String getMoodBehavior() {
        return this.moodBehavior.mood();
    }

    public void setLifestyleBehavior(LifestyleBehavior lifestyleBehavior) {
        this.lifestyleBehavior = lifestyleBehavior;
    }
    public String getLifestyleBehavior() {
        return this.lifestyleBehavior.lifestyle();
    }
}
