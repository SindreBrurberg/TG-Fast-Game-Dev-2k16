package dsda.dethsanius.com.Entity.Blocks;

import dsda.dethsanius.com.Entity.Entity;
import dsda.dethsanius.com.Screen.gameScreen;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class Faller extends Entity {
    public Faller(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "Block/Faller", "png", route);
    }

    @Override
    public void onUpdate() {
        if (gameScreen.routeStatus[getRoute()] == 11) {
            if (getRoute() + 25 < gameScreen.maxRectanglesDrawn && gameScreen.routeStatus[getRoute() + 25] == 0){
                gameScreen.routeStatus[getRoute() + 25] = 11;
                gameScreen.faller[getRoute() + 25].setProcessDone(true);
                gameScreen.routeStatus[getRoute()] = 0;
            }
        }
    }
}
