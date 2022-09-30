import SpeciesOfDogs.Dog;
import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Big;
import Behaviors_and_Realizations.size_realizations.Medium;
import Behaviors_and_Realizations.size_realizations.Small;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to DogSelector!\nYou need to answer a couple of questions regarding dog behavior");
        System.out.println("Let's start!");
        Dog dog = new Dog() { @Override public void display() {} };
        String[] dogInfo = new String[4];

        while(true) {
            while(true) {
                boolean gate = false;
                System.out.println("----------------------------------------");
                System.out.println("Do you prefer more active, aggressive or calm dog?" +
                        "\nActive - 1, Aggressive - 2, Calm - 3");
                System.out.println("----------------------------------------");
                String mood = scan.nextLine();
                switch (mood) {
                    case "1" -> { dogInfo[0] = new Active().mood(); gate = true; }
                    case "2" -> { dogInfo[0] = new Aggressive().mood(); gate = true; }
                    case "3" -> { dogInfo[0] = new Calm().mood(); gate = true; }
                    default -> System.out.println("You need to choose between 1 and 3");
                }
                if (gate) break;
            }
            while(true) {
                boolean gate = false;
                System.out.println("----------------------------------------");
                System.out.println("Pick size of dog that you prefer" +
                        "\nBig - 1, Medium - 2, Small - 3");
                System.out.println("----------------------------------------");
                String size = scan.nextLine();
                switch (size) {
                    case "1" -> { dogInfo[1] = new Big().size(); gate = true; }
                    case "2" -> { dogInfo[1] = new Medium().size(); gate = true; }
                    case "3" -> { dogInfo[1] = new Small().size(); gate = true; }
                    default -> System.out.println("You need to choose between 1 and 3");
                }
                if (gate) break;
            }
            while(true) {
                boolean gate = false;
                System.out.println("----------------------------------------");
                System.out.println("Do you like street or domestic animal?" +
                        "\nStreet - 1, Domestic - 2");
                System.out.println("----------------------------------------");
                String lifestyle = scan.nextLine();
                switch (lifestyle) {
                    case "1" -> { dogInfo[2] = new Street().lifestyle(); gate = true; }
                    case "2" -> { dogInfo[2] = new Domestic().lifestyle(); gate = true; }
                    default -> System.out.println("You need to choose between 1 and 2");
                }
                if (gate) break;
            }
            while (true) {
                boolean gate = false;
                System.out.println("----------------------------------------");
                System.out.println("Should dog be trained or not trained?" +
                        "\nTrained - 1, NoTrained - 2");
                System.out.println("----------------------------------------");
                String intellect = scan.nextLine();
                switch (intellect) {
                    case "1" -> { dogInfo[3] = new Trained().intellect(); gate = true; }
                    case "2" -> { dogInfo[3] = new NoTrained().intellect(); gate = true; }
                    default -> System.out.println("You need to choose between 1 and 2");
                }
                if (gate) break;
            }
            System.out.println("----------------------------------------");
            dog.defineTypeOfDog(dogInfo);
            System.out.println("----------------------------------------");
            System.out.println("Continue? \nYES - y, NO - q or any character");
            String exit = scan.nextLine();
            if (!exit.equalsIgnoreCase("y")) break;
        }
    }
}
