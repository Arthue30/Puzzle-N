package puzzleN.funcoes;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MovJogo implements ActionListener{

    private int tamanho;
    private JButton[][] botao;
    private int[][] gabarito;
    private Usuario player;
    private JLabel movimentos;
    Font fonteBotao = new Font("", Font.BOLD, 50);
    Font botaoBranco = new Font("", Font.BOLD,0);
    Color fundo = new Color(253,184,39);

    public MovJogo(int tamanho, JButton[][] botao, int[][] gabarito, Usuario player, JLabel movimentos) {
        this.tamanho = tamanho;
        this.botao = botao;
        this.gabarito = gabarito;
        this.player = player;
        this.movimentos = movimentos;
    }

    public void actionPerformed(ActionEvent e) {
        Processos processo = new Processos(this.tamanho);
        for(int i = 0; i<botao.length ;i++) { //nesses for daqui ele vai olhar cada botao pra saber qual foi apertado
            for(int j = 0; j<botao[i].length ;j++) {
                if(e.getSource()==botao[i][j]) {
                    if(i+1<tamanho && botao[i+1][j].getText().equals("-1")) { //nessas condicoes ele vai ver se o movimento é possivel para fazer ele
                        botao[i+1][j].setBackground(new Color(84,37,131));
                        botao[i+1][j].setFont(fonteBotao);
                        botao[i+1][j].setForeground(Color.white);
                        botao[i+1][j].setText(botao[i][j].getText());
                        botao[i][j].setBackground(fundo);
                        botao[i][j].setFont(botaoBranco);
                        botao[i][j].setText("-1");
                        player.setMovimento(player.getMovimento() + 1);
                        this.movimentos.setText("Movimentos: "+player.getMovimento());
                        if(processo.foiResolvido(botao)) {
                            JOptionPane.showMessageDialog(null, "PARABENS VOCE GANHOU!!!");

                        }
                    }else if(i-1>=0 && botao[i-1][j].getText().equals("-1")) {
                        botao[i-1][j].setBackground(new Color(84,37,131));
                        botao[i-1][j].setFont(fonteBotao);
                        botao[i-1][j].setForeground(Color.white);
                        botao[i-1][j].setText(botao[i][j].getText());
                        botao[i][j].setBackground(fundo);
                        botao[i][j].setFont(botaoBranco);
                        botao[i][j].setText("-1");
                        player.setMovimento(player.getMovimento() + 1);
                        this.movimentos.setText("Movimentos: "+player.getMovimento());
                        if(processo.foiResolvido(botao)) {
                            JOptionPane.showMessageDialog(null, "PARABENS VOCE GANHOU!!!");

                        }
                    }else if(j+1<tamanho && botao[i][j+1].getText().equals("-1")){
                        botao[i][j+1].setBackground(new Color(84,37,131));
                        botao[i][j+1].setFont(fonteBotao);
                        botao[i][j+1].setForeground(Color.white);
                        botao[i][j+1].setText(botao[i][j].getText());
                        botao[i][j].setBackground(fundo);
                        botao[i][j].setFont(botaoBranco);
                        botao[i][j].setText("-1");
                        player.setMovimento(player.getMovimento() + 1);
                        this.movimentos.setText("Movimentos: "+player.getMovimento());
                        if(processo.foiResolvido(botao)) {
                            JOptionPane.showMessageDialog(null, "PARABENS VOCE GANHOU!!!");

                        }
                    }else if(j-1>=0 && botao[i][j-1].getText().equals("-1")) {
                        botao[i][j-1].setBackground(new Color(84,37,131));
                        botao[i][j-1].setFont(fonteBotao);
                        botao[i][j-1].setForeground(Color.white);
                        botao[i][j-1].setText(botao[i][j].getText());
                        botao[i][j].setBackground(fundo);
                        botao[i][j].setFont(botaoBranco);
                        botao[i][j].setText("-1");
                        player.setMovimento(player.getMovimento() + 1);
                        this.movimentos.setText("Movimentos: "+player.getMovimento());
                        if(processo.foiResolvido(botao)) {
                            JOptionPane.showMessageDialog(null, "PARABENS VOCE GANHOU!!!");

                        }
                    }
                }
            }
        }
        for(int i=0; i<botao.length ;i++) { //Nessa parte aqui ele vai checar se o botao esta na casa certa pra mudar a cor dele
            for(int j=0; j<botao[i].length ; j++) {
                if(String.valueOf(gabarito[i][j]).equals(botao[i][j].getText())) {
                    if(botao[i][j].getText().equals("-1")) { //se o botão que esta na posição correta é o branco então não faz nada
                        continue;
                    }else {
                        botao[i][j].setBackground(new Color(153,50,204));
                    }
                }
            }
        }
    }
}