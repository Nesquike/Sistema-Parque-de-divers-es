/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parque.dominio;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author luizt
 */

//Information Expert e Creator
public class Venda {
    private List<Ticket> tickets;
    private String dataVenda;

    public Venda(String dataVenda) {
        this.tickets = new ArrayList<>();
        this.dataVenda = dataVenda;
    }

    public Ticket adicionarTicket(String tipo, double precoBase, double taxa) {
        /*
        Utilizado o padrão Creator, pois a classe venda
        é responsável por criar as instâncias de Ticket, pois ela contém esses objetos em sua lista
        */
        Ticket novoTicket = new Ticket(tipo, precoBase, taxa);
        this.tickets.add(novoTicket);
        return novoTicket;
    }
    
    public double calcularTotal() {
        /*
        Utilizado o padrão Information Expert, 
        detém a informação agregada (a lista de Tickets) e,
        portanto, é a especialista para calcular o total da transação e exibir seus itens
        */
        double total = 0.0;
        for (Ticket t : tickets) {
            total += t.calcularPreco();
        }
        return total;
    }
    
    private double calcularTotalSemTaxa() {
        double total = 0.0;
        for (Ticket t : tickets) {
            total += t.getPrecoBase();
        }
        return total;
    }

    public void exibirCarrinho() {
        /*
        Também é utilizado o padrão Information Expert pelos mesmos motivos
        */
        System.out.println("\n--- ITENS NO CARRINHO ---");
        if (tickets.isEmpty()) {
            System.out.println("O carrinho está vazio.");
            return;
        }
        
        System.out.println("ÍTENS ADICIONADOS:");
        int i = 1;
        for (Ticket t : tickets) {
            System.out.printf("  %d. %s (R$ %.2f base + %.0f%% taxa) -> Preço Final: R$ %.2f\n", 
                                i++, 
                                t.getTipo(), 
                                t.getPrecoBase(), 
                                t.getTaxa() * 100, 
                                t.calcularPreco()); 
        }
        
        System.out.printf("\nSUBTOTAL (apenas bases): R$ %.2f\n", calcularTotalSemTaxa());
        System.out.printf("TOTAL GERAL: R$ %.2f\n", calcularTotal());
        System.out.println("-------------------------");
    }

    public List<Ticket> getTickets() { 
        return tickets; 
    }
    
    public String getDataVenda() { 
        return dataVenda; 
    }
}
