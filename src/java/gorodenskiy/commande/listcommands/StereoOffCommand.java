package gorodenskiy.commande.listcommands;

import gorodenskiy.commande.baseclasses.Stereo;
import gorodenskiy.commande.interfaces.ICommand;

public class StereoOffCommand implements ICommand {
    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }
}