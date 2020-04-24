package com.anita.jwt.security;
/*package com.javainuse.config;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;


@Configuration
public class TomcatHTTPSecurity {
	
	   @Bean
	    public ConfigurableServletWebServerFactory webServerFactory() {
		   TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		   factory.addAdditionalTomcatConnectors(initiateHttpConnector());
		   factory.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/unauthenticated"));
	        return factory;
	    }



private Connector initiateHttpConnector() {
Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
connector.setScheme("http");
connector.setPort(8080);
connector.setSecure(false);
connector.setRedirectPort(8443);

return connector;
}
}
*/