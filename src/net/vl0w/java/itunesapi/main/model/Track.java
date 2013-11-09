package net.vl0w.java.itunesapi.main.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptException;

import net.vl0w.java.itunesapi.main.mac.MacScriptHelper;

public class Track {

	private Map<TrackAttributes, String> attributes;

	public Track(Long id) {
		attributes = new HashMap<>();
		attributes.put(TrackAttributes.ID, String.valueOf(id));
	}

	public Long getId() {
		Long id = new Long(-1);
		id = Long.valueOf(attributes.get(TrackAttributes.ID));
		return id;
	}

	public String getName() {
		return getAttribute(TrackAttributes.NAME);
	}

	public String getArtist() {
		return getAttribute(TrackAttributes.ARTIST);
	}

	public String getAlbum() {
		return getAttribute(TrackAttributes.ALBUM);
	}

	public String getGenre() {
		return getAttribute(TrackAttributes.GENRE);
	}

	public String getKindOfAudioFile() {
		return getAttribute(TrackAttributes.KIND_OF_AUDIO_FILE);
	}

	public String getSize() {
		return getAttribute(TrackAttributes.SIZE);
	}

	public String getDiscNumber() {
		return getAttribute(TrackAttributes.DISC_NUMBER);
	}

	public String getDiscCount() {
		return getAttribute(TrackAttributes.DISC_COUNT);
	}

	public String getTrackNumber() {
		return getAttribute(TrackAttributes.TRACK_NUMBER);
	}

	public String getBPM() {
		return getAttribute(TrackAttributes.BPM);
	}

	public String getDateModified() {
		return getAttribute(TrackAttributes.DATE_MODIFIED);
	}

	public String getDateAdded() {
		return getAttribute(TrackAttributes.DATE_ADDED);
	}

	public String getBitRate() {
		return getAttribute(TrackAttributes.BIT_RATE);
	}

	public String getSampleRate() {
		return getAttribute(TrackAttributes.SAMPLE_RATE);
	}

	public String getLocation() {
		return getAttribute(TrackAttributes.LOCATION);
	}

	@Override
	public String toString() {
		return "'" + getName() + "' by " + getArtist();
	}

	private String getAttribute(TrackAttributes attribute) {
		if (!attributes.containsKey(attribute)) {
			String value = queryAttribute(attribute);
			attributes.put(attribute, value);
		}
		return attributes.get(attribute);
	}

	private String queryAttribute(TrackAttributes attribute) {
		MacScriptHelper scriptHelper = new MacScriptHelper();
		try {
			return scriptHelper.getTrackAttribute(getId(), attribute);
		} catch (IOException | ScriptException e) {
			return "? (API ERROR)";
		}
	}
}
