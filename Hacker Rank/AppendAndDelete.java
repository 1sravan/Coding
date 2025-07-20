import java.io.*;

class Result {

    public static String appendAndDelete(String s, String t, int k) {
        int commonLength = 0;
        int minLength = Math.min(s.length(), t.length());

        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }

        int totalmovesn = (s.length() - commonLength) + (t.length() - commonLength);

        if (totalmovesn > k) {
            return("No");
        } else if ((k - totalmovesn) % 2 == 0 || k >= s.length() + t.length()) {
            return("Yes");
        } else{
            return("No");
        }

    }

}

public class AppendAndDelete {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
