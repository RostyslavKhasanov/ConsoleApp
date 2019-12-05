package rostyslavkhasanov.service.lector_service;

import java.util.List;
import rostyslavkhasanov.entity.Lector;

public interface LectorsStatisticService {
    List<Lector> getDepartmentStatistic(String name);
}
