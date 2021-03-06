package com.example.dillonconnolly.admobpractice;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Dillon Connolly on 12/9/2015.
 */
public class BannerActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        mAdView = (AdView) findViewById(R.id.ad_view);
        mAdView.setAdListener(new ToastAdListener(getApplicationContext()));
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mAdView.loadAd(adRequest);
    }
}
