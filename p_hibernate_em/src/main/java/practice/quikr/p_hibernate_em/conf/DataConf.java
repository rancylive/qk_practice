package practice.quikr.p_hibernate_em.conf;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:dev.db.properties")
@EnableTransactionManagement
public class DataConf {

	@Autowired
	private Environment environment;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataConf.class);
	
	@Bean
	public EntityManagerFactory c2cEntityManagerFactory() throws Exception {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        //db.default.show_sql=true
        boolean hasShowSql = true;
        try {
          hasShowSql = Boolean.valueOf(environment.getProperty("db.default.show_sql"));
        }
        catch(Exception e) {
          LOGGER.error("Error occured whhile reading sql queries"+e.getMessage());
        }
        vendorAdapter.setShowSql(hasShowSql);
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("practice.quikr");
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setDataSource(getDataSource());
        entityManagerFactory.setJpaPropertyMap(new HashMap<String, String>(){{
            put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        }});
        entityManagerFactory.afterPropertiesSet();
        System.out.println("c2cEntityManagerFactory "+entityManagerFactory.getObject());
        return entityManagerFactory.getObject();
	}
	
	private DataSource getDataSource() throws Exception {
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
    @Qualifier("escrow_c2c")
    public PlatformTransactionManager c2cTransactionManager() throws Exception{
        JpaTransactionManager transactionManager = new JpaTransactionManager(c2cEntityManagerFactory());
        transactionManager.setDefaultTimeout(Integer.valueOf(environment.getProperty("db.c2c.queryTimeout")));
        return transactionManager;
    }
}
