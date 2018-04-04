package cubex2.cs4.plugins.vanilla;

import com.google.gson.Gson;
import cubex2.cs4.TestContentHelper;
import cubex2.cs4.TestUtil;
import cubex2.cs4.api.BlankContent;
import cubex2.cs4.api.InitPhase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OreDictionaryEntryTests
{
    private static Gson gson;

    @BeforeAll
    public static void setup()
    {
        gson = TestUtil.createGson();
    }

    @Test
    public void testDeserialization()
    {
        OreDictionaryEntry entry = gson.fromJson("{ \"oreClass\": \"stickWood\", \"item\":\"minecraft:coal\" }", OreDictionaryEntry.class);
        entry.init(InitPhase.PRE_INIT, new TestContentHelper("{}", BlankContent.class));

        assertEquals("stickWood", entry.oreClass);
        assertSame(Items.COAL, entry.item.getItemStack().getItem());
    }

    @Test
    public void testRegistersEntry()
    {
        OreDictionaryEntry entry = gson.fromJson("{ \"oreClass\": \"someEntry\", \"item\":\"minecraft:coal\" }", OreDictionaryEntry.class);
        entry.init(InitPhase.PRE_INIT, new TestContentHelper("{}", BlankContent.class));

        assertTrue(OreDictionary.doesOreNameExist("someEntry"));
        assertTrue(OreDictionary.containsMatch(true, OreDictionary.getOres("someEntry"), new ItemStack(Items.COAL)));
    }
}
