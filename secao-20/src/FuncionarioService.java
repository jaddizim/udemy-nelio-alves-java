import java.util.List;
import java.util.function.Predicate;

public class FuncionarioService {

    public double filteredSum(List<Funcionario> list, Predicate<Funcionario> criteria) {
        double sum = 0;
        for (Funcionario f : list) {
            if (criteria.test(f)) {
                sum += f.getSalary();
            }
        }
        return sum;
    }
}
