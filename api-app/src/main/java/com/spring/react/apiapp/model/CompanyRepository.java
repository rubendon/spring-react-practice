package com.spring.react.apiapp.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>
{
    Company findByIndustry( Industry industry );

    Company findByCode( String code );

    Company findByName( String name );
}
