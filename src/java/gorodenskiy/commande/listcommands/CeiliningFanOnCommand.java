package gorodenskiy.commande.listcommands;

import gorodenskiy.commande.baseclasses.CeilingFan;
import gorodenskiy.commande.interfaces.ICommand;

public class CeiliningFanOnCommand implements ICommand {
    private CeilingFan ceilingFan;

    public CeiliningFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }
}