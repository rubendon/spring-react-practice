package com.spring.react.apiapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Company
{
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String code;
    @NonNull
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Industry industry;
    private Double grossProfit;
    private Double netSales;
    private Double netIncome;
    private Double totalAssets;
    private Double ownersEquity;
    private Double Dividends;
    private Double employeeCount;

}
