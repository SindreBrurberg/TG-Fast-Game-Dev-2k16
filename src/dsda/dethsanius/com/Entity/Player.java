package dsda.dethsanius.com.Entity;

import dsda.dethsanius.com.Screen.gameScreen;

/**
 * Created by sindre on 18.01.2015.
 */
public class Player extends Entity {
    public int Route = 0;

    public Player(double x, double y, double height, double width, int route) {
        super(x, y, height, width, "Player", "png", route);
    }

    public void moveUp(){
        Route = Route - 25;
        switch (gameScreen.routeStatus[Route]) {
            case 1:
                Route = Route + 25;
                break;
            case 2:
                Route = Route + 25;
                break;
            case 3:
                Route = Route + 25;
                break;
            case 4:
                gameScreen.routeStatus[Route + 25] = 0;
                break;
            case 5:
                gameScreen.routeStatus[Route + 25] = 0;
                break;
            case 6:
                Route = Route + 25;
                break;
            case 7:
                Route = Route + 25;
                break;
            case 8:
                gameScreen.routeStatus[Route + 25] = 0;
                Route = gameScreen.teleport[Route].getTo();
                this.setX(gameScreen.routes[Route].getX());
                break;
            case 9:
                gameScreen.LevelTime.setHouer(gameScreen.LevelTime.getHouer() + gameScreen.timeWarpWorld[Route].getHr());
                gameScreen.LevelTime.setMinute(gameScreen.LevelTime.getMinute() + gameScreen.timeWarpWorld[Route].getMin());
                break;
            case 10:
                Route = Route + 25;
                break;
            case 11:
                Route = Route + 25;
                break;
            default:
                gameScreen.routeStatus[Route + 25] = 0;
        }
        this.setY(gameScreen.routes[Route].getY());
        resetLoop();
        update();
    }

    public void moveDown(){
        Route = Route + 25;
        switch (gameScreen.routeStatus[Route]) {
            case 1:
                Route = Route - 25;
                break;
            case 2:
                Route = Route - 25;
                break;
            case 3:
                Route = Route - 25;
                break;
            case 4:
                gameScreen.routeStatus[Route - 25] = 0;
                break;
            case 5:
                gameScreen.routeStatus[Route - 25] = 0;
                break;
            case 6:
                Route = Route - 25;
                break;
            case 7:
                Route = Route - 25;
                break;
            case 8:
                gameScreen.routeStatus[Route - 25] = 0;
                Route = gameScreen.teleport[Route].getTo();
                this.setX(gameScreen.routes[Route].getX());
                break;
            case 9:
                gameScreen.LevelTime.setHouer(gameScreen.LevelTime.getHouer() + gameScreen.timeWarpWorld[Route].getHr());
                gameScreen.LevelTime.setMinute(gameScreen.LevelTime.getMinute() + gameScreen.timeWarpWorld[Route].getMin());
                break;
            case 10:
                Route = Route - 25;
                break;
            case 11:
                Route = Route - 25;
                break;
            default:
                gameScreen.routeStatus[Route - 25] = 0;
        }
        this.setY(gameScreen.routes[Route].getY());
        resetLoop();
        update();
    }

    public void moveLeft(){
        Route -=1;
        switch (gameScreen.routeStatus[Route]) {
            case 1:
                Route +=1;
                break;
            case 2:
                Route +=1;
                break;
            case 3:
                Route +=1;
                break;
            case 4:
                gameScreen.routeStatus[Route + 1] = 0;
                break;
            case 5:
                gameScreen.routeStatus[Route + 1] = 0;
                break;
            case 6:
                Route +=1;
                break;
            case 7:
                Route +=1;
                break;
            case 8:
                gameScreen.routeStatus[Route + 1] = 0;
                Route = gameScreen.teleport[Route].getTo();
                this.setX(gameScreen.routes[Route].getX());
                break;
            case 9:
                gameScreen.LevelTime.setHouer(gameScreen.LevelTime.getHouer() + gameScreen.timeWarpWorld[Route].getHr());
                gameScreen.LevelTime.setMinute(gameScreen.LevelTime.getMinute() + gameScreen.timeWarpWorld[Route].getMin());
                break;
            case 10:
                Route +=1;
                break;
            case 11:
                Route +=1;
                break;
            default:
                gameScreen.routeStatus[Route + 1] = 0;
        }
        this.setX(gameScreen.routes[Route].getX());
        resetLoop();
        update();
    }

    public void moveRight(){
        Route +=1;
        switch (gameScreen.routeStatus[Route]) {
            case 1:
                Route -=1;
                break;
            case 2:
                Route -=1;
                break;
            case 3:
                Route -=1;
                break;
            case 4:
                System.out.println("Somnerasasd");
                System.out.println(gameScreen.forceBlockMove[Route].getInitialPops());
                System.out.println(gameScreen.forceBlockMove[Route].getEndPoss());
                gameScreen.routeStatus[gameScreen.forceBlockMove[Route].getEndPoss()] = gameScreen.routeStatus[gameScreen.forceBlockMove[Route].getInitialPops()];
                gameScreen.routeStatus[gameScreen.forceBlockMove[Route].getInitialPops()] = 0;
                break;
            case 5:
                gameScreen.routeStatus[Route - 1] = 0;
                break;
            case 6:
                Route -=1;
                break;
            case 7:
                Route -=1;
                break;
            case 8:
                gameScreen.routeStatus[Route - 1] = 0;
                Route = gameScreen.teleport[Route].getTo();
                this.setX(gameScreen.routes[Route].getX());
                break;
            case 9:
                gameScreen.LevelTime.setHouer(gameScreen.LevelTime.getHouer() + gameScreen.timeWarpWorld[Route].getHr());
                gameScreen.LevelTime.setMinute(gameScreen.LevelTime.getMinute() + gameScreen.timeWarpWorld[Route].getMin());
                break;
            case 10:
                Route -=1;
                break;
            case 11:
                Route -=1;
                break;
            default:
                gameScreen.routeStatus[Route - 1] = 0;
        }
        this.setX(gameScreen.routes[Route].getX());
        resetLoop();
        update();
    }

    @Override
    public void onUpdate() {
        if (Route != 1)
            gameScreen.routeStatus[Route] = 12;
    }
}
