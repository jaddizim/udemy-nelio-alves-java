import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner t = new Scanner(System.in);
        List<Product> products = new ArrayList<>();


        System.out.print("Type original file path: ");
        File file = new File(t.nextLine());

        String sourcePath = file.getParent();

        boolean success = new File(sourcePath + "\\out").mkdir();

        File targetFile = new File(sourcePath + "\\out\\summary.xlsx");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;
            String[] attributes;

            while ((line = bufferedReader.readLine()) != null) {

                attributes = line.split(",");

                String tempName = attributes[0];
                double tempPrice = Double.parseDouble(attributes[1]);
                int tempQuantity = Integer.parseInt(attributes[2]);

                products.add(new Product(tempName, tempPrice, tempQuantity));
            }

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile))) {

                for (Product product : products) {
                    bufferedWriter.write(product.getName()
                            + "\t "
                            + String.format("%.2f", product.totalPrice()));
                    bufferedWriter.newLine();
                }

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}