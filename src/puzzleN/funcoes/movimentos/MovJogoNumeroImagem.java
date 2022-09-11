package puzzleN.funcoes.movimentos;

import puzzleN.funcoes.Usuario;

import javax.swing.*;

public class MovJogoNumeroImagem extends MovJogoNumero {
    public MovJogoNumeroImagem(int tamanho, JButton[][] botao, int[][] gabarito, Usuario player, JLabel movimentos, JFrame mainFrame, JPanel painelMenu) {
        super(tamanho, botao, gabarito, player, movimentos, mainFrame, painelMenu);
    }
}
