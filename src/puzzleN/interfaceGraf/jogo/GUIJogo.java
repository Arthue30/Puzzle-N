package puzzleN.interfaceGraf.jogo;
import puzzleN.funcoes.*;
import puzzleN.funcoes.botoes.BotaoRecomecar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class GUIJogo extends JPanel {
    private Usuario player;
    private JFrame mainFrame;
    private JPanel painelMenu;
    private JLabel tentativas;
    private JPanel painelSul;
    JButton reset = new JButton("Recomeçar");
    Color fundo = new Color(253,184,39);
    Font fonteUsuario = new Font("", Font.BOLD, 30);
    Font fonteMovimentos = new Font("",Font.BOLD, 20);

    public GUIJogo(Usuario player, JFrame mainFrame, JPanel painelMenu){
        this.player = player;
        this.mainFrame = mainFrame;
        this.painelMenu = painelMenu;
        this.player.setMovimento(0);

        setLayout(new BorderLayout());
        setVisible(true);
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

    public void parteBaixo(){
        this.painelSul = new JPanel(new FlowLayout());
        this.painelSul.setPreferredSize(new Dimension(700,100));
        this.painelSul.setBackground(fundo);
        BotaoRecomecar botaoRecomecar = new BotaoRecomecar(reset, mainFrame, this.painelMenu, player);
        reset.addActionListener(botaoRecomecar);
        this.painelSul.add(reset);
        add(this.painelSul,BorderLayout.SOUTH);
    }

    public abstract void parteMeio();

    public Usuario getPlayer(){
        return this.player;
    }
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
    public JPanel getPainelMenu(){
        return this.painelMenu;
    }

    public JLabel getTentativas(){
        return this.tentativas;
    }
    public JPanel getPainelSul(){
        return this.painelSul;
    }
}
