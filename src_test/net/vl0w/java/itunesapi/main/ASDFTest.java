package net.vl0w.java.itunesapi.main;

import java.util.List;

import junit.framework.TestCase;
import net.vl0w.java.itunesapi.main.model.Track;
import net.vl0w.java.itunesapi.main.model.TrackAttribute;
import net.vl0w.java.itunesapi.main.query.TrackQuery;
import net.vl0w.java.itunesapi.main.query.TrackQueryBuilder;

import org.junit.Test;

public class ASDFTest extends TestCase {
	@Test
	public void testONe() throws Exception {
		MusicLibrary library = iTunesAPI.INSTANCE.getLibrary();

		TrackQueryBuilder qb = new TrackQueryBuilder();
		TrackQuery query = qb.attributeMustBe(TrackAttribute.ARTIST,
				"Aaskereia").build();

		List<Track> tracks = library.queryTracks(query);
		for (Track track : tracks) {
			System.out.println("Track found: " + track);
		}

	}
}
