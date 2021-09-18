package pl.home;

import pl.home.peselinformation.DataExtraction;
import pl.home.peselinformation.DetailsFromID;
import pl.home.validation.Compatibility;

public class Main {

    public static void main(String[] args) {
        Compatibility peselCompatibility = new Compatibility();

        do {
            String userInput = UserInteraction.askForUserSerialNumber();
            if (peselCompatibility.isIDCompliant(userInput)) {
                DetailsFromID detailsFromID = new DetailsFromID(userInput);
                DataExtraction.extractDataFromPesel(detailsFromID);
                DataExtraction.printOutData(detailsFromID);
            }
        }
        while (UserInteraction.shouldContinue());
    }
}