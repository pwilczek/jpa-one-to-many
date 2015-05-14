package name.wilu.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        pool.setDriverClass("org.firebirdsql.jdbc.FBDriver");
        pool.setJdbcUrl("jdbc:firebirdsql:localhost/3050:test");
        pool.setUser("sysdba");
        pool.setPassword("masterkey");
        pool.setMinPoolSize(5);
        pool.setAcquireIncrement(5);
        pool.setMaxPoolSize(20);
        return pool;
    }
}
