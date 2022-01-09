package com.aor.refactoring.example5;

public class CommandR extends Command {

    public CommandR(Position p) {
        super(p);
    }

    @Override
    public Position execute() {
        if (getPosition().getDirection() == 'N') getPosition().setDirection('E');
        else if (getPosition().getDirection() == 'E') getPosition().setDirection('S');
        else if (getPosition().getDirection() == 'S') getPosition().setDirection('W');
        else if (getPosition().getDirection() == 'W') getPosition().setDirection('N');
        return getPosition();
    }
}
