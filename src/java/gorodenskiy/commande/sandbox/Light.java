package gorodenskiy.commande.sandbox;

import gorodenskiy.commande.graphics.Pult;

public class Light {
    private Pult pult;
    public Light(Pult pult) {
        this.pult = pult;
    }
    public void on(){
        pult.setTextOut("Свет включен");
    }
    public void off() {
        pult.setTextOut("Свет выключен");
    }
}