package btw.community.sockthing.sockseatinganimations.animation;

import com.prupe.mcpatcher.mal.tile.TileLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.src.ITexturePack;
import net.minecraft.src.Icon;
import net.minecraft.src.IconRegister;
import net.minecraft.src.Item;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AnimatedFoodRegistry {
    public static final Map<Item, Icon[]> ICONS = new HashMap<>();
    public static final Map<Item, Integer> FRAME_COUNTS = new HashMap<>();

    public static void registerIcons(Item item, IconRegister reg, int frames, String baseName) {
        Icon[] arr = new Icon[frames];

        arr[0] = reg.registerIcon(baseName);
        for (int i = 1; i < frames; i++) {
            arr[i] = reg.registerIcon(baseName + "_" + i);
        }

        ICONS.put(item, arr);
        FRAME_COUNTS.put(item, frames);
    }

    public static Icon getFrameIcon(Item item, int frameIndex) {
        Icon[] arr = ICONS.get(item);
        if (arr == null || arr.length == 0) return null;
        return arr[frameIndex];
    }

    public static int getFrameCount(Item item) {
        return FRAME_COUNTS.get(item);
    }

    public static boolean isAnimated(Item item) {
        return ICONS.containsKey(item);
    }

    public static int initGetAnimationFrameCount(Item item) {
        return initGetAnimationFrameCount(item.getUnlocalizedName().substring(5));
    }

    public static int initGetAnimationFrameCount(String name) {
        ITexturePack pack = Minecraft.getMinecraft().texturePackList.getSelectedTexturePack();

        int frameCount = 0;
        InputStream stream = null;

        try {
            while (true) {
                String texturePath = TileLoader.getOverridePath("", "/textures/items/", name + "_" + (frameCount + 1), ".png");
                stream = pack.getResourceAsStream(texturePath);

                if (stream == null) {
                    break; // stop when next frame is missing
                }

                frameCount++;
                stream.close();
                stream = null;
            }

            return frameCount;
        } catch (Exception e) {
            return frameCount;
        } finally {
            if (stream != null) {
                try { stream.close(); } catch (IOException ignored) {}
            }
        }
    }
}
