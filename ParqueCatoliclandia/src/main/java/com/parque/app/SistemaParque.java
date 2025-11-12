/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parque.app;

import java.util.Scanner;
import java.time.LocalDate;
import com.parque.dominio.Venda;

/**
 *
 * @author MARIA EDUARDA
 */
public class SistemaParque {
     private static final double PRECO_ADULTO = 50.00;
    private static final double PRECO_CRIANCA = 30.00;
    private static final double PRECO_VIP = 150.00;
    private static final double TAXA_PADRAO = 0.10;
    private static final double TAXA_VIP = 0.15;
    
    public static void main(String[] args) {
        /*
        Utilizado o Controller, pois a classe recebe as escolhas do usuário no menu
        e delega a execução das tarefas para as classes de dominio
        */
        Scanner scanner = new Scanner(System.in);
        
        Venda vendaAtual = new Venda(LocalDate.now().toString());
        boolean continuar = true;

        System.out.println("=== Sistema de Venda de Tickets ===");
        
        while (continuar) {
            System.out.println("\nOpções:");
            System.out.println("1. Adulto (R$ " + PRECO_ADULTO + ")");
            System.out.println("2. Criança (R$ " + PRECO_CRIANCA + ")");
            System.out.println("3. VIP (R$ " + PRECO_VIP + ")");
            System.out.println("4. Finalizar Venda");
            System.out.println("5. Ver Carrinho");
            System.out.print("Escolha uma opção (1-5): ");
            
            String opcao = scanner.nextLine();
            
            switch (opcao) {
                case "1": 
                    vendaAtual.adicionarTicket("Adulto", PRECO_ADULTO, TAXA_PADRAO);
                    System.out.println("Ticket Adulto adicionado.");
                    break;
                case "2": 
                    vendaAtual.adicionarTicket("Criança", PRECO_CRIANCA, 0.00); 
                    System.out.println("Ticket Criança adicionado.");
                    break;
                case "3": 
                    vendaAtual.adicionarTicket("VIP", PRECO_VIP, TAXA_VIP);
                    System.out.println("Ticket VIP adicionado.");
                    break;
                case "4": 
                    continuar = false;
                    break;
                case "5":
                    vendaAtual.exibirCarrinho();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
        double totalVenda = vendaAtual.calcularTotal();
        
        System.out.println("\n=================================");
        System.out.println("Venda Finalizada em: " + vendaAtual.getDataVenda());
        System.out.printf("TOTAL A PAGAR: R$ %.2f\n", totalVenda);
        System.out.println("=================================");
        
        scanner.close();
    }
    
} 

