package dsda.dethsanius.com.Screen;

import Engin.Entity.Butten;
import Engin.Screen;
import Engin.ScreenFactory;
import Engin.StringTxt;
import dsda.dethsanius.com.lib.Reference;

import java.awt.*;

/**
 * Created by Haxer on 09.02.14.
 */
public class mainScrean extends Screen {
    private StringTxt stringTxt;
    private Butten butten1, butten2;
    private int buttensTot = 3;
    private Rectangle[] buttens = new Rectangle[buttensTot];
    private boolean creaded = false;

    public mainScrean(ScreenFactory screenFactory)
    {
        super(screenFactory);
    }

    @Override
    public void onCreate()
    {
        Butten.generateButtons(25, 15, 0, 0, Reference.winX, Reference.winY, buttensTot);
        this.buttens = Butten.buttens;
        buttens[0].width -= 40;
        stringTxt = new StringTxt(buttens[0], "Time of the Future") {
            @Override
            public void onUpdate() {

            }
        };
        butten1 = new Butten(buttens[1], "Level Editor", screenFactory, false) {

            @Override
            public void isPushed()
            {
                getScreenFactory().showScreen(new levelEditorScreen(getScreenFactory()));
            }
        };
        butten2 = new Butten(buttens[2], "Game", screenFactory, false) {

            @Override
            public void isPushed()
            {
                getScreenFactory().showScreen(new gameScreen(getScreenFactory()));
            }
        };
        creaded = true;
    }

    @Override
    public void onUpdate()
    {
        if (creaded)
        {
            stringTxt.update();
            butten1.update();
            butten2.update();
        }
    }

    @Override
    public void onDraw(Graphics2D g2d)
    {
        g2d.setPaint(screenFactory.getGame().bacgroundColor());
        g2d.fillRect(0, 0, (int) screenFactory.getGame().getWindowWidth(), (int) screenFactory.getGame().getWindowHeight());
        stringTxt.draw(g2d);
        butten1.draw(g2d);
        butten2.draw(g2d);
    }
}
