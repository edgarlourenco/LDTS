import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width, height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;

        this.hero = new Hero(10, 10);
        this.walls = this.createWalls();
        this.coins = this.createCoins();
        this.monsters = this.createMonsters();
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

        for (Coin coin : this.coins)
            coin.draw(graphics);

        this.moveMonsters();
        for (Monster monster : this.monsters)
            monster.draw(graphics);

        this.hero.draw(graphics);

        if (this.verifyMonsterCollisions()) {
            System.out.println("You Lose");
            System.exit(0);
        }
    }

    public boolean canHeroMove(Position pos) {
        for (Wall wall : this.walls)
            if (pos.equals(wall.getPos())) return false;

        return (0 <= pos.getX() && pos.getX() < this.width) && (0 <= pos.getY() && pos.getY() < this.height);
    }

    public void moveHero(Position newPos) {
        if (this.canHeroMove(newPos)) {

            this.retrieveCoins();

            for (Monster m : this.monsters)
                if (m.getPos().equals(newPos)) {
                    System.out.println("You lose");
                    System.exit(0);
                }

            this.hero.setPos(newPos);
        }
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

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(this.width - 2) + 1, random.nextInt(this.height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(this.width - 2) + 1, random.nextInt(this.height - 2) + 1));
        return monsters;
    }

    private void retrieveCoins(){
        for (Coin coin : this.coins) {
            if (coin.getPos().equals(this.hero.getPos())) {

                this.coins.remove(coin);

                break; // no 2 coins can be at the same place
            }
        }
    }

    private void moveMonsters() {
        for (Monster m : this.monsters) {
            Position newPos = m.move();
            if (0 < newPos.getX() && newPos.getX() < this.width-1 && 0 < newPos.getY() && newPos.getY() < this.height-1)
                m.setPos(newPos);
        }

    }

    private boolean verifyMonsterCollisions() {
        for (Monster m : this.monsters)
            if (m.getPos().equals(this.hero.getPos())) return true;

        return false;
    }
}
