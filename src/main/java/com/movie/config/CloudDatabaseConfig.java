//package com.movie.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class CloudDatabaseConfig {
//
//    @Bean
//    public DataSource dataSource(@Value("${spring.datasource.url}") final String url,
//                                 @Value("${spring.datasource.username}") final String user,
//                                 @Value("${spring.datasource.password}") final String password) {
//
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(url);
//        hikariConfig.setUsername(user);
//        hikariConfig.setPassword(password);
//        hikariConfig.setDriverClassName("com.sap.db.jdbc.Driver");
//        hikariConfig.setMaximumPoolSize(10);
//        hikariConfig.setMinimumIdle(2);
//        hikariConfig.setIdleTimeout(30000);
//
//        return new HikariDataSource(hikariConfig);
//    }
//}
