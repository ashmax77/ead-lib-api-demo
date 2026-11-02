package edu.example.library_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank; 
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.RequiredArgsConstructor; 

@Entity 
@RequiredArgsConstructor 
@Data 
public class Book {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
  
    @NotBlank 
    private String title; 
  
    @NotBlank 
    private String author; 
  
    private String isbn; 
  
    @PositiveOrZero 
    private Double price;
}
