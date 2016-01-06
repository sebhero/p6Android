package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import se.mah.kirby.Color.Color;
import se.mah.kirby.Color.ColorDisplay;
import se.mah.kirby.controller.Controller;
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

    public void randColor(View v){
        System.out.println("hello");
        ctrl.showRandomColor();
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