package se.mah.kirby.p6Android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import se.mah.kirby.Color.Color;
import se.mah.kirby.Color.ColorDisplay;
import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.view.ViewImpl;

import java.util.ArrayList;

/**
 * Created by Sebastian Börebäck on 2015-12-13.
 */

/**
 *En klass som kommer att innehålla en en Colordisplay som
 * man kan skriva ut en text och få den att rulla med längst
 */
public class FlowText extends Activity implements ViewImpl{


	private ColorDisplay colorDisplay;
	private Controller ctrl;
	private EditText etInputText;
	private Button btnStart;
	private Button btnStop;
	private Button btnRight;
	private Button btnLeft;
	private Button btnDown;
	private Button btnUp;
	private Button btnRandom;

	/**
	 * Detta kallas så fort vi kommer in i aktiviten och sätter upp layout
	 *
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

		btnStart = (Button) findViewById(R.id.btn_start);
		btnStop = (Button) findViewById(R.id.btn_stop);
		btnDown = (Button) findViewById(R.id.btn_down);
		btnUp = (Button) findViewById(R.id.btn_up);
		btnRight = (Button) findViewById(R.id.btn_right);
		btnLeft = (Button) findViewById(R.id.btn_left);
		btnRandom = (Button) findViewById(R.id.btn_random);
	}
	enum states {
		START,
		STOP
	}
	/**
	 * En metod som kommer att fylla den första dispalyn med random färger
	 * @param view
	 */
	public void getRandomColor(View view) {
		setState(states.START);
		ctrl.showRandomColor();
	}


	/**
	 * Uppdaterar Colordisplayviewn så att man får de nya värdena
	 * @param all
	 */
	@Override
	public void updateView(int[][] all) {
		colorDisplay.clearDisplay();
		colorDisplay.setDisplay(all);
		colorDisplay.updateDisplay();
	}


	/**
	 * Metoden kommer att retunera hur lång ens lista med
	 * colordisplayn kommer att vara
	 * @return HorizontalPages antalet sidor
	 */
	@Override
	public int getHorizontalPages() {
		return colorDisplay.getHorizontalPages();
	}

	/**
	 * Metoden kommer att retunera hur hög ens lista med
	 * colordisplayer kommer att vara
	 * @return VerticalPages antal sidor
	 */
	@Override
	public int getVerticalPages() {
		return colorDisplay.getVerticalPages();
	}

	/**
	 * Metoden kommer att uppdatera viewn och Colordisplayn
	 * @param all
	 * @param dir
	 */
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

	/**
	 * Metoden kommer att ladda in en text till
	 * ctrln för att vi ska kunna skriva ut texteb
	 * @param view för att få kontakt med skärmen
	 */
	public void loadText(View view) {
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
	}

	/**
	 * Metoden kommer att shifta texten tills den
	 * har vissat hela texten sedan stoppa åt höger
	 * @param view för att få kontakt med skärmen
	 */
	public void shiftRight(View view) {
		setState(states.START);
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.RIGHT);
		ctrl.flowText(true);
	}

	/**
	 * Metoden kommer att shifta texten tills den
	 * har vissat hela texten sedan stoppa åt vänster
	 * @param view för att få kontakt med skärmen
	 */
	public void shiftLeft(View view) {
		setState(states.START);
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.LEFT);
		ctrl.flowText(true);
	}

	/**
	 * Metoden kommer att shifta texten tills den
	 * har vissat hela texten sedan stoppa uppåt
	 * @param view för att få kontakt med skärmen
	 */
	public void shiftUp(View view) {
		setState(states.START);
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.UP);
		ctrl.flowText(true);
	}

	/**
	 * Metoden kommer att shifta texten tills den
	 * har vissat hela texten sedan stoppa neråt
	 * @param view för att få kontakt med skärmen
	 */
	public void shiftDown(View view) {
		setState(states.START);
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.DOWN);
		ctrl.flowText(true);
	}

	/**
	 * Metoden kommer att göra så att man skiftar tillbaka till
	 * huvudmenyn
	 * @param view för att få kontakt med knappen på skärmen
	 */
	public void switchToStartActivity(View view) {
		ctrl.pause();
		Intent openNewActivity = new Intent(getApplicationContext(), StartActivity.class);
		startActivity(openNewActivity);
	}

	/**
	 * Metoden kommer att låta en text på colordispayn att rulla
	 * tills man antingen trycker på main eller stoppknappen
	 * @param view För att få kontakt med knappen på skärmen
	 */
	public void shiftStart(View view){
		setState(states.START);
		String texy = String.valueOf(etInputText.getText());
		ctrl.loadFlowText(texy);
		ctrl.setDirection(Controller.DIRECTION.LEFT);
		ctrl.flowText(false);
	}

	/**
	 * Metoden kommer att få texten på colodrisplayn att
	 * stanna där den är
	 * @param view för att få kontakt med knappen på skärmen
	 */
	public void shiftStopp(View view){
		setState(states.STOP);
		ctrl.pause();
	}
	public void setState(states CurretState){
		switch(CurretState){
			case START:
				btnDown.setEnabled(false);
				btnRandom.setEnabled(false);
				btnLeft.setEnabled(false);
				btnUp.setEnabled(false);
				btnRight.setEnabled(false);
				btnStart.setEnabled(false);
				btnStop.setEnabled(true);
				break;
			case STOP:
				btnDown.setEnabled(true);
				btnRandom.setEnabled(true);
				btnLeft.setEnabled(true);
				btnUp.setEnabled(true);
				btnRight.setEnabled(true);
				btnStart.setEnabled(true);
				btnStop.setEnabled(false);
				break;
		}
	}
}
