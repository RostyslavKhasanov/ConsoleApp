package rostyslavkhasanov.service.lector_service.lector_service_impl;

import static rostyslavkhasanov.constants.Constants.SEARCH_BY;
import static rostyslavkhasanov.constants.RequestSender.GLOBAL_SEARCH;

import java.util.List;
import java.util.Scanner;
import rostyslavkhasanov.TaskExecutor;
import rostyslavkhasanov.entity.Lector;
import rostyslavkhasanov.repository.LectorRepository;
import rostyslavkhasanov.service.lector_service.LectorsByTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LectorsTemplateServiceImpl implements LectorsByTemplateService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private LectorRepository repo;

    @Override
    public List<Lector> globalSearch(String template) {
        return repo.globalSearch(template);
    }

    @Override
    public void execute() {
        System.out.println(SEARCH_BY);
        String template = SC.nextLine();
        List<Lector> lectors = globalSearch(template);
        lectors.forEach(l -> System.out.println(l.getName()));
    }

    @Override
    public int getNumberOfTask() {
        return GLOBAL_SEARCH;
    }
}
