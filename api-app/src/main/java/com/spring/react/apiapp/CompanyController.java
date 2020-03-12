package com.spring.react.apiapp;

import com.spring.react.apiapp.model.Company;
import com.spring.react.apiapp.model.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping( "/api" )
public class CompanyController
{
    private final Logger log = LoggerFactory.getLogger( CompanyController.class );
    CompanyRepository companyRepository;

    public CompanyController( CompanyRepository companyRepository )
    {
        this.companyRepository = companyRepository;
    }

    @GetMapping( "/companies" )
    Collection<Company> companies()
    {
        return companyRepository.findAll();
    }

    @GetMapping( "/company/{id}" )
    ResponseEntity<?> getCompany( @PathVariable Long id )
    {
        Optional<Company> company = companyRepository.findById( id );
        return company.map( response -> ResponseEntity.ok().body( response ) )
                      .orElse( new ResponseEntity<>( HttpStatus.NOT_FOUND ) );
    }

    @PostMapping( "/company" )
    ResponseEntity<Company> createcompany( @Valid @RequestBody Company company, @AuthenticationPrincipal OAuth2User principal ) throws URISyntaxException
    {
        log.info( "Attempting to create new Company: {}", company );
        Company result = companyRepository.save( company );
        return ResponseEntity.created( new URI( "/api/group/" + result.getId() ) )
                             .body( result );
    }

    @PutMapping( "/company/{id}" )
    ResponseEntity<Company> updatecompany( @Valid @RequestBody Company company, @AuthenticationPrincipal OAuth2User principal ) throws URISyntaxException
    {
        log.info( "Attempting to update Company: {}", company );
        Company result = companyRepository.save( company );
        return ResponseEntity.ok().body( result );
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id){
        log.info( "Request to delete Company: {}", id );
        companyRepository.deleteById( id );
        return ResponseEntity.ok().build();
    }
}
