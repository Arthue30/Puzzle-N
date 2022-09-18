package puzzleN.model;

import java.util.Random;

public class Usuario {
    private String nome;
    private int movimento;
    private int nivel;
    private int tipoJogo;
    private String tempo;
    private Boolean ajudaAtiva;
    private Boolean puzzleNMaluco;
    private double randomMaluco;

    public void setNome(String nome) throws NomeDeUsuarioException{
        if(nome==null) {

        }else if(nome.length()<=12 && nome.length()>=3) {
            this.nome = nome;
        }else {
            throw new NomeDeUsuarioException();
        }
    }
    public String getNome() {
        return this.nome;
    }
    public void setNivel(int dificuldade) {
        this.nivel = dificuldade;
    }
    public int getNivel() {
        return this.nivel;
    }
    public void setTipoJogo(int tipoJogo){
        this.tipoJogo = tipoJogo;
    }
    public int getTipoJogo(){
        return this.tipoJogo;
    }

    public void setMovimento(int movimento){
        this.movimento = movimento;
    }
    public int getMovimento(){
        return this.movimento;
    }
    public void setAjudaAtiva(Boolean ativo){
        this.ajudaAtiva = ativo;
    }
    public Boolean getAjudaAtiva(){
        return this.ajudaAtiva;
    }
    public void setPuzzleNMaluco(Boolean puzzleNMaluco) {
        this.puzzleNMaluco = puzzleNMaluco;
    }
    public Boolean getPuzzleNMaluco(){
        return this.puzzleNMaluco;
    }
    public void setTempo(String tempo){
        this.tempo = tempo;
    }
    public String getTempo(){
        return this.tempo;
    }
    public void setRandomMaluco(){
        Random random = new Random();
        this.randomMaluco = (double) (random.nextInt(10) + 1)/100;
    }
    public double getRandomMaluco(){
        return this.randomMaluco;
    }
}
