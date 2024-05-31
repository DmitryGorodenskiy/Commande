package gorodenskiy.commande.listcommands;

import gorodenskiy.commande.baseclasses.Light;
import gorodenskiy.commande.interfaces.ICommand;

public class KitchenLightOffCommand implements ICommand {
    private Light light;
    public KitchenLightOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }
}