import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {

    private Position pos;

    public Element(int x, int y) {
        this.pos = new Position(x, y);
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }

    public abstract void draw(TextGraphics graphics);

}
