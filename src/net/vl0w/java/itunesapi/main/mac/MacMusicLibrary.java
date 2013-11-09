package net.vl0w.java.itunesapi.main.mac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.script.ScriptException;

import net.vl0w.java.itunesapi.main.MusicLibrary;
import net.vl0w.java.itunesapi.main.model.Track;
import net.vl0w.java.itunesapi.main.model.TrackAttribute;
import net.vl0w.java.itunesapi.main.query.ConditionBuilder;
import net.vl0w.java.itunesapi.main.query.TrackQuery;

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

	@Override
	public List<Track> queryTracks(TrackQuery query) throws IOException,
			ScriptException {
		ConditionBuilder conditionBuilder = new ConditionBuilder();

		Map<TrackAttribute, String> attributeEquality = query
				.getAttributeEquality();
		for (TrackAttribute attribute : attributeEquality.keySet()) {
			conditionBuilder.attribute(attribute).is(
					attributeEquality.get(attribute));
		}

		return scriptHelper.queryTracksByCondition(conditionBuilder);
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
