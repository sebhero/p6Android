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

/**
 *En klass som kommer att innehålla en en Colordisplay som
 * man kan skriva ut en text och få den att rulla med längst
 */

public class FlowText extends Activity implements ViewImpl{


	private ColorDisplay colorDisplay;
	private Controller ctrl;
	private EditText etInputText;

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

	}

	/**
	 * En metod som kommer att fylla den första dispalyn med random färger
	 * @param view
	 */
	public void getRandomColor(View view) {
		ctrl.showRandomColor();
	}
	/**
	 * Sätter den lokala kontrollerna fårn n input kontroller
	 */
	@Override
	public void setCtrl(Controller ctrl) {
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
	//används inte i denna klassen
	@Override
	public void updateBigView(Array7x7[] all) {

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
		ctrl.pause();

	}
}
