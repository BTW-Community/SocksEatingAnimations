package net.minecraft.src;

public class SEAItemFoodBowl extends SEAItemFood
{
    public SEAItemFoodBowl(int iItemID, int iHungerHealed) {
		super(iItemID, iHungerHealed);
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
