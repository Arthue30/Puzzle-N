package puzzleN.view.jogo;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import puzzleN.model.*;
import puzzleN.controller.movimentos.*;

public class GUIJogoCaractere extends GUIJogo{

    private char[] charRandom;//POSICAO DOS BOTOES
    private char[][] resposta;
    private JButton[][] botoes;


    Color fundo = new Color(253,184,39);
    Font fonteBotao = new Font("", Font.BOLD, 50);
    Font botaoBranco = new Font("", Font.BOLD,0);

    public GUIJogoCaractere(Usuario player, JFrame mainFrame, JPanel painelMenu){
        super(player, mainFrame, painelMenu);

        this.charRandom= new char[super.getPlayer().getNivel()*super.getPlayer().getNivel()];
        this.resposta = new char[super.getPlayer().getNivel()][super.getPlayer().getNivel()];

        Processos processosPlayer = new Processos(super.getPlayer().getNivel());
        this.charRandom = processosPlayer.randomResolvivelChar();
        this.resposta = processosPlayer.gabaritoChar();
    }
    public void parteCima(Usuario player) {
        super.parteCima(player);
    }
    public void parteBaixo() {
        super.parteBaixo();
    }

    public void parteMeio() {
        JPanel meio = new JPanel(new GridLayout(super.getPlayer().getNivel(),super.getPlayer().getNivel()));
        meio.setBackground(fundo);
        meio.setBorder(new EmptyBorder(0,100,0,100));
        this.botoes = new JButton[super.getPlayer().getNivel()][super.getPlayer().getNivel()];
        int k = 0;
        MovJogoCaractere controles = new MovJogoCaractere(this.botoes, this.resposta, super.getPlayer(), super.getTentativas(), super.getCronometro(), super.getMainFrame(), super.getPainelMenu());
        for(int i = 0; i<botoes.length; i++) {
            for(int j = 0; j<botoes[i].length ;j++) {
                if(String.valueOf(charRandom[k]).equals("0")) {
                    botoes[i][j] = new JButton();
                    botoes[i][j].setBackground(fundo);
                    botoes[i][j].addActionListener(controles);
                    botoes[i][j].setFont(botaoBranco);
                    botoes[i][j].setText(String.valueOf(charRandom[k]));
                    meio.add(botoes[i][j]);
                } else {
                    botoes[i][j] = new JButton();
                    botoes[i][j].addActionListener(controles);
                    botoes[i][j].setBackground(new Color(84,37,131));
                    botoes[i][j].setFont(fonteBotao);
                    botoes[i][j].setForeground(Color.white);
                    botoes[i][j].setText(String.valueOf(charRandom[k]));
                    if(String.valueOf(resposta[i][j]).equals(botoes[i][j].getText())) {
                        botoes[i][j].setBackground(new Color(153,50,204));
                    }
                }
                k++;
                meio.add(botoes[i][j]);
            }
        }
        add(meio);
    }
}
