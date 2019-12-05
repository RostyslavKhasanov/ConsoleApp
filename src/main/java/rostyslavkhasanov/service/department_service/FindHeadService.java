package rostyslavkhasanov.service.department_service;

import rostyslavkhasanov.entity.Department;

public interface FindHeadService {
    Department findByName(String name);
}
