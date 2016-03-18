package com.arjinmc.ratinglevelbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.arjinmc.ratinglevelbar.widgets.SRatingBar;

public class MainActivity extends AppCompatActivity {

    private SRatingBar sRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sRatingBar = (SRatingBar) findViewById(R.id.ratingbar);
        //set rating total star
        sRatingBar.setNumStar(6);
        //set rating score
        sRatingBar.setRating(3);

        sRatingBar.setOnRatngChangeListener(new SRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(int position) {
                //callback for click the ratingbar
                Log.e("rating",position+"");
            }
        });
    }
}
