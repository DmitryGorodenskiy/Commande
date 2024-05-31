package gorodenskiy.commande.listcommands;

import gorodenskiy.commande.baseclasses.GarageDoor;
import gorodenskiy.commande.interfaces.ICommand;

public class GarageDoorOpenCommand implements ICommand {
    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
