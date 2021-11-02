package net.minecraft.src;

public class SEADecoIntegration {
	private static boolean isDecoInstalled = false;
	private static Class decoDefs = null;
	
	public static void init() {
		try {
			try {
				decoDefs = Class.forName("DecoDefs");
			} catch (ClassNotFoundException e) {
				try {
					decoDefs = Class.forName("net.minecraft.src.DecoDefs");
				} catch (ClassNotFoundException e1) {
					
				}
			}
			
			if (decoDefs != null) {
				isDecoInstalled = true;

			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private static Object getDecoField(String fieldName) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		return decoDefs.getDeclaredField(fieldName).get(null);
	}
	
	public static boolean isDecoInstalled() {
		return isDecoInstalled;
	}
}