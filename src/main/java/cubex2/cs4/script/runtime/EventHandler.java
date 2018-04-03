package cubex2.cs4.script.runtime;

import cubex2.cs4.CustomStuff4;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author <a href="mailto:kisandrasgabor@gmail.com">András Kis</a>
 */

@EventBusSubscriber
public class EventHandler {

    private static void runEvent(String event, Object... argument) {
        try {
            CustomStuff4.scriptHandler.eventHandler.callMember(event + "Function", argument);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public static void EntityItemPickupEvent(EntityItemPickupEvent event) {
        runEvent("entityItemPickupEvent", event);
    }

    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        runEvent("rightClickBlock", event);
    }

    @SubscribeEvent
    public static void rightClickItem(PlayerInteractEvent.RightClickItem event) {
        runEvent("rightClickItem", event);
    }

    @SubscribeEvent
    public static void rightClickEmpty(PlayerInteractEvent.RightClickEmpty event) {
        runEvent("rightClickEmpty", event);
    }

    @SubscribeEvent
    public static void useItem(LivingEntityUseItemEvent entityUseItemEvent) {
        runEvent("livingUseItem", entityUseItemEvent);
    }


}
