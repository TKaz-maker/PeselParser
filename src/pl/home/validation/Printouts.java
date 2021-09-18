package pl.home.validation;

class Printouts {

    private Printouts() {
        throw new IllegalStateException("Utility class");
    }

    static void printoutNumberToLong() {
        System.out.println("PESEL no. too long.");
    }

    static void printoutNumberToShort() {
        System.out.println("PESEL no. too short.");
    }

    static void printOutShouldContainOnlyNumbers() {
        System.out.println("PESEL no. should contain only numbers.");
    }

    static void printOutIncorrectCtrlNumber() {
        System.out.println("Faulty PESEL - Control number is incorrect.\n");
    }

    static void printOutIncorrectBoD() {
        System.out.println("The Date of Birth is incorrect");
    }
}
