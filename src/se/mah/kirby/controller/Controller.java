package se.mah.kirby.controller;


import android.app.Application;
import android.graphics.Typeface;
import se.mah.kirby.algorithms.ShiftArray;
import se.mah.kirby.algorithms.ShiftText;
import se.mah.kirby.model.Array7;
import se.mah.kirby.model.Array7x7;
import se.mah.kirby.strategy.FillAlgorithm;
import se.mah.kirby.strategy.FillCharacter;
import se.mah.kirby.strategy.FillColor;
import se.mah.kirby.strategy.FillNumbers;
import se.mah.kirby.view.ViewImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sebastian Börebäck on 2015-12-13.
 */

/**
 * Kontroller styr kommunikationen mellan Vyn och modelen.
 */
public class Controller extends Application{

	private Typeface font;
	//Hanterar text shiftning
	private ShiftText shiftText;

	//håller koll på vilket håll vi shiftar
    public enum DIRECTION {
		RIGHT,
		LEFT,
		UP,
		DOWN
	}

    /**
     * Väljer vilken filler metod
     */
    public enum FILLERTYPE{
        COLORS, CHARACTERS, NUMBERS
    }

    //vilket håll vi ska rita ut
	private DIRECTION dir = DIRECTION.LEFT;
    //våran algoritm för att skifta a7x7
    private ShiftArray shifter = new ShiftArray();
    private FillAlgorithm filler;
    private Array7x7 model;
    private ViewImpl view;

    private Timer timer;

    /**
     * Kontroller som hanterar kommunikationen mellan vyerna och modelen Array7x7
     */
    public Controller() {
        this.model = new Array7x7();
//        this.view = view;
//        this.view.setCtrl(this);

        shifter = new ShiftArray();

//        updateView();
    }

	/**
	 * skapar controllern. ger ShiftText fonten så att den kan användas för att skapa bokstäver.
	 */
	@Override
	public void onCreate() {
		super.onCreate();

		//Need to be created here, Due to Android isnt loaded in constructor so there is no access to GetAssets()
		font = Typeface.createFromAsset(getAssets(), "00TT.ttf");
		shiftText = new ShiftText(font);


	}

	/**
	 * Hämtar riktning som kontrollern har just nu.
	 * @return
	 */
	public DIRECTION getDirection() {
		return dir;
	}

	/**
	 * Sätter aktiv vy.
	 * @param view
	 */
	public void setView(ViewImpl view) {
		this.view = view;
	}

	/**
	 * Uppdaterar vyn med en Array7x7
     */
    public void updateView() {
        view.updateView(model.getAll());
    }


    /**
	 * Knapp tryck.
	 * skiftar höger på modelen
     */    
    public Array7 shift(Array7 newArray) {

        return shifter.shift(model, newArray, dir);

    }

    /**
     * Sätter vilket håll vi ska shifta
     * @param dir riktigt vi shiftar
     */
    public void setDirection(DIRECTION dir) {
    	this.dir = dir;
    }
    
    /**
	 * Knapp tryck
     * Slumpar antal siffror och ritar ut den i vyn
     */
    public void showRandom() {
        filler = getFiller(FILLERTYPE.NUMBERS);
        model = filler.fillWithRandom();
        updateView();
    }

    /**
     * knapp tryck
     * Ritar ut 1-7 i vyn
     * 1234567
     * 1234567
     * 1234567
     * 1234567
     * 1234567
     * 1234567
     * 1234567
     */
    public void showNumbers1_7() {
        filler = getFiller(FILLERTYPE.NUMBERS);
        model = filler.fillWithInGaining();
        updateView();
    }



    /**
     * Hämtar vilken fyll algoritm vi ska använda
     * @param typeOfFiller val av fyllnings algoritm
     * @return fyllnings algoritmen.
     */
    private FillAlgorithm getFiller(FILLERTYPE typeOfFiller) {
        //TODO use singelton
        switch (typeOfFiller) {

            case COLORS:
                return new FillColor();
            case CHARACTERS:
                return new FillCharacter(font);
            case NUMBERS:
            default:
                return new FillNumbers();
        }
    }

    /**
     * knapp tryck
     * Visa slumpade färger i vyn
     */
    public void showRandomColor() {
        filler = getFiller(FILLERTYPE.COLORS);
		if (model == null) {
			System.out.println("Model is null!!!");
		}
		else {
			System.out.println("model exists");
			model = filler.fillWithRandom();
			updateView();
		}
    }



