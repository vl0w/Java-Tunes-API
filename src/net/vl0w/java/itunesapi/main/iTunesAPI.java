package net.vl0w.java.itunesapi.main;

import net.vl0w.java.itunesapi.main.helper.OS;
import net.vl0w.java.itunesapi.main.mac.MacMusicLibrary;

public enum iTunesAPI {
	INSTANCE;

	iTunesAPI() {
	}

	private MusicLibrary library;

	public MusicLibrary getLibrary() throws Exception {
		if (library == null) {
			library = loadLibrary();
		}
		return library;
	}

	private MusicLibrary loadLibrary() throws Exception {
		if (OS.isMacOsX()) {
			return new MacMusicLibrary();
		} else if (OS.isWindows()) {
			throw new Exception("Unsupported operating system");
		} else {
			throw new Exception("Unsupported operating system");
		}
	}
}
