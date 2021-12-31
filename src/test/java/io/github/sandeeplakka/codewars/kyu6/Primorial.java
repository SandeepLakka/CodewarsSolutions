package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Primorial Of a Number

Definition:
Is similar to factorial of a number, In primorial, not all the natural numbers get multiplied,
only prime numbers are multiplied to calculate the primorial of a number.
It's denoted with P# and it is the product of the first n prime numbers.


Task:
Given a number N , calculate its primorial.

Examples:
1- numPrimorial (3) ==> return (30)     # 2 * 3 * 5
2- numPrimorial (5) ==> return (2310)   # 2 * 3 * 5 * 7 * 11
3- numPrimorial (6) ==> return (30030)  # 2 * 3 * 5 * 7 * 11 * 13


Categories : Fundamentals, Numbers, Basic Language Features, Arrays, Loops, Control Flow
Arithmetic, Mathematics, Algorithms

 */
public class Primorial {

    @Test
    public void tests() {
        assertEquals("30", numPrimorial(3));
        assertEquals("2310", numPrimorial(5));
        assertEquals("30030", numPrimorial(6));
        assertEquals("9699690", numPrimorial(8));
        assertEquals("223092870", numPrimorial(9));
        assertEquals("98203290177655808293675134056" +
                "234283664486972759652529377598564735621083" +
                "477542865705101239868112564727154902018970" +
                "838370780575779239118586689358264536195821" +
                "807911742300062343317192166471689072421558" +
                "759683446757535347799888825192995765539953" +
                "674888341380827865145175656502288198162493" +
                "249746643536820978529854781158557167546529" +
                "307412292561077404563008427609109684317614" +
                "615632434360265115957324488342519203406319" +
                "455264917056802142777474728687528459288456" +
                "710934583520432773329563712182773713004346" +
                "064457885473118546862712794747170600150534" +
                "565177043956332184754852741071638015315601" +
                "062684875561351092037055535399601242141424" +
                "965509505809818563023786280746791816738384" +
                "918924796137921919470363220301457990275418" +
                "364354626193211041086556252819864716379745" +
                "665027786741792958513997396561801062628084" +
                "025782718783488509658732637883765017077658" +
                "696150829152279037779606336738658694528441" +
                "720200014517474451351744019328691111962332" +
                "392247762989769269185066146179589022556224" +
                "616637854897347841016128058925199767775186" +
                "403050801791578916983550779682265396001090" +
                "672069012641078607846637503367433488935744" +
                "737540502478370425097535758484856620570338" +
                "735510646542778832438526594173160927143628" +
                "470926912752064573793978445112109225520847" +
                "924953101393221398808815259354459886888283" +
                "763386784689120294917256719338364196263070" +
                "208965091886378161570106319328400799529448" +
                "822063682167004631716375361042053933739042" +
                "087975095676797909245034721860832142826693" +
                "759148583098742765245969568853154841280403" +
                "356588826877398571336675063973588061019457190", numPrimorial(495));
    }

    //BigInteger has nextProbablePrime but didn't use that as it defeats the purpose of learning.
    //YMMV
    public static String numPrimorial(int n) {
        int till = 100;
        List<BigInteger> primes;
        do {
            System.out.println("Getting primes in " + till);
            primes = getPrimes(till);
            till *= 2;
        } while (primes.size() < n);

        return primes.stream().limit(n)
                .reduce(BigInteger.ONE, (a, b) -> a.multiply(b))
                .toString();
    }

    private static List<BigInteger> getPrimes(int number) {
        boolean[] arr = new boolean[number + 1];
        Arrays.fill(arr, true);
        for (int i = 2; i * i <= number; i++) {
            for (int j = i * i; j <= number; j += i) {
                arr[j] = false;
            }
        }
        List<BigInteger> primes = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (arr[i]) primes.add(BigInteger.valueOf(i));
        }
        return primes;
    }
}