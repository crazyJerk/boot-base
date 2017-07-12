package com.boot.common.configutation;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by lisu on 2017/5/18.
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfig {
    @Autowired
    private DruidProperties properties;

    /**
     * 配置数据库(数据源使用alibaba的druid)
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setValidationQuery(properties.getValidationQuery());
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        return dataSource;
    }
}
