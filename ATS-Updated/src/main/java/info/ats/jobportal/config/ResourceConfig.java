package info.ats.jobportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WiebMvcConfgurer {
	
public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/uploads/**").addResourceLocations("resourceLocations");
	
	
}

}
