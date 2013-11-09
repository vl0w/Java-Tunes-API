package net.vl0w.java.itunesapi.main;

import java.io.IOException;
import java.util.List;

import javax.script.ScriptException;

import net.vl0w.java.itunesapi.main.model.Track;
import net.vl0w.java.itunesapi.main.query.TrackQuery;

public interface MusicLibrary {

	List<Track> getTracks();

	List<Track> queryTracks(TrackQuery query) throws IOException,
			ScriptException;

}