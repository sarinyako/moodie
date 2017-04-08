package learnapi.immindie.moodiie.Model;

public class Track {

    private int id;
    private int duration;
    private String title;
    private String uri;
    private String genre;
    private String sharing;
    private String artwork_url;
    private String user_id;
    private String playback_count;

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }

    public String getGenre() {
        return genre;
    }

    public String getSharing() {
        return sharing;
    }

    public String getArtworkurl() {
        return artwork_url;
    }

    public String getUser() {
        return user_id;
    }

    public String getPlaybackCount() {
        return playback_count;
    }


}