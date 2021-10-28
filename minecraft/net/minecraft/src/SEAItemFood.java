package net.minecraft.src;

public class SEAItemFood extends FCItemFood {

	static public final int m_iProgressTimeInterval = 5;
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
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer,
			int par4) {
	
		par1ItemStack.setItemDamage(0);
	}
	 
	 @Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		
		if (par1ItemStack.stackSize > 1) {
			par1ItemStack.setItemDamage(0);
		}		
		return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
	}

	private Icon[] iconArray; 
	 
	public void registerIcons(IconRegister par1IconRegister) 
	{ 
	    super.registerIcons(par1IconRegister); 
	    this.iconArray = new Icon[eatingProgressArray.length]; 
	 
	    for (int var2 = 0; var2 < this.iconArray.length; ++var2) 
	    { 
	        this.iconArray[var2] = par1IconRegister.registerIcon(eatingProgressArray[var2]); 
	    } 
	} 
	 
	@Override 
	public Icon getIconFromDamage(int par1) { 
		return this.iconArray[par1]; 
	} 
	
}
