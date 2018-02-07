package vip.xuejike.spring.boot.multidatasource.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;

import java.util.Map;

@Getter
@Setter
public class DataSourcePropery {
    private String url;
    private String name;
    private String username;
    private String password;
    private String driverClassName;
    private String dataSource= "org.apache.tomcat.jdbc.pool.DataSource";
    private String[] scanPackage;
    private Map<String,Object> dataSourceProperty;
    private JpaProperties jpaProperty;


}
