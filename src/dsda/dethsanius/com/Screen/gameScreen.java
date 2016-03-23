package dsda.dethsanius.com.Screen;

import Engin.*;
import Engin.Entity.Butten;
import dsda.dethsanius.com.Entity.Blocks.*;
import dsda.dethsanius.com.Entity.Player;
import dsda.dethsanius.com.Entity.WorldAbilities.*;
import dsda.dethsanius.com.Handlers.KeyboardHandlerGameScreen;
import dsda.dethsanius.com.lib.Colors;
import dsda.dethsanius.com.lib.Reference;

import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class gameScreen extends Screen {
    public static Player player;
    private ReadWriteFile readWriteFile;
    private KeyboardHandlerGameScreen keyboardListener;
    private int startRoute = 0;
    private boolean cloased = false;
    public static boolean useAbillity = false;
    public static int bagSpace = 20;
    private int[] slot = new int[bagSpace];
    public static int activeSlot = 0;
    private Rectangle[] bag = new Rectangle[bagSpace];
    private static int maxRectangles = 420;
    public static int maxRectanglesDrawn = 0;
    public static int[] routeStatus = new int[maxRectangles];
    public static Rectangle[] routes = new Rectangle[maxRectangles];
    private Butten butten1, butten2, butten3;
    private StringTxt chosenLevel, timeUsed, worldTime, levelTime;
    private String ChosenLevel = "First file structure";
    public static Time LevelTime;
    private Time WorldTime, TimeUsed;

    private Goal[] goal = new Goal[maxRectangles];
    private Entrence[] entrence = new Entrence[maxRectangles];
    private BooHoo[] booHoo = new BooHoo[maxRectangles];
    private Stone[] stone = new Stone[maxRectangles];
    private Path[] path = new Path[maxRectangles];
    private ChangingEnvironment[] changingEnvironment = new ChangingEnvironment[maxRectangles];
    public static ForceBlockMove[] forceBlockMove = new ForceBlockMove[maxRectangles];
    private Power[] power = new Power[maxRectangles];
    public static Teleport[] teleport = new Teleport[maxRectangles];
    public static TimeWarp[] timeWarpWorld = new TimeWarp[maxRectangles];
    public static Straifer[] straifer = new Straifer[maxRectangles];
    public static Faller[] faller = new Faller[maxRectangles];

    public gameScreen(ScreenFactory screenFactory) {
        super(screenFactory);
    }

    @Override
    public void onCreate() {
        int route = 0;
        for (int x = 1; x <= 15; x++) {
            for (int i = 0; i < 25; i++) {
                routes[route] = new Rectangle(48 * i, 48 * x, 48, 48);
                route++;
            }
        }
        for (int i = 0; i < bagSpace; i++){
            bag[i] = new Rectangle(48 * i, 1, 47, 46);
        }
        maxRectanglesDrawn = route;
        player = new Player(routes[startRoute].x, routes[startRoute].y, 48, 48, startRoute);
        player.Route = startRoute;
        keyboardListener = new KeyboardHandlerGameScreen();
        screenFactory.getGame().getWindow().addKeyListener(keyboardListener);
        butten1 = new Butten(48*27, 0, 48, 48, "S", screenFactory) {
            @Override
            public void isPushed() {

            }
        };
        butten2 = new Butten(48*28, 0, 48, 48, "L", screenFactory) {
            @Override
            public void isPushed() {
                readWriteFile = new ReadWriteFile();
                int dubbleInc = 1;
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    int streifer = 0, hr = 0, min = 0, to = 0, init = 0, end = 0;
                    routeStatus[i] = readWriteFile.getIntLine(i + 1, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".txt");
                    streifer = readWriteFile.getIntLine(i + 1, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".streifer.txt");
                    hr = readWriteFile.getIntLine(dubbleInc, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".TimeWarp.txt");
                    min = readWriteFile.getIntLine(dubbleInc + 1, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".TimeWarp.txt");
                    to = readWriteFile.getIntLine(i + 1, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".Teleport.txt");
                    init = readWriteFile.getIntLine(dubbleInc, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".ForceBlockMove.txt");
                    end = readWriteFile.getIntLine(dubbleInc + 1, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".ForceBlockMove.txt");
                    switch (routeStatus[i]){
                        case 1:
                            startRoute = i;
                            break;
                        default:
                    }
                    entrence[i] = new Entrence(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
                    goal[i] = new Goal(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
                    booHoo[i] = new BooHoo(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
                    forceBlockMove[i] = new ForceBlockMove(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i, init, end);
                    changingEnvironment[i] = new ChangingEnvironment(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
                    stone[i] = new Stone(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
                    path[i] = new Path(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
                    power[i] = new Power(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
                    teleport[i] = new Teleport(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i, to);
                    timeWarpWorld[i] = new TimeWarp(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i, hr, min);
                    straifer[i] = new Straifer(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i, streifer==0);
                    faller[i] = new Faller(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
                    dubbleInc = dubbleInc + 2;
                }
                LevelTime.setHouer(readWriteFile.getIntLine(1, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".time.txt"));
                LevelTime.setMinute(readWriteFile.getIntLine(2, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".time.txt"));
                levelTime.setTXT(LevelTime.toMilitary());
                levelTime.update();
                WorldTime.setHouer(readWriteFile.getIntLine(3, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".time.txt"));
                WorldTime.setMinute(readWriteFile.getIntLine(4, Reference.resorcess("TotF") + "Level/" + ChosenLevel + ".time.txt"));
                worldTime.setTXT(WorldTime.toMilitary());
                worldTime.update();
            }
        };
        butten3 = new Butten(48*29, 0, 48, 48, "C", screenFactory) {
            @Override
            public void isPushed() {
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    routeStatus[i] = 0;
                }
                screenFactory.getGame().getWindow().removeKeyListener(keyboardListener);
                getScreenFactory().showScreen(new mainScrean(getScreenFactory()));
            }
        };
        chosenLevel = new StringTxt(48 * 20 + 3, 1, 48 * 7 - 8, 46, ChosenLevel) {
            @Override
            public void onUpdate() {

            }
        };
        LevelTime = new Time();
        WorldTime = new Time();
        TimeUsed = new Time();
        levelTime = new StringTxt(48 * 26.25, 48 * 2, 48 * 3 - 8, 46, LevelTime.toMilitary()) {
            @Override
            public void onUpdate() {
                if (LevelTime.getSecound() == 0 && LevelTime.getMinute() != 0) {
                    LevelTime.setSecound(59);
                    LevelTime.setMinute(LevelTime.getMinute() - 1);
                }
                if (LevelTime.getMinute() == 0 && LevelTime.getHouer() != 0) {
                    LevelTime.setMinute(59);
                    LevelTime.setHouer(LevelTime.getHouer() - 1);
                }
                LevelTime.setSecound(LevelTime.getSecound() - 1);
                setTXT(LevelTime.toMilitary());
            }
        };
        worldTime = new StringTxt(48 * 26.25, 48 * 4, 48 * 3 - 8, 46, WorldTime.toMilitary()) {
            @Override
            public void onUpdate() {
                if (WorldTime.getSecound() == 0 && WorldTime.getMinute() != 0) {
                    WorldTime.setSecound(59);
                    WorldTime.setMinute(WorldTime.getMinute() - 1);
                }
                if (WorldTime.getMinute() == 0 && WorldTime.getHouer() != 0) {
                    WorldTime.setMinute(59);
                    WorldTime.setHouer(WorldTime.getHouer() - 1);
                }
                WorldTime.setSecound(WorldTime.getSecound() - 1);
                setTXT(WorldTime.toMilitary());
            }
        };
        timeUsed = new StringTxt(48 * 26.25, 48 * 6, 48 * 3 - 8, 46, TimeUsed.toMilitary()) {
            @Override
            public void onUpdate() {
                TimeUsed.setTime(TimeUsed.getHouer() + (TimeUsed.getMinute() == 59 ? 1 : 0), TimeUsed.getMinute() + (TimeUsed.getSecound() == 59 ? 1 : 0) + (TimeUsed.getMinute() == 59 ? 1 : 0), TimeUsed.getSecound() + 1);
                setTXT(TimeUsed.toMilitary());
            }
        };
        butten2.isPushed();
    }

    @Override
    public void onUpdate() {
        butten1.update();
        butten2.update();
        butten3.update();
        worldTime.update();
        levelTime.update();
        timeUsed.update();
        if (TimeUsed.getSecound() == 0){
            for (int i = maxRectangles - 1; i >= 0; i--){
                switch (routeStatus[i]) {
                    case 0:
                        break;
                    case 1:
                        entrence[i].update();
                        break;
                    case 2:
                        goal[i].update();
                        break;
                    case 3:
                        booHoo[i].update();
                        break;
                    case 4:
                        forceBlockMove[i].update();
                        break;
                    case 5:
                        changingEnvironment[i].update();
                        break;
                    case 6:
                        stone[i].update();
                        break;
                    case 7:
                        power[i].update();
                        break;
                    case 8:
                        teleport[i].update();
                        break;
                    case 9:
                        timeWarpWorld[i].update();
                        break;
                    case 10:
                        straifer[i].update();
                        break;
                    case 11:
                        faller[i].update();
                        break;
                    default:
                }
            }
            for (int i = 0; i < maxRectanglesDrawn; i++) {
                switch (routeStatus[i]) {
                    case 0:
                        break;
                    case 1:
                        entrence[i].resetLoop();
                        break;
                    case 2:
                        goal[i].resetLoop();
                        break;
                    case 3:
                        booHoo[i].resetLoop();
                        break;
                    case 4:
                        forceBlockMove[i].resetLoop();
                        break;
                    case 5:
                        changingEnvironment[i].resetLoop();
                        break;
                    case 6:
                        stone[i].resetLoop();
                        break;
                    case 7:
                        power[i].resetLoop();
                        break;
                    case 8:
                        teleport[i].resetLoop();
                        break;
                    case 9:
                        timeWarpWorld[i].resetLoop();
                        break;
                    case 10:
                        straifer[i].resetLoop();
                        break;
                    case 11:
                        faller[i].resetLoop();
                        break;
                    default:
                }
            }
        }
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        g2d.setPaint(Colors.bacgroundColorBrighter());
        g2d.fillRect(0, 0, 48 * 25, 48);
        for (int i = 0; i < 20; i++) {
            g2d.setColor(Color.BLACK);
            g2d.draw(bag[i]);
        }
        g2d.setColor(Color.YELLOW);
        g2d.fill(bag[activeSlot]);
        for (int i = 0; i < maxRectanglesDrawn; i++) {
            if (routeStatus[i] != 1)path[i].draw(g2d);
            switch (routeStatus[i]) {
                case 0:
                    break;
                case 1:
                    entrence[i].draw(g2d);
                    break;
                case 2:
                    goal[i].draw(g2d);
                    break;
                case 3:
                    booHoo[i].draw(g2d);
                    break;
                case 4:
                    forceBlockMove[i].draw(g2d);
                    break;
                case 5:
                    changingEnvironment[i].draw(g2d);
                    break;
                case 6:
                    stone[i].draw(g2d);
                    break;
                case 7:
                    power[i].draw(g2d);
                    break;
                case 8:
                    teleport[i].draw(g2d);
                    break;
                case 9:
                    timeWarpWorld[i].draw(g2d);
                    break;
                case 10:
                    straifer[i].draw(g2d);
                    break;
                case 11:
                    faller[i].draw(g2d);
                    break;
                case 12:
                    g2d.fill(routes[i]);
                default:
            }
        }
        if (!cloased) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(48 * 20, 1, 48 * 7 - 1, 46);
            g2d.setColor(Color.WHITE);
            g2d.drawRect(48*20, 1, 48*7 - 1, 46);
            g2d.drawRect(48 * 20 + 1, 2, 48 * 7 - 3, 44);
        }
        else {

        }
        player.draw(g2d);
        butten1.draw(g2d);
        butten2.draw(g2d);
        butten3.draw(g2d);
        chosenLevel.draw(g2d);
        worldTime.draw(g2d);
        levelTime.draw(g2d);
        timeUsed.draw(g2d);
    }
}
