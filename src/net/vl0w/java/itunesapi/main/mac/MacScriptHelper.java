package net.vl0w.java.itunesapi.main.mac;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import net.vl0w.java.itunesapi.main.iTunesAPI;
import net.vl0w.java.itunesapi.main.model.Track;
import net.vl0w.java.itunesapi.main.model.TrackAttribute;
import net.vl0w.java.itunesapi.main.query.ConditionBuilder;

import org.apache.commons.io.IOUtils;

public class MacScriptHelper {

	public List<Long> getAllTrackIds() throws IOException, ScriptException {
		String script = getScript("QueryAllTracks.applescript");
		Object result = getEngine().eval(script);
		return (List<Long>) result;
	}

	public List<Track> queryTracksByCondition(ConditionBuilder conditionBuilder)
			throws IOException, ScriptException {
		String script = getScript("QueryTracksByCondition.applescript");
		script = script.replaceAll("<CONDITION>", conditionBuilder.build());

		List<Long> trackIds = (List<Long>) getEngine().eval(script);
		List<Track> tracks = new ArrayList<>();
		for (Long trackId : trackIds) {
			tracks.add(new Track(trackId));
		}
		return tracks;
	}

	public String queryAttributeOfTrack(TrackAttribute attribute, Long trackId)
			throws ScriptException, IOException {
		String script = getScript("QueryAttributeOfTrack.applescript");
		script = script.replaceAll("<ATTRIBUTE>",
				attribute.getAttributeIdentifier());
		script = script.replaceAll("<TRACK_ID>", String.valueOf(trackId));

		Object result = getEngine().eval(script);
		String unparsedStringResult = String.valueOf(result);
		return unparsedStringResult.substring(1,
				unparsedStringResult.length() - 1);
	}

	private String getScript(String scriptName) throws IOException {
		InputStream stream = iTunesAPI.class.getClassLoader()
				.getResourceAsStream(
						"net/vl0w/java/itunesapi/resources/scripts/"
								+ scriptName);
		return IOUtils.toString(stream);
	}

	private ScriptEngine getEngine() {
		return new ScriptEngineManager().getEngineByName("AppleScript");
	}

}
