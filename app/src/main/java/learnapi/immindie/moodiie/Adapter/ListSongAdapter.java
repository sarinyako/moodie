package learnapi.immindie.moodiie.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import learnapi.immindie.moodiie.Model.Track;
import learnapi.immindie.moodiie.R;


public class ListSongAdapter extends RecyclerView.Adapter<ListSongAdapter.MyViewHolder> {
    List<Track> TrackList;
    Context context;

    public ListSongAdapter(List<Track> TrackList) {
        this.TrackList = TrackList;
    }

    @Override
    public int getItemCount() {
        return TrackList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.listsong, parent, false);
        context = parent.getContext();
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Track track = TrackList.get(position);
        holder.txtTitle.setText(track.getTitle());

        holder.txtSharing.setText("Count : " + track.getPlaybackCount());

        if (track.getUser() != null) {
            holder.txtStation.setText(track.getUser());
        }

        if (track.getArtworkurl() != null) {
            //holder.imgThumb.setImageDrawable(getImageThumb(track.getArtworkurl()));
            Picasso.with(context).load(track.getArtworkurl()).into(holder.imgThumb);

        }

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtSharing, txtStation, txtDuration;
        ImageView imgThumb;


        private MyViewHolder(View view) {
            super(view);
            txtStation = (TextView) view.findViewById(R.id.txt_station);
            txtTitle = (TextView) view.findViewById(R.id.txt_title);
            txtSharing = (TextView) view.findViewById(R.id.txt_count);
            imgThumb = (ImageView) view.findViewById(R.id.img_thumb);
            txtDuration = (TextView) view.findViewById(R.id.txt_duration);

        }

    }
}
