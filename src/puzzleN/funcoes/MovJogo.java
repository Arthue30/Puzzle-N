package puzzleN.funcoes;

import puzzleN.interfaceGraf.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MovJogo implements ActionListener{

    private int tamanho;
    private JButton[][] botao;
    private int[][] gabarito;
    private Usuario player;
    private JLabel movimentos;
    private JFrame mainFrame;
    private JPanel painelMenu;
    private int linhaBotaoBranco;
    private int colunaBotaoBranco;

    Font fonteBotao = new Font("", Font.BOLD, 50);
    Font botaoBranco = new Font("", Font.BOLD,0);
    Color fundo = new Color(253,184,39);

    public MovJogo(int tamanho, JButton[][] botao, int[][] gabarito, Usuario player, JLabel movimentos, JFrame mainFrame, JPanel painelMenu) {
        this.tamanho = tamanho;
        this.botao = botao;
        this.gabarito = gabarito;
        this.player = player;
        this.movimentos = movimentos;
        this.mainFrame = mainFrame;
        this.painelMenu = painelMenu;
    }

    public void linhaBotaoBranco(){
        for(int i = 0; i<this.tamanho ;i++){
            for(int j = 0; j<this.tamanho ;j++){
                if(botao[i][j].getText().equals("-1")){
                    this.linhaBotaoBranco = i;
                }
            }
        }
    }
    public void colunaBotaoBranco(){
        for(int i = 0; i<this.tamanho ;i++){
            for(int j = 0; j<this.tamanho ;j++){
                if(botao[i][j].getText().equals("-1")){
                    this.colunaBotaoBranco = j;
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        Processos processo = new Processos(this.tamanho);
        for(int i = 0; i<botao.length ;i++) { //nesses for daqui ele vai olhar cada botao pra saber qual foi apertado
            for(int j = 0; j<botao[i].length ;j++) {
                if(e.getSource()==botao[i][j]) {
                    linhaBotaoBranco();
                    colunaBotaoBranco();
                    if(((i+1 == this.linhaBotaoBranco && j == this.colunaBotaoBranco) || (i-1 == this.linhaBotaoBranco && j == this.colunaBotaoBranco) || (i == this.linhaBotaoBranco && j+1 == this.colunaBotaoBranco) || (i == this.linhaBotaoBranco && j-1 == this.colunaBotaoBranco))) { //ele checa se o botao realmente esta na posicao certa para fazer o movimento
                        botao[this.linhaBotaoBranco][this.colunaBotaoBranco].setBackground(new Color(84,37,131));
                        botao[this.linhaBotaoBranco][this.colunaBotaoBranco].setFont(fonteBotao);
                        botao[this.linhaBotaoBranco][this.colunaBotaoBranco].setForeground(Color.white);
                        botao[this.linhaBotaoBranco][this.colunaBotaoBranco].setText(botao[i][j].getText());
                        botao[i][j].setBackground(fundo);
                        botao[i][j].setFont(botaoBranco);
                        botao[i][j].setText("-1");
                        player.setMovimento(player.getMovimento() + 1);
                        this.movimentos.setText("Movimentos: "+player.getMovimento());
                        if(processo.foiResolvido(botao)) {
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
        for(int i=0; i<botao.length ;i++) { //nessa parte aqui ele vai checar se o botao esta na casa certa pra mudar a cor dele
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