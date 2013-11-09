package net.vl0w.java.itunesapi.main.model;

public enum TrackAttribute {
	ID("id"), //
	NAME("name"), //
	ARTIST("artist"), //
	ALBUM("album"), //
	GENRE("genre"), //
	KIND_OF_AUDIO_FILE("kind"), //
	SIZE("size"), //
	DISC_NUMBER("disc number"), //
	DISC_COUNT("disc count"), //
	TRACK_NUMBER("track number"), YEAR("year"), //
	BPM("bpm"), //
	DATE_MODIFIED("date modified"), //
	DATE_ADDED("date added"), //
	BIT_RATE("bit rate"), //
	SAMPLE_RATE("sample rate"), //
	LOCATION("location");

	private String attributeIdentifier;

	public String getAttributeIdentifier() {
		return attributeIdentifier;
	}

	private TrackAttribute(String identifier) {
		this.attributeIdentifier = identifier;
	}
}
