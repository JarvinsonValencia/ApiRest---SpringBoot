package com.app.ApiRest.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "buys")
@AllArgsConstructor
@NoArgsConstructor
public class Buys implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBuy;
    //private Long idClient;
    private LocalTime date;
    private String paymentMethod;
    private String comment;
    private String status;
    @ManyToOne
    @JoinColumn(name = "idClient", insertable = false, updatable = false)
    public Client client;

    @OneToMany(mappedBy = "buy")
    private List<BuyProduct> products;

}
