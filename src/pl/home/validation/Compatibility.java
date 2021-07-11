package pl.home.validation;

public class Compatibility {

    private static final int[] weight = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

    private static int peselLength(String input) {
        return input.length();
    }

    private boolean doesContainOnlyDigits(String input) {
        return input.matches("\\d+");
    }

    private static boolean isControlNumberValid(String input) {
        int sum = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            sum += (Character.getNumericValue(input.charAt(i)) * weight[i]);
        }
        int lastDigit;
        lastDigit = (10 - (sum % 10)) % 10;
        return lastDigit == Character.getNumericValue(input.charAt(10));
    }

    private static boolean isBirthDateCorrect(String input) {
        int daysOfMonth = Integer.parseInt(input.substring(4, 6));
        return daysOfMonth < 32 && daysOfMonth >= 1;
    }

    public boolean isIDCompliant(String input) {
        boolean check = true;
        if (!doesContainOnlyDigits(input)) {
            Printouts.printOutShouldContainOnlyNumbers();
            return false;
        }
        if (peselLength(input) < 11) {
            Printouts.printoutNumberToShort();
            return false;
        }
        if (peselLength(input) > 11) {
            Printouts.printoutNumberToLong();
            return false;
        }
        if (!isBirthDateCorrect(input)) {
            Printouts.printOutIncorrectBoD();
            return false;
        }
        if (!isControlNumberValid(input)) {
            Printouts.printOutIncorrectCtrlNumber();
            return false;
        }
        return check;
    }
}
