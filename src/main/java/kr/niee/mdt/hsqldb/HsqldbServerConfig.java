/*
package kr.niee.mdt.hsqldb;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HsqldbServerConfig {

	 *  <!-- HSQLDB STARTER -->
     <bean id="hsqldb" class="com.syaku.hsqldb.HSQLDB" init-method="start">
          <constructor-arg>
               <value>
               server.database.0 = file:/Users/syaku/develop/spring/hsqldb/syaku
               server.dbname.0 = syaku
               server.remote_open = true
               server.port = 9002
               hsqldb.reconfig_logging = false
               </value>
          </constructor-arg>
     </bean>
	 * */
	
	/*@Bean(initMethod="start",destroyMethod="stop")
	public HsqldbAutoStartService hsqldbAutoStartService(){
		Properties properties = new Properties();
		properties.setProperty("server.database.0", "D:/hsqldb");
		properties.setProperty("server.dbname.0", "scheduler");
		properties.setProperty("server.remote_open", "true");
		properties.setProperty("server.port", "6001");
		properties.setProperty("hsqldb.reconfig_logging", "false");
		return new HsqldbAutoStartService(properties);
	
}

	}*/