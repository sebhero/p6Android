package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.view.ViewImpl;

/**
 * Created by jonatan on 2016-01-05.
 */
public class StartActivity extends Activity implements ViewImpl{
    private Controller ctrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_view);
        getActionBar().hide();

        //Get Global Controller Class object (see application tag in AndroidManifest.xml)
        ctrl= (Controller) getApplicationContext();
        //set the view to the controller
        ctrl.setView(this);
    }

    @Override
    public void setCtrl(Controller ctrl) {

    }

    @Override
    public void updateView(int[][] all) {

    }

    @Override
    public void updateBigView(Array7x7[] all) {

    }

    @Override
    public int getHorizontalPages() {
        return 0;
    }

    @Override
    public int getVerticalPages() {
        return 0;
    }

    @Override
    public void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir) {

    }

    public void switchToNumberActivity(View view){
        Intent openNewActivity = new Intent(getApplicationContext(), NumberActivity.class);
        startActivity(openNewActivity);
    }

    public void switchToColorTextView(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), FlowText.class);
        startActivity(openNewActivity);
    }
    public void switchToColorView(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), ViewColor.class);
        startActivity(openNewActivity);
    }
    public void switchToShiftView(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), ViewShift.class);
        startActivity(openNewActivity);
    }
}