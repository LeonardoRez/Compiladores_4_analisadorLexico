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
    public void resetarTokens(){
        tokens.clear();
    }

    public String tokenizar(String entrada) {

        Token erro = new Token("ERRO", Pattern.compile("^ *(\\n|\\t|\\b)*$"));
        Stack<Token> result = new Stack();
        String temp = "";
        String saida = "";
        int inicioTemp = 0;
        for (int i = 0; i < entrada.length(); i++) {
            inicioTemp = i;
            if (entrada.charAt(i) == '\n' || entrada.charAt(i) == '\t' || entrada.charAt(i) == '\b') {
                temp = " ";
            } else {
                temp = "" + entrada.charAt(i);
            }
            while (!(consultaTokens(temp)).isEmpty() && i < entrada.length() - 1) { //enquanto temp estiver sendo aceito por algum token

                if (entrada.charAt(i + 1) == '\n' || entrada.charAt(i + 1) == '\t' || entrada.charAt(i + 1) == '\b') {
                    temp += " ";
                    i += 2;
                    break;
                } else {
                    temp += entrada.charAt(++i);
                }
            }
            if (i == inicioTemp) {
                if (!erro.confere(temp)){
                    if (!result.empty()) {
                        if (result.peek() != erro) {
                            result.add(erro);
                            saida += result.peek();
                        }
                    }
                }
                //System.out.println("deu erro no char " + i);//debug
            } else {
                if (i != entrada.length() - 1) {
                    temp = temp.substring(0, temp.length() - 1);
                    i--;
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
    public String getTokensToString(){
        String result = "";
        for(Token t: tokens){
            result += t.getToString() +"\n";
        }
        return result;
    }

}
