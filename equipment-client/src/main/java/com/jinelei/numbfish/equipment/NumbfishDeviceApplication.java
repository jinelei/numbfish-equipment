package com.jinelei.numbfish.equipment;

import com.jinelei.numbfish.acquisition.configuration.annotation.EnableInfluxService;
import com.jinelei.numbfish.common.helper.SpringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SuppressWarnings("unused")
@Import({SpringHelper.class})
@EnableInfluxService
@SpringBootApplication(scanBasePackageClasses = {NumbfishEquipmentApplication.class})
public class NumbfishEquipmentApplication {
    private static final Logger log = LoggerFactory.getLogger(NumbfishEquipmentApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NumbfishEquipmentApplication.class, args);
    }

}
