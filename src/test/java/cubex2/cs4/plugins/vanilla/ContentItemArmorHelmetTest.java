package cubex2.cs4.plugins.vanilla;

import net.minecraft.init.Bootstrap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ContentItemArmorHelmetTest
{
    @BeforeAll
    public static void setUp()
    {
        Bootstrap.register();
    }

    @Test
    public void test_createItem()
    {
        ContentItemArmorHelmet content = new ContentItemArmorHelmet();

        content.createItem();
    }
}