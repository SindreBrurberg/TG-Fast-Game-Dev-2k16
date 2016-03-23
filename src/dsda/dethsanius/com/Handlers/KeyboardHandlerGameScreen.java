package dsda.dethsanius.com.Handlers;

import Engin.Listener.KeyboardListener;
import dsda.dethsanius.com.Screen.gameScreen;

import java.awt.event.KeyEvent;

/**
 * Created by sindre on 18.01.2015.
 */
public class KeyboardHandlerGameScreen extends KeyboardListener{

    @Override
    public void Typed(KeyEvent e) {
    }

    @Override
    public void Pressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (gameScreen.player.Route - 25 >= 0 && !gameScreen.useAbillity){
                    gameScreen.player.moveUp();
                }
                else{}
                break;
            case KeyEvent.VK_DOWN:
                if (gameScreen.player.Route + 25 < gameScreen.maxRectanglesDrawn && !gameScreen.useAbillity){
                    gameScreen.player.moveDown();
                }
                else{}
                break;
            case KeyEvent.VK_LEFT:
                if (gameScreen.player.Route - 1 >= 0 && (gameScreen.player.Route) / 25.0 % 1 != 0.0 && !gameScreen.useAbillity){
                    gameScreen.player.moveLeft();
                }
                else{}
                break;
            case KeyEvent.VK_RIGHT:
                if (gameScreen.player.Route + 1 < gameScreen.maxRectanglesDrawn && (gameScreen.player.Route + 1) / 25.0 % 1  != 0.0 && !gameScreen.useAbillity){
                    gameScreen.player.moveRight();
                }
                else{}
                break;
            case KeyEvent.VK_Q:
                if (gameScreen.activeSlot != 0)
                    gameScreen.activeSlot--;
                break;
            case KeyEvent.VK_E:
                if (gameScreen.activeSlot < gameScreen.bagSpace - 1)
                    gameScreen.activeSlot++;
                break;
            case KeyEvent.VK_W:
                gameScreen.useAbillity = !gameScreen.useAbillity;
                break;
        }

    }

    @Override
    public void Released(KeyEvent e) {

    }
}
