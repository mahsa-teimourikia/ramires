/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimi.thesis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


/**
 * The Configuration annotation identifies it to Spring as a configuration class.
 */ 
@Configuration
/**
 * The ComponentScan and EnableWebMVC are required for Spring to find and 
 * configure all annotated classes. Spring will search for annotations on classes 
 * specified in the value parameter that is passed to ComponentScan i.e “polimi.thesis”. 
 */
@ComponentScan("polimi.thesis")
@EnableWebMvc

/**
 * extending WebMvcConfigurerAdapter is necessary in this case to allow ‘resources’ 
 * (images, JavaScript, CSS etc.) to be included in the project. 
 * To that end the addResourceHandlers() method is overridden. In ‘addResourceHandlers()’ 
 * an instruction to Spring is given that when it sees a URL beginning with “resources/**”,
 * let it through and search the actual location “/WEB-INF/resources/*” for the resource 
 * (multiple locations can be specified in the addResourceLocations(…) method).
 */
public class Config extends WebMvcConfigurerAdapter{
    
    @Bean
    public UrlBasedViewResolver setupViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
    }
    
}
