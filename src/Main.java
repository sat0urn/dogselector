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

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to DogSelector!\nYou need to answer a couple of questions regarding dog behavior");
        System.out.println("Let's start!");
        Dog dog = new Dog() { @Override public void display() {} };
        String[] dogInfo = new String[4];

        while(true) {
            System.out.println("----------------------------------------");
            System.out.println("Do you prefer more active, aggressive or calm dog?" +
                    "\nActive - 1, Aggressive - 2, Calm - 3");
            System.out.println("----------------------------------------");
            String mood = scan.nextLine();
            switch (mood) {
                case "1" -> dogInfo[0] = new Active().mood();
                case "2" -> dogInfo[0] = new Aggressive().mood();
                case "3" -> dogInfo[0] = new Calm().mood();
                default -> System.out.println("You need to choose between 1 and 3");
            }
            System.out.println("----------------------------------------");
            System.out.println("Pick size of dog that you prefer" +
                    "\nBig - 1, Medium - 2, Small - 3");
            System.out.println("----------------------------------------");
            String size = scan.nextLine();
            switch (size) {
                case "1" -> dogInfo[1] = new Big().size();
                case "2" -> dogInfo[1] = new Medium().size();
                case "3" -> dogInfo[1] = new Small().size();
                default -> System.out.println("You need to choose between 1 and 3");
            }
            System.out.println("----------------------------------------");
            System.out.println("Do you like street or domestic animal?" +
                    "\nStreet - 1, Domestic - 2");
            System.out.println("----------------------------------------");
            String lifestyle = scan.nextLine();
            switch (lifestyle) {
                case "1" -> dogInfo[2] = new Street().lifestyle();
                case "2" -> dogInfo[2] = new Domestic().lifestyle();
                default -> System.out.println("You need to choose between 1 and 2");
            }
            System.out.println("----------------------------------------");
            System.out.println("Should dog be trained or not trained?" +
                    "\nTrained - 1, NoTrained - 2");
            System.out.println("----------------------------------------");
            String intellect = scan.nextLine();
            switch (intellect) {
                case "1" -> dogInfo[3] = new Trained().intellect();
                case "2" -> dogInfo[3] = new NoTrained().intellect();
                default -> System.out.println("You need to choose between 1 and 2");
            }
            System.out.println("----------------------------------------");
            dog.defineTypeOfDog(dogInfo);
            System.out.println("----------------------------------------");
            System.out.println("Continue? \nYES - y, NO - q or any number");
            String exit = scan.nextLine();
            if (!exit.equalsIgnoreCase("y")) break;
        }
    }
}
