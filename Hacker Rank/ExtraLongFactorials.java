import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

public static void extraLongFactorials(int n) {
        BigInteger fact = BigInteger.valueOf(1);
        BigInteger a = BigInteger.valueOf(n);
        while (a!=BigInteger.valueOf(0)){
            fact = fact.multiply(a) ;
            a = a.subtract(BigInteger.valueOf(1));
        }
        System.out.println(fact);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
