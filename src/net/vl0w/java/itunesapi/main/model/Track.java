package net.vl0w.java.itunesapi.main.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptException;

import net.vl0w.java.itunesapi.main.mac.MacScriptHelper;

public class Track {

	private Map<TrackAttribute, String> attributes;

	public Track(String id) {
		this(Long.valueOf(id));
	}

	public Track(Long id) {
		attributes = new HashMap<>();
		attributes.put(TrackAttribute.ID, String.valueOf(id));
	}

	public Long getId() {
		Long id = new Long(-1);
		id = Long.valueOf(attributes.get(TrackAttribute.ID));
		return id;
	}

	public String getName() {
		return getAttribute(TrackAttribute.NAME);
	}

	public String getArtist() {
		return getAttribute(TrackAttribute.ARTIST);
	}

	public String getAlbum() {
		return getAttribute(TrackAttribute.ALBUM);
	}

	public String getGenre() {
		return getAttribute(TrackAttribute.GENRE);
	}

	public String getKindOfAudioFile() {
		return getAttribute(TrackAttribute.KIND_OF_AUDIO_FILE);
	}

	public String getSize() {
		return getAttribute(TrackAttribute.SIZE);
	}

	public String getDiscNumber() {
		return getAttribute(TrackAttribute.DISC_NUMBER);
	}

	public String getDiscCount() {
		return getAttribute(TrackAttribute.DISC_COUNT);
	}

	public String getTrackNumber() {
		return getAttribute(TrackAttribute.TRACK_NUMBER);
	}

	public String getBPM() {
		return getAttribute(TrackAttribute.BPM);
	}

	public String getDateModified() {
		return getAttribute(TrackAttribute.DATE_MODIFIED);
	}

	public String getDateAdded() {
		return getAttribute(TrackAttribute.DATE_ADDED);
	}

	public String getBitRate() {
		return getAttribute(TrackAttribute.BIT_RATE);
	}

	public String getSampleRate() {
		return getAttribute(TrackAttribute.SAMPLE_RATE);
	}

	public String getLocation() {
		return getAttribute(TrackAttribute.LOCATION);
	}

	public String getAttribute(TrackAttribute attribute) {
		if (!attributes.containsKey(attribute)) {
			String value = queryAttribute(attribute);
			attributes.put(attribute, value);
		}
		return attributes.get(attribute);
	}

	@Override
	public String toString() {
		return "'" + getName() + "' by " + getArtist();
	}

	private String queryAttribute(TrackAttribute attribute) {
		MacScriptHelper scriptHelper = new MacScriptHelper();
		try {
			return scriptHelper.queryAttributeOfTrack(attribute, getId());
		} catch (IOException | ScriptException e) {
			return "? (API ERROR)";
		}
	}
}
