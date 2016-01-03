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

	//	private Font font;
	private Typeface font;

	/**
	 * Konstruktor
	 */
	public Alphabet() {
		try {
			font = initFont();
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
        }
    }

	/**
	 *
	 * @return Ett importerat typsnitt för att bokstäverna ska se bra ut i 7x7
	 * @throws IOException
	 */
	public Typeface initFont() throws IOException, URISyntaxException {
        URL fontpath = this.getClass().getClassLoader().getResource("assets/00TT.ttf");
//		return Font.createFont(Font.TRUETYPE_FONT, new File(fontpath.toURI())).deriveFont(12f);
		return Typeface.createFromFile(fontpath.toURI().toString());
				//createFont(Font.TRUETYPE_FONT, new File(fontpath.toURI())).deriveFont(12f);
	}

	/**
	 *
	 * @param letter
	 * Bokstaven som man vill ha i 7x7 format
	 * @return En 2d int array som är 7x7 och representerar en bokstav
	 * @exception RuntimeException Om bokstaven inte accepteras
	 */
	public Array7x7 getLetter(char letter) {
		int[][] array = new int[7][7];


		int w = 7, h = 7;

		Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
		Bitmap bmp = Bitmap.createBitmap(w, h, conf); // this creates a MUTABLE bitmap
		Canvas canvas = new Canvas(bmp);

		Paint tPaint = new Paint();
		tPaint.setTypeface(font);
		tPaint.setColor(Color.WHITE);

		canvas.drawText(Character.toString(letter),0,0,tPaint);




//		//Skapar en ny bild av typen RGB
//        BufferedImage image = new BufferedImage(array.length, array.length, BufferedImage.TYPE_INT_RGB);
//        Graphics g = image.getGraphics();
//        g.setFont(font);
//        Graphics2D graphics = (Graphics2D) g;
//        //Ritar ut bokstaven på graphics objektet av image
//        graphics.drawString(Character.toString(letter), 0, array.length);
        //En boolean för att se om det är en bokstav som returneras eller om bokstaven inte accepteras
        boolean isChar = false;
        //skriver bilden i arrayen genom att loppa igenom den.
        //-16777216 är blank ruta

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
