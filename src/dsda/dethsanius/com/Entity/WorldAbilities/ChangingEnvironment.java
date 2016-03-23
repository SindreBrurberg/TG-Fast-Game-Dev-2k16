package dsda.dethsanius.com.Entity.WorldAbilities;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class ChangingEnvironment extends Entity {
    public ChangingEnvironment(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "WorldAbilities/ChangingEnvironment", "png", route);
    }

    @Override
    public void onUpdate() {

    }
}
