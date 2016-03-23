package dsda.dethsanius.com.Entity.PlayerAbilities;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class MoveBlock extends Entity {
    public MoveBlock(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "PlayerAbilities/MoveBlock", "png", route);
    }

    @Override
    public void onUpdate() {

    }
}
