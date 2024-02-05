package com.app.ApiRest.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "buy_product")
@AllArgsConstructor
@NoArgsConstructor
public class BuyProduct implements Serializable {
    @EmbeddedId
    private BuyProductPk id;
    private Integer quantity;
    private Double total;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "idBuy", insertable = false, updatable = false)
    private Buys buy;
    @ManyToOne
    @JoinColumn(name = "idProduct", insertable = false, updatable = false)
    private Product product;
}
