package cubex2.cs4.plugins.vanilla.block;

import cubex2.cs4.plugins.vanilla.ContentBlockSimple;
import net.minecraft.block.Block;
import net.minecraft.init.Bootstrap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class BlockMixinTest
{
    @BeforeAll
    public static void setUp()
    {
        Bootstrap.register();
    }

    @Test
    public void collisionBoundsNullreturnsNull()
    {
        ContentBlockSimple content = new ContentBlockSimple();
        content.id = "test";
        content.collisionBounds = null;

        Block block = content.createBlock();
        assertNull(block.getCollisionBoundingBox(block.getDefaultState(),null,null));
    }
}