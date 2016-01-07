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
 * klasssen kommer att ha fyra knappar som gör det möjligt att byta mellan olika vyer
 */
public class StartActivity extends Activity implements ViewImpl{
    private Controller ctrl;

    /**
     * Metoden kommer att sätta upp standard layouten
     * @param savedInstanceState
     */
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

    /**
     * Metoden kommer att sätta en input kontroller till den lokala
     * @param ctrl
     */
    @Override
    public void setCtrl(Controller ctrl) {

    }

    //används inte
    @Override
    public void updateView(int[][] all) {

    }

    //används inte
    @Override
    public void updateBigView(Array7x7[] all) {

    }

    //används inte
    @Override
    public int getHorizontalPages() {
        return 0;
    }

    //används inte
    @Override
    public int getVerticalPages() {
        return 0;
    }

    //används inte
    @Override
    public void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir) {
    }

    /**
     *Metoden kommer att byta view till NumberActivity
     * @param view för att få kontakt med knappen
     */
    public void switchToNumberActivity(View view){
        Intent openNewActivity = new Intent(getApplicationContext(), NumberActivity.class);
        startActivity(openNewActivity);
    }

    /**
     * Metoden kommer att byra view till Flowtext
     * @param view för att få kontakt med knappen
     */
    public void switchToColorTextView(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), FlowText.class);
        startActivity(openNewActivity);
    }

    /**
     *Metoden kommer att byta view till ViewColor
     * @param view
     */
    public void switchToColorView(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), ViewColor.class);
        startActivity(openNewActivity);
    }

    /**
     * Metoden kommer att byta view till viewShift
     * @param view
     */
    public void switchToShiftView(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), ViewShift.class);
        startActivity(openNewActivity);
    }
}