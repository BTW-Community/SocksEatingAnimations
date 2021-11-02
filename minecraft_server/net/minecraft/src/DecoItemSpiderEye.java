package net.minecraft.src;

public class DecoItemSpiderEye extends SEAItemFood {
	private static String[] eatingProgressArray = new String[] {"spiderEye", "spiderEye_1" , "spiderEye_2", "spiderEye_3", "spiderEye_4"};

	public DecoItemSpiderEye(int id) {
		super(id, 2, 0.8F, false, sItemName, eatingProgressArray );
		this.setPotionEffect(Potion.poison.id, 5, 0, 1.0F);
		this.SetNeutralBuoyant();
		this.SetFilterableProperties(2);
		this.setPotionEffect(PotionHelper.goldenCarrotEffect);
		this.setUnlocalizedName("spiderEye");
	}

    public boolean IsPistonPackable(ItemStack var1)
    {
        return true;
    }

    public int GetRequiredItemCountToPistonPack(ItemStack var1)
    {
        return 16;
    }

    public int GetResultingBlockIDOnPistonPack(ItemStack var1)
    {
        return 3307; //DecoDefs.spiderEyeBlock.blockID;
    }
}