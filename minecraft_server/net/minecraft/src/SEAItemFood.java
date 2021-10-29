package net.minecraft.src;

public class SEAItemFood extends FCItemFood {

	static public final int m_iProgressTimeInterval = 5;

	private static String sItemName;

	private static float fSaturationModifier;

	private Icon[] iconArray; 
	public String[] eatingProgressArray;

	public SEAItemFood( int iItemID, int iHungerHealed, float fSaturationModifier, boolean bWolfMeat, String sItemName, String[] eatingTextures )
    {
        super( iItemID, iHungerHealed, fSaturationModifier, bWolfMeat, sItemName );
        setMaxDamage( 0 ); //Disable progress bar
        setUnlocalizedName( sItemName );
        this.eatingProgressArray = eatingTextures;
    }
    
    public SEAItemFood( int iItemID, int iHungerHealed, float fSaturationModifier, boolean bWolfMeat, String sItemName, boolean bZombiesConsume , String[] eatingTextures )
    {
        super( iItemID, iHungerHealed, fSaturationModifier, bWolfMeat, sItemName, bZombiesConsume );
        setMaxDamage( 0 ); //Disable progress bar
        setUnlocalizedName( sItemName );
        this.eatingProgressArray = eatingTextures;
    } 
    
    public SEAItemFood(int iItemID, int iHungerHealed, float fSaturationModifier, String sItemName, String[] eatingTextures) {
    	super( iItemID, iHungerHealed, fSaturationModifier, false, sItemName );
    	 setMaxDamage( 0 ); //Disable progress bar
         setUnlocalizedName( sItemName );
         this.eatingProgressArray = eatingTextures;
	}

	@Override
    public void UpdateUsingItem( ItemStack stack, World world, EntityPlayer player )
    {
    	int iUseCount = player.getItemInUseCount();

        if ( getMaxItemUseDuration( stack ) - iUseCount > GetItemUseWarmupDuration() )
        {
        	
            if ( !world.isRemote && iUseCount % m_iProgressTimeInterval == 0 )
            {
            	int iDamage = stack.getItemDamage();
            	
            	iDamage += 1;
            	
            	if ( iDamage > 0 )
            	{            	
            		stack.setItemDamage( iDamage );
            	}
            }
        }
    }
	
	@Override
    public boolean IgnoreDamageWhenComparingDuringUse()
    {
    	return true;
    }
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int par4) {
	
		stack.setItemDamage(0);
	}
	 
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		
		if (stack.stackSize > 1) {
			stack.setItemDamage(0);
		}
		
		return super.onEaten(stack, world, player);
	}

	
	public Icon getIconFromDamage(int par1) { 
		return this.iconArray[par1];
	} 

}
