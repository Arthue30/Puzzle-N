package puzzleN.funcoes;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Usuario {
    private String nome;
    private int movimento;
    private int nivel;
    private int tipoJogo;
    private Boolean ajudaAtiva;
    private Boolean PuzzleNMaluco;

    public void setNome(String nome){
        if(nome.isEmpty()) {
            this.nome = "Indefinido";
        }else if(nome.length()>12) {
            this.nome = nome.substring(0,12);
        }else {
            this.nome = nome;
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
        this.PuzzleNMaluco = puzzleNMaluco;
    }
    public Boolean getPuzzleNMaluco(){
        return this.PuzzleNMaluco;
    }
}
