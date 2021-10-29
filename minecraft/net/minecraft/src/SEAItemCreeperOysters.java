// FCMOD

package net.minecraft.src;

import java.util.List;

public class SEAItemCreeperOysters extends SEAItemFood
{
    public SEAItemCreeperOysters( int iItemID, int iHungerHealed, float fSaturationModifier, String sItemName, String[] eatingTextures )
    {
    	super( iItemID, iHungerHealed, fSaturationModifier, false, sItemName, eatingTextures );
    	
    	setPotionEffect(Potion.poison.id, 5, 0, 1F );
	}
    
    @Override
    public void OnUsedInCrafting( EntityPlayer player, ItemStack outputStack )
    {
		// note: the playSound function for player both plays the sound locally on the client, and plays it remotely on the server without it being sent again to the same player
    	
		if ( player.m_iTimesCraftedThisTick == 0 )
		{
			player.playSound( "mob.slime.attack", 0.5F, ( player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat()) * 0.1F + 0.7F );
		}
    }
    
    //------------- Class Specific Methods ------------//
    
	//------------ Client Side Functionality ----------//
}
