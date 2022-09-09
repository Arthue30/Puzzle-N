package puzzleN;

import puzzleN.funcoes.*;
import puzzleN.interfaceGraf.Menu;

public class JogoMain {
    public static void main(String[] args) {
        Usuario player = new Usuario();
        Menu novoJogo = new Menu(player);
    }
}
