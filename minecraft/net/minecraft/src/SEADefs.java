package net.minecraft.src;

public class SEADefs {
	
	//Vanilla foods
	static String[] appleTextures = new String[] {"apple", "apple_1" , "apple_2", "apple_3", "apple_4"};
	static String[] mushroomStewTextures = new String[] {"mushroomStew", "mushroomStew_1" , "mushroomStew_2", "mushroomStew_3", "mushroomStew_4"};
	static String[] breadTextures = new String[] {"bread", "bread_1" , "bread_2", "bread_3", "bread_4"};
	static String[] porkRawTextures = new String[] {"porkchopRaw", "porkchopRaw_1" , "porkchopRaw_2", "porkchopRaw_3", "porkchopRaw_4"};
	static String[] porkCookedTextures = new String[] {"porkchopCooked", "porkchopCooked_1" , "porkchopCooked_2", "porkchopCooked_3", "porkchopCooked_4"};
	static String[] appleGoldTextures = new String[] {"appleGold", "appleGold_1" , "appleGold_2", "appleGold_3", "appleGold_4"};
	static String[] milkTextures = new String[] {"milk", "milk_1" , "milk_2", "milk_3", "milk_4"};
	static String[] fishRawTextures = new String[] {"fishRaw", "fishRaw_1" , "fishRaw_2", "fishRaw_3", "fishRaw_4"};
	static String[] fishCookedTextures = new String[] {"fishCooked", "fishCooked_1" , "fishCooked_2", "fishCooked_3", "fishCooked_4"};
	static String[] cookieTextures = new String[] {"cookie", "cookie_1" , "cookie_2", "cookie_3", "cookie_4"};
	static String[] melonTextures = new String[] {"melon", "melon_1" , "melon_2", "melon_3", "melon_4"};
	static String[] seeds_pumpkinTextures = new String[] {"seeds_pumpkin", "seeds_pumpkin_1" , "seeds_pumpkin_2", "seeds_pumpkin_3", "seeds_pumpkin_4"};
	static String[] beefRawTextures = new String[] {"beefRaw", "beefRaw_1" , "beefRaw_2", "beefRaw_3", "beefRaw_4"};
	static String[] beefCookedTextures = new String[] {"beefCooked", "beefCooked_1" , "beefCooked_2", "beefCooked_3", "beefCooked_4"};
	static String[] chickenRawTextures = new String[] {"chickenRaw", "chickenRaw_1" , "chickenRaw_2", "chickenRaw_3", "chickenRaw_4"};
	static String[] chickenCookedTextures = new String[] {"chickenCooked", "chickenCooked_1" , "chickenCooked_2", "chickenCooked_3", "chickenCooked_4"};
	static String[] rottenFleshTextures = new String[] {"rottenFlesh", "rottenFlesh_1" , "rottenFlesh_2", "rottenFlesh_3", "rottenFlesh_4"};
	static String[] spiderEyeTextures = new String[] {"spiderEye", "spiderEye_1" , "spiderEye_2", "spiderEye_3", "spiderEye_4"};
	static String[] carrotsTextures = new String[] {"carrots", "carrots_1" , "carrots_2", "carrots_3", "carrots_4"};
	static String[] potatoTextures = new String[] {"potato", "potato_1" , "potato_2", "potato_3", "potato_4"};
	static String[] potatoBakedTextures = new String[] {"potatoBaked", "potatoBaked_1" , "potatoBaked_2", "potatoBaked_3", "potatoBaked_4"};
	static String[] potatoPoisonousTextures = new String[] {"potatoPoisonous", "potatoPoisonous_1" , "potatoPoisonous_2", "potatoPoisonous_3", "potatoPoisonous_4"};
	static String[] pumpkinPieTextures = new String[] {"pumpkinPie", "pumpkinPie_1" , "pumpkinPie_2", "pumpkinPie_3", "pumpkinPie_4"};
	
	
	
	
	
	//static String[] Textures = new String[] {"", "_1" , "_2", "_3", "_4"};
	
