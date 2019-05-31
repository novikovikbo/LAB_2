package com.example.rpp_lab_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TabViewAdapter extends PagerAdapter {
    Context context;
    @Override
    public int getCount() {
        return MainActivity.technologies.size();
    }

    public TabViewAdapter(Context ctx) {
        context = ctx;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (LinearLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.slide, container,false);
        ImageView avatar = view.findViewById(R.id.avatar_page);
        TextView name = view.findViewById(R.id.page_name);
        TextView description = view.findViewById(R.id.description);

        Glide
                .with(context)
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + MainActivity.technologies.get(position).getGraphic())
                .into(avatar);
        name.setText(MainActivity.technologies.get(position).getName());
        description.setText(MainActivity.technologies.get(position).getHelptext());
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
