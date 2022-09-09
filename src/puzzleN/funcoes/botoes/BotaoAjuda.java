package puzzleN.funcoes.botoes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BotaoAjuda extends JPanel implements ActionListener{ //CLASSE EM DESENVOLVIMENTO
    private JFrame jogo;
    private int[][] gabarito;
    private int tamanho;
    private boolean apertou = true;
    private JLabel[][] ajuda;
    private JButton apertado;

    Color fundo = new Color(153,50,204);
    Font fonteLabel = new Font("", Font.BOLD, 10);
    Font labelBranco = new Font("", Font.BOLD,0);

    public BotaoAjuda(JFrame jogo, int[][] gabarito, int tamanho, JButton apertado) {
        this.jogo = jogo;
        this.gabarito = gabarito;
        this.tamanho = tamanho;
        this.apertado = apertado;
        this.ajuda = new JLabel[tamanho][tamanho];
        setLayout(new GridLayout(this.tamanho,this.tamanho));
        PopupFactory pf = new PopupFactory();
        Popup popUp = pf.getPopup(jogo, this, 500, 500);
        setValorAjuda();
        jogo.add(this);
    }

    public void setValorAjuda() {
        for(int i = 0; i<ajuda.length ;i++) {
            for(int j = 0; i<ajuda[i].length ;j++) {
                ajuda[i][j] = new JLabel();
                ajuda[i][j].setText(String.valueOf(gabarito[i][j]));
                ajuda[i][j].setBackground(fundo);
                ajuda[i][j].setFont(fonteLabel);
                ajuda[i][j].setForeground(Color.WHITE);
                add(ajuda[i][j]);
            }
        }
        //ajuda[tamanho-1][tamanho-1].setFont(labelBranco);
    }


    public void actionPerformed(ActionEvent e) {
        //if(e.getSource() == apertado) {
            //if(apertou == false) {
               // popUp.show();
                //apertou = true;
            //}else {
               // popUp.hide();
               // apertou = false;
           // }
        //}
    }
}