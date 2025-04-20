package com.jinelei.numbfish.device;

import com.jinelei.numbfish.acquisition.configuration.annotation.EnableInfluxService;
import com.jinelei.numbfish.common.helper.SpringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SuppressWarnings("unused")
@Import(SpringHelper.class)
@EnableInfluxService
@SpringBootApplication(scanBasePackageClasses = {NumbfishDeviceClientApplication.class})
public class NumbfishDeviceClientApplication {
    private static final Logger log = LoggerFactory.getLogger(NumbfishDeviceClientApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext run = SpringApplication.run(NumbfishDeviceClientApplication.class, args);
        Environment env = run.getEnvironment();
        log.info("""
                        
                        ----------------------------------------------------------
                        \t\
                        Application '{}' is running!
                        \t\
                        Local: \t\thttp://localhost:{}
                        \t\
                        External: \thttp://{}:{}
                        \t\
                        Doc: \t\thttp://{}:{}/doc.html
                        ----------------------------------------------------------""",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

}
