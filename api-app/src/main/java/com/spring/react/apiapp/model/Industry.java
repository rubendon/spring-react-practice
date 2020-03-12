package com.spring.react.apiapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Industry
{
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String code;
    private String description;
}
