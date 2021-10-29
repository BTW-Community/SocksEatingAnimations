package net.minecraft.src;

public class SEAItemBucketDrinkable extends FCItemBucketDrinkable {
	
	static public final int m_iProgressTimeInterval = 5;

	private Icon[] iconArray; 
	public String[] eatingProgressArray;
	private int blockID;
	
	public SEAItemBucketDrinkable( int iItemID, int iHungerHealed, float fSaturationModifier, String sItemName, String[] eatingTextures, int blockID )
    {
        super(iItemID, iHungerHealed, fSaturationModifier);
        setMaxDamage( 0 ); //Disable progress bar
        setUnlocalizedName( sItemName );
        this.eatingProgressArray = eatingTextures;
        this.blockID = blockID;
    }
    //FCBucket
    
    @Override
    public int getBlockID()
    {
        return this.blockID;
    }    
    
    @Override
    public boolean DoesConsumeContainerItemWhenCrafted( Item containerItem )
    {
    	if ( containerItem.itemID == Item.bucketEmpty.itemID )
    	{
    		return true;
    	}
    	
    	return false;
    }    
    
    //SEA
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
		
		//FC Bucket
		if ( !world.isRemote )
        {
            player.clearActivePotions();
        }
		
		return super.onEaten(stack, world, player);
	}

	
}
