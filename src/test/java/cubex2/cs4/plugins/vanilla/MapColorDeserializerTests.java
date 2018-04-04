package cubex2.cs4.plugins.vanilla;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import cubex2.cs4.TestUtil;
import net.minecraft.block.material.MapColor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MapColorDeserializerTests
{
    private static Gson gson;

    @BeforeAll
    public static void setup()
    {
        gson = TestUtil.createGson();
    }

    @Test
    public void test_noArray()
    {
        Map<String, MapColor> map = gson.fromJson("{ \"color\": \"light_blue\" }", new TypeToken<Map<String, MapColor>>() {}.getType());

        MapColor color = map.get("color");
        assertNotNull(color);
        assertSame(MapColor.LIGHT_BLUE, color);
    }
}
