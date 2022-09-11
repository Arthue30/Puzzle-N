package puzzleN.interfaceGraf;

import puzzleN.funcoes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ganhou extends JPanel implements ActionListener {
    private Usuario player;
    private JFrame mainFrame;
    private JPanel painelMenu;

    JButton voltarMenu = new JButton("Voltar ao início");
    Color fundo = new Color(253,184,39);
    Font fonteT = new Font("", Font.BOLD,35);
    Font fonteTmenor = new Font("", Font.BOLD, 25);
    public Ganhou(JFrame mainMenu, JPanel painelMenu, Usuario player){
        this.mainFrame = mainMenu;
        this.painelMenu = painelMenu;
        this.player = player;

        setSize(500,430);
        setLayout(new BorderLayout());
        setVisible(true);
        painelCima();
        painelMeio();
        painelBaixo();
        painelLadoOeste();
        painelLadoLeste();
    }
    public void painelCima() {
        JPanel cima = new JPanel();
        cima.setLayout(new BoxLayout(cima, BoxLayout.PAGE_AXIS));
        cima.setBackground(fundo);
        cima.setPreferredSize(new Dimension(500, 80));

        JLabel parabens = new JLabel("Parabéns, " +player.getNome()+"!!!");
        parabens.setFont(fonteT);
        parabens.setForeground(new Color(54, 54, 54));
        parabens.setAlignmentX(CENTER_ALIGNMENT);

        cima.add(Box.createRigidArea(new Dimension(0,15)));
        cima.add(parabens);
        add(cima, BorderLayout.NORTH);
    }

    public void painelMeio(){
        JPanel meio = new JPanel();
        meio.setLayout(new BoxLayout(meio, BoxLayout.PAGE_AXIS));
        meio.setBackground(new Color(0, 0, 0));

        JLabel dificuldade = new JLabel("DIFICULDADE");
        dificuldade.setFont(fonteTmenor);
        dificuldade.setForeground(new Color(255, 255, 255));
        dificuldade.setAlignmentX(CENTER_ALIGNMENT);

        JLabel tempo = new JLabel("TEMPO");
        tempo.setFont(fonteTmenor);
        tempo.setForeground(new Color(255, 255, 255));
        tempo.setAlignmentX(CENTER_ALIGNMENT);

        JLabel movimentos = new JLabel(player.getMovimento()+ " movimentos");
        movimentos.setFont(fonteTmenor);
        movimentos.setForeground(new Color(255, 255, 255));
        movimentos.setAlignmentX(CENTER_ALIGNMENT);

        meio.add(Box.createRigidArea(new Dimension(0,45)));
        meio.add(dificuldade);
        meio.add(Box.createRigidArea(new Dimension(0,15)));
        meio.add(tempo);
        meio.add(Box.createRigidArea(new Dimension(0,15)));
        meio.add(movimentos);
        add(meio, BorderLayout.CENTER);
    }

    public void painelBaixo(){
        JPanel baixo = new JPanel();
        baixo.setLayout(new BoxLayout(baixo, BoxLayout.PAGE_AXIS));
        baixo.setBackground(fundo);
        baixo.setPreferredSize(new Dimension(500, 80));

        voltarMenu.setAlignmentX(CENTER_ALIGNMENT);
        voltarMenu.setMaximumSize(new Dimension(140,40));
        voltarMenu.addActionListener(this);

        baixo.add(Box.createRigidArea(new Dimension(0,15)));
        baixo.add(voltarMenu);
        add(baixo, BorderLayout.SOUTH);
    }
    public void painelLadoLeste(){
        JPanel lado = new JPanel();
        lado.setBackground(fundo);
        lado.setPreferredSize(new Dimension(100, 430));
        add(lado, BorderLayout.EAST);
    }
    public void painelLadoOeste(){
        JPanel lado = new JPanel();
        lado.setBackground(fundo);
        lado.setPreferredSize(new Dimension(100, 430));
        add(lado, BorderLayout.WEST);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == voltarMenu){
            mainFrame.setContentPane(painelMenu);
            painelMenu.revalidate();
        }
    }
}
