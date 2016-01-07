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
    private Array7 arr;
    private int color = 0;
    private int tick1 = 0, tick2 = 0, tick3 = 0, tick4 = 0, tick5 = 0, tick6 = 0, tick7 = 0, tickBig = 0;

    /**
     * Metoden kommer att användas vid start va aktiviteten och sätta hur layouten ser ut
     * @param savedInstanceState
     */
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

    /**
     * Metoden kommer att göra så att man kan återvända till huvudmenyn
     * @param view fär att få kontakt med knappen
     */
    public void switchToStartMeny(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(openNewActivity);
    }

    /**
     * Metoden kommer att nollställa ticksen som bestämmer vilken färg man kommer att
     * sätta på colordisplayn
     */
    public void resetTick(){
        tick1 = 0;
        tick2 = 0;
        tick3 = 0;
        tick4 = 0;
        tick5 = 0;
        tick6 = 0;
        tick7 = 0;
    }

    /**
     * Metoden kommer att byta mellan 11 olika färger som man
     * kan sätte i colordisplayn
     * @param tick vilken färg det kommer att bli
     */
    public void updateColor(int tick){
        switch(tick){
            case 0:
                this.color = Color.BLUE;
                break;
            case 1:
                this.color = Color.RED;
                break;
            case 2:
                this.color = Color.GREEN;
                break;
            case 3:
                this.color = Color.YELLOW;
                break;
            case 4:
                this.color = Color.CYAN;
                break;
            case 5:
                this.color = Color.MAGENTA;
                break;
            case 6:
                this.color = Color.WHITE;
                break;
            case 7:
                this.color = Color.LTGRAY;
                break;
            case 8:
                this.color = Color.GRAY;
                break;
            case 9:
                this.color = Color.DKGRAY;
                break;
            case 10:
                this.color = Color.BLACK;
                break;
        }
    }

    /**
     * Metoden kommer att inditifera ett knapptryck och
     * där efter kommer den att utföra:
     * Shift: höger,vänster,ner och upp
     * Färg: kommer att sätta fär på den första elementer i listan,
     * en knapp färgar med slumpvisade färger och en med alla samma färger
     * @param v
     */
    public void chooseColor(View v){
        switch (v.getId()){
            //Sätter färg på 0.0
            case R.id.btn_row1:
                updateColor(tick1);
                ctrl.setElement(0, 0, color);
                tick1++;
                if(tick1 > 10)
                    tick1 = 0;
                break;
            //Sätter färg på 1.0
            case R.id.btn_row2:
                updateColor(tick2);
                ctrl.setElement(1, 0, color);
                tick2++;
                if(tick2 > 10)
                    tick2 = 0;
                break;
            //Sätter färg på 2.0
            case R.id.btn_row3:
                updateColor(tick3);
                ctrl.setElement(2, 0, color);
                tick3++;
                if(tick3 > 10)
                    tick3 = 0;
                break;
            //Sätter färg på 3.0
            case R.id.btn_row4:
                updateColor(tick4);
                ctrl.setElement(3, 0, color);
                tick4++;
                if(tick4 > 10)
                    tick4 = 0;
                break;
            //Sätter färg på 4.0
            case R.id.btn_row5:
                updateColor(tick5);
                ctrl.setElement(4, 0, color);
                tick5++;
                if(tick5 > 10)
                    tick5 = 0;
                break;
            //Sätter färg på 5.0
            case R.id.btn_row6:
                updateColor(tick6);
                ctrl.setElement(5, 0, color);
                tick6++;
                if(tick6 > 10)
                    tick6 = 0;
                break;
            //Sätter färg på 6.0
            case R.id.btn_row7:
                updateColor(tick7);
                ctrl.setElement(6, 0, color);
                tick7++;
                if(tick7 > 10)
                    tick7 = 0;
                break;
            //Shiftar upp
            case R.id.btn_shiftUp:
                resetTick();
                ctrl.setDirection(Controller.DIRECTION.UP);
                arr = new Array7();
                ctrl.showShift(arr);
                break;
            //shiftar ner
            case R.id.btn_shiftDown:
                resetTick();
                ctrl.setDirection(Controller.DIRECTION.DOWN);
                arr = new Array7();
                ctrl.showShift(arr);
                break;
            //shiftar vänster
            case R.id.btn_shiftLeft:
                resetTick();
                ctrl.setDirection(Controller.DIRECTION.LEFT);
                arr = new Array7();
                ctrl.showShift(arr);
                break;
            //shiftar höger
            case R.id.btn_shiftRight:
                resetTick();
                ctrl.setDirection(Controller.DIRECTION.RIGHT);
                arr = new Array7();
                ctrl.showShift(arr);
                break;
            //Sätter slumpad färg
            case R.id.btn_randColor:
                resetTick();
                ctrl.showRandomColor();
                break;
            //Sätter en färg på hela displayn
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

    /**
     * Metoden kommer att sätta den lokala kontrollern med en input kontroller
     * @param ctrl
     */
    @Override
    public void setCtrl(Controller ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * Metoden kommer att uppdatera viewn på colordisplayn
     * @param all
     */
    @Override
    public void updateView(int[][] all) {
        colorDisplay.setDisplay(all);
        colorDisplay.updateDisplay();
    }
    //används ej
    @Override
    public void updateBigView(Array7x7[] all) {
    }
    //används ej
    @Override
    public int getHorizontalPages() {
        return colorDisplay.getHorizontalPages();
    }
    //används ej
    @Override
    public int getVerticalPages() {
        return colorDisplay.getVerticalPages();
    }
    //används ej
    @Override
    public void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir) {
    }
}