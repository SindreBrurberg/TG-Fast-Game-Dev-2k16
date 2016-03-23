package dsda.dethsanius.com.Entity.Blocks;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class Entrence extends Entity {
    public Entrence(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "Block/Entrance", "png", route);
    }

    @Override
    public void onUpdate() {

    }
}
