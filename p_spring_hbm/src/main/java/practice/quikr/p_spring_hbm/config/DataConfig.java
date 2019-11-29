package practice.quikr.p_spring_hbm.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class DataConfig {

	@Autowired
	private Environment environment;
	/*
	@Bean
    public EntityManagerFactory c2cEntityManagerFactory() throws Exception{
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        //db.default.show_sql=true
        boolean hasShowSql = true;
        vendorAdapter.setShowSql(hasShowSql);
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("com.quikr");
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setDataSource(c2cDataSource());
        entityManagerFactory.setJpaPropertyMap(new HashMap<String, String>(){{
            put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        }});
        entityManagerFactory.afterPropertiesSet();
        System.out.println("c2cEntityManagerFactory "+entityManagerFactory.getObject());
        return entityManagerFactory.getObject();
    }
	
	@Bean
    public DataSource c2cDataSource() throws Exception{
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try{
          dataSource.setDriverClass(environment.getProperty("db.default.driver"));
          dataSource.setJdbcUrl(environment.getProperty("db.c2c.url"));
          dataSource.setUser(environment.getProperty("db.c2c.user"));
          dataSource.setPassword(environment.getProperty("db.c2c.password"));
          dataSource.setInitialPoolSize(Integer.valueOf(environment.getProperty("db.c2c.initialPoolSize")));
          dataSource.setMinPoolSize(Integer.valueOf(environment.getProperty("db.c2c.minPoolSize")));
          dataSource.setMaxPoolSize(Integer.valueOf(environment.getProperty("db.c2c.maxPoolSize")));
          dataSource.setMaxIdleTime(Integer.valueOf(environment.getProperty("db.c2c.maxIdleTime")));
          dataSource.setAcquireIncrement(Integer.valueOf(environment.getProperty("db.c2c.acquireIncrement")));
          dataSource.setCheckoutTimeout(Integer.valueOf(environment.getProperty("db.c2c.checkoutTimeout")));
          dataSource.setMaxStatements(Integer.valueOf(environment.getProperty("db.c2c.maxStatements")));
          dataSource.setAcquireRetryAttempts(Integer.valueOf(environment.getProperty("db.c2c.acquireRetryAttempts")));
          dataSource.setAcquireRetryDelay(Integer.valueOf(environment.getProperty("db.c2c.acquireRetryDelay")));
          dataSource.setIdleConnectionTestPeriod(Integer.valueOf(environment.getProperty("db.c2c.idleConnectionTestPeriod")));
          dataSource.setTestConnectionOnCheckin(Boolean.valueOf(environment.getProperty("db.c2c.testConnectionOnCheckin")));
          dataSource.setPreferredTestQuery(environment.getProperty("db.c2c.preferredTestQuery"));
        } catch (Exception e){
          System.out.println("Exception while creating c2cDataSource : " +  e.getStackTrace());
          throw e;
        }
        return dataSource;
    }
	

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        boolean hasShowSql = true;
        
        vendorAdapter.setShowSql(hasShowSql);
        
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("models");
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaPropertyMap(new HashMap<String, String>(){{
            put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        }});
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

    @Bean
    @Qualifier("escrow")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());

        return transactionManager;
    }
    
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.default.driver"));
        dataSource.setUrl(environment.getProperty("db.default.url"));
        dataSource.setUsername(environment.getProperty("db.default.user"));
        dataSource.setPassword(environment.getProperty("db.default.password"));
        return dataSource;
    }
    */

    @Bean(name = "h2Data")
    public EntityManagerFactory h2EMF() throws Exception{
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("org.h2.Driver");
            dataSource.setJdbcUrl("jdbc:h2:mem:test");
            dataSource.setUser("sa");
            dataSource.setPassword("");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("models.c2c");
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaPropertyMap(new HashMap<String, String>(){{
            put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        }});
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

}
