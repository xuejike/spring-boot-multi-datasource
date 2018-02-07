package vip.xuejike.spring.boot.multidatasource.demo.core;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.support.ClasspathScanningPersistenceUnitPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class MultiDataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.db1")
    public DataSource dataSource(){
//        AtomikosDataSourceBean sourceBean = new AtomikosDataSourceBean();
////        sourceBean.setXaDataSource();
//        new DruidXADataSource()
        return DruidDataSourceBuilder.create().build();
    }


    @Bean("entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setDataSource(dataSource());


        ClasspathScanningPersistenceUnitPostProcessor postProcesso =
                new ClasspathScanningPersistenceUnitPostProcessor("vip.xuejike.spring.boot.multidatasource.demo.db1");
        factoryBean.setPersistenceUnitPostProcessors(postProcesso);
        return factoryBean;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory().getObject());
        return transactionManager;
//        transactionManager.setEntityManagerFactory();

    }


    @Bean
    @ConfigurationProperties("spring.datasource.druid.db2")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }





    @Bean("twoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean twoEntityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setDataSource(dataSourceTwo());
        factoryBean.setPackagesToScan("vip.xuejike.spring.boot.multidatasource.demo.db2");
        ClasspathScanningPersistenceUnitPostProcessor postProcesso = new ClasspathScanningPersistenceUnitPostProcessor("vip.xuejike.spring.boot.multidatasource.demo.db2");
        factoryBean.setPersistenceUnitPostProcessors(postProcesso);
        return factoryBean;
    }

    @Bean("twoTransactionManager")
    public PlatformTransactionManager twoTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager(twoEntityManagerFactory().getObject());
        return transactionManager;

    }




}
