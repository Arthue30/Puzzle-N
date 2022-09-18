package puzzleN.controller.movimentos;

import puzzleN.model.Cronometro;
import puzzleN.model.Processos;
import puzzleN.model.Usuario;
import puzzleN.view.Ganhou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class MovJogoImagem extends MovJogo{
    private int[][] gabarito;
    private JLabel movimentos;
    private Cronometro cronometro;
    private JFrame mainFrame;
    private JPanel painelMenu;


    Font fonteBotao = new Font("", Font.BOLD, 50);
    Font botaoBranco = new Font("", Font.BOLD,0);
    Color fundo = new Color(253,184,39);
    public MovJogoImagem(JButton[][] botao, int[][] gabarito, Usuario player, JLabel movimentos, Cronometro cronometro, JFrame mainFrame, JPanel painelMenu) {
        super(player,botao);
        this.gabarito = gabarito;
        this.movimentos = movimentos;
        this.cronometro = cronometro;
        this.mainFrame = mainFrame;
        this.painelMenu = painelMenu;
    }
    public void actionPerformed(ActionEvent e) {
        Processos processo = new Processos(super.getPlayer().getNivel());
        for (int i = 0; i < super.getBotao().length; i++) { //nesses for daqui ele vai olhar cada botao pra saber qual foi apertado
            for (int j = 0; j < super.getBotao()[i].length; j++) {
                if (e.getSource() == super.getBotao()[i][j]) {
                    if (((i + 1 == super.getIBotao() && j == super.getJBotao()) || (i - 1 == super.getIBotao() && j == super.getJBotao()) || (i == super.getIBotao() && j + 1 == super.getJBotao()) || (i == super.getIBotao() && j - 1 == super.getJBotao()))) { //ele checa se o botao realmente esta na posicao certa para fazer o movimento
                        misturarBotoesMaluco();
                        super.getBotao()[super.getIBotao()][super.getJBotao()].setIcon(getBotao()[i][j].getIcon());
                        super.getBotao()[super.getIBotao()][super.getJBotao()].setForeground(Color.white);
                        if(super.getPlayer().getAjudaAtiva()){
                            super.getBotao()[super.getIBotao()][super.getJBotao()].setFont(fonteBotao);
                        }
                        super.getBotao()[super.getIBotao()][super.getJBotao()].setText(super.getBotao()[i][j].getText());
                        super.getBotao()[i][j].setIcon(null);
                        super.getBotao()[i][j].setBackground(fundo);
                        super.getBotao()[i][j].setFont(botaoBranco);
                        super.getBotao()[i][j].setText("0");
                        super.getPlayer().setMovimento(super.getPlayer().getMovimento() + 1);
                        this.movimentos.setText("Movimentos: " + super.getPlayer().getMovimento()+ " |");
                        if (processo.foiResolvido(super.getBotao())) {
                            this.cronometro.pararCronometro();
                            mainFrame.setSize(500, 430);
                            mainFrame.setLocationRelativeTo(null);
                            Ganhou telaGanhou = new Ganhou(this.mainFrame, this.painelMenu, super.getPlayer());
                            mainFrame.setContentPane(telaGanhou);
                            telaGanhou.revalidate();
                        }
                    }
                }
            }
        }
        for(int i=0; i<super.getBotao().length ;i++) { //caso o botao estiver na posicao certa ele troca de cor
            for(int j=0; j<super.getBotao()[i].length ; j++) {
                if(String.valueOf(gabarito[i][j]).equals(super.getBotao()[i][j].getText())) {
                    if(super.getBotao()[i][j].getText().equals("0")) { //se o botão que esta na posição correta é o branco então não faz nada
                        continue;
                    }else {
                        super.getBotao()[i][j].setForeground(new Color(23,197,0));
                    }
                }
            }
        }
    }
    public void misturarBotoesMaluco(){
        if (super.getPlayer().getPuzzleNMaluco()){
            if ((new Random().nextInt(100) + 1) <= super.getPlayer().getRandomMaluco()*100){
                Random random = new Random();
                int posicaoI1 = getIBotao();
                int posicaoJ1 = getJBotao();
                int posicaoI2 = getIBotao();
                int posicaoJ2 = getJBotao();
                while ((posicaoI1 == getIBotao()) && (posicaoJ1 == getJBotao()) && (posicaoI2 == getIBotao()) && (posicaoJ2 == getJBotao()) && (posicaoI1 == posicaoI2) && (posicaoJ1 == posicaoJ2)){
                    posicaoI1 = random.nextInt(getPlayer().getNivel());
                    posicaoJ1 = random.nextInt(getPlayer().getNivel());
                    posicaoI2 = random.nextInt(getPlayer().getNivel());
                    posicaoJ2 = random.nextInt(getPlayer().getNivel());
                }
                JButton temp = new JButton(super.getBotao()[posicaoI1][posicaoJ1].getText());
                temp.setIcon(super.getBotao()[posicaoI1][posicaoJ1].getIcon());
                super.getBotao()[posicaoI1][posicaoJ1].setText(super.getBotao()[posicaoI2][posicaoJ2].getText());
                super.getBotao()[posicaoI1][posicaoJ1].setIcon(super.getBotao()[posicaoI2][posicaoJ2].getIcon());
                super.getBotao()[posicaoI2][posicaoJ2].setText(temp.getText());
                super.getBotao()[posicaoI2][posicaoJ2].setIcon(temp.getIcon());
                super.getBotao()[posicaoI1][posicaoJ1].setFont(botaoBranco);
                super.getBotao()[posicaoI1][posicaoJ1].setForeground(Color.white);
                super.getBotao()[posicaoI2][posicaoJ2].setFont(botaoBranco);
                super.getBotao()[posicaoI2][posicaoJ2].setForeground(Color.white);
                if (super.getPlayer().getAjudaAtiva()){
                    super.getBotao()[posicaoI1][posicaoJ1].setFont(fonteBotao);
                    super.getBotao()[posicaoI2][posicaoJ2].setFont(fonteBotao);
                }
            }
        }
    }
}
