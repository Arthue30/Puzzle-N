package puzzleN.funcoes.movimentos;

import puzzleN.funcoes.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class MovJogo implements ActionListener{
    private Usuario player;
    private JButton[][] botao;

    public MovJogo(Usuario player, JButton[][] botao) {
        this.player = player;
        this.botao = botao;
    }


    public int getIBotao(){
        for(int i = 0; i<this.player.getNivel() ;i++){
            for(int j = 0; j<this.player.getNivel() ;j++){
                if(botao[i][j].getText().equals("0")){
                    return i;
                }
            }
        }
        return 0;
    }
    public int getJBotao(){
        for(int i = 0; i<this.player.getNivel() ;i++){
            for(int j = 0; j<this.player.getNivel() ;j++){
                if(botao[i][j].getText().equals("0")){
                    return j;
                }
            }
        }
        return 0;
    }
    public abstract void actionPerformed(ActionEvent e);

    public JButton[][] getBotao(){
        return this.botao;
    }
    public Usuario getPlayer(){
        return this.player;
    }
}
