package puzzleN.view;
import javax.swing.*;
import puzzleN.model.*;

import java.awt.event.*;
import java.awt.*;

public class Menu extends JFrame implements ActionListener{
    Color fundo = new Color(253,184,39);
    Font fonteT = new Font("", Font.BOLD,60);
    JButton iniciar = new JButton("Início");
    JButton ranking = new JButton("Ranking");
    JButton sair = new JButton("Sair");
    JPanel menu = new JPanel();
    private Usuario player;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==iniciar) {
            int n = JOptionPane.showConfirmDialog(null, "Gostaria de jogar o modo 'puzzle-N maluco'?", "MALUQUICE", JOptionPane.YES_NO_OPTION);
            if (n==0){
                setTitle("O PATRÃO FICOU MALUCO");
                player.setPuzzleNMaluco(true);
                Dificuldade dificuldade = new Dificuldade(player,this, menu);
                setContentPane(dificuldade);
                dificuldade.revalidate();
            }if (n==1){
                player.setPuzzleNMaluco(false);
                Dificuldade dificuldade = new Dificuldade(player,this, menu);
                setContentPane(dificuldade);
                dificuldade.revalidate();
            }
        }else if(e.getSource()==sair) {
            System.exit(0);
        }
    }

    public Menu(){
        this.player = new Usuario();
        setTitle("Puzzle-N");
        setSize(500,430);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);
        painelMenu();
    }

    public void painelMenu() {
        menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
        menu.setBackground(fundo);
        menu.setPreferredSize(new Dimension(500,430));

        JLabel tituloJogo = new JLabel("PUZZLE-N");
        tituloJogo.setFont(fonteT);
        tituloJogo.setForeground(new Color(54,54,54));
        tituloJogo.setAlignmentX(CENTER_ALIGNMENT);

        iniciar.setAlignmentX(CENTER_ALIGNMENT);
        iniciar.setFont(new Font("",Font.BOLD, 20));
        iniciar.setMaximumSize(new Dimension(115,40));
        iniciar.addActionListener(this);

        ranking.setAlignmentX(CENTER_ALIGNMENT);
        ranking.setMaximumSize(new Dimension(100,40));

        sair.setAlignmentX(CENTER_ALIGNMENT);
        sair.setMaximumSize(new Dimension(100,40));
        sair.addActionListener(this);

        menu.add(Box.createRigidArea(new Dimension(0,10)));
        menu.add(tituloJogo);
        menu.add(Box.createRigidArea(new Dimension(0,50)));
        menu.add(iniciar);
        menu.add(Box.createRigidArea(new Dimension(0,10)));
        menu.add(ranking);
        menu.add(Box.createRigidArea(new Dimension(0,10)));
        menu.add(sair);

        add(menu, BorderLayout.CENTER);
    }
}