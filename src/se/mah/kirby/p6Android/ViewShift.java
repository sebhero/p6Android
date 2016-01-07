package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import se.mah.kirby.Color.IntDisplay;
import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.view.ViewImpl;

/**
 * Created by jonatan on 2016-01-06.
 * Klassen kommer att visa hur vi shiftar från höger och vänster genom en
 * intdisplay tillsammans med två listor av textviews
 */
public class ViewShift extends Activity implements ViewImpl {
    private Controller ctrlShift;
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
    private Array7 temp2 = new Array7();
    private Random rand = new Random();

    /**
     * Metoden kommer att sätta upp layouten och länka
     * textviews med de lokala instansvariablerna
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_shift);

        intDisplayshift = (IntDisplay) findViewById(R.id.shiftDisplay);

        ctrlShift = (Controller) getApplicationContext();
        ctrlShift.setView(this);
        ctrlShift.showRandom();

        textViewsRight01 = (TextView) findViewById(R.id.txt_edit_L01);
        textViewsRight02 = (TextView) findViewById(R.id.txt_edit_L02);
        textViewsRight03 = (TextView) findViewById(R.id.txt_edit_L03);
        textViewsRight04 = (TextView) findViewById(R.id.txt_edit_L04);
        textViewsRight05 = (TextView) findViewById(R.id.txt_edit_L05);
        textViewsRight06 = (TextView) findViewById(R.id.txt_edit_L06);
        textViewsRight07 = (TextView) findViewById(R.id.txt_edit_L07);
        textViewsLeft01 = (TextView) findViewById(R.id.txt_edit01);
        textViewsLeft02 = (TextView) findViewById(R.id.txt_edit02);
        textViewsLeft03 = (TextView) findViewById(R.id.txt_edit03);
        textViewsLeft04 = (TextView) findViewById(R.id.txt_edit04);
        textViewsLeft05 = (TextView) findViewById(R.id.txt_edit05);
        textViewsLeft06 = (TextView) findViewById(R.id.txt_edit06);
        textViewsLeft07 = (TextView) findViewById(R.id.txt_edit07);

    }

    /**
     *  Metoden komemr att sätta värdena på de vänstra textviews fårn ett
     *  array7 objekt som kommer in
     * @param arr De nya värdet på textviewsena
     */
    public void setLeftArray(Array7 arr){
        textViewsLeft01.setText(String.valueOf(arr.getElement(0)));
        textViewsLeft02.setText(String.valueOf(arr.getElement(1)));
        textViewsLeft03.setText(String.valueOf(arr.getElement(2)));
        textViewsLeft04.setText(String.valueOf(arr.getElement(3)));
        textViewsLeft05.setText(String.valueOf(arr.getElement(4)));
        textViewsLeft06.setText(String.valueOf(arr.getElement(5)));
        textViewsLeft07.setText(String.valueOf(arr.getElement(6)));
    }

    /**
     *  Metoden kommer att sätta det som står i den vänstra
     *  listan av textviews till ett Array7 objekt
     * @return Array7 objekt med siffror från vänstra textviews
     */
    public Array7 getLeftArray(){
        Array7 newArray = new Array7();
        newArray.setElement(0, Integer.parseInt((String) textViewsLeft01.getText()));
        newArray.setElement(1, Integer.parseInt((String) textViewsLeft02.getText()));
        newArray.setElement(2, Integer.parseInt((String) textViewsLeft03.getText()));
        newArray.setElement(3, Integer.parseInt((String) textViewsLeft04.getText()));
        newArray.setElement(4, Integer.parseInt((String) textViewsLeft05.getText()));
        newArray.setElement(5, Integer.parseInt((String) textViewsLeft06.getText()));
        newArray.setElement(6, Integer.parseInt((String) textViewsLeft07.getText()));
        return newArray;
    }

    /**
     *  Metoden komemr att sätta värdena på de högra textviews fårn ett
     *  array7 objekt som kommer in
     * @param arr De nya värdet på textviewsena
     */
    public void setRightArray(Array7 arr){
        textViewsRight01.setText(String.valueOf(arr.getElement(0)));
        textViewsRight02.setText(String.valueOf(arr.getElement(1)));
        textViewsRight03.setText(String.valueOf(arr.getElement(2)));
        textViewsRight04.setText(String.valueOf(arr.getElement(3)));
        textViewsRight05.setText(String.valueOf(arr.getElement(4)));
        textViewsRight06.setText(String.valueOf(arr.getElement(5)));
        textViewsRight07.setText(String.valueOf(arr.getElement(6)));
    }

    /**
     *  Metoden kommer att sätta det som står i den högra
     *  listan av textviews till ett Array7 objekt
     * @return Array7 objekt med siffror från högra textviews
     */
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

    /**
     * Metoden kommer att shifta alla tal ett steg åt höger och fylla på den
     * vänstra textviewn med nollor
     * @param view för att få kontakt med knappen
     */
    public void shiftRight(View view){
        ctrlShift.setDirection(Controller.DIRECTION.RIGHT);
        temp2 = getLeftArray();
        //skicka temp2 till ctrl och shifta right
        Array7 returnArr = this.ctrlShift.shift(temp2);
        setRightArray(returnArr);
        setLeftArray(new Array7());
        ctrlShift.updateView();
    }


    /**
     * Metoden kommer att shifta alla tal ett steg åt vänster och fylla på den
     * högra textviewn med nollor
     * @param view för att få kontakt med knappen
     */
    public void shiftLeft(View view){
        ctrlShift.setDirection(Controller.DIRECTION.LEFT);
        temp2 = getRightArray();
        Array7 reternArr = this.ctrlShift.shift(temp2);
        setLeftArray(reternArr);
        setRightArray(new Array7());
        ctrlShift.updateView();
    }

    /**
     * Metoden fyller intdisplayn och texrviewns med random tal
     * @param view
     */
    public void fillRandom(View view){
        setLeftArray(fillArrayRandom());
        setRightArray(fillArrayRandom());
        ctrlShift.showRandom();
    }

    /**
     * Metoden kommer att returnera ett arrayobjekt med
     * slumpade tal i sig
     * @return Lista med slumpade tal
     */
    public Array7 fillArrayRandom(){
        Array7 newArr = new Array7();
        for(int i = 0; i < newArr.getLength(); i++){
            newArr.setElement(i,rand.nextInt(7)+1);
        }
        return newArr;
    }

    /**
     * Metoden kommer att sätta en input kontroller till den lokala
     * @param ctrl
     */
    @Override
    public void setCtrl(Controller ctrl) {
        this.ctrlShift = ctrl;
    }

    /**
     * Metoden kommer att uppdatera intdisplayn med nya värdena
     * @param all
     */
    @Override
    public void updateView(int[][] all) {
        this.intDisplayshift.setDisplay(all);
        this.intDisplayshift.updateDisplay();
    }

    //används ej
    @Override
    public void updateBigView(Array7x7[] all) {

    }

    //används ej
    @Override
    public int getHorizontalPages() {
        return 0;
    }

    //används ej
    @Override
    public int getVerticalPages() {
        return 0;
    }

    /**
     * Metoden kommer att uppdatera intdisplayn och shifta talen
     * @param all de nya värdena
     * @param dir vilket håll den shiftar på
     */
    @Override
    public void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir) {
        this.intDisplayshift.setDisplay(all.get(0));
        this.intDisplayshift.updateDisplay();
    }

    /**
     * Metoden kommer att byta view och aktivet till huvudmenyn
     * @param view
     */
    public void switchToStartMeny(View view) {
        Intent openNewActivity = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(openNewActivity);
    }
}