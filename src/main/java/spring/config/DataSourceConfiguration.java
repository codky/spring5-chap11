package spring.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import spring.util.SimpleCrypto;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DataSourceConfiguration implements TransactionManagementConfigurer {

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriverClassName;

    @Value("${spring.datasource.url}")
    private String dbURL;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    private String key = "nexgrid";

    @Bean
    public DataSource dataSource() throws Exception {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(dbDriverClassName);
        dataSource.setJdbcUrl(dbURL);
        dataSource.setUsername(SimpleCrypto.decrypt(key,userName));
        dataSource.setPassword(SimpleCrypto.decrypt(key,password));

        return dataSource;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return null;
    }
}
