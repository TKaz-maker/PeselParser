package pl.home.peselinformation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class IdNumber {

    private final String pesel;
    private String gender;
    private String birthDate;
    private String primeStatus;

    public static String defineGender(String input) {
        return (!isEvenNumber(Character.getNumericValue(input.charAt(9)))) ? "Male" : "Female";
    }

    private static boolean isEvenNumber(int input) {
        return input % 2 == 0;
    }

    public static String calculateBirthDate(String input) {
        int birthDay = 10 * Character.getNumericValue(input.charAt(4)) + Character.getNumericValue(input.charAt(5));
        int birthYear = 10 * Character.getNumericValue(input.charAt(0)) + Character.getNumericValue(input.charAt(1));
        int birthMonth = 10 * Character.getNumericValue(input.charAt(2)) + Character.getNumericValue(input.charAt(3));
        if (birthMonth <= 12) birthYear += 1900;
        else if (birthMonth <= 32) {
            birthYear += 2000;
            birthMonth -= 20;
        } else if (birthMonth <= 52) {
            birthYear += 2100;
            birthMonth -= 40;
        } else if (birthMonth <= 72) {
            birthYear += 2200;
            birthMonth -= 60;
        } else if (birthMonth <= 92) {
            birthYear += 1800;
            birthMonth -= 80;
        }
        return LocalDate.of(birthYear, birthMonth, birthDay).toString();
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

    public void printOutUserDetails() {
        System.out.println("Your Pesel no.: " + getPesel());
        System.out.println("Gender: " + getGender());
        System.out.println("BoD: " + getBirthDate());
        System.out.println("Prime status:  " + getPrimeStatus());
    }

}
