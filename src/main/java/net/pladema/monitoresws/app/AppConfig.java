package net.pladema.monitoresws.app;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;

import net.pladema.monitoresws.app.converters.AndroidPKConverter;

@Configuration
public class AppConfig {
	
    @Resource(name = "defaultConversionService")
    private GenericConversionService genericConversionService;
    
    @Bean
    public AndroidPKConverter string2androidPkConverter(){
    	AndroidPKConverter androidPKConverter = new AndroidPKConverter();
        genericConversionService.addConverter(androidPKConverter);
        return androidPKConverter;
    }
       
}
