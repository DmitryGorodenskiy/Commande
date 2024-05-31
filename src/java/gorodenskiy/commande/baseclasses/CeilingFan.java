package gorodenskiy.commande.baseclasses;

import gorodenskiy.commande.graphics.Pult;

public class CeilingFan {
    private Pult pult;
    private String inRoom;
    public CeilingFan(String inRoom, Pult pult) {
        this.inRoom = inRoom;
        this.pult = pult;
    }
    public void on() {
        pult.setTextOut("Потолочный вентилятор " + inRoom + " включен");
    }
    public void off() {
        pult.setTextOut("Потолочный вентилятор " + inRoom + " выключен");
    }
    public void setQualityHight(){
        pult.setTextOut("Установлено высокое качество обслуживания");
    }
    public void setQualityLow() {
        pult.setTextOut("Установлено низкое качество обслуживания");
    }
}
