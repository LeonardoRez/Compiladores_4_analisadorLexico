package compiladores4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token {

    private Pattern expressao;
    private String nomeToken;

    public Token(String nomeToken, Pattern expressao) {
        this.expressao = expressao;
        this.nomeToken = nomeToken;
    }

    public String getNomeToken() {
        return nomeToken;
    }

    public boolean confere(String entrada) {
        Matcher m = expressao.matcher(entrada);
        if (m.matches()) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public String toString() {
        return "<"+nomeToken+">";
    }

}
