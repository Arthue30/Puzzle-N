package puzzleN.funcoes.botoes;

import puzzleN.funcoes.Usuario;
import puzzleN.interfaceGraf.jogo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoRecomecar implements ActionListener {

    private JButton recomeco;
    private JFrame mainFrame;
    private Usuario player;
    private JPanel painelMenu;
    private int tipoJogo;

    public BotaoRecomecar(JButton recomeco, JFrame mainFrame, JPanel painelMenu, Usuario player, int tipoJogo){
        this.recomeco = recomeco;
        this.mainFrame = mainFrame;
        this.painelMenu = painelMenu;
        this.player = player;
        this.tipoJogo = tipoJogo;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == recomeco){
            if(tipoJogo == 1){
                GUIJogoNumero numeroJogo = new GUIJogoNumero(player, this.mainFrame, this.painelMenu);
                mainFrame.setContentPane(numeroJogo);
                numeroJogo.revalidate();
            } else if (tipoJogo == 2) {
                GUIJogoCaractere caractereJogo = new GUIJogoCaractere(player, this.mainFrame, this.painelMenu);
                mainFrame.setContentPane(caractereJogo);
                caractereJogo.revalidate();
            }

        }
    }
}
