package learnapi.immindie.moodiie.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import learnapi.immindie.moodiie.Model.Mood;
import learnapi.immindie.moodiie.R;


public class MoodAdapter extends RecyclerView.Adapter<MoodAdapter.MoodViewHolder> {
    Context context;
    List<Mood> MoodList;

    public MoodAdapter(List<Mood> MoodList) {
        this.MoodList = MoodList;
    }

    @Override
    public MoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.listmood, parent, false);
        context = parent.getContext();
        return new MoodAdapter.MoodViewHolder(item);
    }


    @Override
    public void onBindViewHolder(MoodViewHolder holder, int position) {
        Mood track = MoodList.get(position);
        holder.txtMood.setText(track.getMood());
        Picasso.with(context).load(track.getThumbnail()).into(holder.imgThumb);

    }

    @Override
    public int getItemCount() {
        return MoodList.size();
    }

    public class MoodViewHolder extends RecyclerView.ViewHolder {
        TextView txtMood;
        ImageView imgThumb;


        private MoodViewHolder(View view) {
            super(view);
            txtMood = (TextView) view.findViewById(R.id.txt_mood);
            imgThumb = (ImageView) view.findViewById(R.id.img_thumb);
            view.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    Log.d("Check List Click ", " ");


                }

            });


        }

    }
}
