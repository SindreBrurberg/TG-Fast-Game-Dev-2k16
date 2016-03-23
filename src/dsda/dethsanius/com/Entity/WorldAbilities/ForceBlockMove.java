package dsda.dethsanius.com.Entity.WorldAbilities;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class ForceBlockMove extends Entity {
    int initialPops = 0, endPoss = 0;
    public ForceBlockMove(double x, double y, double width, double height, int route, int inital, int end) {
        super(x, y, width, height, "WorldAbilities/ForceBlockMove", "png", route);
        this.initialPops = inital;
        this.endPoss = end;
    }

    public ForceBlockMove(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "WorldAbilities/ForceBlockMove", "png", route);
    }

    public int getInitialPops() {
        return initialPops;
    }

    public int getEndPoss() {
        return endPoss;
    }

    @Override
    public void onUpdate() {

    }
}
