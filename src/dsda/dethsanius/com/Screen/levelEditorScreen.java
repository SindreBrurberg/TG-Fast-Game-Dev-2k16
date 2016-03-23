package dsda.dethsanius.com.Screen;

import Engin.*;
import Engin.Entity.Butten;
import dsda.dethsanius.com.Entity.Blocks.*;
import dsda.dethsanius.com.Entity.WorldAbilities.*;
import dsda.dethsanius.com.Handlers.MouseHandlerEditorScreen;
import dsda.dethsanius.com.lib.Colors;
import dsda.dethsanius.com.lib.Reference;

import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Dethsanius on 4/2/2015.
 */
public class levelEditorScreen extends Screen {
    public levelEditorScreen(ScreenFactory screenFactory) {
        super(screenFactory);
    }

    private ReadWriteFile readWriteFile;
    private MouseHandlerEditorScreen mousepadListener;
    private Rectangle oldRect = new Rectangle(0,0,0,0);
    private Butten butten1, butten2, butten3, butten4, butten5, butten6, butten7, butten8, butten9, butten10, butten11, butten12, butten13, butten14, butten15, butten16, butten17, butten18, butten19, butten20, butten21, butten22, butten23, butten24, butten25, butten26, butten27, butten28, butten29, butten30, butten31, butten32, butten33;
    private FileWriter fileWriter, fileWriterStreifer, fileWriterTimeWarp, fileWriterTeleport, fileWriterForceBlockMove, fileWriterChangeEnvironment;
    private PrintWriter printWriter, printWriterStreifer, printWriterTimeWarp, printWriterTeleport, printWriterForceBlockMove, printWriterChangeEnvironment;
    private static int maxRectangles = 420;
    public static int maxRectanglesDrawn = 0;
    public static int routeStat = 0, state = 0, selectedTimeMin = 0, selectedTimeHr = 0, destination = 0, initPoss = 0, endPoss = 0;
    public static int[] routeStatus = new int[maxRectangles], InitPos = new int[maxRectangles], EndPos = new int[maxRectangles], timeMin = new int[maxRectangles], timeHr = new int[maxRectangles], streiferState = new int[maxRectangles], timeWarpState = new int[maxRectangles], teleportState = new int[maxRectangles], forceBlockMoveState = new int[maxRectangles], changeEnvironmentState = new int[maxRectangles];
    public static Rectangle[] routes = new Rectangle[maxRectangles];
    private int selected = 0;
    public static boolean selecting = false, selectingInitPos = false, selectingEndPos = false;

    private Goal[] goal = new Goal[maxRectangles];
    private Entrence[] entrence = new Entrence[maxRectangles];
    private BooHoo[] booHoo = new BooHoo[maxRectangles];
    private Stone[] stone = new Stone[maxRectangles];
    private Path[] path = new Path[maxRectangles];
    private ChangingEnvironment[] changingEnvironment = new ChangingEnvironment[maxRectangles];
    private ForceBlockMove[] forceBlockMove = new ForceBlockMove[maxRectangles];
    private Power[] power = new Power[maxRectangles];
    private Teleport[] teleport = new Teleport[maxRectangles];
    private TimeWarp[] timeWarpWorld = new TimeWarp[maxRectangles];
    private Straifer[] straifer = new Straifer[maxRectangles];
    private Faller[] faller = new Faller[maxRectangles];
    private StringTxt timeUsed, worldTime, levelTime, direction, timeMinShow, timeHrShow, ChangeEnvironment;
    private Time LevelTime, WorldTime, TimeUsed;
    private Battery battery;

    @Override
    public void onCreate()

