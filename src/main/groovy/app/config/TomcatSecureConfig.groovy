package app.config

import org.apache.catalina.connector.Connector
import org.apache.coyote.http11.Http11Nio2Protocol
import org.apache.coyote.http11.Http11NioProtocol
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.util.ResourceUtils

/**
 * Configure two Tomcat connectors, 8080/http and 8443/https.
 * By default, Spring Security will redirect 8080->8443
 *
 */

//@Configuration
//@Profile("ssl")
class TomcatSecureConfig {

    //@Bean
    TomcatServletWebServerFactory servletContainer() throws FileNotFoundException {
        TomcatServletWebServerFactory f = new TomcatServletWebServerFactory();
        f.addAdditionalTomcatConnectors(createSslConnector());
        return f;
    }

    private Connector createSslConnector() throws FileNotFoundException {
        Connector connector = new Connector(Http11NioProtocol.class.getName());
        //Http11NioProtocol protocol =  (Http11NioProtocol)connector.getProtocolHandler();
        Http11Nio2Protocol protocol =  (Http11Nio2Protocol)connector.getProtocolHandler();
        connector.setPort(8443);
        connector.setSecure(true);
        connector.setScheme("https");
        protocol.setSSLEnabled(true);
        protocol.setKeyAlias("springagram");
        protocol.setKeystorePass("password");
        protocol.setKeystoreFile(ResourceUtils.getFile("src/main/resources/keystore.jks").getAbsolutePath());
        protocol.setSslProtocol("TLS");
        return connector;
    }

}
