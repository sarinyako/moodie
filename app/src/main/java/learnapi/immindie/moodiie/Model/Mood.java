package learnapi.immindie.moodiie.Model;


public class Mood {
    private int thumbnail;
    private String mood;

    public Mood(String mood, int thumbnail) {
        this.mood = mood;
        this.thumbnail = thumbnail;
    }


    public String getMood() {
        return mood;
    }

    public int getThumbnail() {
        return thumbnail;
    }
}
