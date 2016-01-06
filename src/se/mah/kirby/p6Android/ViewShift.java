package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by jonatan on 2016-01-06.
 */
public class ViewShift extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_shift);
    }

    public void switchToStartMeny(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(openNewActivity);
    }
}