package cubex2.cs4.plugins.vanilla.block;

import cubex2.cs4.plugins.vanilla.ContentBlockTorch;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Bootstrap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockTorchTest
{
    @BeforeAll
    public static void setUp()
    {
        Bootstrap.register();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testProperties()
    {
        ContentBlockTorch content = new ContentBlockTorch();
        content.id = "test_getSubtype";

        Block block = content.createBlock();
        Collection<IProperty<?>> properties = block.getBlockState().getProperties();
        assertEquals(1, properties.size());
    }
}