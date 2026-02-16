package com.valora.test.dbbundlecontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.valora.test.dbbundlecontrol.entity")
@EnableJpaRepositories("com.valora.test.dbbundlecontrol.repository")
public class DbBundleControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbBundleControlApplication.class, args);
    }

}
