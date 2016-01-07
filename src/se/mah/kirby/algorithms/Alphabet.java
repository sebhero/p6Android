package se.mah.kirby.algorithms;


import android.graphics.*;
import se.mah.kirby.Color.Color;
import se.mah.kirby.model.Array7x7;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;



/**
 * @author Gustaf Bohlin, Sebastian J Börebäck
 * Skapar en 7x7 array med 1 och 0 som representerar en bokstav
 */
public class Alphabet {

	private Typeface font;

	public Alphabet(Typeface font) {
		this.font = font;
	}

	/**
	 *
	 * @return Ett importerat typsnitt för att bokstäverna ska se bra ut i 7x7
	 * @throws IOException
	 */
	/*
	public Typeface initFont() throws IOException, URISyntaxException {
        URL fontpath = this.getClass().getClassLoader().getResource("assets/00TT.ttf");
		return null;
	}
*/
	/**
	 * Skapar en Array7x7 av en char bokstav.
	 * @param letter Bokstaven som man vill ha i 7x7 format
	 * @return En 2d int array som är 7x7 och representerar en bokstav
	 * @exception RuntimeException Om bokstaven inte accepteras
	 */
	public Array7x7 getLetter(char letter) {
		int[][] array = new int[7][7];


		//convert char to string
		String text = String.valueOf(letter);
		//create a paintbrush
		Paint paint = new Paint();
		//set font size
		paint.setTextSize(12);
		//set font
		paint.setTypeface(font);
		//set brush color
		paint.setColor(Color.WHITE);
		//turn off
		paint.setAntiAlias(true);
		//set the hight and width of the letter
		int width = (int) (paint.measureText(text) + 0.5f); // round
		int height = 11;//ar alltid 11 i denna textsize 12

		//ifall bokstaven är mindre än 7x7
		if (width < 7) {
			width =7;
		}
		if (height < 7) {
			height=7;
		}
		//create the image to paint to
		Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
		//create the canvas we are using
		Canvas canvas = new Canvas(bmp);

		//paint the canvas
		canvas.drawText(text, 1, 7, paint);


        //En boolean för att se om det är en bokstav som returneras eller om bokstaven inte accepteras
        boolean isChar = false;

		//Acutall size is 7x11 but the 4 extra pixels are all black color

		if (letter == ' ') {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					array[i][j] = Color.TRANSPARENT;
				}
			}
			return new Array7x7(array);
		}


        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
	            //get the colors from bitmap
	            if(bmp.getPixel(x,y) == Color.BLACK) {
            		array[y][x] = Color.TRANSPARENT;
            	}
            	else {
            		array[y][x] = Color.WHITE;
            		isChar = true;
            	}
            }
        }
        //Om det inte är någon bokstav som returneras, kasta ett exception
        if(!isChar)
        	throw new RuntimeException();
        Array7x7 array7x7 = new Array7x7(array);
        return array7x7;
    }
}
