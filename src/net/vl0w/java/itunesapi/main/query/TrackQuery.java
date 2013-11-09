package net.vl0w.java.itunesapi.main.query;

import java.util.HashMap;
import java.util.Map;

import net.vl0w.java.itunesapi.main.model.TrackAttribute;

public class TrackQuery {
	private Map<TrackAttribute, String> attributeEquality;

	public TrackQuery() {
		attributeEquality = new HashMap<>();
	}

	public Map<TrackAttribute, String> getAttributeEquality() {
		return attributeEquality;
	}

	public void addAttributeEquality(TrackAttribute attribute, String value) {
		attributeEquality.put(attribute, value);
	}

}
