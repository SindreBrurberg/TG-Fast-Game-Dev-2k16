package dsda.dethsanius.com.Entity.Blocks;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class Path extends Entity {
    public Path(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "Block/Path", "png", route);
    }

    @Override
    public void onUpdate() {

    }
}
