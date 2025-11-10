/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parque.dominio;

/**
 *
 * @author luizt
 */
// Information Expert
public class Ticket {
    private String tipo;
    private double precoBase;
    private double taxa;

    public Ticket(String tipo, double precoBase, double taxa) {
        this.tipo = tipo;
        this.precoBase = precoBase;
        this.taxa = taxa;
    }
    
    public double calcularPreco() {
        /*Utilizado no metodo calcularPreco(), que calcula o preço total com as informações
        necessarias que ele ja possui (precoBase e taxa)
        */
        return precoBase * (1 + taxa);
    }
    
    public String getTipo() { 
        return tipo; 
    }
    
    public double getPrecoBase() { 
        return precoBase; 
    }
    
    public double getTaxa() { 
        return taxa; 
    }
}
