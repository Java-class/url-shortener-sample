import ir.javaclass.Config;
import ir.javaclass.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UrlShortenerTest {

    @Mock
    private RandomUtil randomUtil;

    private final String longUrl = "https://www.example.com/junit-toturial";

    @Test
    public void testNothing() {

    }

    @Test
    public void givenLongUrl_WhenCallingGenerateShortUtl_thenReturnNotNullUrl() {
        String shortUrl = UrlShortener.generateShortenerUrl(longUrl);
        assertNotNull(shortUrl);
    }

    @Test
    public void givenLongUrl_whenCallingGenerateShortUrl_thenReturnShortenerUrl() {
        String shortUrl = UrlShortener.generateShortenerUrl(longUrl);
        String basePath = Config.basePath;
        String differential = shortUrl.replaceAll(basePath, "");
        assertEquals(Config.randomKeywordLength, differential.length());
    }

    @Test
    public void givenShort_whenCallingGetOriginalUrl_thenReturnTheOriginalLongUrl() {
        String shortUrl = UrlShortener.generateShortenerUrl(longUrl);
        String originalUrl = UrlShortener.getOriginalUrl(shortUrl);
        assertEquals(longUrl, originalUrl);
    }

    @Test
    public void givenMultipleLongUrl_whenCallingGenerateShortenerUtl_thenGenerateDifferentShortUrl() {
        String anotherLongUrl = "https://www.example.com/spring-tutorial";
        String firstShortUrl = UrlShortener.generateShortenerUrl(longUrl);
        String secondShortUrl = UrlShortener.generateShortenerUrl(anotherLongUrl);
        assertNotEquals(firstShortUrl, secondShortUrl);
    }

    @Test
    public void givenLongUrl_whenCallingGenerateShortenerUrl_thenShouldCalledGenerateRandomKeywordOnce() {
        try (MockedStatic<RandomUtil> randomUtilMockedStatic = Mockito.mockStatic(RandomUtil.class)) {
            randomUtilMockedStatic.when(RandomUtil::getRandomKeyword)
                    .thenReturn("abcdef");
            // when
            UrlShortener.generateShortenerUrl(longUrl);
            //then
            randomUtilMockedStatic.verify(
                    RandomUtil::getRandomKeyword,
                    times(1)
            );
        }
    }
}
