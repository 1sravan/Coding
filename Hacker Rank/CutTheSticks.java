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

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        List<Integer> stickscut = new ArrayList<>();
        stickscut.add(arr.size());
        int min = 0,i = 0;
        for ( ; i<arr.size(); i++) {
            min = Collections.min(arr);
            for (int j = 0; j < arr.size(); j++) {
                if (arr.get(j) > 0)
                    arr.set(j,arr.get(j)-min);
            }
            arr.removeIf(n -> n == 0);
            if (arr.size()==0){
                break;
            }
            stickscut.add(arr.size());
            i=0;
        }
        return stickscut;

    }

}

public class CutTheSticks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
