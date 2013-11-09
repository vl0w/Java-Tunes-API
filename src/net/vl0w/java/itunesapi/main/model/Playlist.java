package net.vl0w.java.itunesapi.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements Serializable {

	private static final long serialVersionUID = 2248150084454712212L;

	private String name;
	private List<Track> tracks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public Playlist(String name) {
		this.name = name;
		this.tracks = new ArrayList<Track>();
	}

	@Override
	public String toString() {
		return getName() + " (" + tracks.size() + " tracks)";
	}
}
