package com.example.kdrelf.flickbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by KdrElf on 27.2.2015.
 */
public class FlickrRecyclerViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder> {
    private List<Photo> mPhotoList;
    private Context mContext;

    private final String LOG_TAG = FlickrRecyclerViewAdapter.class.getSimpleName();

    public FlickrRecyclerViewAdapter(Context context, List<Photo> photoList) {
        mContext = context;
        this.mPhotoList = photoList;
    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browser,null);
        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);
        return flickrImageViewHolder;
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder flickrImageViewHolder, int i) {

        Photo photoItem = mPhotoList.get(i);

        Log.d(LOG_TAG, " Processing " + photoItem.getmTitle() + " --> " + Integer.toString(i));

        Picasso.with(mContext).load(photoItem.getmImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(flickrImageViewHolder.thumbnail);

        flickrImageViewHolder.title.setText(photoItem.getmTitle());
    }

    @Override
    public int getItemCount() {
        return (null != mPhotoList ? mPhotoList.size() : 0 );
    }
}
