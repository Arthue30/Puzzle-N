package puzzleN.controller.botoes;

import puzzleN.model.Usuario;
import puzzleN.view.jogo.*;

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
            if(player.getTipoJogo() == 1){
                GUIJogo numeroJogo = new GUIJogoNumero(player, this.mainFrame, this.painelMenu);
                mainFrame.setContentPane(numeroJogo);
                numeroJogo.revalidate();
                numeroJogo.parteCima(this.player);
                numeroJogo.parteMeio();
                numeroJogo.parteBaixo();
            } else if (player.getTipoJogo() == 2) {
                GUIJogo caractereJogo = new GUIJogoCaractere(player, this.mainFrame, this.painelMenu);
                mainFrame.setContentPane(caractereJogo);
                caractereJogo.revalidate();
                caractereJogo.parteCima(this.player);
                caractereJogo.parteMeio();
                caractereJogo.parteBaixo();
            } else {
                GUIJogo imagemJogo = new GUIJogoImagem(this.player, this.mainFrame, this.painelMenu);
                mainFrame.setContentPane(imagemJogo);
                imagemJogo.revalidate();
                imagemJogo.parteCima(this.player);
                imagemJogo.parteMeio();
                imagemJogo.parteBaixo();
            }

        }
    }
}
