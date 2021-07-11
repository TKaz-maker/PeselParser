package pl.home.peselinformation;

import java.time.LocalDate;

public class DetailsFromID {

    private final String pesel;
    private String gender;
    private String birthDate;
    private String primeStatus;

    public DetailsFromID(String pesel) {
        this.pesel = pesel;
    }

    String getPesel() {
        return pesel;
    }

    String getGender() {
        return gender;
    }

    String getPrimeStatus() {
        return primeStatus;
    }

    String getBirthDate() {
        return birthDate;
    }

    void defineGender() {
        gender = (!isEvenNumber(Character.getNumericValue(pesel.charAt(9)))) ? "Male" : "Female";
    }

    private static boolean isEvenNumber(int input) {
        return input % 2 == 0;
    }

    void calculateBirthDate() {
        int birthDay = 10 * Character.getNumericValue(pesel.charAt(4)) + Character.getNumericValue(pesel.charAt(5));
        int birthYear = 10 * Character.getNumericValue(pesel.charAt(0)) + Character.getNumericValue(pesel.charAt(1));
        int birthMonth = 10 * Character.getNumericValue(pesel.charAt(2)) + Character.getNumericValue(pesel.charAt(3));
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
        birthDate = LocalDate.of(birthYear, birthMonth, birthDay).toString();
    }

    void setPrimeStatus() {
        long peselLong = Long.parseLong(getPesel());
        for (int i = 2; i < Math.sqrt(peselLong); i++) {
            if (peselLong % i == 0) {
                primeStatus = "Number is Prime";
            } else primeStatus = "Number is not prime";
        }
    }
}