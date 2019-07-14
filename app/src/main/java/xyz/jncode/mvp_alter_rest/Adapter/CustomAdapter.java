package xyz.jncode.mvp_alter_rest.Adapter;
//https://www.androidhive.info/2015/09/android-material-design-working-with-tabs/
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.jncode.mvp_alter_rest.Model.PhotosDetailResponse;
import xyz.jncode.mvp_alter_rest.R;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<PhotosDetailResponse> myPhotos;
    private Context context;


    public CustomAdapter(Context context, List<PhotosDetailResponse> myPhotos) {

        this.myPhotos = myPhotos;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_photos, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder customViewHolder, int i) {

        customViewHolder.titlePhotos.setText(myPhotos.get(i).title);
    }

    @Override
    public int getItemCount() {
        return myPhotos.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {


        AppCompatImageView iconPhotos;
        AppCompatTextView titlePhotos;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            iconPhotos = itemView.findViewById(R.id.imageID);
            titlePhotos= itemView.findViewById(R.id.titleID);


        }
    }
}
