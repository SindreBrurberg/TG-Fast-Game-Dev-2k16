package dsda.dethsanius.com.Entity.Blocks;

import dsda.dethsanius.com.Entity.Entity;
import dsda.dethsanius.com.Screen.gameScreen;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class Straifer extends Entity {
    private boolean Left = false;
    public Straifer(double x, double y, double width, double height, int route, boolean left) {
        super(x, y, width, height, "Block/Straifer", "png", route);
        this.Left = left;
    }

    public void setLeft(boolean left) {
        Left = left;
    }

    @Override
    public void onUpdate() {
        if (Left) {
            if (gameScreen.routeStatus[getRoute()] == 10) {
                if (getRoute() - 1 < gameScreen.maxRectanglesDrawn && gameScreen.routeStatus[getRoute() - 1] == 0 && (getRoute()) / 25.0 % 1 != 0.0){
                    gameScreen.routeStatus[getRoute() - 1] = 10;
                    gameScreen.straifer[getRoute() - 1].setProcessDone(true);
                    gameScreen.straifer[getRoute() - 1].setLeft(true);
                    gameScreen.routeStatus[getRoute()] = 0;
                }
            }
        }
        else {
            if (gameScreen.routeStatus[getRoute()] == 10) {
                if (getRoute() + 1 < gameScreen.maxRectanglesDrawn && gameScreen.routeStatus[getRoute() + 1] == 0 && (getRoute() + 1) / 25.0 % 1  != 0.0){
                    gameScreen.routeStatus[getRoute() + 1] = 10;
                    gameScreen.straifer[getRoute() + 1].setProcessDone(true);
                    gameScreen.straifer[getRoute() + 1].setLeft(false);
                    gameScreen.routeStatus[getRoute()] = 0;
                }
            }
        }
    }
}
