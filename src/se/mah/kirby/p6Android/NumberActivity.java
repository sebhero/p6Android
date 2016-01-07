package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import se.mah.kirby.Color.IntDisplay;
import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.view.ViewImpl;

import java.util.ArrayList;

/**
 * Created by Sebastian Börebäck on 2016-01-04.
 */
public class NumberActivity extends Activity implements ViewImpl{
	private Controller ctrl;
	private IntDisplay intDisplay;

	/**
	 *Metoden kommer att Sätta upp layouten och hur det ska se ut i starten av aktiviteten
	 * @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.number_activity);
		getActionBar().hide();

		intDisplay =  (IntDisplay) findViewById(R.id.intDisplay);

		//Get Global Controller Class object (see application tag in AndroidManifest.xml)
		ctrl= (Controller) getApplicationContext();
		//set the view to the controller
		ctrl.setView(this);
		//fill the intDisp with random numbers
		ctrl.showRandom();
	}

	/**
	 * Slumpar antal siffror och ritar ut den i vyn
	 * @param view för att få kontakt med knappen på skärmen
	 */
	public void getRandomNumbers(View view) {
		ctrl.showRandom();
	}

	/**
	 *Metoden kommer att fylla displayn med stigande nummer
	 * @param view för att få kontakt med knappen på skärmen
	 */
	public void getIncreasingNumbers(View view) {
		ctrl.showNumbers1_7();
	}



	/**
	 * Metoden kommer att uppdatera det som finns på skärmen
	 * @param all
	 */
	@Override
	public void updateView(int[][] all) {
		this.intDisplay.setDisplay(all);
		this.intDisplay.updateDisplay();
	}


	/**
	 *	Retunerar många sidor man har på ländgen
	 * @return
	 */
	@Override
	public int getHorizontalPages() {
		return 1;
	}

	/**
	 *	Retunerar hur många sidor man har på höjden
	 * @return
	 */
	@Override
	public int getVerticalPages() {
		return 1;
	}

	/**
	 *Uppdaterar intdisplayn med de nya värdena som man får som input
	 * @param all arraylista med värden
	 * @param dir vilket håll man shiftar på
	 */
	@Override
	public void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir) {
		this.intDisplay.setDisplay(all.get(0));
		this.intDisplay.updateDisplay();
	}

	/**
	 * Metoden kommer att göra så att man återvänder till huvudmenyn
	 * @param view för att få kontakt med knappen på skärmen
	 */
	public void switchToStartActivity(View view) {
		Intent openNewActivity = new Intent(getApplicationContext(), StartActivity.class);
		startActivity(openNewActivity);
	}
}