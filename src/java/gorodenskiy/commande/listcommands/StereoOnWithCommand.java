package gorodenskiy.commande.listcommands;

import gorodenskiy.commande.baseclasses.Stereo;
import gorodenskiy.commande.interfaces.ICommand;

public class StereoOnWithCommand implements ICommand {
    private Stereo stereo;

    public StereoOnWithCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolime("11");
    }
}