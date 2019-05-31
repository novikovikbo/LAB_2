package com.example.rpp_lab_2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.element, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return MainActivity.technologies.size();
    }



    //////////////
    // ViewHolder
    //////////////
    public class ViewHolder extends RecyclerView.ViewHolder
    {
         ImageView avatar;
         TextView name;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.techno_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), SliderActivity.class);
                    intent.putExtra("position", getAdapterPosition());
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        public void bind(int position) {
            name.setText(MainActivity.technologies.get(position).getName());
            Glide.with(itemView.getContext()).load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + MainActivity.technologies.get(position).getGraphic()).into(avatar);
        }
    }
}
