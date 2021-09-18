package pl.home;

import pl.home.peselinformation.BirthDate;
import pl.home.peselinformation.BirthDates;
import pl.home.peselinformation.IdNumber;
import pl.home.validation.Compatibility;

public class Main {

    public static void main(String[] args) {
        Compatibility peselCompatibility = new Compatibility();

        do {
            String userInput = UserInteraction.askForUserSerialNumber();
            if (peselCompatibility.isIDCompliant(userInput)) {
                IdNumber polishPesel = new IdNumber(userInput,
                        IdNumber.defineGender(userInput),
                        IdNumber.setPrimeStatus(userInput));
                BirthDates birthDate = new BirthDate();
                birthDate.calculateBirthDate(userInput);
                UserInteraction.printOutUserDetails(polishPesel);
                UserInteraction.printOutUserBoD(birthDate);
            }
        }
        while (UserInteraction.shouldContinue());
    }
}