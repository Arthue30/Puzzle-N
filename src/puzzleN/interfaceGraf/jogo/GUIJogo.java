package puzzleN.interfaceGraf.jogo;
import javax.swing.*;

public abstract class GUIJogo extends JPanel {

    public abstract void parteCima(String nome, int mov);

    public abstract void parteBaixo();

    public abstract void parteMeio();
}
