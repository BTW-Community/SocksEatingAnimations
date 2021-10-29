package net.minecraft.src;

public class SEAItemFoodHighRes extends SEAItemFood {

    
	public SEAItemFoodHighRes( int iItemID, int iHungerHealed, float fSaturationModifier, boolean bWolfMeat, String sItemName , String[] eatingTextures )
    {
        super( iItemID, iHungerHealed, fSaturationModifier, bWolfMeat, sItemName, eatingTextures );        
    }
    
    public SEAItemFoodHighRes( int iItemID, int iHungerHealed, float fSaturationModifier, boolean bWolfMeat, String sItemName, boolean bZombiesConsume , String[] eatingTextures )
    {
        super( iItemID, iHungerHealed, fSaturationModifier, bWolfMeat, sItemName, bZombiesConsume, eatingTextures );
    }
	@Override
    public int GetHungerRestored()
    {
    	// override of super function which multiplies the value
    	
    	return getHealAmount();
    }
}
