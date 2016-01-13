package kr.niee.mdt.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Profile("real")
public class SpringDataSourceConfigForReal{

/*
 * <property name="driverClassName" value="org.hsqldb.jdbcDriver" />
    <property name="url" value="jdbc:hsqldb:mem:mydb" />
    <property name="username" value="sa" />
    <property name="password" value="" />
    <property name="initialSize" value="5" />
    <property name="maxActive" value="10" />
    <property name="poolPreparedStatements" value="true" />
    <property name="maxOpenPreparedStatements" value="10" />
 */
	
	/*@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("classpath:kr/niee/mdt/web/resources/query/schema/schema.sql")
            .addScript("classpath:kr/niee/mdt/web/resources/query/data/test-data.sql")
            .build();
    }*/
	/*
	 *  <property name="driverClassName" value="org.hsqldb.jdbcDriver" />
          <property name="url" value="jdbc:hsqldb:hsql://localhost:9002/syaku" />
          <property name="username" value="sa" />
          <property name="password" value="" />
	 * */
	@Bean(destroyMethod="close")
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		//dataSource.setUrl("jdbc:hsqldb:hsql://localhost:6001/scheduler");
		dataSource.setUrl("jdbc:hsqldb:file:./hsqldb/scheduler;hsqldb.cache_rows=100;hsqldb.nio_data_file=false");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		//dataSource.setValidationQuery("select 1 from dual");
		dataSource.setInitialSize(5);
		dataSource.setMaxActive(10);
		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxOpenPreparedStatements(10);
		dataSource.setValidationQueryTimeout(60);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(60000);
		return dataSource;
	}
	
	@Bean
	@Qualifier("dataSource")
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
	    ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
	    databasePopulator.addScript(new ClassPathResource("query/schema/schema.sql"));
	    databasePopulator.setIgnoreFailedDrops(true);
	    databasePopulator.setSqlScriptEncoding("UTF-8");
	    databasePopulator.setContinueOnError(true);

	    DataSourceInitializer initializer = new DataSourceInitializer();
	    initializer.setDataSource(dataSource);
	    initializer.setDatabasePopulator(databasePopulator);

	    return initializer;
	}
	
	/*
	 * <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation" value="classpath:sqlmap/mybatis.xml" />
		<property name="mapperLocations" value="classpath:sqlmap/*.xml" />
	</bean>
	 */
	
	/*@Bean
	public SqlSessionFactoryBean sqlSessionFactory(){
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation("classpath:sqlmap/mybatis.xml");
	}*/
	
	/*
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" ref="sqlSessionFactory" />
	</bean>
	 * */
	@Bean
	@Qualifier("dataSource")
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
	/*
	 *  <bean id="transactionManager"
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource" />
    </bean>
	 * */
	
	@Bean
	@Qualifier("dataSource")
	public DataSourceTransactionManager transactionManager(DataSource dataSource){
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		return transactionManager;
	}
	
	/*
	 * <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
     <property name="dataSource" ref="dataSource" />
     </bean>

     <tx:advice id="txAdvice" transaction-manager="transactionManager">
     <tx:attributes>
     <tx:method name="get*" read-only="true" />
     <tx:method name="insert*" />
     <tx:method name="update*" />
     <tx:method name="delete*" />
     </tx:attributes>
     </tx:advice>

     <aop:config>
     <aop:pointcut id="transactionPointcut" expression="execution(* com.syaku.hsqldb.TestDao*.*(..))"/>
     <aop:advisor advice-ref="txAdvice" pointcut-ref="transactionPointcut" />
     </aop:config>
	 * */
}
