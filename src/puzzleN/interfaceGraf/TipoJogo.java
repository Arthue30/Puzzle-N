package puzzleN.interfaceGraf;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import puzzleN.funcoes.Usuario;
import puzzleN.interfaceGraf.jogo.GUIJogoNumero;

public class TipoJogo extends JPanel implements ActionListener{

    Color fundo = new Color(253,184,39);
    Font fonteT = new Font("", Font.BOLD,35);
    JButton numero = new JButton("Números");
    JButton caracter = new JButton("Caracteres");
    JButton imagem = new JButton("Imagem");
    JButton voltar = new JButton("Voltar");

    private Usuario player;
    private JPanel painelMenu;
    private JFrame mainFrame;


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==numero) {
            this.player.setNome(JOptionPane.showInputDialog("Qual seu nome?"));
            mainFrame.setSize(700,700);
            mainFrame.setLocationRelativeTo(null);
            GUIJogoNumero numeroJogo = new GUIJogoNumero(player, this.mainFrame);
            mainFrame.setContentPane(numeroJogo);
            numeroJogo.revalidate();
        }else if(e.getSource()==voltar) {
            mainFrame.setContentPane(painelMenu);
            painelMenu.revalidate();
        }
    }

    public TipoJogo(JPanel painelMenu, JFrame frameMenu, Usuario player) {
        this.painelMenu = painelMenu;
        this.mainFrame = frameMenu;
        this.player = player;
        setSize(500,430);
        setLayout(new BorderLayout());
        setVisible(true);

        titulo();
        botoes();
    }

    public void titulo (){
        JPanel norte = new JPanel(new FlowLayout());
        norte.setPreferredSize(new Dimension(700,80));
        norte.setBackground(fundo);
        JLabel tituloJogo = new JLabel("Qual sua preferência?");
        tituloJogo.setFont(fonteT);
        tituloJogo.setForeground(new Color(54,54,54));
        norte.add(tituloJogo);
        add(norte,BorderLayout.NORTH);
    }

    public void botoes() {
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.PAGE_AXIS));
        centro.setBackground(fundo);
        numero.setAlignmentX(CENTER_ALIGNMENT);
        caracter.setAlignmentX(CENTER_ALIGNMENT);
        imagem.setAlignmentX(CENTER_ALIGNMENT);
        voltar.setAlignmentX(CENTER_ALIGNMENT);
        numero.setMaximumSize(new Dimension(150,60));
        caracter.setMaximumSize(new Dimension(150,60));
        imagem.setMaximumSize(new Dimension(150,60));
        voltar.setMaximumSize(new Dimension(100,40));
        numero.addActionListener(this);
        centro.add(numero);
        centro.add(Box.createRigidArea(new Dimension(0,10)));
        centro.add(caracter);
        centro.add(Box.createRigidArea(new Dimension(0,10)));
        centro.add(imagem);
        centro.add(Box.createRigidArea(new Dimension(0,20)));
        voltar.addActionListener(this);
        centro.add(voltar);
        add(centro,BorderLayout.CENTER);
    }
}