package dsda.dethsanius.com.Entity.Blocks;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class Stone extends Entity {
    public Stone(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "Block/Stone", "png", route);
    }

    @Override
    public void onUpdate() {

    }
}
