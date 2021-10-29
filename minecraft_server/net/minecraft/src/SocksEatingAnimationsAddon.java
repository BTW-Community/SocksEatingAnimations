package net.minecraft.src;

/**
 * @author Sockthing (@socklessthing)
 *
 */

public class SocksEatingAnimationsAddon extends FCAddOn {
    public static SocksEatingAnimationsAddon instance = new SocksEatingAnimationsAddon();
    

    private SocksEatingAnimationsAddon() {
        super("Sock's Eating Animations", "1.0.0", "SEA");
    }
    
    @Override
    public void Initialize() {
    	FCAddOnHandler.LogMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    	SEADefs.addDefinitions();
		
    	FCAddOnHandler.LogMessage(this.getName() + " Initialized");
    }
    
//    @Override
//    public String GetLanguageFilePrefix() {
//    	return "SEA";
//    }
}