package net.vl0w.java.itunesapi.main.query;

import net.vl0w.java.itunesapi.main.model.TrackAttribute;

public class TrackQueryBuilder {

	private TrackQuery query;

	public TrackQueryBuilder() {
		query = new TrackQuery();
	}

	public TrackQueryBuilder attributeMustBe(TrackAttribute attribute,
			String value) {
		query.addAttributeEquality(attribute, value);
		return this;
	}

	public TrackQuery build() {
		return query;
	}

}
