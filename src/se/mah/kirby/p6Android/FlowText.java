package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import se.mah.kirby.Color.Color;
import se.mah.kirby.Color.ColorDisplay;
import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.view.ViewImpl;

import java.util.ArrayList;


public class FlowText extends Activity implements ViewImpl{


	private ColorDisplay colorDisplay;
	private Controller ctrl;
	private EditText etInputText;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getActionBar().hide();

		colorDisplay =  (ColorDisplay) findViewById(R.id.colorDisplay);
		colorDisplay.setBackgroundColor(Color.BLACK);
		colorDisplay.setGridColor(Color.PINK);
		etInputText = (EditText) findViewById(R.id.etInputText);


		//Get Global Controller Class object (see application tag in AndroidManifest.xml)
		ctrl= (Controller) getApplicationContext();
		//set the view to the controller
		ctrl.setView(this);

	}

	public void getRandomColor(View view) {
		ctrl.showRandomColor();
	}

	@Override
	public void setCtrl(Controller ctrl) {
	}

	@Override
	public void updateView(int[][] all) {
		colorDisplay.clearDisplay();
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
		colorDisplay.clearDisplay();
		for (int i = 0; i < all.size(); i++) {
			switch (dir) {

				case RIGHT:
				case LEFT:
					colorDisplay.setDisplay(all.get(i),0,i);
					break;
				case UP:
				case DOWN:
					colorDisplay.setDisplay(all.get(i),i,0);
					break;
			}

		}
		colorDisplay.updateDisplay();
	}

	public void loadText(View view) {
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
	}

	public void shiftRight(View view) {
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.RIGHT);
		ctrl.flowText();
	}

	public void shiftLeft(View view) {
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.LEFT);
		ctrl.flowText();
	}

	public void shiftUp(View view) {

		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.UP);
		ctrl.flowText();
	}

	public void shiftDown(View view) {
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.DOWN);
		ctrl.flowText();
	}

	public void switchToStartActivity(View view) {
		Intent openNewActivity = new Intent(getApplicationContext(), StartActivity.class);
		startActivity(openNewActivity);
	}

	public void switchToNumberActivity(View view) {
		Intent openNewActivity = new Intent(getApplicationContext(), NumberActivity.class);
		startActivity(openNewActivity);
	}
	public void shiftStart(View view){
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.LEFT);
		ctrl.flowText();
	}
	public void shiftStopp(View view){


	}
}
