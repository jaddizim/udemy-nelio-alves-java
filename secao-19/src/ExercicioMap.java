import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExercicioMap {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();
        String source = "c:\\in.csv";
        Scanner sc = new Scanner(System.in);


        try (BufferedReader br = new BufferedReader(new FileReader(source))) {

            String line = br.readLine();

            while (line != null) {

                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)) {
                    int votesSoFar = votes.get(name);
                    votes.put(name, count + votesSoFar);
                } else {
                    votes.put(name, count);
                }

                line = br.readLine();
            }

            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error accessing file: " + e.getMessage());
        }
    }
}