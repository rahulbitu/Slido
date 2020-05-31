package com.slido.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.slido.R;
import com.slido.ScreenItem;

import java.util.List;

public class IntroViewPagerAdapter extends PagerAdapter {
    Context context;
    List<ScreenItem> screenItems;

    public IntroViewPagerAdapter(Context context, List<ScreenItem> screenItems) {
        this.context = context;
        this.screenItems = screenItems;
    }

    @Override
    public int getCount() {
        return screenItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.intro_slider_raw,null);
        ImageView imgSlide = view.findViewById(R.id.imgView);
        TextView heading = view.findViewById(R.id.headingTxt);
        TextView description = view.findViewById(R.id.desTxt);

        heading.setText(screenItems.get(position).getTitle());
        description.setText(screenItems.get(position).getDescription());
        imgSlide.setImageResource(screenItems.get(position).getScreenImg());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
