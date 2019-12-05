package rostyslavkhasanov.service.lector_service.lector_service_impl;

import static rostyslavkhasanov.constants.Constants.DEPARTMENT_NAME;
import static rostyslavkhasanov.constants.RequestSender.EMPLOYEE_STATISTIC;

import java.util.List;
import java.util.Scanner;
import rostyslavkhasanov.TaskExecutor;
import rostyslavkhasanov.entity.Lector;
import rostyslavkhasanov.entity.enums.Degree;
import rostyslavkhasanov.repository.LectorRepository;
import rostyslavkhasanov.service.lector_service.LectorsStatisticService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LectorsStatisticServiceImpl implements LectorsStatisticService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private LectorRepository repo;

    @Override
    public void execute() {
        System.out.println(DEPARTMENT_NAME);
        String name = SC.nextLine();
        int countAssistants = 0;
        int countAssociateProfessors = 0;
        int countProfessors = 0;

        List<Lector> lectors = getDepartmentStatistic(name);
        for (Lector lector : lectors) {
            if (lector.getDegree().equals(Degree.ASSISTANT)) {
                countAssistants++;
            } else if (lector.getDegree().equals(Degree.ASSOCIATE_PROFESSOR)) {
                countAssociateProfessors++;
            } else if (lector.getDegree().equals(Degree.PROFESSOR)) {
                countProfessors++;
            }
        };

        System.out.println("Assistance - " + countAssistants);
        System.out.println("Associate professors - " + countAssociateProfessors);
        System.out.println("Professors - " + countProfessors);
    }

    @Override
    public int getNumberOfTask() {
        return EMPLOYEE_STATISTIC;
    }

    @Override
    public List<Lector> getDepartmentStatistic(String name) {
        return repo.getAllByDepartmentName(name);
    }
}
