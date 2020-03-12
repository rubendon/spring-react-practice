package com.spring.react.apiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses= CompanyController.class)
@SpringBootApplication
public class ApiAppApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( ApiAppApplication.class, args );
    }

}
