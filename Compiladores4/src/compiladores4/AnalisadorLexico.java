package compiladores4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class AnalisadorLexico {

    ArrayList<Token> tokens;

    public AnalisadorLexico(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public AnalisadorLexico() {
        tokens = new ArrayList<>();
    }

    public void adicionarToken(Token token) {
        this.tokens.add(token);
    }

    public void adicionarToken(String nome, String regex) {
        this.tokens.add(new Token(nome, Pattern.compile(regex)));
    }

    public String tokenizar(String entrada) {
        return null;
    }

    private ArrayList<Token> consultaTokens(String palavra) {
        ArrayList<Token> aceitos = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).confere(palavra)) {
                aceitos.add(tokens.get(i));
            }
        }
        return aceitos;
    }

}
