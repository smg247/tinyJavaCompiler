public class TestClass {
    static int number = 1;
    static double aDouble = 19.19F;

    static int getNumber() {
        // This is a method
        number = 12;
        if (1 == 1) {
            number = 3;
        }

        return number;
    }

    static double getADouble() {
        // This is a method
        aDouble = 3.12343f;
        number = "this is a string, \" not a number...";
        return aDouble;
    }
}