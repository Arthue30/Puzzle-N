package puzzleN.interfaceGraf.jogo;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import puzzleN.funcoes.*;
import puzzleN.funcoes.botoes.BotaoRecomecar;
import puzzleN.funcoes.movimentos.MovJogoNumero;

public class GUIJogoNumero extends GUIJogo{
    private int[] numerosRandom;//POSICAO DOS BOTOES
    private int[][] resposta;
    private JButton[][] botoes;
    Color fundo = new Color(253,184,39);
    JButton reset = new JButton("Recomeçar");
    Font fonteUsuario = new Font("", Font.BOLD, 30);
    Font fonteMovimentos = new Font("",Font.BOLD, 20);
    Font fonteBotao = new Font("", Font.BOLD, 50);
    Font botaoBranco = new Font("", Font.BOLD,0);

    public GUIJogoNumero(Usuario player, JFrame mainFrame, JPanel painelMenu){
        super(player, mainFrame, painelMenu);

        this.numerosRandom = new int[super.getPlayer().getNivel()*super.getPlayer().getNivel()];
        this.resposta = new int[super.getPlayer().getNivel()][super.getPlayer().getNivel()];

        Processos processosPlayer = new Processos(super.getPlayer().getNivel());
        this.numerosRandom = processosPlayer.randomResolvivel();
        this.resposta = processosPlayer.gabarito();
    }

    public void parteCima(String nome, int mov){
        super.parteCima(nome, mov);
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
        MovJogoNumero controles = new MovJogoNumero(this.botoes, this.resposta, super.getPlayer(), super.getTentativas(), super.getMainFrame(), super.getPainelMenu());
        for(int i = 0; i<botoes.length; i++) {
            for(int j = 0; j<botoes[i].length ;j++) {
                if(String.valueOf(numerosRandom[k]).equals("0")) {
                    botoes[i][j] = new JButton();
                    botoes[i][j].setBackground(fundo);
                    botoes[i][j].addActionListener(controles);
                    botoes[i][j].setFont(botaoBranco);
                    botoes[i][j].setText(String.valueOf(numerosRandom[k]));
                    meio.add(botoes[i][j]);
                } else {
                    botoes[i][j] = new JButton();
                    botoes[i][j].addActionListener(controles);
                    botoes[i][j].setBackground(new Color(84,37,131));
                    botoes[i][j].setFont(fonteBotao);
                    botoes[i][j].setForeground(Color.white);
                    botoes[i][j].setText(String.valueOf(numerosRandom[k]));
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