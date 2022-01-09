package com.aor.refactoring.example5;

public class CommandL extends Command {

    public CommandL(Position p) {
        super(p);
    }

    @Override
    public Position execute() {
        if (getPosition().getDirection() == 'N') getPosition().setDirection('W');
        else if (getPosition().getDirection() == 'W') getPosition().setDirection('S');
        else if (getPosition().getDirection() == 'S') getPosition().setDirection('E');
        else if (getPosition().getDirection() == 'E') getPosition().setDirection('N');
        return getPosition();
    }

}
