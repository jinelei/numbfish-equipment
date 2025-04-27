package com.jinelei.numbfish.device;

import com.jinelei.numbfish.acquisition.configuration.annotation.EnableInfluxService;
import com.jinelei.numbfish.common.helper.SpringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SuppressWarnings("unused")
@Import(SpringHelper.class)
@EnableInfluxService
@SpringBootApplication(scanBasePackageClasses = {NumbfishDeviceApplication.class}, exclude = {SecurityAutoConfiguration.class})
public class NumbfishDeviceApplication {
    private static final Logger log = LoggerFactory.getLogger(NumbfishDeviceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NumbfishDeviceApplication.class, args);
    }

}
