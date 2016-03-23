package dsda.dethsanius.com.Entity.Blocks;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class Goal extends Entity {
    public Goal(double x, double y, double width, double height, int route) {
        super(x, y, width, height, "Block/GoalLocked", "png", route);
    }

    @Override
    public void onUpdate() {
        if (false){
            loadImage("Block/GoalOpen", "png");
        }
    }
}
