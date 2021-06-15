package transport.randomElement;

import java.util.ArrayList;
import java.util.Random;

public class IDTransport {
    private static String id = "0123456789";
    private static Random generator = new Random();

    public int randNumber(int min, int max) {
        return generator.nextInt(max - min + 1) + min;
    }

    public static boolean checkExits(ArrayList<Integer> numbers, int number) {
        for (var otherNumber : numbers) {
            if (otherNumber == number) {
                return true;
            }
        }
        return false;
    }

    public String getIdTransport() {
        ArrayList<Integer> listNumber = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int number;
        for (int i = 0; i < 4; ++i) {
            number = randNumber(0, id.length() - 1);
            do {
                if (checkExits(listNumber, number) == false) {
                    listNumber.add(number);
                    char characters = id.charAt(number);
                    sb.append(characters);
                    listNumber.add(number);
                    break;
                } else {
                    number = randNumber(0, id.length() - 1);
                }
            } while (true);
        }
        return sb.toString();
    }
}
