import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    Screen screen;
    private int x = 10, y = 10;

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(40, 20)).createTerminal();
            screen = new TerminalScreen(terminal);
            screen.startScreen();             // screens must be started
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            this.draw();
            try {
                KeyStroke keyStroke = this.screen.readInput();
                if (keyStroke.getKeyType() == KeyType.EOF) break;
                this.processKey(keyStroke);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void draw() {
        try {
            screen.clear();
            screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) {

        switch (key.getKeyType()) {
            case Character:
                switch (key.getCharacter()) {
                    case 'q':
                    case 'Q':
                        try {
                            this.screen.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                break;
            case ArrowDown:
                this.y++;
                break;
            case ArrowUp:
                this.y--;
                break;
            case ArrowLeft:
                this.x--;
                break;
            case ArrowRight:
                this.x++;
                break;
            default:
                break;
        }

        System.out.println(key);
    }
}
