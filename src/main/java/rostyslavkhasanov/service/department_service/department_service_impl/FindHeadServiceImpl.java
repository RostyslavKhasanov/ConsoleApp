package rostyslavkhasanov.service.department_service.department_service_impl;

import static rostyslavkhasanov.constants.Constants.DEPARTMENT_NAME;
import static rostyslavkhasanov.constants.Constants.HEAD_NOT_FOUND_BY_NAME;
import static rostyslavkhasanov.constants.RequestSender.FIND_HEAD;

import java.util.Scanner;
import rostyslavkhasanov.TaskExecutor;
import rostyslavkhasanov.entity.Department;
import rostyslavkhasanov.repository.DepartmentRepository;
import rostyslavkhasanov.service.department_service.FindHeadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindHeadServiceImpl implements FindHeadService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private DepartmentRepository repo;

    @Override
    public Department findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public void execute() {
        System.out.println(DEPARTMENT_NAME);
        String name = SC.nextLine();
        try {
            System.out.println("Head of department - " + findByName(name).getHead().getName());
        } catch (Exception e) {
            System.out.println(HEAD_NOT_FOUND_BY_NAME);
        }
    }

    @Override
    public int getNumberOfTask() {
        return FIND_HEAD;
    }
}
