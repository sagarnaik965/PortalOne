package in.cdac.dbswitch;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = "classpath:/datasources.properties")
public class DataSourceProperties {
	
	private final static Logger logger = Logger.getLogger(DataSourceProperties.class);
	
	@Autowired
	Environment env;

		    
	    @Bean
	    @Qualifier("test_ds")
	    public DataSource tenantTest() {

	    	logger.info("creating Test dataSources....");
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getProperty("ds.driver1"));
	        dataSource.setUrl(env.getProperty("ds.url1"));
	        dataSource.setUsername(env.getProperty("ds.username1"));
	        dataSource.setPassword(env.getProperty("ds.password1"));
	        logger.info("Test datasource created "+dataSource);
	        return dataSource;
	    		 
	    }

	    @Bean
	    @Qualifier("preproduction_ds")
	    public DataSource tenantPreProduction() {

	    	logger.info("creating PreProduction dataSources ....");
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getProperty("ds.driver2"));
	        dataSource.setUrl(env.getProperty("ds.url2"));
	        dataSource.setUsername(env.getProperty("ds.username2"));
	        dataSource.setPassword(env.getProperty("ds.password2"));
	        logger.info("Test PreProduction created "+dataSource);
	        return dataSource;
	    }
	    
	    
	    @Bean
	    @Qualifier("production_ds")
	    public DataSource tenantProduction() {

	    	logger.info("creating Production dataSources ....");
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getProperty("ds.driver3"));
	        dataSource.setUrl(env.getProperty("ds.url3"));
	        dataSource.setUsername(env.getProperty("ds.username3"));
	        dataSource.setPassword(env.getProperty("ds.password3"));
	        logger.info("Test Production created "+dataSource);
	        return dataSource;
	    }
	
}
