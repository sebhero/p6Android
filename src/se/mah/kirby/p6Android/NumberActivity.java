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

	public void getRandomNumbers(View view) {
		ctrl.showRandom();
	}

	public void getIncreasingNumbers(View view) {
		ctrl.showNumbers1_7();
	}

	@Override
	public void setCtrl(Controller ctrl) {

	}

	@Override
	public void updateView(int[][] all) {
		//this.intDisplay.clearDisplay();
		this.intDisplay.setDisplay(all);
		this.intDisplay.updateDisplay();
	}

	@Override
	public void updateBigView(Array7x7[] all) {

	}

	@Override
	public int getHorizontalPages() {
		return 1;
	}

	@Override
	public int getVerticalPages() {
		return 1;
	}

	@Override
	public void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir) {
		this.intDisplay.setDisplay(all.get(0));
		this.intDisplay.updateDisplay();
	}


	public void switchToStartActivity(View view) {
		Intent openNewActivity = new Intent(getApplicationContext(), StartActivity.class);
		startActivity(openNewActivity);
	}
}