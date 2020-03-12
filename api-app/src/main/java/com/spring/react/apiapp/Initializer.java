package com.spring.react.apiapp;

import com.spring.react.apiapp.model.Company;
import com.spring.react.apiapp.model.CompanyRepository;
import com.spring.react.apiapp.model.Industry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner
{
    private final CompanyRepository repository;

    public Initializer( CompanyRepository repository )
    {
        this.repository = repository;
    }

    @Override
    public void run( String... args ) throws Exception
    {
        repository.save( new Company( "MSFT", "Microsoft" ) );
        repository.save( new Company( "GOOGL", "Google" ) );
        repository.save( new Company( "AMZN", "Amazon" ) );

        Company company = repository.findByName( "Microsoft" );
        company.setIndustry( new Industry( "TECH" ) );
        repository.save( company );

        repository.findAll().forEach( System.out::println );
    }
}
