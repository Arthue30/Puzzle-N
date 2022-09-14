package puzzleN.interfaceGraf.jogo;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import puzzleN.funcoes.*;
import puzzleN.funcoes.botoes.*;
import puzzleN.funcoes.movimentos.*;

public class GUIJogoImagem extends GUIJogo{
    private int[] numerosRandom;//POSICAO DOS BOTOES
    private int[][] resposta;
    private JButton[][] botoes;
    Color fundo = new Color(253,184,39);
    JButton ajuda = new JButton("Ajuda");
    Font botaoImagem = new Font("", Font.BOLD,0);
    public GUIJogoImagem(Usuario player, JFrame mainFrame, JPanel painelMenu){
        super(player, mainFrame, painelMenu);
        super.getPlayer().setAjudaAtiva(false);

        this.numerosRandom= new int[super.getPlayer().getNivel()*super.getPlayer().getNivel()];
        this.resposta = new int[super.getPlayer().getNivel()][super.getPlayer().getNivel()];

        Processos processosPlayer = new Processos(super.getPlayer().getNivel());
        this.numerosRandom = processosPlayer.randomResolvivel();
        this.resposta = processosPlayer.gabarito();
    }
    public void parteCima(String nome, int mov) {
        super.parteCima(nome, mov);
    }

    public void parteBaixo() {
        super.parteBaixo();
        BotaoAjuda botaoAjuda = new BotaoAjuda(this.botoes,this.ajuda, super.getPlayer());
        ajuda.addActionListener(botaoAjuda);
        super.getPainelSul().add(ajuda);
        add(super.getPainelSul(),BorderLayout.SOUTH);
    }
    public void parteMeio() {
        JPanel meio = new JPanel(new GridLayout(super.getPlayer().getNivel(),super.getPlayer().getNivel()));
        meio.setBackground(fundo);
        meio.setBorder(new EmptyBorder(0,100,0,100));
        this.botoes = new JButton[super.getPlayer().getNivel()][super.getPlayer().getNivel()];
        int k = 0;
        MovJogo controles = new MovJogoImagem(this.botoes, this.resposta, super.getPlayer(), super.getTentativas(), super.getMainFrame(), super.getPainelMenu());
        for(int i = 0; i<botoes.length; i++) {
            for(int j = 0; j<botoes[i].length ;j++) {
                if(String.valueOf(numerosRandom[k]).equals("0")) {
                    botoes[i][j] = new JButton();
                    botoes[i][j].setBackground(fundo);
                    botoes[i][j].addActionListener(controles);
                    botoes[i][j].setFont(botaoImagem);
                    botoes[i][j].setForeground(Color.white);
                    botoes[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
                    botoes[i][j].setText(String.valueOf(numerosRandom[k]));
                    meio.add(botoes[i][j]);
                } else {
                    botoes[i][j] = new JButton();
                    botoes[i][j].addActionListener(controles);
                    botoes[i][j].setText(String.valueOf(numerosRandom[k]));
                    if (super.getPlayer().getNivel() == 2){
                        botoes[i][j].setIcon(new ImageIcon(getClass().getResource("/imagemFacil/"+(botoes[i][j].getText())+".png")));
                    }else if(super.getPlayer().getNivel() == 3){
                        botoes[i][j].setIcon(new ImageIcon(getClass().getResource("/imagemMedio/"+(botoes[i][j].getText())+".png")));
                    }else {
                        botoes[i][j].setIcon(new ImageIcon(getClass().getResource("/imagemDificil/"+(botoes[i][j].getText())+".png")));
                    }
                    botoes[i][j].setFont(botaoImagem);
                    botoes[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
                    botoes[i][j].setForeground(Color.white);
                    if(String.valueOf(resposta[i][j]).equals(botoes[i][j].getText())) {
                        botoes[i][j].setForeground(new Color(23, 197, 0));
                    }
                }
                k++;
                meio.add(botoes[i][j]);
            }
        }
        add(meio);
    }
}
