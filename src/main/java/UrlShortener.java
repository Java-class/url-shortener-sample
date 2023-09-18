import ir.javaclass.Config;
import ir.javaclass.RandomUtil;

import java.util.HashMap;

public class UrlShortener {
    private static final HashMap<String, String> data = new HashMap<>();

    public static String generateShortenerUrl(String longUrl) {
        String basePath = Config.basePath;
        String shortUrl = basePath + RandomUtil.getRandomKeyword();
        data.put(shortUrl, longUrl);
        return shortUrl;
    }

    public static String getOriginalUrl(String shortUrl) {
        return data.get(shortUrl);
    }
}
