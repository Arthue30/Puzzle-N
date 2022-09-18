package puzzleN.controller.movimentos;

import puzzleN.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public abstract class MovJogo implements ActionListener{
    private Usuario player;
    private JButton[][] botao;
    Font fonteBotao = new Font("", Font.BOLD, 50);

    public MovJogo(Usuario player, JButton[][] botao) {
        this.player = player;
        this.botao = botao;
    }
    public void misturarBotoesMaluco(){
        if (this.player.getPuzzleNMaluco()){
            if ((new Random().nextInt(100) + 1) <= this.player.getRandomMaluco()*100){
                Random random = new Random();
                int posicaoI1 = getIBotao();
                int posicaoJ1 = getJBotao();
                int posicaoI2 = getIBotao();
                int posicaoJ2 = getJBotao();
                while ((posicaoI1 == getIBotao()) && (posicaoJ1 == getJBotao()) && (posicaoI2 == getIBotao()) && (posicaoJ2 == getJBotao()) && (posicaoI1 == posicaoI2) && (posicaoJ1 == posicaoJ2)){
                    posicaoI1 = random.nextInt(getPlayer().getNivel());
                    posicaoJ1 = random.nextInt(getPlayer().getNivel());
                    posicaoI2 = random.nextInt(getPlayer().getNivel());
                    posicaoJ2 = random.nextInt(getPlayer().getNivel());
                }
                String temp = (this.botao[posicaoI1][posicaoJ1].getText());
                this.botao[posicaoI1][posicaoJ1].setText(this.botao[posicaoI2][posicaoJ2].getText());
                this.botao[posicaoI2][posicaoJ2].setText(temp);
                this.botao[posicaoI1][posicaoJ1].setBackground(new Color(84,37,131));
                this.botao[posicaoI1][posicaoJ1].setFont(fonteBotao);
                this.botao[posicaoI1][posicaoJ1].setForeground(Color.white);
                this.botao[posicaoI2][posicaoJ2].setBackground(new Color(84,37,131));
                this.botao[posicaoI2][posicaoJ2].setFont(fonteBotao);
                this.botao[posicaoI2][posicaoJ2].setForeground(Color.white);
            }
        }
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
