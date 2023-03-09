import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Aluno> listaTotalAlunos = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int number = 0;

        System.out.print("How many students for course A?");
        number = sc.nextInt();
        for(int i = 0; i < number; i++){
            Integer id = sc.nextInt();
            listaTotalAlunos.add(new Aluno(id));
        }
        System.out.print("How many students for course B?");
        number = sc.nextInt();
        for(int i = 0; i < number; i++){
            Integer id = sc.nextInt();
            listaTotalAlunos.add(new Aluno(id));
        }
        System.out.print("How many students for course C?");
        number = sc.nextInt();
        for(int i = 0; i < number; i++){
            Integer id = sc.nextInt();
            listaTotalAlunos.add(new Aluno(id));
        }
        System.out.println("Total students: "+ listaTotalAlunos.size());
    }
}