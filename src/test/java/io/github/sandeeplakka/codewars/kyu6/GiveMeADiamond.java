package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
 *
 * Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James. Since James doesn't know how to make this happen, he needs your help.
   Task

   You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters. Trailing spaces should be removed, and every line must be terminated with a newline character (\n).

   Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.
   Examples

   A size 3 diamond:

    *
   ***
    *

   ...which would appear as a string of " *\n***\n *\n"

   A size 5 diamond:

    *
   ***
  *****
   ***
    *

  ...that is:

  "  *\n ***\n*****\n ***\n  *\n"

  Categories: Fundamentals, Strings
 */
public class GiveMeADiamond {

    @Test
    public void testReturnDiamond(){
        assertEquals("  *\n ***\n*****\n ***\n  *\n", returnDiamond(5));
        assertEquals(" *\n***\n *\n", returnDiamond(3));
        assertNull(returnDiamond(-3));
        assertNull(returnDiamond(10));

    }

    public String returnDiamond(int n){
        StringBuilder sb = new StringBuilder();
        if ((n&1) == 0 || n < 0) return null;
        int iter = 1;
        for(int i = 1; i <= n;i++){
            for(int k = 1; k <=Math.abs((n+1)/2-i);k++){
                sb.append(" ");
            }
            for(int j = 1; j <= iter; j++){
                sb.append("*");
            }
            iter = i < (n+1)/2 ? iter+2 : iter-2;
            sb.append("\n");
        }
        return sb.toString();
    }
}
