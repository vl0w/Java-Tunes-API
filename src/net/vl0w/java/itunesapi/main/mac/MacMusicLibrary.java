package net.vl0w.java.itunesapi.main.mac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptException;

import net.vl0w.java.itunesapi.main.MusicLibrary;
import net.vl0w.java.itunesapi.main.model.Track;

public class MacMusicLibrary implements MusicLibrary {

	private MacScriptHelper scriptHelper;
	private List<Track> tracks;

	public MacMusicLibrary() {
		scriptHelper = new MacScriptHelper();
	}

	@Override
	public List<Track> getTracks() {
		if (tracks == null) {
			loadTracks();
		}
		return tracks;
	}

	private void loadTracks() {
		tracks = new ArrayList<>();

		try {
			List<Long> trackIds = scriptHelper.getAllTrackIds();

			for (Long trackId : trackIds) {
				Track track = new Track(trackId);
				tracks.add(track);
			}

		} catch (IOException | ScriptException e) {
			e.printStackTrace();
		}
	}
}
