package compiladores4;

import java.util.ArrayList;
import java.util.Stack;
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

        Token erro = new Token("ERRO", null);
        Stack<Token> result = new Stack();
        String temp = "";
        String saida = "";
        int inicioTemp = 0;
        for (int i = 0; i < entrada.length(); i++) {
            inicioTemp = i;
            temp = "" + entrada.charAt(i);
            while (!(consultaTokens(temp)).isEmpty() && i < entrada.length() - 1) { //enquanto temp estiver sendo aceito por algum token

                if (entrada.charAt(i + 1) == '\n') {
                    break;
                }
                temp += entrada.charAt(++i);
            }
            if (i == inicioTemp) {
                if (entrada.charAt(i) == '\n') {
                    saida += '\n';
                    i++;
                } else if (!result.empty()) {
                    if (result.peek() != erro) {
                        result.add(erro);
                        saida += result.peek();
                    }
                }
                System.out.println("deu erro no char " + i);//debug
            } else {
                if (i != entrada.length() - 1) {
                    temp = temp.substring(0, temp.length() - 1);
                }
                result.add(consultaTokens(temp).get(0));
                saida += result.peek();
            }

        }

        return saida;
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
