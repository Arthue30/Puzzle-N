package puzzleN.view;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import puzzleN.model.NomeDeUsuarioException;
import puzzleN.model.Usuario;
import puzzleN.view.jogo.*;

public class TipoJogo extends JPanel implements ActionListener{

    Color fundo = new Color(253,184,39);
    Font fonteT = new Font("", Font.BOLD,35);
    JButton numero = new JButton("Números");
    JButton caracter = new JButton("Caracteres");
    JButton imagem = new JButton("Imagem");
    JButton voltar = new JButton("Voltar");

    private Usuario player;
    private JPanel painelMenu;
    private JPanel painelDificuldade;
    private JFrame mainFrame;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==numero || e.getSource()==caracter || e.getSource()==imagem){
            try{
                this.player.setNome(JOptionPane.showInputDialog("Qual seu nome?"));
            } catch(NomeDeUsuarioException x) {
                JOptionPane.showMessageDialog(null,x.getMessage());
            }
        }
        if(e.getSource()==numero && this.player.getNome() != null) {
            this.player.setTipoJogo(1);
            mainFrame.setSize(700,700);
            mainFrame.setLocationRelativeTo(null);
            GUIJogo numeroJogo = new GUIJogoNumero(this.player, this.mainFrame, this.painelMenu);
            mainFrame.setContentPane(numeroJogo);
            numeroJogo.parteCima(this.player);
            numeroJogo.parteMeio();
            numeroJogo.parteBaixo();
            numeroJogo.revalidate();
        }else if(e.getSource()==caracter && this.player.getNome() != null){
            this.player.setTipoJogo(2);
            mainFrame.setSize(700,700);
            mainFrame.setLocationRelativeTo(null);
            GUIJogo caractereJogo = new GUIJogoCaractere(this.player, this.mainFrame, this.painelMenu);
            mainFrame.setContentPane(caractereJogo);
            caractereJogo.parteCima(this.player);
            caractereJogo.parteMeio();
            caractereJogo.parteBaixo();
            caractereJogo.revalidate();
        }else if(e.getSource()==imagem && this.player.getNome() != null){
            this.player.setTipoJogo(3);
            mainFrame.setSize(700,700);
            mainFrame.setLocationRelativeTo(null);
            GUIJogo imagemJogo = new GUIJogoImagem(this.player, this.mainFrame, this.painelMenu);
            mainFrame.setContentPane(imagemJogo);
            imagemJogo.parteCima(this.player);
            imagemJogo.parteMeio();
            imagemJogo.parteBaixo();
            imagemJogo.revalidate();
        }else if(e.getSource()==voltar) {
            mainFrame.setContentPane(painelDificuldade);
            painelDificuldade.revalidate();
        }
    }
    public TipoJogo(Usuario player, JFrame frameMenu, JPanel painelMenu, JPanel painelDificuldade) {
        this.player = player;
        this.mainFrame = frameMenu;
        this.painelMenu = painelMenu;
        this.painelDificuldade = painelDificuldade;
        setSize(500,430);
        setLayout(new BorderLayout());
        setVisible(true);

        painelTipoJogo();
    }
    public void painelTipoJogo() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBackground(fundo);
        JLabel tituloJogo = new JLabel("Qual sua preferência?");
        tituloJogo.setFont(fonteT);
        tituloJogo.setForeground(new Color(54,54,54));

        tituloJogo.setAlignmentX(CENTER_ALIGNMENT);
        numero.setAlignmentX(CENTER_ALIGNMENT);
        caracter.setAlignmentX(CENTER_ALIGNMENT);
        imagem.setAlignmentX(CENTER_ALIGNMENT);
        voltar.setAlignmentX(CENTER_ALIGNMENT);

        numero.setMaximumSize(new Dimension(150,60));
        caracter.setMaximumSize(new Dimension(150,60));
        imagem.setMaximumSize(new Dimension(150,60));
        voltar.setMaximumSize(new Dimension(100,40));


        painel.add(Box.createRigidArea(new Dimension(0,10)));
        painel.add(tituloJogo);
        painel.add(Box.createRigidArea(new Dimension(0,30)));
        numero.addActionListener(this);
        painel.add(numero);
        painel.add(Box.createRigidArea(new Dimension(0,10)));
        caracter.addActionListener(this);
        painel.add(caracter);
        painel.add(Box.createRigidArea(new Dimension(0,10)));
        imagem.addActionListener(this);
        painel.add(imagem);
        painel.add(Box.createRigidArea(new Dimension(0,20)));
        voltar.addActionListener(this);
        painel.add(voltar);

        add(painel,BorderLayout.CENTER);
    }
}