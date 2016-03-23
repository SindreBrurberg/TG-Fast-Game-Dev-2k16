package dsda.dethsanius.com.Entity.WorldAbilities;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class TimeWarp extends Entity {
    private int Hr = 0, Min = 0;
    public TimeWarp(double x, double y, double width, double height, int route, int hr, int min) {
        super(x, y, width, height, "WorldAbilities/TimeWarp", "png", route);
        this.Hr = hr;
        this.Min = min;
    }

    public TimeWarp (double x, double y, double width, double height, int route) {
        this(x, y, width, height, route, 0, 0);
    }

    public int getHr() {
        return Hr;
    }

    public int getMin() {
        return Min;
    }

    @Override
    public void onUpdate() {

    }
}
