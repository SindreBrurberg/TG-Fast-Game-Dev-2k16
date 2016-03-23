package dsda.dethsanius.com.Entity.WorldAbilities;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class Power extends Entity {
    private int PowerLevel = 0;
    public Power(double x, double y, double width, double height, int route, int powerLevel) {
        super(x, y, width, height, "WorldAbilities/Power", "png", route);
        this.PowerLevel = powerLevel;
    }

    public Power(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "WorldAbilities/Power", "png", route);
    }

    @Override
    public void onUpdate() {

    }
}