    {
        int route = 0;
        for (int x = 1; x <= 15; x++) {
            for (int i = 0; i < 25; i++) {
                routes[route] = new Rectangle(48 * i, 48 * x, 48, 48);
                route++;
            }
        }
        maxRectanglesDrawn = route;
        for (int i = 0; i < maxRectanglesDrawn; i++){
            entrence[i] = new Entrence(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            goal[i] = new Goal(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            booHoo[i] = new BooHoo(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            forceBlockMove[i] = new ForceBlockMove(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            changingEnvironment[i] = new ChangingEnvironment(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            stone[i] = new Stone(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            path[i] = new Path(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            power[i] = new Power(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            teleport[i] = new Teleport(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            timeWarpWorld[i] = new TimeWarp(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
            straifer[i] = new Straifer(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i, false);
            faller[i] = new Faller(routes[i].getX(), routes[i].getY(), routes[i].getWidth(), routes[i].getHeight(), i);
        }
        butten1 = new Butten(48*0, 0, 48, 48, "1", screenFactory) {
            @Override
            public void isPushed() {
                selected = 0;
                routeStat = 1;
            }
        };
        butten2 = new Butten(48*1, 0, 48, 48, "2", screenFactory) {
            @Override
            public void isPushed() {
                selected = 0;
                routeStat = 2;
            }
        };
        butten3 = new Butten(48*2, 0, 48, 48, "3", screenFactory) {
            @Override
            public void isPushed() {
                selected = 0;
                routeStat = 3;
            }
        };
        butten4 = new Butten(48*3, 0, 48, 48, "4", screenFactory) {
            @Override
            public void isPushed() {
                selected = 4;
                routeStat = 4;
            }
        };
        butten5 = new Butten(48*4, 0, 48, 48, "5", screenFactory) {
            @Override
            public void isPushed() {
                selected = 5;
                routeStat = 5;
            }
        };
        butten6 = new Butten(48*5, 0, 48, 48, "6", screenFactory) {
            @Override
            public void isPushed() {
                selected = 6;
                routeStat = 6;
            }
        };
        butten7 = new Butten(48*6, 0, 48, 48, "7", screenFactory) {
            @Override
            public void isPushed() {
                selected = 7;
                routeStat = 7;
            }
        };
        butten8 = new Butten(48*7, 0, 48, 48, "8", screenFactory) {
            @Override
            public void isPushed() {
                selected = 8;
                routeStat = 8;
            }
        };
        butten9 = new Butten(48*8, 0, 48, 48, "9", screenFactory) {
            @Override
            public void isPushed() {
                selected = 9;
                routeStat = 9;
            }
        };
        butten10 = new Butten(48*9, 0, 48, 48, "10", screenFactory) {
            @Override
            public void isPushed() {
                selected = 10;
                routeStat = 10;
            }
        };
        butten11 = new Butten(48*10, 0, 48, 48, "11", screenFactory) {
            @Override
            public void isPushed() {
                selected = 0;
                routeStat = 11;
            }
        };
        butten12 = new Butten(48*25, 0, 48, 48, "C", screenFactory) {
            @Override
            public void isPushed() {
                selected = 0;
                routeStat = 0;
            }
        };
        butten13 = new Butten(48*26, 0, 48, 48, "L", screenFactory) {
            @Override
            public void isPushed() {
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    routeStatus[i] = readWriteFile.getIntLine(i + 1, Reference.resorcess("TotF") + "Level/" + "First file structure.txt");
                }
            }
        };
        butten14 = new Butten(48*27, 0, 48, 48, "S", screenFactory) {
            @Override
            public void isPushed() {
                String filname = "First file structure";
                String filpath = Reference.resorcess("TotF") + "Level/" + filname + ".txt";
                fileWriter = readWriteFile.getFile(filpath);
                printWriter = readWriteFile.StartWrite(fileWriter);
                String streiferpath = Reference.resorcess("TotF") + "Level/" + filname + ".streifer.txt";
                fileWriterStreifer = readWriteFile.getFile(streiferpath);
                printWriterStreifer = readWriteFile.StartWrite(fileWriterStreifer);
                String timewarppath = Reference.resorcess("TotF") + "Level/" + filname + ".TimeWarp.txt";
                fileWriterTimeWarp = readWriteFile.getFile(timewarppath);
                printWriterTimeWarp = readWriteFile.StartWrite(fileWriterTimeWarp);
                String teleportpath = Reference.resorcess("TotF") + "Level/" + filname + ".Teleport.txt";
                fileWriterTeleport = readWriteFile.getFile(teleportpath);
                printWriterTeleport = readWriteFile.StartWrite(fileWriterTeleport);
                String forceblockmovepath = Reference.resorcess("TotF") + "Level/" + filname + ".ForceBlockMove.txt";
                fileWriterForceBlockMove = readWriteFile.getFile(forceblockmovepath);
                printWriterForceBlockMove = readWriteFile.StartWrite(fileWriterForceBlockMove);
                String changeenvironmentpath = Reference.resorcess("TotF") + "Level/" + filname + ".ChangeEnvironment.txt";
                fileWriterChangeEnvironment = readWriteFile.getFile(changeenvironmentpath);
                printWriterChangeEnvironment = readWriteFile.StartWrite(fileWriterChangeEnvironment);
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    readWriteFile.Write(printWriter, Integer.toString(routeStatus[i]));
                    readWriteFile.Write(printWriterStreifer, Integer.toString(streiferState[i]));
                    readWriteFile.Write(printWriterTimeWarp, Integer.toString(timeHr[i]));
                    readWriteFile.Write(printWriterTimeWarp, Integer.toString(timeMin[i]));
                    readWriteFile.Write(printWriterTeleport, Integer.toString(teleportState[i]));
                    readWriteFile.Write(printWriterForceBlockMove, Integer.toString(InitPos[i]));
                    readWriteFile.Write(printWriterForceBlockMove, Integer.toString(EndPos[i]));
                    readWriteFile.Write(printWriterChangeEnvironment, Integer.toString(changeEnvironmentState[i]));
                }
                readWriteFile.EndWrite(fileWriter);
                readWriteFile.EndWrite(fileWriterStreifer);
                readWriteFile.EndWrite(fileWriterTimeWarp);
                readWriteFile.EndWrite(fileWriterTeleport);
                readWriteFile.EndWrite(fileWriterForceBlockMove);
                readWriteFile.EndWrite(fileWriterChangeEnvironment);
                String timepath = Reference.resorcess("TotF") + "Level/" + filname + ".time.txt";
                fileWriter = readWriteFile.getFile(timepath);
                printWriter = readWriteFile.StartWrite(fileWriter);
                readWriteFile.Write(printWriter, Integer.toString(LevelTime.getHouer()));
                readWriteFile.Write(printWriter, Integer.toString(LevelTime.getMinute()));
                readWriteFile.Write(printWriter, Integer.toString(WorldTime.getHouer()));
                readWriteFile.Write(printWriter, Integer.toString(WorldTime.getMinute()));
                readWriteFile.EndWrite(fileWriter);
            }
        };
        butten15 = new Butten(48*28, 0, 48, 48, "C", screenFactory) {
            @Override
            public void isPushed() {
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    routeStatus[i] = 0;
                }
            }
        };
        butten16 = new Butten(48*29, 0, 48, 48, "C", screenFactory) {
            @Override
            public void isPushed() {
                for (int i = 0; i < maxRectanglesDrawn; i++) {
                    routeStatus[i] = 0;
                }
                screenFactory.getGame().getWindow().removeMouseListener(mousepadListener);
                getScreenFactory().showScreen(new mainScrean(getScreenFactory()));
            }
        };
        butten17 = new Butten(48 * 25, 48 * 2, 48, 46 / 2, "+", screenFactory) {
            @Override
            public void isPushed() {
                LevelTime.setHouer(LevelTime.getHouer() + 1);
                levelTime.setTXT(LevelTime.toMilitary());
                levelTime.update();
            }
        };
        butten18 = new Butten(48 * 29, 48 * 2, 48, 46 / 2, "-", screenFactory) {
            @Override
            public void isPushed() {
                LevelTime.setHouer(LevelTime.getHouer() - 1);
                levelTime.setTXT(LevelTime.toMilitary());
                levelTime.update();
            }
        };
        butten19 = new Butten(48 * 25, (int)(48 * 2.5), 48, 46 / 2, "+", screenFactory) {
            @Override
            public void isPushed() {
                LevelTime.setMinute(LevelTime.getMinute() + 1);
                levelTime.setTXT(LevelTime.toMilitary());
                levelTime.update();
            }
        };
        butten20 = new Butten(48 * 29, (int)(48 * 2.5), 48, 46 / 2, "-", screenFactory) {
            @Override
            public void isPushed() {
                LevelTime.setMinute(LevelTime.getMinute() - 1);
                levelTime.setTXT(LevelTime.toMilitary());
                levelTime.update();
            }
        };
        butten21 = new Butten(48 * 25, 48 * 4, 48, 46 / 2, "+", screenFactory) {
            @Override
            public void isPushed() {
                WorldTime.setHouer(WorldTime.getHouer() + 1);
                worldTime.setTXT(WorldTime.toMilitary());
                worldTime.update();
            }
        };
        butten22 = new Butten(48 * 29, 48 * 4, 48, 46 / 2, "-", screenFactory) {
            @Override
            public void isPushed() {
                WorldTime.setHouer(WorldTime.getHouer() - 1);
                worldTime.setTXT(WorldTime.toMilitary());
                worldTime.update();
            }
        };
        butten23 = new Butten(48 * 25, (int)(48 * 4.5), 48, 46 / 2, "+", screenFactory) {
            @Override
            public void isPushed() {
                WorldTime.setMinute(WorldTime.getMinute() + 1);
                worldTime.setTXT(WorldTime.toMilitary());
                worldTime.update();
            }
        };
        butten24 = new Butten(48 * 29, (int)(48 * 4.5), 48, 46 / 2, "-", screenFactory) {
            @Override
            public void isPushed() {
                WorldTime.setMinute(WorldTime.getMinute() - 1);
                worldTime.setTXT(WorldTime.toMilitary());
                worldTime.update();
            }
        };
        butten25 = new Butten(48 * 25, (int)(48 * 8), 48, 46, "<", screenFactory, true) {
            @Override
            public void isPushed() {
                state = 0;
                setDiactivated(true);
                butten26.setDiactivated(false);
            }
        };
        butten26 = new Butten(48 * 29, (int)(48 * 8), 48, 46, ">", screenFactory) {
            @Override
            public void isPushed() {
                state = 1;
                setDiactivated(true);
                butten25.setDiactivated(false);
            }
        };
        butten27 = new Butten(48 * 25, (int)(48 * 8), 48, 46, "+", screenFactory) {
            @Override
            public void isPushed() {
                selectedTimeHr++;
                timeHrShow.update();
            }
        };
        butten28 = new Butten(48 * 29, (int)(48 * 8), 48, 46, "-", screenFactory) {
            @Override
            public void isPushed() {
                selectedTimeHr--;
                timeHrShow.update();
            }
        };
        butten29 = new Butten(48 * 25, (int)(48 * 10), 48, 46, "+", screenFactory) {
            @Override
            public void isPushed() {
                selectedTimeMin++;
                timeMinShow.update();
            }
        };
        butten30 = new Butten(48 * 29, (int)(48 * 10), 48, 46, "-", screenFactory) {
            @Override
            public void isPushed() {
                selectedTimeMin--;
                timeMinShow.update();
            }
        };
        butten31 = new Butten(48 * 25, (int)(48 * 8), 48 * 5, 46, "Select Destination", screenFactory) {
            @Override
            public void isPushed() {
                selecting = true;
                selectingInitPos = false;
                selectingEndPos = false;
            }
        };
        butten32 = new Butten(48 * 25, (int)(48 * 8), 48 * 5, 46, "Select Start Pos", screenFactory) {
            @Override
            public void isPushed() {
                selecting = false;
                selectingInitPos = true;
                selectingEndPos = false;
            }
        };
        butten33 = new Butten(48 * 25, (int)(48 * 10), 48 * 5, 46, "Select Destination", screenFactory) {
            @Override
            public void isPushed() {
                selecting = false;
                selectingInitPos = false;
                selectingEndPos = true;
            }
        };
        battery = new Battery(48 * 25.5, 48 * 7, 48 * 5, 48, 0);
        LevelTime = new Time();
        WorldTime = new Time();
        TimeUsed = new Time();
        levelTime = new StringTxt(48 * 26.25, 48 * 2, 48 * 3 - 8, 46, LevelTime.toMilitary()) {
            @Override
            public void onUpdate() {

            }
        };
        worldTime = new StringTxt(48 * 26.25, 48 * 4, 48 * 3 - 8, 46, WorldTime.toMilitary()) {
            @Override
            public void onUpdate() {

            }
        };
        timeUsed = new StringTxt(48 * 26.25, 48 * 6, 48 * 3 - 8, 46, TimeUsed.toMilitary()) {
            @Override
            public void onUpdate() {
                TimeUsed.setTime(TimeUsed.getHouer() + (TimeUsed.getMinute() == 59 ? 1 : 0), TimeUsed.getMinute() + (TimeUsed.getSecound() == 59 ? 1 : 0) + (TimeUsed.getMinute() == 59 ? 1 : 0), TimeUsed.getSecound() + 1);
                setTXT(TimeUsed.toMilitary());
            }
        };
        direction = new StringTxt(48 * 26.25, 48 * 8, 48 * 3 - 8, 46, "Direction") {
            @Override
            public void onUpdate() {

            }
        };
        timeHrShow = new StringTxt(48 * 26.25, 48 * 8, 48 * 3 - 8, 46, "Hr: " + Integer.toString(selectedTimeHr)) {
            @Override
            public void onUpdate() {
                setTXT("Hr: " + Integer.toString(selectedTimeHr));
            }
        };
        timeMinShow = new StringTxt(48 * 26.25, 48 * 10, 48 * 3 - 8, 46, "Min: " + Integer.toString(selectedTimeMin)) {
            @Override
            public void onUpdate() {
                setTXT("Min: " + Integer.toString(selectedTimeMin));
            }
        };
        mousepadListener = new MouseHandlerEditorScreen(screenFactory);
        screenFactory.getGame().getWindow().addMouseListener(mousepadListener);
        readWriteFile = new ReadWriteFile();
    }

    @Override
    public void onUpdate()
    {
        butten1.update();
        butten2.update();
        butten3.update();
        butten4.update();
        butten5.update();
        butten6.update();
        butten7.update();
        butten8.update();
        butten9.update();
        butten10.update();
        butten11.update();
        butten12.update();
        butten13.update();
        butten14.update();
        butten15.update();
        butten16.update();
        butten17.update();
        butten18.update();
        butten19.update();
        butten20.update();
        butten21.update();
        butten22.update();
        butten23.update();
        butten24.update();
        switch (selected) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                butten32.update();
                butten33.update();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                butten31.update();
                break;
            case 9:
                butten27.update();
                butten28.update();
                butten29.update();
                butten30.update();
                break;
            case 10:
                butten25.update();
                butten26.update();
                break;
            case 11:
                break;
        }
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        g2d.setPaint(Colors.bacgroundColorBrighter());
        g2d.fillRect(0, 0, 48 * 25, 48);
        for (int i = 0; i < maxRectanglesDrawn; i++) {
            switch (routeStatus[i]) {
                case 0:
                    path[i].draw(g2d);
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
                default:
            }
        }
        g2d.setColor(Color.white);
        g2d.fill(MouseHandlerEditorScreen.path);
        butten1.draw(g2d);
        butten2.draw(g2d);
        butten3.draw(g2d);
        butten4.draw(g2d);
        butten5.draw(g2d);
        butten6.draw(g2d);
        butten7.draw(g2d);
        butten8.draw(g2d);
        butten9.draw(g2d);
        butten10.draw(g2d);
        butten11.draw(g2d);
        butten12.draw(g2d);
        butten13.draw(g2d);
        butten14.draw(g2d);
        butten15.draw(g2d);
        butten16.draw(g2d);
        butten17.draw(g2d);
        butten18.draw(g2d);
        butten19.draw(g2d);
        butten20.draw(g2d);
        butten21.draw(g2d);
        butten22.draw(g2d);
        butten23.draw(g2d);
        butten24.draw(g2d);
        switch (selected) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                butten32.draw(g2d);
                butten33.draw(g2d);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                butten31.draw(g2d);
                break;
            case 9:
                butten27.draw(g2d);
                butten28.draw(g2d);
                butten29.draw(g2d);
                butten30.draw(g2d);
                timeHrShow.draw(g2d);
                timeMinShow.draw(g2d);
                break;
            case 10:
                butten25.draw(g2d);
                butten26.draw(g2d);
                direction.draw(g2d);
                break;
            case 11:
                break;
        }
        worldTime.draw(g2d);
        levelTime.draw(g2d);
        timeUsed.draw(g2d);
        g2d.draw(oldRect);
        battery.draw(g2d);
    }
}
