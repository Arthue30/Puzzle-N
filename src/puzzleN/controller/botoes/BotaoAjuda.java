package puzzleN.controller.botoes;
import puzzleN.model.Usuario;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BotaoAjuda implements ActionListener{
    private JButton[][] botao;
    private JButton ajudaAtivo;
    private Usuario player;
    public BotaoAjuda(JButton[][] botao, JButton ajuda, Usuario player){
        this.botao = botao;
        this.ajudaAtivo = ajuda;
        this.player = player;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.ajudaAtivo){
            if(player.getAjudaAtiva()){
                for(int i = 0; i< player.getNivel() ;i++){
                    for(int j = 0; j<player.getNivel() ;j++){
                        botao[i][j].setFont(new Font("", Font.BOLD, 0));
                    }
                }
                player.setAjudaAtiva(false);
            }else{
                for(int i = 0; i<player.getNivel() ;i++){
                    for(int j = 0; j<player.getNivel() ;j++){
                        if (botao[i][j].getText().equals("0")){
                            continue;
                        }else{
                            botao[i][j].setFont(new Font("", Font.BOLD, 50));
                        }
                    }
                }
                player.setAjudaAtiva(true);
            }
        }
    }
}