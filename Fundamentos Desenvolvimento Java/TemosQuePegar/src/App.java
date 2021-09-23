import java.util.Date;
import java.util.Random;

import exception.NaoTemPokebolaException;
import exception.PokemonNaoCapturadoException;
import exception.PokemonNaoEncontradoException;

public class App {
    private static Random geradorRespostaAleatoria = new Random();

    public static void main(String[] args) {

        // tente capturar o Pokemon
        try
        {
            pegarPokebola();
            iniciarCaptura();
        }
        /* ok, se não consegue capturar o Pokemon 
           pelo menos capture o erro e mostre o que aconteceu: */
        catch(PokemonNaoCapturadoException e) 
        {
            System.out.println(e.getMessage());
        }
        /* não tinha Pokemon ou não tinha Pokebola,
           a culpa não foi sua, só anote nos registros de log 
        */
        catch(NaoTemPokebolaException | PokemonNaoEncontradoException e){
            gerarLog(e.getMessage());
        }
        /* ops, essse erro não era pra acontecer, onde foi isso? */
        catch(Exception e) 
        {
            // o e.getStackTrace() vai mostrar a origem e o caminho do erro
            System.out.println("Erro inesperado em: " + e.getStackTrace());
        }
        // independe se deu certo ou não, guarde a Pokebola
        finally
        {
            guardarPokebola();
        }

    }

    private static void gerarLog(String empecilho) { 
        Date dataAtual = new Date();
        System.out.println("Problema: " + empecilho + ". Data: " + dataAtual);
    }

    private static void iniciarCaptura() throws PokemonNaoEncontradoException, PokemonNaoCapturadoException{ 
        procurar();
        capturar();
    }

    private static void procurar() throws PokemonNaoEncontradoException{

        boolean encontreiOPokemon = geradorRespostaAleatoria.nextBoolean();

        if(encontreiOPokemon){
            System.out.println("Pokemon encontrado.");
        }else{
            // se não existe um Pokemon para capturar, não tem porque seguir o processo
            // então PARA TUDO, porém não é aqui que vamos decidir o que fazer
            // use o THROWS pra delegar a responsabilidade de resolver pra outra pessoa
            throw new PokemonNaoEncontradoException("Nao encontrei o Pokemon");
        }        
    }

    private static void capturar() throws PokemonNaoCapturadoException{

        boolean captureiOPokemon = geradorRespostaAleatoria.nextBoolean();

        if(captureiOPokemon){
            System.out.println("Pokemon capturado.");
        }else{
            
            throw new PokemonNaoCapturadoException("Errei a bola.");
        }        
    }

    private static void pegarPokebola() throws NaoTemPokebolaException{

        boolean aindaTemPokebola = geradorRespostaAleatoria.nextBoolean();

        if(aindaTemPokebola){
            System.out.println("Pokebola na mao.");
        }else{
            throw new NaoTemPokebolaException("Nao tem Pokebolas no estoque.");
        }        
    }

    private static void guardarPokebola(){
        System.out.println("Pokebola guardada.");
    }
}
