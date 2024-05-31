package gorodenskiy.commande;

import gorodenskiy.commande.interfaces.ICommand;
import gorodenskiy.commande.listcommands.NoCommand;

public class RemoteControl {
    private ICommand[] onCommands;
    private ICommand[] offCommands;

    public RemoteControl() {
        onCommands = new ICommand[Supervisor.buttonsCount];
        offCommands = new ICommand[Supervisor.buttonsCount];
        ICommand noCommand = new NoCommand();
        for (int i = 0; i < Supervisor.buttonsCount; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, ICommand onCommand, ICommand offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    public String toString(String message) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n-----RemoteControl-----" + message + "\n");
        for (int i = 0; i < offCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();
    }
}
