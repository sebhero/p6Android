package se.mah.kirby.view;

import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7x7;

import java.util.ArrayList;

/**
 * Created by seb on 2015-12-18.
 */
public interface ViewImpl {



    void updateView(int[][] all);



    int getHorizontalPages();
    int getVerticalPages();


    void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir);


}
