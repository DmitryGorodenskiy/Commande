package gorodenskiy.commande.graphics;

public class PrinterController implements IPrinter {
    private final IPrinter printer;

    public PrinterController(IPrinter printer) {this.printer = printer;}
    @Override
    public void print(String message) {printer.print(message); }
}