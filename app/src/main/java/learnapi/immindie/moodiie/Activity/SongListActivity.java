package learnapi.immindie.moodiie.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import learnapi.immindie.moodiie.Adapter.ListSongAdapter;
import learnapi.immindie.moodiie.Model.Track;
import learnapi.immindie.moodiie.Network.SoundCloundNetwork;
import learnapi.immindie.moodiie.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongListActivity extends AppCompatActivity {
    RecyclerView getRecyclerView;
    ListSongAdapter listAdapter;
    List<Track> trackList = new ArrayList<>();
    Context context;
    String keyGenre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        initialize();

        RecyclerView.LayoutManager layoutmgn = new LinearLayoutManager(context);
        getRecyclerView.setLayoutManager(layoutmgn);
        getRecyclerView.setAdapter(listAdapter);
        getTrackData();

    }

    private void getTrackData() {

        SoundCloundNetwork.getInstance()
                .getApi()
                .trackList("Half Life 2 CP Violation Dubstep Remix", "e2a6681bccff23130855618e14c481af")


                .enqueue(new Callback<List<Track>>() {
                    @Override
                    public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                        Log.d("", "onResponse() called with: call = [" + call + "], response = [" + response + "]");
                        // Log.d("Track List", response.body().get(2).getTitle());
                        listAdapter = new ListSongAdapter(response.body());
                        getRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                        getRecyclerView.setAdapter(listAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Track>> call, Throwable t) {

                    }
                });

    }

    private void initialize() {
        context = getApplicationContext();
        listAdapter = new ListSongAdapter(trackList);
        getRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Bundle getGenere = getIntent().getExtras();
        if (getGenere != null) {
            keyGenre = getGenere.getString("GENRE");
            Log.d("INTENT GENRE:: ", keyGenre);
        }


    }
}