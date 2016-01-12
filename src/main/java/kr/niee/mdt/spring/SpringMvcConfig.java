package kr.niee.mdt.spring;

import java.util.ArrayList;
import java.util.List;

import kr.niee.mdt.config.CorsInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages={"kr.niee.mdt"})
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

	@Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		super.addArgumentResolvers(argumentResolvers);
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		super.addFormatters(registry);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(corsInterceptor());
	}
	
	@Bean
	public CorsInterceptor corsInterceptor(){
		return new CorsInterceptor();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addReturnValueHandlers(
			List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		super.addReturnValueHandlers(returnValueHandlers);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		super.addViewControllers(registry);
	}
	
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureAsyncSupport(configurer);
	}
	
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureContentNegotiation(configurer);
	}
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
	}
	
	@Override
	public void configureHandlerExceptionResolvers(
			List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}
	
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		/*
		 <mvc:message-converters>
			<bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
		        <property name="supportedMediaTypes">
		            <list>
		                <value>text/plain;charset=UTF-8</value>
		                <value>application/json;charset=UTF-8</value>
		            </list>
		        </property>
		    </bean>
		</mvc:message-converters>
		 */
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.TEXT_PLAIN);
		mediaTypes.add(MediaType.APPLICATION_JSON);
		jackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
		converters.add(jackson2HttpMessageConverter);
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configurePathMatch(configurer);
	}
	
	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return super.getMessageCodesResolver();
	}
	
	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return super.getValidator();
	}
}
