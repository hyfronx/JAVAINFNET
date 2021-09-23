package exception;

public class PokemonNaoCapturadoException extends Exception{
    public PokemonNaoCapturadoException(String mensagem){
		super(mensagem);
	}
}