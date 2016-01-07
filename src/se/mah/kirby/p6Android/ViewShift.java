package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import se.mah.kirby.Color.IntDisplay;
import se.mah.kirby.algorithms.ShiftArray;
import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.view.ViewImpl;

/**
 * Created by jonatan on 2016-01-06.
 */
public class ViewShift extends Activity implements ViewImpl {
    private Controller ctrlShift;
    private ShiftArray shiftare;
    private IntDisplay intDisplayshift;
    private TextView textViewsRight01;
    private TextView textViewsRight02;
    private TextView textViewsRight03;
    private TextView textViewsRight04;
    private TextView textViewsRight05;
    private TextView textViewsRight06;
    private TextView textViewsRight07;
    private TextView textViewsLeft01;
    private TextView textViewsLeft02;
    private TextView textViewsLeft03;
    private TextView textViewsLeft04;
    private TextView textViewsLeft05;
    private TextView textViewsLeft06;
    private TextView textViewsLeft07;
    private Array7x7 arr2D = new Array7x7();
    private Array7 temp1 = new Array7();
    private Array7 temp2 = new Array7();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_shift);

        intDisplayshift = (IntDisplay) findViewById(R.id.shiftDisplay);

        ctrlShift = (Controller) getApplicationContext();
        ctrlShift.setView(this);
        ctrlShift.showRandom();

        textViewsRight01 = (TextView) findViewById(R.id.txt_edit01);
        textViewsRight02 = (TextView) findViewById(R.id.txt_edit02);
        textViewsRight03 = (TextView) findViewById(R.id.txt_edit03);
        textViewsRight04 = (TextView) findViewById(R.id.txt_edit04);
        textViewsRight05 = (TextView) findViewById(R.id.txt_edit05);
        textViewsRight06 = (TextView) findViewById(R.id.txt_edit06);
        textViewsRight07 = (TextView) findViewById(R.id.txt_edit07);
        textViewsLeft01 = (TextView) findViewById(R.id.txt_edit_L01);
        textViewsLeft02 = (TextView) findViewById(R.id.txt_edit_L02);
        textViewsLeft03 = (TextView) findViewById(R.id.txt_edit_L03);
        textViewsLeft04 = (TextView) findViewById(R.id.txt_edit_L04);
        textViewsLeft05 = (TextView) findViewById(R.id.txt_edit_L05);
        textViewsLeft06 = (TextView) findViewById(R.id.txt_edit_L06);
        textViewsLeft07 = (TextView) findViewById(R.id.txt_edit_L07);

    }
    public Array7x7 getTextArray(){
        Array7x7 newArray = new Array7x7();
        for (int i = 0; i < arr2D.getLength(); i++) {
            for (int j = 0; j < arr2D.getLength(); j++) {
                newArray.setElement(i,j,ctrlShift.getElement(i,j));
            }
        }
        return newArray;
    }
    public void setTextArray(Array7x7 newArray){
        for (int i = 0; i < arr2D.getLength(); i++) {
            for (int j = 0; j < arr2D.getLength(); j++) {
                ctrlShift.setElement(i,j,newArray.getElement(i, j));
            }
        }
    }
    public void setLeftArray(Array7 arr){
        textViewsLeft01.setText(String.valueOf(arr.getElement(0)));
        textViewsLeft02.setText(String.valueOf(arr.getElement(1)));
        textViewsLeft03.setText(String.valueOf(arr.getElement(2)));
        textViewsLeft04.setText(String.valueOf(arr.getElement(3)));
        textViewsLeft05.setText(String.valueOf(arr.getElement(4)));
        textViewsLeft06.setText(String.valueOf(arr.getElement(5)));
        textViewsLeft07.setText(String.valueOf(arr.getElement(6)));
    }
    public Array7 getLeftArray(){
        Array7 newArray = new Array7();
        newArray.setElement(0, Integer.parseInt((String)textViewsLeft01.getText()));
        newArray.setElement(1, Integer.parseInt((String)textViewsLeft02.getText()));
        newArray.setElement(2, Integer.parseInt((String)textViewsLeft03.getText()));
        newArray.setElement(3, Integer.parseInt((String)textViewsLeft04.getText()));
        newArray.setElement(4, Integer.parseInt((String)textViewsLeft05.getText()));
        newArray.setElement(5, Integer.parseInt((String)textViewsLeft06.getText()));
        newArray.setElement(6, Integer.parseInt((String)textViewsLeft07.getText()));
        return newArray;
    }
    public void setRightArray(Array7 arr){
        textViewsRight01.setText(String.valueOf(arr.getElement(0)));
        textViewsRight02.setText(String.valueOf(arr.getElement(1)));
        textViewsRight03.setText(String.valueOf(arr.getElement(2)));
        textViewsRight04.setText(String.valueOf(arr.getElement(3)));
        textViewsRight05.setText(String.valueOf(arr.getElement(4)));
        textViewsRight06.setText(String.valueOf(arr.getElement(5)));
        textViewsRight07.setText(String.valueOf(arr.getElement(6)));
    }
    public Array7 getRightArray(){
        Array7 newArray = new Array7();
        newArray.setElement(0, Integer.parseInt(String.valueOf(textViewsRight01.getText())));
        newArray.setElement(1, Integer.parseInt(String.valueOf(textViewsRight02.getText())));
        newArray.setElement(2, Integer.parseInt(String.valueOf(textViewsRight03.getText())));
        newArray.setElement(3, Integer.parseInt(String.valueOf(textViewsRight04.getText())));
        newArray.setElement(4, Integer.parseInt(String.valueOf(textViewsRight05.getText())));
        newArray.setElement(5, Integer.parseInt(String.valueOf(textViewsRight06.getText())));
        newArray.setElement(6, Integer.parseInt(String.valueOf(textViewsRight07.getText())));
        return newArray;
    }
    public int[][] getIntMatrix(Array7x7 array){
        int[][] newArray = new int[7][7];
        for(int i = 0; i < newArray.length; i++){
            for(int j = 0; j < newArray[i].length;i++){
                newArray[i][j] = array.getElement(i,j);
            }
        }
        return  newArray;
    }


    public void shiftRight(View view){
        ctrlShift.setDirection(Controller.DIRECTION.RIGHT);
        Array7x7 array7x7 = new Array7x7();
        array7x7 = getTextArray();
        temp2 = getLeftArray();
        setTextArray(array7x7);
        //chashar ej ner hit ? felet bör ligga längre ner!
        setRightArray(shiftare.shiftRight(array7x7, temp2));
        //setLeftArray(temp1);
        //updateView(getIntMatrix(array7x7));

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