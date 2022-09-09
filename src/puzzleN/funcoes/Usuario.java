package puzzleN.funcoes;

public class Usuario {
    private String nome;
    private int movimento;
    private int dificuldade;

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

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getDificuldade() {
        return this.dificuldade;
    }

    public void setMovimento(int movimento){
        this.movimento = movimento;
    }

    public int getMovimento(){
        return this.movimento;
    }
}
