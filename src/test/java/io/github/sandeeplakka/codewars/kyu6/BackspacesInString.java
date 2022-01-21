package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackspacesInString {
    @Test
    public void tests() {
      assertEquals("ac", cleanString("abc#d##c"));
      assertEquals("", cleanString("abc####d##c#"));
      assertEquals("jf", cleanString("abjd####jfk#"));
      assertEquals("gdasda", cleanString("gfh#jds###d#dsd####dasdaskhj###dhkjs####df##s##d##"));
      assertEquals("6+yqw8hfklsd-=-f", cleanString("831####jns###s#cas/*####-5##s##6+yqw87e##hfklsd-=-28##fds##"));
      assertEquals("jdsfdasns", cleanString("######831###dhkj####jd#dsfsdnjkf###d####dasns"));
      assertEquals("", cleanString(""));
      assertEquals("", cleanString("#######"));
      assertEquals("sa", cleanString("####gfdsgf##hhs#dg####fjhsd###dbs########afns#######sdanfl##db#####s#a"));
      assertEquals("hskjdgd", cleanString("#hskjdf#gd"));
      assertEquals("hsk48hjjdfgd", cleanString("hsk48hjjdfgd"));
      assertEquals("Io4f", cleanString("fjnwui#NI#(*N#ION#Onfjen################Io4f"));
      assertEquals("6d87hbaskj$$%$$2332ff", cleanString("####6d87hbaskjdnf###$$%W#$@#$2332fr#f"));
      assertEquals("9OooooO", cleanString("#9#9#9#9o#9#9#9#Oooooo#OOOooO#OO######"));
      assertEquals("0", cleanString("0###0###0"));
      assertEquals("904rfDj*fsf09mfednkmfd;m", cleanString("904rfn#jlkcn#####Djva2###*(#fsdgfd####fsdg###09849###mfenf##dnjn##kmfd;l#mg03###"));
    }

    //naive
    public String cleanString(String s) {
        // your code here
        Stack<String> chars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '#':
                    if (!chars.isEmpty()) chars.pop();
                    break;
                default:
                    chars.push("" + s.charAt(i));
            }
        }
        return chars.stream().collect(Collectors.joining());
    }
}