package cubex2.cs4.plugins.vanilla;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import cubex2.cs4.TestUtil;
import net.minecraft.block.SoundType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SoundTypeDeserializerTests
{
    private static Gson gson;

    @BeforeAll
    public static void setup()
    {
        gson = TestUtil.createGson();
    }

    @Test
    public void test_clay()
    {
        Map<String, SoundType> map = gson.fromJson("{ \"sound\": \"glass\" }", new TypeToken<Map<String, SoundType>>() {}.getType());

        SoundType sound = map.get("sound");
        assertNotNull(sound);
        assertSame(SoundType.GLASS, sound);
    }

    @Test
    public void test_air()
    {
        Map<String, SoundType> map = gson.fromJson("{ \"sound\": \"wood\" }", new TypeToken<Map<String, SoundType>>() {}.getType());

        SoundType sound = map.get("sound");
        assertNotNull(sound);
        assertSame(SoundType.WOOD, sound);
    }
}
