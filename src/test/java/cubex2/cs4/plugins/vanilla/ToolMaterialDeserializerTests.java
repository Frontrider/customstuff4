package cubex2.cs4.plugins.vanilla;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import cubex2.cs4.TestUtil;
import cubex2.cs4.api.WrappedToolMaterial;
import net.minecraft.item.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ToolMaterialDeserializerTests
{
    private static Gson gson;

    @BeforeAll
    public static void setup()
    {
        gson = TestUtil.createGson();
    }

    @Test
    public void test_diamond()
    {
        Map<String, WrappedToolMaterial> map = gson.fromJson("{ \"mat\": \"diamond\" }", new TypeToken<Map<String, WrappedToolMaterial>>() {}.getType());

        WrappedToolMaterial mat = map.get("mat");
        assertNotNull(mat);
        assertSame(Item.ToolMaterial.DIAMOND, mat.getToolMaterial());
    }

    @Test
    public void test_iron()
    {
        Map<String, WrappedToolMaterial> map = gson.fromJson("{ \"mat\": \"iron\" }", new TypeToken<Map<String, WrappedToolMaterial>>() {}.getType());

        WrappedToolMaterial mat = map.get("mat");
        assertNotNull(mat);
        assertSame(Item.ToolMaterial.IRON, mat.getToolMaterial());
    }
}
