package dsda.dethsanius.com.Entity;

import Engin.Entity.AbstractEntity;
import dsda.dethsanius.com.lib.Reference;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public abstract class Entity extends AbstractEntity implements IEntity{
    private double Width = 0, Height = 0;
    private boolean ImageLoaded = false;
    private BufferedImage img = null;
    private int Route = 0;
    private boolean processDone = false;
    public Entity(double x, double y, double width, double height, String File , String Ekstention, int route) {
        super(x, y);
        this.Width = width;
        this.Height = height;
        this.loadImage(File, Ekstention);
        this.Route = route;
    }

    public void setProcessDone(boolean processDone) {
        this.processDone = processDone;
    }

    public void setRoute(int route) {
        Route = route;
    }

    public int getRoute() {
        return Route;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public void setWidth(double width) {
        Width = width;
    }

    public double getHeight() {
        return Height;
    }

    public double getWidth() {
        return Width;
    }

    @Override
    public void update() {
        if (ImageLoaded && !processDone){
            onUpdate();
            processDone = true;
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (ImageLoaded){
            g2d.drawImage(img, (int)getX(), (int)getY(), null);
        }
    }

    public void loadImage(String File , String Ekstention){
        try {
            System.out.println(Reference.resorcess("TotF") + "Pickture/" + File + "." + Ekstention);
            img = ImageIO.read(new File(Reference.resorcess("TotF") + "Pickture/" + File + "." + Ekstention));
            ImageLoaded = true;
        } catch (IOException e) {
        }
    }

    public void resetLoop(){
        processDone = false;
    }
}
