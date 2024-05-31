package gorodenskiy.commande.baseclasses;

import gorodenskiy.commande.graphics.Pult;

public class GarageDoor {

    private Pult pult;

    public GarageDoor(String inRoom, Pult pult) {
        this.pult = pult;
    }

    public void up() {
        pult.setTextOut("Дверь открыта");
    }

    public void donw() {
        pult.setTextOut("Дверь закрыта");
    }

    public void light0n() {
        pult.setTextOut("Свет включен");
    }

    public void ligthOff() {
        pult.setTextOut("Свет выключен");
    }
}