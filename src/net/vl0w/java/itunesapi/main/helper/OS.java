package net.vl0w.java.itunesapi.main.helper;

public class OS {
	public static boolean isMacOsX() {
		return System.getProperty("os.name").equals("Mac OS X");
	}

	public static boolean isWindows() {
		return System.getProperty("os.name").startsWith("Windows");
	}

	public static boolean isWindows32() {
		return isWindows() && System.getProperty("os.arch").equals("x86");
	}

}
