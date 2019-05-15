package com.emokehajdu.gunsounds;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class WelcomeActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initializeAds(this);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("0F16E7C6A3B2A844025E3E39695F70BE").build());

        final Context context = this;
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                startActivity(new Intent(context, MainActivity.class));
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    public void btnStart_OnClick(View view) {
        if(mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private static boolean areAdsInitialized = false;

    private static void initializeAds(Context context) {
        if(areAdsInitialized) {
            return;
        }

        MobileAds.initialize(context, "ca-app-pub-3940256099942544~3347511713");
        areAdsInitialized = true;
    }
}
