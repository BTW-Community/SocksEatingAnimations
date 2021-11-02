package net.minecraft.src;

import java.util.List;

/**
 * @author Sockthing (@socklessthing)
 *
 */
public class SocksEatingAnimationsAddon extends AddonExt {
	private static SocksEatingAnimationsAddon instance;

	public SocksEatingAnimationsAddon() {
		super("Sock's Eating Animations", "1.0.0", "SEA");
	}

	public static SocksEatingAnimationsAddon getInstance() {
		if (instance == null) {
			instance = new SocksEatingAnimationsAddon();
		}

		return instance;
	}

	@Override
	public void Initialize() {
		
		SEADecoIntegration.init();
		SEADefs.addDefinitions(); //add blocks and items
	}
	
	public String GetLanguageFilePrefix()
	{
		return "SEA";
	}


}