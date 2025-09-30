package btw.community.sockthing.sockseatinganimations.mixin;

import btw.community.sockthing.sockseatinganimations.animation.AnimatedFoodRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    private int itemDamage;
    @Shadow public abstract Item getItem();

    @Shadow public int itemID;

    @Shadow private EntityItemFrame itemFrame;

    @Environment(EnvType.CLIENT)
    @Inject(
            method = "getIconIndex",
            at = @At("HEAD"),
            cancellable = true
    )
    private void hookGetIconIndex(CallbackInfoReturnable<Icon> cir) {
        ItemStack thisStack = (ItemStack)(Object)this;
        Item item = thisStack.getItem();

        if (item != null && AnimatedFoodRegistry.isAnimated(item)) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;

            if (player == null) return;

            if (player.getItemInUse() == thisStack) {

                int useDuration = thisStack.getMaxItemUseDuration();
                int remaining = player.getItemInUseCount();
                int totalFrames = AnimatedFoodRegistry.getFrameCount(item);

                int elapsed = useDuration - remaining;
                int frameIndex = 1 + (int)((long)elapsed * (totalFrames - 1) / useDuration);
                if (frameIndex >= totalFrames) frameIndex = totalFrames - 1;

                Icon icon = AnimatedFoodRegistry.getFrameIcon(item, frameIndex);

                // DEBUG LOG
//                System.out.println("[DEBUG] elapsed=" + (useDuration - remaining) +
//                        ", remaining=" + remaining +
//                        ", frameIndex=" + frameIndex +
//                        ", icon=" + icon);


                if (icon != null) {
                    cir.setReturnValue(icon);
                }
            }


        }
    }
}

