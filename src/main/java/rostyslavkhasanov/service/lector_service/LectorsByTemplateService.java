package rostyslavkhasanov.service.lector_service;

import java.util.List;
import rostyslavkhasanov.entity.Lector;

public interface LectorsByTemplateService {
    List<Lector> globalSearch(String template);
}
