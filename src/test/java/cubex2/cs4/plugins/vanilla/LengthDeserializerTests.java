package cubex2.cs4.plugins.vanilla;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cubex2.cs4.TestUtil;
import cubex2.cs4.api.Length;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthDeserializerTests
{
    private static Gson gson;

    @BeforeAll
    public static void setup()
    {
        gson = TestUtil.createGson();
    }

    @Test
    public void test_absoluteDeserialization()
    {
        Map<String, Length> map = gson.fromJson("{ \"length\" : 200 }", new TypeToken<Map<String, Length>>() {}.getType());
        Length length = map.get("length");

        assertEquals(200, length.getLength(1000));
    }

    @Test
    public void test_relativeDeserialization()
    {
        Map<String, Length> map = gson.fromJson("{ \"length\" : \"55.5%\" }", new TypeToken<Map<String, Length>>() {}.getType());
        Length length = map.get("length");

        assertEquals(555, length.getLength(1000));
    }

    @Test
    public void test_absoluteAndRelativeDeserialization()
    {
        Map<String, Length> map = gson.fromJson("{ \"length\" : [\"55.5%\", 100] }", new TypeToken<Map<String, Length>>() {}.getType());
        Length length = map.get("length");

        assertEquals(655, length.getLength(1000));
    }
}
