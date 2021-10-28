package net.minecraft.src;

public class SEADefs {

	public static void addDefinitions() {

		Item.appleRed = Item.replaceItem(Item.appleRed.itemID, SEAItemAppleRed.class, SocksEatingAnimationsAddon.instance);
		
		//public static Item bowlSoup = ( new FCItemMushroomSoup( 26, 3 ) ).setUnlocalizedName( "mushroomStew" );
		//public static Item bread = ( new ItemFood( 41, 3, 0.25F, false ) ).setUnlocalizedName( "bread" );
	}

}
