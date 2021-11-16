import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {

    public Monster(int x, int y) {
        super(x,y);
    }

    public Position move() {
        Random random = new Random(System.nanoTime());

        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        return new Position(this.getPos().getX() + dx, this.getPos().getY() + dy);
    }

    @Override
    public void draw(TextGraphics graphics) {

        graphics.setForegroundColor(TextColor.Factory.fromString("red"));
        graphics.enableModifiers(SGR.BOLD);

        graphics.putString(new TerminalPosition(this.getPos().getX(), this.getPos().getY()), "M");

    }
}
