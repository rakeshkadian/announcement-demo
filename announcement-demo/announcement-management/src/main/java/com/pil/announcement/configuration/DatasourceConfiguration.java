/**
 * 
 */
package com.pil.announcement.configuration;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Rakesh kadian
 *
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.pil.announcement.entity" })
@EnableJpaRepositories(basePackages = { "com.pil.announcement.repository" })
@EnableTransactionManagement
@Profile("!test")
public class DatasourceConfiguration {

	/**
	 * This function is basically responsible for configuring the primary data
	 * source as it's required for data source interaction
	 * 
	 * @return
	 */
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "flyway.datasource")
	public DataSource flyWayDataSource() {
		return DataSourceBuilder.create().build();
	}

	/** Configures a flyway object 
	 * 
	 * @return
	 */
	@Bean(initMethod = "migrate")
	public Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setDataSource(flyWayDataSource());
		flyway.setSchemas("announcement_management");
		return flyway;
	}
}
