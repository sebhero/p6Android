package se.mah.kirby.view;

import se.mah.kirby.controller.Controller;
import se.mah.kirby.model.Array7x7;

import java.util.ArrayList;

/**
 * Created by seb on 2015-12-18.
 */
public interface ViewImpl {

	/**
     * Never used due to the AndroidManifest.xml CDI in the controller into the view.
     * afterwards the view calls the controller and sets the current view
     * @param ctrl
     */
    @Deprecated
    void setCtrl(Controller ctrl);

    void updateView(int[][] all);

    void updateBigView(Array7x7[] all);

    int getHorizontalPages();
    int getVerticalPages();


    void updateView(ArrayList<int[][]> all, Controller.DIRECTION dir);


}
