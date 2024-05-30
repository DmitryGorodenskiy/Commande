package gorodenskiy.commande.listcommands;

import gorodenskiy.commande.baseclasses.Light;
import gorodenskiy.commande.interfaces.ICommand;

public class LivingRoomLightOffCommand implements ICommand {
    private Light light;
    public LivingRoomLightOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }
}