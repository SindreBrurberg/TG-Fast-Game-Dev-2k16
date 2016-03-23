package dsda.dethsanius.com.Entity.WorldAbilities;

import dsda.dethsanius.com.Entity.Entity;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class Teleport extends Entity {
    private int To = 0;
    public Teleport(double x, double y, double width, double height, int route, int to) {
        super(x, y, width, height, "WorldAbilities/Teleport", "png", route);
        this.To = to;
        System.out.println(to);
    }

    public int getTo() {
        return To;
    }

    public Teleport(double x, double y, double width, double height, int route){
        this(x, y, width, height, route, 0);
    }

    @Override
    public void onUpdate() {

    }
}
