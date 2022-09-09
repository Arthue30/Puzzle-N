package puzzleN.interfaceGraf.jogo;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import puzzleN.funcoes.*;
import puzzleN.funcoes.botoes.BotaoRecomecar;

public class GUIJogoNumero extends JPanel{

    private int tamanho = 3;//2 ou 3 ou 4(quando tiver dificuldade será setado lá)
    private int[] numerosRandom;//POSICAO DOS BOTOES
    private int[][] resposta;
    private JButton[][] botoes;
    private JFrame mainFrame;
    private Usuario player;
    private JLabel tentativas;

    Color fundo = new Color(253,184,39);
    JButton reset = new JButton("Recomeçar");
    JButton ajuda = new JButton("Ajuda");
    Font fonteUsuario = new Font("", Font.BOLD, 30);
    Font fonteMovimentos = new Font("",Font.BOLD, 20);
    Font fonteBotao = new Font("", Font.BOLD, 50);
    Font botaoBranco = new Font("", Font.BOLD,0);

    public GUIJogoNumero(Usuario player, JFrame mainFrame){

        this.numerosRandom= new int[tamanho*tamanho];
        this.resposta = new int[tamanho][tamanho];

        this.player = player;
        player.setMovimento(0);
        this.mainFrame = mainFrame;

        Processos processosPlayer = new Processos(this.tamanho);
        this.numerosRandom = processosPlayer.randomResolvivel();
        this.resposta = processosPlayer.gabarito();

        setLayout(new BorderLayout());
        setVisible(true);
        parteCima(this.player.getNome(), player.getMovimento());
        parteMeio();
        parteBaixo();
    }

    public void parteCima(String nome, int mov){
        JPanel norte = new JPanel();
        norte.setBackground(fundo);
        norte.setBorder(new EmptyBorder(10,10,0,0));
        norte.setLayout(new BoxLayout(norte, BoxLayout.PAGE_AXIS));
        norte.setPreferredSize(new Dimension(700,100));
        JLabel usuario = new JLabel(nome);
        usuario.setFont(fonteUsuario);
        this.tentativas = new JLabel("Movimentos: " +mov);
        this.tentativas.setFont(fonteMovimentos);
        norte.add(usuario);
        norte.add(this.tentativas);
        add(norte,BorderLayout.NORTH);
    }

    public void parteBaixo() {
        JPanel sul = new JPanel(new FlowLayout());
        sul.setPreferredSize(new Dimension(700,100));
        sul.setBackground(fundo);
        BotaoRecomecar botaoRecomecar = new BotaoRecomecar(reset, mainFrame, player);
        reset.addActionListener(botaoRecomecar);
        sul.add(reset);
        sul.add(ajuda);
        add(sul,BorderLayout.SOUTH);
    }

    public void parteMeio() {
        JPanel meio = new JPanel(new GridLayout(this.tamanho,this.tamanho));
        meio.setBackground(fundo);
        meio.setBorder(new EmptyBorder(10,10,0,10));
        this.botoes = new JButton[tamanho][tamanho];
        int k = 0;
        MovJogo controles = new MovJogo(this.tamanho,this.botoes,this.resposta, this.player, this.tentativas);
        for(int i = 0; i<botoes.length; i++) {
            for(int j = 0; j<botoes[i].length ;j++) {
                if(String.valueOf(numerosRandom[k]).equals("-1")) {
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