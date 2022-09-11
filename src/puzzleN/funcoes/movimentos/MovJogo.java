package puzzleN.funcoes.movimentos;

import puzzleN.funcoes.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class MovJogo implements ActionListener{
    private int tamanho;
    private JButton[][] botao;

    public MovJogo(int tamanho, JButton[][] botao) {
        this.tamanho = tamanho;
        this.botao = botao;
    }


    public int getIBotao(){
        for(int i = 0; i<this.tamanho ;i++){
            for(int j = 0; j<this.tamanho ;j++){
                if(botao[i][j].getText().equals("0")){
                    return i;
                }
            }
        }
        return 0;
    }
    public int getJBotao(){
        for(int i = 0; i<this.tamanho ;i++){
            for(int j = 0; j<this.tamanho ;j++){
                if(botao[i][j].getText().equals("0")){
                    return j;
                }
            }
        }
        return 0;
    }
    public void setBotao(JButton[][] botao){
        this.botao = botao;
    }

    public JButton[][] getBotao(){
        return this.botao;
    }
    public int getTamanho(){
        return this.tamanho;
    }
}
