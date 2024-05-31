package gorodenskiy.commande.listcommands;

import gorodenskiy.commande.baseclasses.Light;
import gorodenskiy.commande.interfaces.ICommand;


public class KitchenLightOnCommand implements ICommand {
    private Light light;
    public KitchenLightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }
}