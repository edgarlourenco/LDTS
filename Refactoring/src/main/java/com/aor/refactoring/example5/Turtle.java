package com.aor.refactoring.example5;

public class Turtle {
    Position p;

    public Turtle(int row, int column, char direction) {
        this.p = new Position(row, column, direction);
    }

    public int getRow() {
        return p.getRow();
    }

    public int getColumn() {
        return p.getColumn();
    }

    public char getDirection() {
        return p.getDirection();
    }

    public void setRow(int row) {
        p.setRow(row);
    }

    public void setColumn(int column) {
        p.setColumn(column);
    }

    public void setDirection(char direction) {
        p.setDirection(direction);
    }

    public void setP(Position p) {
        this.p = p;
    }

    public void execute(char command) {
        if (command == 'L') { // ROTATE LEFT
            setP(new CommandL(p).execute());
        } else if (command == 'R') { // ROTATE RIGHT
            setP(new CommandR(p).execute());
        } else if (command == 'F'){ // MOVE FORWARD
            setP(new CommandF(p).execute());
        }
    }
}
