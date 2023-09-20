package ir.javaclass;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomUtil {
    private final static Random random = new Random();
    public static String getRandomKeyword() {
        StringBuilder randomKeyword = new StringBuilder();
        IntStream.range(0, Config.randomKeywordLength).forEach(i -> {
            char c = (char) random.nextInt(65, 90);
            randomKeyword.append(c);
        });
        return randomKeyword.toString();
    }
}
