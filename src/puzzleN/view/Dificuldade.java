package puzzleN.view;

import puzzleN.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dificuldade extends JPanel implements ActionListener {

    private JFrame mainFrame;
    private JPanel painelMenu;
    private Usuario player;
    Color fundo = new Color(253,184,39);
    Font fonteT = new Font("", Font.BOLD,35);

    JButton facil = new JButton("Fácil");
    JButton medio = new JButton("Médio");
    JButton dificil = new JButton("Dificil");
    JButton voltar = new JButton("Voltar");

    public Dificuldade(Usuario player, JFrame mainFrame, JPanel painelMenu){
        this.player = player;
        this.mainFrame = mainFrame;
        this.painelMenu = painelMenu;

        setSize(500,430);
        setLayout(new BorderLayout());
        setVisible(true);
        painelDificuldade();
    }

    public void painelDificuldade(){
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBackground(fundo);
        JLabel titulo = new JLabel("Escolha a dificuldade");
        titulo.setFont(fonteT);

        titulo.setAlignmentX(CENTER_ALIGNMENT);
        facil.setAlignmentX(CENTER_ALIGNMENT);
        medio.setAlignmentX(CENTER_ALIGNMENT);
        dificil.setAlignmentX(CENTER_ALIGNMENT);
        voltar.setAlignmentX(CENTER_ALIGNMENT);

        facil.setMaximumSize(new Dimension(150,60));
        medio.setMaximumSize(new Dimension(150,60));
        dificil.setMaximumSize(new Dimension(150,60));
        voltar.setMaximumSize(new Dimension(100,40));

        painel.add(Box.createRigidArea(new Dimension(0,10)));
        painel.add(titulo);
        painel.add(Box.createRigidArea(new Dimension(0,30)));
        facil.addActionListener(this);
        painel.add(facil);
        painel.add(Box.createRigidArea(new Dimension(0,10)));
        medio.addActionListener(this);
        painel.add(medio);
        painel.add(Box.createRigidArea(new Dimension(0,10)));
        dificil.addActionListener(this);
        painel.add(dificil);
        painel.add(Box.createRigidArea(new Dimension(0,20)));
        voltar.addActionListener(this);
        painel.add(voltar);

        add(painel, BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==facil){
            player.setNivel(2);
            TipoJogo tipoJogo = new TipoJogo(player, mainFrame, painelMenu, this);
            mainFrame.setContentPane(tipoJogo);
            tipoJogo.revalidate();
        }else if (e.getSource()==medio){
            player.setNivel(3);
            TipoJogo tipoJogo = new TipoJogo(player, mainFrame, painelMenu, this);
            mainFrame.setContentPane(tipoJogo);
            tipoJogo.revalidate();
        }else if(e.getSource()==dificil){
            player.setNivel(4);
            TipoJogo tipoJogo = new TipoJogo(player, mainFrame, painelMenu, this);
            mainFrame.setContentPane(tipoJogo);
            tipoJogo.revalidate();
        }else {
            mainFrame.setContentPane(painelMenu);
            painelMenu.revalidate();
        }
    }
}
