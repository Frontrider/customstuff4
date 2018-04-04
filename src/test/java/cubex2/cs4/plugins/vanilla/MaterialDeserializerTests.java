package cubex2.cs4.plugins.vanilla;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import cubex2.cs4.TestUtil;
import net.minecraft.block.material.Material;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class MaterialDeserializerTests
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
        Map<String, Material> map = gson.fromJson("{ \"mat\": \"clay\" }", new TypeToken<Map<String, Material>>() {}.getType());

        Material mat = map.get("mat");
        assertNotNull(mat);
        assertSame(Material.CLAY, mat);
    }

    @Test
    public void test_air()
    {
        Map<String, Material> map = gson.fromJson("{ \"mat\": \"air\" }", new TypeToken<Map<String, Material>>() {}.getType());

        Material mat = map.get("mat");
        assertNotNull(mat);
        assertSame(Material.AIR, mat);
    }
}
