package rostyslavkhasanov.service.department_service.department_service_impl;

import static rostyslavkhasanov.constants.Constants.DEPARTMENT_NAME;
import static rostyslavkhasanov.constants.RequestSender.AVG_SALARY;

import java.util.Scanner;
import rostyslavkhasanov.TaskExecutor;
import rostyslavkhasanov.repository.DepartmentRepository;
import rostyslavkhasanov.service.department_service.AverageSalaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AverageSalaryServiceImpl implements AverageSalaryService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private DepartmentRepository repo;

    @Override
    public void execute() {
        System.out.println(DEPARTMENT_NAME);
        String name = SC.nextLine();
        System.out.println("The average salary of " + name + " is " + avgSalary(name));
    }

    @Override
    public double avgSalary(String name) {
        return repo.avgSalary(name);
    }

    @Override
    public int getNumberOfTask() {
        return AVG_SALARY;
    }
}
