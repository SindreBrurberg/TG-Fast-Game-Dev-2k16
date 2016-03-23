package dsda.dethsanius.com.Handlers;

import Engin.Listener.MousepadListener;
import Engin.ScreenFactory;
import dsda.dethsanius.com.Screen.levelEditorScreen;

import java.awt.*;

/**
 * Created by Dethsanius on 12.01.2015.
 */
public class MouseHandlerEditorScreen extends MousepadListener {

    public static Rectangle path = new Rectangle(0,48,0,0);

    ScreenFactory screenFactory;

    public MouseHandlerEditorScreen(ScreenFactory initScreenFactory) {
        super();
        screenFactory = initScreenFactory;
    }

    @Override
    public void Moved() {

    }

    @Override
    public void Exited() {

    }

    @Override
    public void Entered() {

    }

    @Override
    public void Clicked() {

    }

    @Override
    public void Pressed() {

    }

    @Override
    public void Released() {
        int RouteY = (int)(getMouse(screenFactory).getY() - 48) / 48;
        int RouteX = (int)(getMouse(screenFactory).getX()) / 48;
        int Route = RouteY * 25 + RouteX;
        if (getMouse(screenFactory).getBounds().intersects(levelEditorScreen.routes[Route])){
            if (levelEditorScreen.selecting){
                levelEditorScreen.destination = Route;
                levelEditorScreen.selecting = false;
            }
            else if (levelEditorScreen.selectingInitPos){
                levelEditorScreen.initPoss = Route;
                levelEditorScreen.selectingInitPos = false;
            }
            else if (levelEditorScreen.selectingEndPos){
                levelEditorScreen.endPoss = Route;
                levelEditorScreen.selectingEndPos = false;
            }
            else {
                levelEditorScreen.routeStatus[Route] = levelEditorScreen.routeStat;
                levelEditorScreen.streiferState[Route] = levelEditorScreen.state;
                levelEditorScreen.timeHr[Route] = levelEditorScreen.selectedTimeHr;
                levelEditorScreen.timeMin[Route] = levelEditorScreen.selectedTimeMin;
                levelEditorScreen.teleportState[Route] = levelEditorScreen.destination;
                levelEditorScreen.InitPos[Route] = levelEditorScreen.initPoss;
                levelEditorScreen.EndPos[Route] = levelEditorScreen.endPoss;
            }
        }
    }

    @Override
    public void Dragged() {

    }
}
