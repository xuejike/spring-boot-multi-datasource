package vip.xuejike.spring.boot.multidatasource.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.util.Map;

@SpringBootApplication
@EnableJpaRepositories("vip.xuejike.spring.boot.multidatasource.demo.db1")
public class MultiDatasourceApplication {


	public static void main(String[] args) {
		SpringApplication.run(MultiDatasourceApplication.class, args);
	}

	@EventListener(ContextRefreshedEvent.class)
	public void lf(ContextRefreshedEvent event){
		Map<String, DataSource> map = event.getApplicationContext().getBeansOfType(DataSource.class);
	}
}
