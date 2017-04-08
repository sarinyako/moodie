package learnapi.immindie.moodiie.Network;

import java.util.List;

import learnapi.immindie.moodiie.Model.Track;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SoundCloundAPI {
    @GET("tracks")
    Call<List<Track>> trackList(@Query("title") String tagList, @Query("client_id") String clientID);


}
