package gorodenskiy.commande.listcommands;

import gorodenskiy.commande.baseclasses.GarageDoor;
import gorodenskiy.commande.interfaces.ICommand;

public class GarageDoorCloseCommand implements ICommand {
    private GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.donw();
    }
}