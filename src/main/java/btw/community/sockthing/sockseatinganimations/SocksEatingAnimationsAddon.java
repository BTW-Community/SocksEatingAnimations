package btw.community.sockthing.sockseatinganimations;

import btw.AddonHandler;
import btw.BTWAddon;

public class SocksEatingAnimationsAddon extends BTWAddon {
    private static SocksEatingAnimationsAddon instance;

    private SocksEatingAnimationsAddon() {
        super("Sock's Eating Animations", "2.0.0", "SEA");
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }

    public static SocksEatingAnimationsAddon getInstance() {
        if (instance == null)
            instance = new SocksEatingAnimationsAddon();
        return instance;
    }
}
