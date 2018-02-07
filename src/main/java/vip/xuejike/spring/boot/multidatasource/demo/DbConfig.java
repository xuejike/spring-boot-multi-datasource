package vip.xuejike.spring.boot.multidatasource.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import vip.xuejike.spring.boot.multidatasource.demo.core.MultiDataSourceConfig;

@Configuration
@EnableJpaRepositories(basePackages = "vip.xuejike.spring.boot.multidatasource.demo.db2",
        entityManagerFactoryRef = "twoEntityManagerFactory",
        transactionManagerRef = "twoTransactionManager")
public class DbConfig {

}
