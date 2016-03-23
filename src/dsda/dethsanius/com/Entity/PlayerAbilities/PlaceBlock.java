package dsda.dethsanius.com.Entity.PlayerAbilities;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class PlaceBlock extends Entity {
    public PlaceBlock(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "PlayerAbilities/PlaceBlock", "png", route);
    }

    @Override
    public void onUpdate() {

    }
}
