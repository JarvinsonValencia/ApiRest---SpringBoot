package com.app.ApiRest.persistence.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BuyProductPk implements Serializable {
    private Long idBuy;
    private Long idProduct;
}
