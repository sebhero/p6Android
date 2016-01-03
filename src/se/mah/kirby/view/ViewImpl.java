package se.mah.kirby.view;

import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7x7;

import java.util.ArrayList;

/**
 * Created by seb on 2015-12-18.
 */
public interface ViewImpl {

    void setCtrl(Controller ctrl);

    void updateView(int[][] all);

    void updateBigView(Array7x7[] all);

    int getHorizontalPages();
    int getVerticalPages();


    void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir);


    /**
     * @deprecated will be replaced by updateView
     * @param all
     */
//    void updateViewColor(int[][] all);
}
