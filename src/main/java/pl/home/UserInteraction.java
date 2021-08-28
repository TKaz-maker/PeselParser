package pl.home;

import pl.home.peselinformation.IdNumber;

import java.util.Scanner;

class UserInteraction {

    private UserInteraction() {
        throw new IllegalStateException("Utility class");
    }

    private static final Scanner input = new Scanner(System.in);

    static String askForUserSerialNumber() {
        System.out.println("Provide PESEL number.");
        return input.nextLine();
    }

    static boolean shouldContinue() {
        System.out.println("Would you like to check another PESEL no.? (Y/N).");
        while (true) {
            switch (input.nextLine().toUpperCase()) {
                case "Y":
                    return true;
                case "N":
                    input.close();
                    System.out.println("Closing the program...");
                    return false;
                default:
                    System.out.println("Please type Y or N.");
            }
        }
    }

    static void printOutUserDetails(IdNumber idNumber) {
        System.out.println(idNumber);
    }
}