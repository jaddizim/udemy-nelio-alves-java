package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program8 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println();

        System.out.println("=== TEST 2: department findAll ===");
        List<Department> departmentList = departmentDao.findAll();
        for (Department department1 : departmentList) {
            System.out.println(department1);
        }

        System.out.println();

        System.out.println("=== TEST 3: department insert ===");
        Department department1 = new Department(null, "Music");
        departmentDao.insert(department1);
        System.out.println("Inserted! New Id = " + department1.getId());

        System.out.println();

        System.out.println("\n=== TEST 4: update =======");
        Department department2 = departmentDao.findById(1);
        department2.setName("Food");
        departmentDao.update(department2);
        System.out.println("Update completed");

        System.out.println();

        System.out.println("=== TEST 5: department delete ===");
        departmentDao.deleteById(6);
    }
}