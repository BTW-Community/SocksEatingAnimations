package btw.community.sockthing.sockseatinganimations.mixin;

import btw.community.sockthing.sockseatinganimations.animation.AnimatedFoodRegistry;
import btw.item.items.BucketItemDrinkable;
import btw.item.items.PotionItem;
import net.minecraft.src.IconRegister;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemPotion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(
            method = "registerIcons",
            at = @At("TAIL")
    )
    private void hookRegisterIcons(IconRegister reg, CallbackInfo ci) {
        Item thisItem = (Item)(Object)this;

        if (thisItem instanceof ItemFood || thisItem instanceof BucketItemDrinkable) {
            int frames = AnimatedFoodRegistry.initGetAnimationFrameCount(thisItem);

            if (frames > 0) {
                System.out.println("[Sock's Eating Animations] Found " + frames + " Frames of Food Animation Textures for: " + thisItem.getUnlocalizedName().substring(5) );
                AnimatedFoodRegistry.registerIcons(thisItem, reg, frames + 1, thisItem.getUnlocalizedName().substring(5));
            }
        }
    }
}
