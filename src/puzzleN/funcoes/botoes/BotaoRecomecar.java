package puzzleN.funcoes.botoes;

import puzzleN.funcoes.Usuario;
import puzzleN.interfaceGraf.jogo.GUIJogoNumero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoRecomecar implements ActionListener {

    private JButton recomeco;
    private JFrame mainFrame;
    private Usuario player;
    private JPanel painelMenu;

    public BotaoRecomecar(JButton recomeco, JFrame mainFrame, JPanel painelMenu, Usuario player){
        this.recomeco = recomeco;
        this.mainFrame = mainFrame;
        this.painelMenu = painelMenu;
        this.player = player;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == recomeco){
            GUIJogoNumero numeroJogo = new GUIJogoNumero(player, this.mainFrame, this.painelMenu);
            mainFrame.setContentPane(numeroJogo);
            numeroJogo.revalidate();
        }
    }
}
