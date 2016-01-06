package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import se.mah.kirby.Color.IntDisplay;
import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.view.ViewImpl;

/**
 * Created by jonatan on 2016-01-06.
 */
public class ViewShift extends Activity implements ViewImpl {
    private Controller ctrlShift;
    private IntDisplay intDisplayshift;
    private TextView[] textViews = new TextView[7];


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_shift);

        intDisplayshift = (IntDisplay) findViewById(R.id.shiftDisplay);

        ctrlShift = (Controller) getApplicationContext();
        ctrlShift.setView(this);
        ctrlShift.showRandom();

        textViews[0] = (TextView) findViewById(R.id.txt_edit01);
        textViews[1] = (TextView) findViewById(R.id.txt_edit02);
        textViews[2] = (TextView) findViewById(R.id.txt_edit03);
        textViews[3] = (TextView) findViewById(R.id.txt_edit04);
        textViews[4] = (TextView) findViewById(R.id.txt_edit05);
        textViews[5] = (TextView) findViewById(R.id.txt_edit06);
        textViews[6] = (TextView) findViewById(R.id.txt_edit07);
    }

    public void shiftRight(View view){
        ctrlShift.setDirection(Controller.DIRECTION.RIGHT);



    }
    public void shiftLeft(View view){

    }
    @Override
    public void setCtrl(Controller ctrl) {
        this.ctrlShift = ctrl;
    }

    @Override
    public void updateView(int[][] all) {
        this.intDisplayshift.setDisplay(all);
        this.intDisplayshift.updateDisplay();
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
        this.intDisplayshift.setDisplay(all.get(0));
        this.intDisplayshift.updateDisplay();
    }
    public void switchToStartMeny(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(openNewActivity);
    }
}