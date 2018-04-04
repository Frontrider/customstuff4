package cubex2.cs4.plugins.vanilla;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import cubex2.cs4.TestUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class NBTTagCompoundDeserializerTests
{
    private static Gson gson;

    @BeforeAll
    public static void setup()
    {
        gson = TestUtil.createGson();
    }

    @Test
    public void test()
    {
        Map<String, NBTTagCompound> map = gson.fromJson("{ \"nbt\": \"{AByte:1b, AString:\\\"Test\\\"}\" }", new TypeToken<Map<String, NBTTagCompound>>() {}.getType());

        NBTTagCompound nbt = map.get("nbt");
        assertNotNull(nbt);
        assertTrue(nbt.hasKey("AByte", Constants.NBT.TAG_BYTE));
        assertTrue(nbt.hasKey("AString", Constants.NBT.TAG_STRING));
        assertEquals((byte) 1, nbt.getByte("AByte"));
        assertEquals("Test", nbt.getString("AString"));
    }
}
