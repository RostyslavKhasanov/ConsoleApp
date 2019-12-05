package rostyslavkhasanov.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rostyslavkhasanov.repository.DepartmentRepository;
import rostyslavkhasanov.repository.LectorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackageClasses = {DepartmentRepository.class, LectorRepository.class})
@EnableTransactionManagement
@Configuration
public class JpaConfig {

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("primary");
    }

    @Bean(name = "entityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }
}
