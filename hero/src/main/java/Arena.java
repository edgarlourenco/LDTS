import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {

    private int width, height;
    private Hero hero;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;

        this.hero = new Hero(10, 10);
        this.walls = this.createWalls();
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowDown:
                this.moveHero(this.hero.moveDown());
                break;
            case ArrowUp:
                this.moveHero(this.hero.moveUp());
                break;
            case ArrowLeft:
                this.moveHero(this.hero.moveLeft());
                break;
            case ArrowRight:
                this.moveHero(this.hero.moveRight());
                break;
            default:
                break;
        }

        System.out.println(key);
    }

    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (Wall wall : this.walls)
            wall.draw(graphics);

        this.hero.draw(graphics);
    }

    public boolean canHeroMove(Position pos) {
        for (Wall wall : this.walls)
            if (pos.equals(wall.getPos())) return false;

        return (0 <= pos.getX() && pos.getX() < this.width) && (0 <= pos.getY() && pos.getY() < this.height);
    }

    public void moveHero(Position newPos) {
        if (this.canHeroMove(newPos))
            this.hero.setPos(newPos);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
}
