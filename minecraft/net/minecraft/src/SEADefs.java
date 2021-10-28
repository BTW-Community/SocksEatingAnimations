package net.minecraft.src;

public class SEADefs {
	
	static String[] appleTextures = new String[] {"apple", "apple_1" , "apple_2", "apple_3", "apple_4"};
	static String[] breadTextures = new String[] {"bread", "bread_1" , "bread_2", "bread_3", "bread_4"};
	
	public static void addDefinitions() {

		Item.appleRed = Item.replaceItem(Item.appleRed.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance, 1, 0F, false, "apple", appleTextures).SetFilterableProperties( Item.m_iFilterable_Small );
		Item.bread = Item.replaceItem(Item.bread.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance, 3, 0.25F, false, "bread", breadTextures);
	}

}
