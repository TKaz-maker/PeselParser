package pl.home.peselinformation;

public class DataExtraction {

    private DataExtraction() {
        throw new IllegalStateException("Utility class");
    }

    public static void printOutData(DetailsFromID detailsFromID) {
        System.out.println("Your Pesel no.: " + detailsFromID.getPesel());
        System.out.println("Gender: " + detailsFromID.getGender());
        System.out.println("BoD: " + detailsFromID.getBirthDate());
        System.out.println("Prime status:  " + detailsFromID.getPrimeStatus());
    }

    public static void extractDataFromPesel(DetailsFromID detailsFromID) {
        detailsFromID.defineGender();
        detailsFromID.calculateBirthDate();
        detailsFromID.setPrimeStatus();
    }
}