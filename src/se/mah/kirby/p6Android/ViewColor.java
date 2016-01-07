package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import se.mah.kirby.Color.Color;
import se.mah.kirby.Color.ColorDisplay;
import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.view.ViewImpl;

/**
 * Created by jonatan on 2016-01-06.
 */
public class ViewColor extends Activity implements ViewImpl{
    private Controller ctrl;
    private ColorDisplay colorDisplay;
    private Controller.DIRECTION dir;

    private int color = 0;
    private int tick1 = 0, tick2 = 0, tick3 = 0, tick4 = 0, tick5 = 0, tick6 = 0, tick7 = 0, tickBig = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_color);

        colorDisplay =  (ColorDisplay) findViewById(R.id.colorDisplay);
        colorDisplay.setBackgroundColor(Color.BLACK);
        colorDisplay.setGridColor(Color.PINK);

        //Get Global Controller Class object (see application tag in AndroidManifest.xml)
        ctrl= (Controller) getApplicationContext();
        //set the view to the controller
        ctrl.setView(this);
    }

    public void switchToStartMeny(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(openNewActivity);
    }

    public void resetTick(){
        tick1 = 0;
        tick2 = 0;
        tick3 = 0;
        tick4 = 0;
        tick5 = 0;
        tick6 = 0;
        tick7 = 0;
    }

    public void updateColor(int tick){

        if(tick == 0)
            this.color = Color.BLUE;
        else if(tick == 1)
            this.color = Color.RED;
        else if(tick == 2)
            this.color = Color.GREEN;
        else if(tick == 3)
            this.color = Color.YELLOW;
        else if(tick == 4)
            this.color = Color.CYAN;
        else if(tick == 5)
            this.color = Color.MAGENTA;
        else if(tick == 6)
            this.color = Color.WHITE;
        else if(tick == 7)
            this.color = Color.LTGRAY;
        else if(tick == 8)
            this.color = Color.GRAY;
        else if(tick == 9)
            this.color = Color.DKGRAY;
        else if(tick == 10)
            this.color = Color.BLACK;
    }

//    public void randColor(View v){
  //      ctrl.showRandomColor();
    //}

    Array7 arr;
    public void chooseColor(View v){
        switch (v.getId()){
            case R.id.btn_row1:
                updateColor(tick1);
                ctrl.setElement(0, 0, color);
                tick1++;
                if(tick1 > 10)
                    tick1 = 0;
                break;
            case R.id.btn_row2:
                updateColor(tick2);
                ctrl.setElement(1, 0, color);
                tick2++;
                if(tick2 > 10)
                    tick2 = 0;
                break;
            case R.id.btn_row3:
                updateColor(tick3);
                ctrl.setElement(2, 0, color);
                tick3++;
                if(tick3 > 10)
                    tick3 = 0;
                break;
            case R.id.btn_row4:
                updateColor(tick4);
                ctrl.setElement(3, 0, color);
                tick4++;
                if(tick4 > 10)
                    tick4 = 0;
                break;
            case R.id.btn_row5:
                updateColor(tick5);
                ctrl.setElement(4, 0, color);
                tick5++;
                if(tick5 > 10)
                    tick5 = 0;
                break;
            case R.id.btn_row6:
                updateColor(tick6);
                ctrl.setElement(5, 0, color);
                tick6++;
                if(tick6 > 10)
                    tick6 = 0;
                break;
            case R.id.btn_row7:
                updateColor(tick7);
                ctrl.setElement(6, 0, color);
                tick7++;
                if(tick7 > 10)
                    tick7 = 0;
                break;
            case R.id.btn_shiftUp:
                ctrl.setDirection(Controller.DIRECTION.UP);
                arr = new Array7();
                ctrl.showShift(arr);
                break;
            case R.id.btn_shiftDown:
                ctrl.setDirection(Controller.DIRECTION.DOWN);
                arr = new Array7();
                ctrl.showShift(arr);
                break;
            case R.id.btn_shiftLeft:
                resetTick();
                ctrl.setDirection(Controller.DIRECTION.LEFT);
                arr = new Array7();
                ctrl.showShift(arr);
                break;
            case R.id.btn_shiftRight:
                resetTick();
                ctrl.setDirection(Controller.DIRECTION.RIGHT);
                arr = new Array7();
                ctrl.showShift(arr);
                break;
            case R.id.btn_randColor:
                ctrl.showRandomColor();
                break;
            case R.id.btn_oneColor:
                resetTick();
                updateColor(tickBig);
                ctrl.showSameColor(color);

                tickBig++;
                if(tickBig > 9)
                    tickBig = 0;
                break;
        }
    }

    @Override
    public void setCtrl(Controller ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public void updateView(int[][] all) {
        colorDisplay.setDisplay(all);
        colorDisplay.updateDisplay();
    }

    @Override
    public void updateBigView(Array7x7[] all) {

    }

    @Override
    public int getHorizontalPages() {
        return colorDisplay.getHorizontalPages();
    }

    @Override
    public int getVerticalPages() {
        return colorDisplay.getVerticalPages();
    }
    @Override
    public void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir) {
        // TODO Auto-generated method stub

    }
}