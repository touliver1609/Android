package com.example.touliver1609.listviewmusic;

public class Song {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    private String name;
    private String artist;
    private int icon;

    public Song(String name, String artist, int icon) {
        this.name = name;
        this.artist = artist;
        this.icon = icon;
    }
}
