package com.example.demospringboot.democrudapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "order_name")
    private String name;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "order_total")
    private double total;
    private int quantity;
    private String status;
    //Many-to-one relationship with customer entity
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonIgnoreProperties("orders")
    private Customer customer;

    //Many-to-many relationship with book entity
    @ManyToMany(mappedBy = "orderList", fetch = FetchType.LAZY) //(default) lazy load -> incarcarea relatiei nu se va face imediat ci doar atunci cand e nevoie de ea,entitatile asociate sunt incarcate doar atunci cand sunt accesate prima data
    @JsonIgnoreProperties("orderList")
    private List<Book> bookList;                              // eager load -> toate entitatile asociate sunt incarcate din baza de date simultan

}
