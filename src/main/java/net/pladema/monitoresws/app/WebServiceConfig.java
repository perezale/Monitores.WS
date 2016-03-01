package net.pladema.monitoresws.app;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.xml.xsd.SimpleXsdSchema;

import net.pladema.monitoresws.soap.MyWsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);		
		servlet.setTransformWsdlLocations(true);		
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "WebService")
	public MyWsdl11Definition defaultWsdl11Definition(SimpleXsdSchema legacySoapOp) {
		MyWsdl11Definition wsdl11Definition = new MyWsdl11Definition();
		wsdl11Definition.setPortTypeName("WebServiceHttpEndpoint");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://ws.monitors.com");		
		wsdl11Definition.setSchema(legacySoapOp);		
		wsdl11Definition.setRequestSuffix("");
		return wsdl11Definition;
	}
	
	@Bean
	public SimpleXsdSchema legacySoapOp() {
		return new SimpleXsdSchema(new ClassPathResource("legacySoapOp.xsd"));
	}
	
	@Bean
	public SimpleXsdSchema legacySoap() {
		return new SimpleXsdSchema(new ClassPathResource("legacySoap.xsd"));
	}
	
}