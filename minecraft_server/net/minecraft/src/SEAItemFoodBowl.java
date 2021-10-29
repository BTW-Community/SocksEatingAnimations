package net.minecraft.src;

public class SEAItemFoodBowl extends SEAItemFood
{
    public SEAItemFoodBowl(int iItemID, int iHungerHealed, float fSaturationModifier, boolean bWolfMeat, String sItemName, String[] eatingTextures) {
		super(iItemID, iHungerHealed, fSaturationModifier, bWolfMeat, sItemName, eatingTextures);
	}
    
    public SEAItemFoodBowl(int iItemID, int iHungerHealed, float fSaturationModifier, String sItemName, String[] eatingTextures) {
    	super(iItemID, iHungerHealed, fSaturationModifier, sItemName, eatingTextures);
	}

	@Override
    public ItemStack onEaten( ItemStack stack, World world, EntityPlayer player )
    {
        super.onEaten( stack, world, player );

        ItemStack bowlStack = new ItemStack( Item.bowlEmpty );
        
        if ( !player.inventory.addItemStackToInventory( bowlStack ) )
        {
            player.dropPlayerItem( bowlStack );
        }
        
        return stack;
    }
}
