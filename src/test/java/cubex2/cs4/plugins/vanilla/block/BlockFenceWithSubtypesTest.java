package cubex2.cs4.plugins.vanilla.block;

import cubex2.cs4.plugins.vanilla.ContentBlockFence;
import cubex2.cs4.util.BlockHelper;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Bootstrap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockFenceWithSubtypesTest
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
        ContentBlockFence content = new ContentBlockFence();
        content.subtypes = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
        content.id = "test_getSubtype";

        Block block = content.createBlock();
        Collection<IProperty<?>> properties = block.getBlockState().getProperties();
        assertEquals(5, properties.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void test_getSubtype()
    {
        ContentBlockFence content = new ContentBlockFence();
        content.subtypes = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
        content.id = "test_getSubtype";

        Block block = content.createBlock();
        CSBlock<ContentBlockFence> csblock = (CSBlock<ContentBlockFence>) block;
        for (int subtype = 0; subtype < 8; subtype++)
        {
            IBlockState state = block.getDefaultState()
                                     .withProperty(BlockFence.NORTH, false)
                                     .withProperty(BlockFence.SOUTH, true)
                                     .withProperty(BlockHelper.getSubtypeProperty(content.subtypes), EnumSubtype.values()[subtype]);

            assertEquals(subtype, csblock.getSubtype(state));
        }

    }
}