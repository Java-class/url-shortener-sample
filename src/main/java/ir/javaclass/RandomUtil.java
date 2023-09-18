package ir.javaclass;

import java.util.Random;

public class RandomUtil {
    private final static Random random = new Random();
    public static String getRandomKeyword() {
        StringBuilder randomKeyword = new StringBuilder();
        for (int i = 0; i < Config.randomKeywordLength; i++) {
            char c = (char) random.nextInt(65, 90);
            randomKeyword.append(c);
        }
        return randomKeyword.toString();
    }
}
