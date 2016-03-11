package net.pladema.monitoresws.app;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;

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
    
    /*
	  @Bean(name="conversionService")
	    public ConversionService getConversionService() {
	        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();    
	        Set<Converter<String,AndroidPK>> converters = new HashSet<Converter<String,AndroidPK>>();

	        //add the converter
	        converters.add(new AndroidPKConverter()); 

	        bean.setConverters(converters);
	        return bean.getObject();
	    }
*/
	}
