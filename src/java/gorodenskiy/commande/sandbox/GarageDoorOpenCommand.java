package gorodenskiy.commande.sandbox;

public class GarageDoorOpenCommand implements ICommand {
    private GarageDoor garageDoor;
    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }
    @Override
    public void execute(){
        garageDoor.up();
    }
}