    /**
     * Visa en färg i på hela Array7x7 i vyn
     */
    public void showSameColor(int color) {
        filler = getFiller(FILLERTYPE.COLORS);
        model = filler.fillWithOneType(color);
        updateView();
    }

    /**
     * Visar en graident färg mellan 2 färger
     * i vyn
     */
    public void showGradiantColor() {
        filler = getFiller(FILLERTYPE.COLORS);
        model = filler.fillWithInGaining();
        updateView();
    }

    /**
     * Visar en slumpad bokstav i vyn
     */
    public void showRanomChar() {
        filler = getFiller(FILLERTYPE.CHARACTERS);
        model = filler.fillWithRandom();
        updateView();
    }


    /**
     * knapp tryck
     * Satter en ny rad i modelen.
     */
    public void setRow(int rowPos, int[] newRow) {
        model.setRow(rowPos, new Array7(newRow));
        updateView();
    }

    /**
     * knapp tryck
     * Satter en ny kolumn i modelen.
     */
    public void setCol(int colPos, int[] newCol) {
        model.setCol(colPos, new Array7(newCol));
        updateView();
    }


    /**
     * knapp tryck
     * Satter ett nytt element i modelen.
     */
    public void setElement(int rowPos, int colPos, int value) {

        model.setElement(rowPos, colPos, value);
        updateView();
    }

    /**
     * knapp tryck
     * Hamtar rad i modelen.
     */
    public int[] getRow(int rowPos) {
        return model.getRow(rowPos).getAll();
    }

    /**
     * knapp tryck
     * Hamtar kolumn i modelen.
     */
    public int[] getCol(int colPos) {
        return model.getCol(colPos).getAll();
    }

    /**
     * knapp tryck
     * Hamtar element i modelen.
     */
    public int getElement(int rowPos, int colPos) {
        return model.getElement(rowPos,colPos);
    }


	/**
	 * Shiftar modelen i nuvarande riktning.
	 * därefter uppdatera vyn
	 * @param input
	 */
	public void showShift(Array7 input) {
		shift(input);
		updateView();

	}


	/**
	 * Pausar timern
	 */
	public void pause() {
		if(timer != null)
		timer.cancel();
	}


	/**
	 * Uppdaterar vyn med den nya message list<7x7>
	 */
	private void updateViewMessage() {
		view.updateView(shiftText.getMessageView(), dir);
	}

	/**
	 * Laddar in strängen från vyn till en lista av 7x7
	 * @param texy strängen av alla char
	 */
	public void loadFlowText(String texy) {
		shiftText.loadText(texy);
	}

//	/**
//	 * knapp tryck för att steppa genom strängen vi har laddat in
//	 */
//	public void showStepText() {
//
//		shiftText.stepText(dir);
//		updateViewMessage();
//	}


	/**
	 * Rullande text av strängen vi har laddat in
	 */
	public void flowText(boolean flowing) {
		shiftText.setEndingFlowing(flowing);
		switch (dir) {
			case RIGHT:
			case LEFT:
				//setup messageView size
				shiftText.setupMessageView(view.getHorizontalPages());
				//setup max steps how many Columns/rows
				if (view.getHorizontalPages() > shiftText.getMessageSize()) {
					shiftText.setMaxSteps(view.getHorizontalPages() * 7+7);

				}
				else {
					shiftText.setMaxSteps(shiftText.getMessageSize()*7+7);
				}
				break;
			case UP:
			case DOWN:
				//setup messageView size
				shiftText.setupMessageView(view.getVerticalPages());
				//setup max steps how many Columns/rows
				if (view.getVerticalPages() > shiftText.getMessageSize()) {
					shiftText.setMaxSteps(view.getVerticalPages() * 7+7);
				}
				else {
					shiftText.setMaxSteps(shiftText.getMessageSize()*7+7);
				}
				break;
		}

		//start timer
		timer = new Timer();
		timer.schedule(new shiftTextTimer(), 50, 50);
	}

	/**
	 * Timmer till flowText för strängen vi har laddat in
	 */
	private class shiftTextTimer extends TimerTask {


		@Override
		public void run() {
			if (shiftText.checkIfDoneStepping()){
				//TODO if want continues flow remove this line

				if(shiftText.getEndingFlowing())
					timer.cancel();
				return;
			}
			shiftText.stepText(dir);
			shiftText.increaseSteps();
			updateViewMessage();
		}
	}

}