	public static void addDefinitions() {
		
		//Vanilla foods
		Item.appleRed = Item.replaceItem(Item.appleRed.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				1, 0F, false, "apple",
				appleTextures).SetFilterableProperties( Item.m_iFilterable_Small );
		
//		Item.bowlSoup = Item.replaceItem(Item.bowlSoup.itemID, SEAItemFoodBowl.class, SocksEatingAnimationsAddon.instance,
//				3, 0.25F, false, "mushroomStew");
		
		Item.bread = Item.replaceItem(Item.bread.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				3, 0.25F, false, "bread",
				breadTextures);
		
		Item.porkRaw = ((SEAItemFood) Item.replaceItem(Item.porkRaw.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				FCItemFood.m_iPorkChopRawHungerHealed, FCItemFood.m_fPorkChopSaturationModifier, true, "porkchopRaw", true,
				porkRawTextures)).SetStandardFoodPoisoningEffect();
		
		Item.porkCooked = Item.replaceItem(Item.porkCooked.itemID, SEAItemFood.class,  SocksEatingAnimationsAddon.instance,
				FCItemFood.m_iPorkChopCookedHungerHealed, FCItemFood.m_fPorkChopSaturationModifier, true, "porkchopCooked",
				porkCookedTextures);
		
		Item.appleGold = ((SEAItemFood) Item.replaceItem(Item.appleGold.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				1, 0F, false, "appleGold",
				appleGoldTextures)).setAlwaysEdible().setPotionEffect( Potion.regeneration.id, 5, 0, 1F ).SetNonBuoyant().SetNotIncineratedInCrucible().SetFilterableProperties( Item.m_iFilterable_Small );
		
		Item.bucketMilk = Item.replaceItem(Item.bucketMilk.itemID, SEAItemBucketDrinkable.class, SocksEatingAnimationsAddon.instance,
				6, 0.25F, "milk",
				milkTextures, FCBetterThanWolves.fcBlockBucketMilk.blockID);
		
		Item.fishRaw = ((SEAItemFood) Item.replaceItem(Item.fishRaw.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				FCItemFood.m_iFishRawHungerHealed, FCItemFood.m_fFishSaturationModifier, false, "fishRaw",
				fishRawTextures)).SetStandardFoodPoisoningEffect();
		
		Item.fishCooked = Item.replaceItem(Item.fishCooked.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				FCItemFood.m_iFishCookedHungerHealed, FCItemFood.m_fFishSaturationModifier, false, "fishCooked",
				fishCookedTextures);
		
		Item.cookie = ((SEAItemFood) Item.replaceItem(Item.cookie.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				1, 1F, false, "cookie",
				cookieTextures)).setAlwaysEdible().SetFilterableProperties( Item.m_iFilterable_Small );
		
//		Item.melon = Item.replaceItem(Item.melon.itemID, SEAItemFoodHighRes.class, SocksEatingAnimationsAddon.instance,
//				2, 0F, false, "melon",
//				melonTextures);
		
		Item.pumpkinSeeds = Item.replaceItem(Item.pumpkinSeeds.itemID, SEAItemSeedFood.class, SocksEatingAnimationsAddon.instance,
				1, 0F, Block.pumpkinStem.blockID, "seeds_pumpkin",
				seeds_pumpkinTextures).SetAsBasicChickenFood().SetBellowsBlowDistance( 2 ).SetFilterableProperties( Item.m_iFilterable_Fine );
		
		Item.beefRaw = ((SEAItemFood) Item.replaceItem(Item.beefRaw.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				FCItemFood.m_iBeefRawHungerHealed, FCItemFood.m_fBeefSaturationModifier, true, "beefRaw", true,
				beefRawTextures)).SetStandardFoodPoisoningEffect();
		
		Item.beefCooked = Item.replaceItem(Item.beefCooked.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				FCItemFood.m_iBeefCookedHungerHealed, FCItemFood.m_fBeefSaturationModifier, true, "beefCooked",
				beefCookedTextures);
		
		Item.chickenRaw = ((SEAItemFood) Item.replaceItem(Item.chickenRaw.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				FCItemFood.m_iChickenRawHungerHealed, FCItemFood.m_fChickenSaturationModifier, true, "chickenRaw",
				chickenRawTextures)).SetStandardFoodPoisoningEffect(); 
		
		Item.chickenCooked = Item.replaceItem(Item.chickenCooked.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				FCItemFood.m_iChickenCookedHungerHealed, FCItemFood.m_fChickenSaturationModifier, true, "chickenCooked",
				chickenCookedTextures);
		
		Item.rottenFlesh = ((SEAItemFood) Item.replaceItem(Item.rottenFlesh.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				3, 0F, true, "rottenFlesh",
				rottenFleshTextures)).SetIncreasedFoodPoisoningEffect();
		
		Item.spiderEye = ((SEAItemFood) Item.replaceItem(Item.spiderEye.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				2, 0.8F, false, "spiderEye",
				spiderEyeTextures)).setPotionEffect( Potion.poison.id, 5, 0, 1F ).SetNeutralBuoyant().SetFilterableProperties( Item.m_iFilterable_Small ).setPotionEffect( PotionHelper.goldenCarrotEffect );
		
		Item.carrot = Item.replaceItem(Item.carrot.itemID, SEAItemSeedFood.class, SocksEatingAnimationsAddon.instance,
				3, 0F, Block.carrot.blockID, "carrots",
				carrotsTextures).SetFilterableProperties( Item.m_iFilterable_Small ).SetAsBasicPigFood().setCreativeTab(null);
		
		Item.potato = Item.replaceItem(Item.potato.itemID, SEAItemSeedFood.class, SocksEatingAnimationsAddon.instance,
				3, 0F, Block.potato.blockID, "potato",
				potatoTextures).SetFilterableProperties( Item.m_iFilterable_Small ).SetAsBasicPigFood();
		
		Item.bakedPotato = Item.replaceItem(Item.bakedPotato.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				2, 0F, false, "potatoBaked",
				potatoBakedTextures).SetFilterableProperties( Item.m_iFilterable_Small ).SetAsBasicPigFood();
		
		Item.poisonousPotato = ((SEAItemFood) Item.replaceItem(Item.poisonousPotato.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				1, 0F, false, "potatoPoisonous",
				potatoPoisonousTextures)).setPotionEffect( Potion.poison.id, 5, 0, 0.6F ).SetFilterableProperties( Item.m_iFilterable_Small );
		
		//golden carrot
		
		Item.pumpkinPie = ((SEAItemFood) Item.replaceItem(Item.pumpkinPie.itemID, SEAItemFood.class, SocksEatingAnimationsAddon.instance,
				2, 2.5F, false, "pumpkinPie",
				pumpkinPieTextures)).setAlwaysEdible().setCreativeTab( CreativeTabs.tabFood );

	}

}
