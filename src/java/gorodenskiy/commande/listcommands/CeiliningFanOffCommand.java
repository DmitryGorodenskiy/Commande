package gorodenskiy.commande.listcommands;

import gorodenskiy.commande.baseclasses.CeilingFan;
import gorodenskiy.commande.interfaces.ICommand;

public class CeiliningFanOffCommand implements ICommand {
    private CeilingFan ceilingFan;

    public CeiliningFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }
}