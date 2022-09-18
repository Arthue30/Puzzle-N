package puzzleN.view.jogo;
import puzzleN.model.*;
import puzzleN.controller.botoes.BotaoRecomecar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class GUIJogo extends JPanel {
    private Usuario player;
    private Cronometro cronometro;
    private JFrame mainFrame;
    private JPanel painelMenu;
    private JLabel tentativas;
    private JLabel dificuldade;
    private JLabel puzzleMaluco;
    private JLabel tempo;
    private JPanel painelSul;
    JButton reset = new JButton("Recomeçar");
    Color fundo = new Color(253,184,39);
    Font fontePainel = new Font("", Font.BOLD, 15);

    public GUIJogo(Usuario player, JFrame mainFrame, JPanel painelMenu){
        this.player = player;
        this.mainFrame = mainFrame;
        this.painelMenu = painelMenu;
        this.player.setMovimento(0);
        if (this.player.getPuzzleNMaluco()){
            this.player.setRandomMaluco();
        }
        this.tempo = new JLabel();

        setLayout(new BorderLayout());
        setVisible(true);
    }
    public void parteCima(Usuario player){
        JPanel norte = new JPanel();
        norte.setBackground(fundo);
        norte.setBorder(new EmptyBorder(30,0,0,0));
        norte.setLayout(new FlowLayout());
        norte.setPreferredSize(new Dimension(700,100));
        JLabel usuario = new JLabel(player.getNome()+" |");
        if(this.player.getPuzzleNMaluco()){
            if (this.player.getRandomMaluco() <= 0.3){
                this.puzzleMaluco = new JLabel("Maluquice leve |");
            } else if ((this.player.getRandomMaluco() > 0.3) && (this.player.getRandomMaluco() <= 0.6)) {
                this.puzzleMaluco = new JLabel("Maluquice média |");
            } else if ((this.player.getRandomMaluco() > 0.6) && (this.player.getRandomMaluco() <= 0.9)){
                this.puzzleMaluco = new JLabel("Maluquice forte |");
            } else {
                this.puzzleMaluco = new JLabel("Maluquice EXTREMA |");
            }
        }
        if(this.player.getNivel()==2){
            this.dificuldade = new JLabel("Fácil |");
        } else if (player.getNivel()==3) {
            this.dificuldade = new JLabel("Médio |");
        } else if (player.getNivel()==4) {
            this.dificuldade = new JLabel("Difícil |");
        }
        this.tentativas = new JLabel("Movimentos: " +player.getMovimento()+" |");
        usuario.setFont(fontePainel);
        this.dificuldade.setFont(fontePainel);
        this.tentativas.setFont(fontePainel);
        this.tempo.setFont(fontePainel);
        this.tempo.setText("00:00:00:00");
        norte.add(usuario);
        if (this.player.getPuzzleNMaluco()){
            norte.add(this.puzzleMaluco);
            this.puzzleMaluco.setFont(fontePainel);
        }
        norte.add(this.dificuldade);
        norte.add(this.tentativas);
        norte.add(tempo);
        add(norte,BorderLayout.NORTH);
        this.cronometro = new Cronometro(this.player, this.tempo);
        this.cronometro.comecarCronometro();
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
    public Cronometro getCronometro(){
        return this.cronometro;
    }
    public JPanel getPainelSul(){
        return this.painelSul;
    }
}
