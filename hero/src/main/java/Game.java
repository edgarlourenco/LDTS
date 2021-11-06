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
    private Arena arena;

    private TerminalSize size = new TerminalSize(40, 20);

    public Game() {

        arena = new Arena(size.getColumns(), size.getRows());

        try {
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(size).createTerminal();
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
                else if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') this.screen.close();
                else this.arena.processKey(keyStroke);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void draw() {
        this.screen.clear();
        this.arena.draw(this.screen.newTextGraphics());
        try {
            this.screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
