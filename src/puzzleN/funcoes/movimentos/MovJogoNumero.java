package puzzleN.funcoes.movimentos;

import puzzleN.funcoes.Processos;
import puzzleN.funcoes.Usuario;
import puzzleN.interfaceGraf.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MovJogoNumero extends MovJogo{
    private int[][] gabarito;
    private Usuario player;
    private JLabel movimentos;
    private JFrame mainFrame;
    private JPanel painelMenu;

    Font fonteBotao = new Font("", Font.BOLD, 50);
    Font botaoBranco = new Font("", Font.BOLD,0);
    Color fundo = new Color(253,184,39);

    public MovJogoNumero(int tamanho, JButton[][] botao, int[][] gabarito, Usuario player, JLabel movimentos, JFrame mainFrame, JPanel painelMenu) {
        super(tamanho,botao);
        this.gabarito = gabarito;
        this.player = player;
        this.movimentos = movimentos;
        this.mainFrame = mainFrame;
        this.painelMenu = painelMenu;
    }
    public void actionPerformed(ActionEvent e) {
        Processos processo = new Processos(super.getTamanho());
        for(int i = 0; i<getBotao().length ;i++) { //nesses for daqui ele vai olhar cada botao pra saber qual foi apertado
            for(int j = 0; j<getBotao()[i].length ;j++) {
                if(e.getSource()==getBotao()[i][j]) {
                    if(((i+1 == super.getIBotao() && j == super.getJBotao()) || (i-1 == super.getIBotao() && j == super.getJBotao()) || (i == super.getIBotao() && j+1 == super.getJBotao()) || (i == super.getIBotao() && j-1 == super.getJBotao()))) { //ele checa se o botao realmente esta na posicao certa para fazer o movimento
                        getBotao()[super.getIBotao()][super.getJBotao()].setBackground(new Color(84,37,131));
                        getBotao()[super.getIBotao()][super.getJBotao()].setFont(fonteBotao);
                        getBotao()[super.getIBotao()][super.getJBotao()].setForeground(Color.white);
                        getBotao()[super.getIBotao()][super.getJBotao()].setText(getBotao()[i][j].getText());
                        getBotao()[i][j].setBackground(fundo);
                        getBotao()[i][j].setFont(botaoBranco);
                        getBotao()[i][j].setText("0");
                        player.setMovimento(player.getMovimento() + 1);
                        this.movimentos.setText("Movimentos: "+player.getMovimento());
                        if(processo.foiResolvido(getBotao())) {
                            mainFrame.setSize(500,430);
                            mainFrame.setLocationRelativeTo(null);
                            Ganhou telaGanhou = new Ganhou(this.mainFrame, this.painelMenu, this.player );
                            mainFrame.setContentPane(telaGanhou);
                            telaGanhou.revalidate();
                        }
                    }
                }
            }
        }
        for(int i=0; i<getBotao().length ;i++) { //caso o botao estiver na posicao certa ele troca de cor
            for(int j=0; j<getBotao()[i].length ; j++) {
                if(String.valueOf(gabarito[i][j]).equals(getBotao()[i][j].getText())) {
                    if(getBotao()[i][j].getText().equals("0")) { //se o botão que esta na posição correta é o branco então não faz nada
                        continue;
                    }else {
                        getBotao()[i][j].setBackground(new Color(153,50,204));
                    }
                }
            }
        }
    }
}