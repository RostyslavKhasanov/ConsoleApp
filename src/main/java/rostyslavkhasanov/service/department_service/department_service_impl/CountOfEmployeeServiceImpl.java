package rostyslavkhasanov.service.department_service.department_service_impl;

import static rostyslavkhasanov.constants.Constants.DEPARTMENT_NAME;
import static rostyslavkhasanov.constants.RequestSender.COUNT_OF_LECTORS;

import java.util.Scanner;
import rostyslavkhasanov.TaskExecutor;
import rostyslavkhasanov.repository.DepartmentRepository;
import rostyslavkhasanov.service.department_service.CountOfEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountOfEmployeeServiceImpl implements CountOfEmployeeService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private DepartmentRepository repo;

    @Override
    public void execute() {
        System.out.println(DEPARTMENT_NAME);
        String name = SC.nextLine();
        System.out.println(countOfEmployee(name) + " employee(s).");
    }

    @Override
    public int countOfEmployee(String name) {
        return repo.countOfEmployee(name);
    }

    @Override
    public int getNumberOfTask() {
        return COUNT_OF_LECTORS;
    }
}
