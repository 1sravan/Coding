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
    public static int countchar(String s, long length){
        int count = 0;
        for (int i = 0; i < length; i++) {
                if (s.charAt(i) == 'a') {
                    count++;
                }
        }
        return count;
    }    

    public static long repeatedString(String s, long n) {
        long result = (n / s.length()) * countchar(s,s.length());
        if (n % s.length() == 0) {
             return result + (n % s.length());
        }else {
             return result + countchar(s,n % s.length());
        }
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
