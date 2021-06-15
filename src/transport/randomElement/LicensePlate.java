package transport.randomElement;

import java.util.Random;

public class LicensePlate {
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;

    public static Random generator = new Random();

    public static String getLicensePlate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; ++i) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() -1);
            char character = ALPHA_NUMERIC.charAt(number);
            sb.append(character);
        }
        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

}
