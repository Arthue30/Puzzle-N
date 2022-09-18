package puzzleN.model;

public class NomeDeUsuarioException extends Exception{
    public NomeDeUsuarioException(){
        super("Por favor, digite seu nome de usuário corretamente, ele deve ter entre 3 a 12 letras");
    }
}
