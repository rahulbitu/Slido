package com.slido;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.slido.Adapters.IntroViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Intro_slider extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.nextBtn)
    Button nextBtn;
    @BindView(R.id.tab_indicator)
    TabLayout tab_indicator;
    @BindView(R.id.getStartButon)
    Button getStartButon;
    List<ScreenItem> mList = new ArrayList<>();
    int position = 0;
    Animation btnAnim;

    private IntroViewPagerAdapter introViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //make full screen
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro_slider);
        ButterKnife.bind(this);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);

        //fill list screen


        mList.add(new ScreenItem("Show Talent", "nice talent make mens sccessfull", R.drawable.dance5));
        mList.add(new ScreenItem("Show Talent", "nice talent make mens sccessfull", R.drawable.dance7));
        mList.add(new ScreenItem("Show Talent", "nice talent make mens sccessfull", R.drawable.dance6));

        //setup view pager
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        viewPager.setAdapter(introViewPagerAdapter);
        //setup tablayout with viewpager

        tab_indicator.setupWithViewPager(viewPager);

        tab_indicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == mList.size() - 1){
                    loadLastScreen();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

    }

    @OnClick(R.id.nextBtn)
    public void onViewClicked() {

        position = viewPager.getCurrentItem();
        if(position < mList.size()){
            position++;
            viewPager.setCurrentItem(position);
        }
        if(position == mList.size() - 1){
            loadLastScreen();
        }

    }

    private void loadLastScreen() {
        nextBtn.setVisibility(View.INVISIBLE);
        getStartButon.setVisibility(View.VISIBLE);
        tab_indicator.setVisibility(View.INVISIBLE);
        getStartButon.setAnimation(btnAnim);
    }
}