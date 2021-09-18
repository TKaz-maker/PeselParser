package pl.home.peselinformation;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BirthDate implements BirthDates {

    private int birthDay;
    private int birthMonth;
    private int birthYear;

    @Override
    public String calculateBirthDate(String input) {
        birthDay = 10 * Character.getNumericValue(input.charAt(4)) + Character.getNumericValue(input.charAt(5));
        birthYear = 10 * Character.getNumericValue(input.charAt(0)) + Character.getNumericValue(input.charAt(1));
        birthMonth = 10 * Character.getNumericValue(input.charAt(2)) + Character.getNumericValue(input.charAt(3));
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

    @Override
    public String toString() {
        return "BoD: " + LocalDate.of(birthYear,birthMonth,birthDay) +
                "\n----------------------\n";
    }
}
