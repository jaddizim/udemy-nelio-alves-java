import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale locale = Locale.US;
        Scanner t = new Scanner(System.in);
        List<Funcionario> list = new ArrayList<>();

        System.out.print("Enter full file path: ");
        String path = t.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");

                String name = fields[0];
                String email = fields[1];
                Double salary = Double.valueOf(fields[2]);

                list.add(new Funcionario(name, email, salary));

                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            Double referenceSalary = t.nextDouble();

            System.out.println("Email of people whose salary is more than 2000.00: ");

            List<Funcionario> emailPeopleMoreThan2000 = list.stream()
                    .filter(p -> p.getSalary() > referenceSalary)
                    .sorted()
                    .toList();

            for (Funcionario f : emailPeopleMoreThan2000) {
                System.out.println(f.getEmail());
            }

            System.out.print("Sum of salary of people whose name starts with 'M': ");

            FuncionarioService fs = new FuncionarioService();

            double sum = fs.filteredSum(list,f -> f.getName().charAt(0) == 'M');

            System.out.print(sum);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}