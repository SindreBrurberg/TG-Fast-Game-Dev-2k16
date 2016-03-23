package dsda.dethsanius.com.Entity.PlayerAbilities;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class TimeWarp extends Entity {
    public TimeWarp(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "PlayerAbilities/TimeWarp", "png", route);
    }

    @Override
    public void onUpdate() {

    }
}
