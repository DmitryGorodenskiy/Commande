package gorodenskiy.commande;

import gorodenskiy.commande.graphics.Pult;

public class Supervisor {
    private String[] textFieldStrings = new String[] {"Свет в доме", "Гараж", "Подвал", "Парковка", "Мастерская", "Теплица 1", "Теплица 2"};
    private int buttonsCount = 9;
    public void start() {
        Pult pult = new Pult(textFieldStrings, buttonsCount);
        pult.setTextOut("Проба\nПривет\nМир!");
        pult.myCreateAndShowAPI(pult);
    }
}