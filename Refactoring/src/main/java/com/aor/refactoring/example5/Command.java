package com.aor.refactoring.example5;

public abstract class Command {
    Position position;

    public Command(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract Position execute();
}
