package se.mah.kirby.model;

/**
 * Klassen kommer att inneh�lla en lista med sju int variabler
 * 
 * @author Jonatan Fridsten
 *
 *
 */
public class Array7 {

	private int[] array = new int[7];

	/**
	 * Konstrukterar en ny lista
	 * 
	 * @param array
	 */
	public Array7(int[] array) {
		this.array = array;
	}

	/**
	 * Fyller en lista med 0:or
	 */
	public Array7() {
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}

	/**
	 *Fyller med inmatade nummer
	 * @param number
	 */
    public Array7(int number) {
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
        }
    }

    /**
	 * Sätt ett värde i en specifik position
	 * 
	 * @param pos:
	 *            vilken position man ska lägga i värdet
	 * @param value:
	 *            värdet som man vill stoppa in
	 */
	public void setElement(int pos, int value) {
		array[pos] = value;
	}

	/**
	 * Returnerar ett värde på en specifik position
	 * 
	 * @param pos:
	 *            vilken position man vill veta värdet i
	 * @return : värdet man vill veta
	 */
	public int getElement(int pos) {
		return array[pos];
	}

    /**
     * Metoden kommer att retunera hela listan
     * @return
     */
    public int[] getAll() {
        return array;
    }

    /**
     * Metoden retunerar hur lång listan är
     * @return
     */
    public int getLength() {
        return array.length;
    }
    /**
     * Metoden kommer att spara in informatrionen i en String
     */
    public String toString() {
    	String res = "{";
    	for(int i=0; i<array.length; i++) {
    		if(i >= array.length-1 ) {
    			res+=array[i] + " ";
    		}else {
    			res += array[i] + "," + " ";
    		}
    	}
    	res += "}";
    	return res;
    }
   
}
