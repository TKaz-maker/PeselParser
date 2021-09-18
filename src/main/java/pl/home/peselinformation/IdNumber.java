package pl.home.peselinformation;

import lombok.Data;

@Data
public class IdNumber {

    private final String pesel;
    private String gender;
    private String primeStatus;

    public IdNumber(String pesel, String gender, String primeStatus) {
        this.pesel = pesel;
        this.gender = gender;
        this.primeStatus = primeStatus;
    }

    public static String defineGender(String input) {
        return (!isEvenNumber(Character.getNumericValue(input.charAt(9)))) ? "Male" : "Female";
    }

    private static boolean isEvenNumber(int input) {
        return input % 2 == 0;
    }

    public static String setPrimeStatus(String input) {
        long inputLong = Long.parseLong(input);
        String status = "";
        for (int i = 2; i < Math.sqrt(inputLong); i++) {
            if (inputLong % i == 0) {
                status = "Number is Prime";
            } else status = "Number is not prime";
        }
        return status;
    }

    @Override
    public String toString() {
        return "\n-----------------------"
                + "\nID Number: " + pesel
                + "\nGender: " + gender
                + "\nPrime Status: " + primeStatus;
    }
}
