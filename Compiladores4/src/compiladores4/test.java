package compiladores4;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.regex.*;
import javafx.scene.control.TextArea;

public class test {

    public static void main(String[] args) {
//        Pattern p = Pattern.compile("^((?!\\A( *(if|else|do|while|for|int|float|char|bool))\\Z)( *[_a-zA-Z][\\w]*))*$"); //regex para identificador (IDT)
//        Matcher m = p.matcher("if1");
//        if(m.matches())
//            System.out.println("DEU BOM");
//        else
//            System.out.println("DEU RUIM");

//        AnalisadorLexico a = new AnalisadorLexico();
//        a.adicionarToken("AA", "aa");
//        a.adicionarToken("NUMERO", "^ *([0-9]*[0-9])$");
//        a.adicionarToken("IDT", "^((?!\\A( *(if|else|do|while|for|int|float|char|bool))\\Z)( *[_a-zA-Z][\\w]*))*$");
//        System.out.println(a.tokenizar("1a"));
//        String temp = "TESTE";
//        System.out.println(temp.substring(0, temp.length()-1));
        AnalisadorLexico a = new AnalisadorLexico();
        a.adicionarToken("IDT", "^((?!\\A( *(if|else|do|while|for|int|float|char|bool))\\Z)(\\A *[_a-zA-Z][\\w]*\\Z))*$");
        a.adicionarToken("NUM","^ *([0-9]*[0-9])$");
        a.adicionarToken("IF", "^ *(if)$");
        a.adicionarToken("WHILE", "^ *(while)$");
        System.out.println(a.tokenizar("teste 123 abc if \n \t arroz3 7prato while"));
    
    
    
    
    }
}
