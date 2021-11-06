import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element{

    private Position pos;

    public int getX() {
        return this.getPos().getX();
    }

    public int getY() {
        return this.getPos().getY();
    }

    public void setX(int x) {
        this.getPos().setX(x);
    }

    public void setY(int y) {
        this.getPos().setY(y);
    }

    public Hero(int x, int y) {
        super(x, y);
    }

    public Position moveUp() {
        return new Position(this.getX(), this.getY() - 1);
    }

    public Position moveDown() {
        return new Position(this.getX(), this.getY() + 1);
    }

    public Position moveRight() {
        return new Position(this.getX() + 1, this.getY());
    }

    public Position moveLeft() {
        return new Position(this.getX() - 1, this.getY());
    }

    public void draw(TextGraphics graphics) {

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);

        graphics.putString(new TerminalPosition(this.getPos().getX(), this.getPos().getY()), "X");
    }
}
