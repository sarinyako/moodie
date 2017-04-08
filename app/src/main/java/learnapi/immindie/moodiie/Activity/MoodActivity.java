package learnapi.immindie.moodiie.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import learnapi.immindie.moodiie.Adapter.MoodAdapter;
import learnapi.immindie.moodiie.Model.Mood;
import learnapi.immindie.moodiie.R;

public class MoodActivity extends AppCompatActivity {
    Context context;
    MoodAdapter moodAdapter;
    private List<Mood> mood = new ArrayList<>();
    private RecyclerView getRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        initializeData();
        initializeView();

    }

    private void initializeView() {
        getRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        getRecyclerView.setLayoutManager(layoutManager);
        // getRecyclerView.setAdapter(moodAdapter);

        moodAdapter = new MoodAdapter(mood);
        getRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        getRecyclerView.setAdapter(moodAdapter);

    }

    private void initializeData() {
        context = getApplicationContext();


        mood.add(new Mood("Happy", R.drawable.happy));
        mood.add(new Mood("Exuberant", R.drawable.exuberant));
        mood.add(new Mood("Sad", R.drawable.sad));
    }
}
