package puzzleN.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro implements ActionListener {
    private Usuario player;
    private JLabel cronometro;
    private long hora;
    private long minutos;
    private long segundos;
    private long centisegundos;
    private long tempoDecorrido;
    private long tempoInicial;

    public Cronometro(Usuario player ,JLabel cronometro){
        this.player = player;
        this.cronometro = cronometro;
    }

    public void actionPerformed(ActionEvent e) {
        this.tempoDecorrido = System.currentTimeMillis() - this.tempoInicial;
        this.hora = (this.tempoDecorrido/3600000) % 24;
        this.minutos = (this.tempoDecorrido/60000) % 60;
        this.segundos = (this.tempoDecorrido/1000) % 60;
        this.centisegundos = (this.tempoDecorrido/10) % 100;
        this.cronometro.setText(String.format("%02d:%02d:%02d:%02d", this.hora, this.minutos, this.segundos, this.centisegundos));
    }
    Timer timer = new Timer(10, this);
    public void pararCronometro(){
        timer.stop();
        player.setTempo(String.format("%02d:%02d:%02d:%02d", this.hora, this.minutos, this.segundos, this.centisegundos));
    }
    public void comecarCronometro(){
        this.tempoInicial = System.currentTimeMillis();
        timer.start();
    }
}

