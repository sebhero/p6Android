package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import se.mah.kirby.Color.IntDisplay;
import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.view.ViewImpl;

/**
 * Created by jonatan on 2016-01-06.
 */
public class ViewShift extends Activity implements ViewImpl {
    private Controller ctrlShift;
    private IntDisplay intDisplayshift;
    private TextView textViews01;
    private TextView textViews02;
    private TextView textViews03;
    private TextView textViews04;
    private TextView textViews05;
    private TextView textViews06;
    private TextView textViews07;
    private Array7 arr = new Array7();
    private Array7 temp1 = new Array7();
    private Array7 temp2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_shift);

        intDisplayshift = (IntDisplay) findViewById(R.id.shiftDisplay);

        ctrlShift = (Controller) getApplicationContext();
        ctrlShift.setView(this);
        ctrlShift.showRandom();

        textViews01 = (TextView) findViewById(R.id.txt_edit01);
        textViews02 = (TextView) findViewById(R.id.txt_edit02);
        textViews03 = (TextView) findViewById(R.id.txt_edit03);
        textViews04 = (TextView) findViewById(R.id.txt_edit04);
        textViews05 = (TextView) findViewById(R.id.txt_edit05);
        textViews06 = (TextView) findViewById(R.id.txt_edit06);
        textViews07 = (TextView) findViewById(R.id.txt_edit07);
    }

    public void shiftRight(View view){

        for (int i = 0; i < temp1.getLength(); i++) {
                temp1.setElement(i, ctrlShift.getElement(i, 0));
        }
        textViews01.setText(String.valueOf(ctrlShift.getElement(0,0)));
        textViews02.setText(String.valueOf(ctrlShift.getElement(0,1)));
        textViews03.setText(String.valueOf(ctrlShift.getElement(0,2)));
        textViews04.setText(String.valueOf(ctrlShift.getElement(0,3)));
        textViews05.setText(String.valueOf(ctrlShift.getElement(0,4)));
        textViews06.setText(String.valueOf(ctrlShift.getElement(0,5)));
        textViews07.setText(String.valueOf(ctrlShift.getElement(0,6)));

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