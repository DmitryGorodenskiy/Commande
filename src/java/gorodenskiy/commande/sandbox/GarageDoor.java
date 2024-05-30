package gorodenskiy.commande.sandbox;

import gorodenskiy.commande.graphics.Pult;

public class GarageDoor {
    private Pult pult;
    public GarageDoor(Pult pult){
        this.pult = pult;
    }
    public void up(){
        pult.setTextOut("Дверь открыта");
    }
    public void down(){
        pult.setTextOut("Дверь закрыта");
    }
    public void lightOn(){
        pult.setTextOut("Свет в гараже включен");
    }
    public void lightOff(){
        pult.setTextOut("Свет в гараже выключен");
    }
}
