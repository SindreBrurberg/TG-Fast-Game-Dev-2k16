package dsda.dethsanius.com.Core;

import Engin.Core.Game;
import dsda.dethsanius.com.Screen.mainScrean;
import dsda.dethsanius.com.lib.Reference;


public class Main {

    private final Game game;

    Main()
    {
        game = new Game(Reference.winX, Reference.winY, Reference.Title);
        game.getScreenFactory().showScreen(new mainScrean(game.getScreenFactory()));
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
