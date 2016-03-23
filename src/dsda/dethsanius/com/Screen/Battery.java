package dsda.dethsanius.com.Screen;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/3/2015.
 */
public class Battery extends Entity {
    private int Powerlevel = 0;
    public Battery(double x, double y, double width, double height, int route, int initPowerLevel) {
        super(x, y, width, height, "Battery 1", "png", route);
        this.Powerlevel = initPowerLevel;
    }

    public Battery(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "Battery 1", "png", route);
    }

    @Override
    public void onUpdate() {
        switch (Powerlevel){
            case 0:
                loadImage("Battery 1", "png");
                break;
            case 1:
                loadImage("Battery 2", "png");
                break;
            case 2:
                loadImage("Battery 3", "png");
                break;
            case 3:
                loadImage("Battery 4", "png");
                break;
            case 4:
                loadImage("Battery 5", "png");
                break;
        }
    }
}
