package puzzleN.interfaceGraf;
import javax.swing.*;
import puzzleN.funcoes.*;

import java.awt.event.*;
import java.awt.*;

public class Menu extends JFrame implements ActionListener{
    Color fundo = new Color(253,184,39);
    Font fonteT = new Font("", Font.BOLD,60);
    JButton iniciar = new JButton("Início");
    JButton puzzleNMaluco = new JButton("Maluco");
    JButton dificuldade = new JButton("Dificuldade");
    JButton ranking = new JButton("Ranking");
    JButton sair = new JButton("Sair");
    JPanel menu = new JPanel();
    private Usuario player;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==iniciar) {
            TipoJogo tipoJogo = new TipoJogo(menu, this, player);
            setContentPane(tipoJogo);
            tipoJogo.revalidate();
        }else if(e.getSource()==sair) {
            System.exit(0);
        }
    }

    public Menu(Usuario player){
        this.player = player;
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

        puzzleNMaluco.setAlignmentX(CENTER_ALIGNMENT);
        puzzleNMaluco.setMaximumSize(new Dimension(100,40));

        dificuldade.setAlignmentX(CENTER_ALIGNMENT);
        dificuldade.setMaximumSize(new Dimension(100,40));

        ranking.setAlignmentX(CENTER_ALIGNMENT);
        ranking.setMaximumSize(new Dimension(100,40));

        sair.setAlignmentX(CENTER_ALIGNMENT);
        sair.setMaximumSize(new Dimension(100,40));
        sair.addActionListener(this);

        menu.add(Box.createRigidArea(new Dimension(0,10)));
        menu.add(tituloJogo);
        menu.add(Box.createRigidArea(new Dimension(0,20)));
        menu.add(iniciar);
        menu.add(Box.createRigidArea(new Dimension(0,10)));
        menu.add(puzzleNMaluco);
        menu.add(Box.createRigidArea(new Dimension(0,10)));
        menu.add(dificuldade);
        menu.add(Box.createRigidArea(new Dimension(0,10)));
        menu.add(ranking);
        menu.add(Box.createRigidArea(new Dimension(0,10)));
        menu.add(sair);

        add(menu, BorderLayout.CENTER);
    }
}