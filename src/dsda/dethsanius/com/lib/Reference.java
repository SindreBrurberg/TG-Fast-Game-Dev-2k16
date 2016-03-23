package dsda.dethsanius.com.lib;

import Engin.Core.Game;
import Engin.ScreenFactory;

/**
 * Created by Haxer on 09.02.14.
 */
public class Reference {
    public static final int winX = 1440, winY = 768;
    public static String Title = "Time of the Future";

    public static String resorcess(String game)
    {
        return Game.projectPath() + "Resorsess/" + game + "/";
    }

    public static int getWidth(ScreenFactory screenFactory)
    {
        return (int)screenFactory.getGame().getWindowWidth();
    }

    public static int getHeight(ScreenFactory screenFactory)
    {
        return (int)screenFactory.getGame().getWindowHeight();
    }
}
