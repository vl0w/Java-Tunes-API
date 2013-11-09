package net.vl0w.java.itunesapi.main.mac;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import net.vl0w.java.itunesapi.main.iTunesAPI;
import net.vl0w.java.itunesapi.main.model.TrackAttributes;

import org.apache.commons.io.IOUtils;

public class MacScriptHelper {

	// @Deprecated
	// public boolean isTrackInItunes(Track track) throws ScriptException,
	// IOException {
	// String script = getScript("QueryTrack.applescript");
	// script = script.replace("<ARTIST>", track.getArtist());
	// script = script.replace("<TRACK>", track.getName());
	//
	// Object result = getEngine().eval(script);
	// return !((List<String>) result).isEmpty();
	// }
	//
	// @Deprecated
	// public void addTrackToItunes(String filePath) throws IOException,
	// ScriptException {
	// // TODO Duplicate Code!
	// String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
	// String playlistName = "\"ShareTunes " + date + "\"";
	//
	// String script = getScript("AddTrackToITunes.applescript");
	// script = script.replaceAll("<PLAYLIST>", playlistName);
	// script = script.replaceAll("<PATH>", "\"" + filePath + "\"");
	//
	// getEngine().eval(script);
	//
	// }

	public List<Long> getAllTrackIds() throws IOException, ScriptException {
		String script = getScript("QueryTrackIDs.applescript");
		Object result = getEngine().eval(script);
		return (List<Long>) result;
	}

	public String getTrackAttribute(Long trackId, TrackAttributes attribute)
			throws IOException, ScriptException {
		String script = getScript("QueryTrackAttribute.applescript");
		script = script.replaceAll("<ATTRIBUTE>",
				attribute.getAttributeIdentifier());
		script = script.replaceAll("<TRACK_ID>", String.valueOf(trackId));

		Object result = getEngine().eval(script);
		String value = String.valueOf(result);
		return value.substring(1, value.length() - 1);
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
