package org.formation.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc // on active les fonctionnalit�s Web de Spring
@Configuration
@ComponentScan(basePackages = { "org.formation.spring" })
@Import({ ApplicationConfig.class })
@PropertySource("classpath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

	// On configure la servlet de dispatch (qui utilise beaucoup d'objets, de type
	// ResourceHandler, etc.)
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// Relayer les requ�tes provenant d'un autre type
		registry.addMapping("/**"); // ** nom + extension
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		// Machine � chercher les vues
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	// Cas sp�ciaux (le reste est configur� par convention)
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// Spring �crase ce comportement par d�faut de Tomcat ; on le remet donc ici
		registry.addViewController("/").setViewName("index");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
