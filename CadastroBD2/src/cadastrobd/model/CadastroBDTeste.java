/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

import cadastro.model.util.PessoaFisicaDAO;
import cadastro.model.util.PessoaJuridicaDAO;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author naote
 */
public class CadastroBDTeste {
    public static void main(String[] args) {
        
        PessoaFisicaDAO persF= new PessoaFisicaDAO();
        PessoaJuridicaDAO persJ= new PessoaJuridicaDAO();
        Scanner scan = new Scanner(System.in);
        
        //PessoaFisica p1 = new PessoaFisica(1,"Alan","Rua Carandiru 300","Rio de Janeiro","RJ","1010-1010","Alan@gmail.com","1010101010");
        //persF.incluir(p1);
        //PessoaFisica p2 = new PessoaFisica(1,"Alan","Rua Carandiru 120","Rio de Janeiro","RJ","2010-4010","Alan@gmail.com","1010101010");
        //persF.alterar(p2);
        //persF.getPessoas();
        //persF.excluir(1);
        
        //PessoaJuridica p3 = new PessoaJuridica(10,"JDBC","Rua Antares 3000","Rio de Janeiro","RJ","2030-4050","JDBC@ltda.com","101010101010");
        //PessoaJuridica p4 = new PessoaJuridica(10,"JDBC","Rua Antares 400","Rio de Janeiro","RJ","2050-4050","JDBC@ltda.com","101010101010");
        //persJ.incluir(p3);
        //persJ.alterar(p4);
        //persJ.getPessoas();
        //persJ.excluir(10);
        
        System.out.println("========================");
            System.out.printf("1 - Incluir Pessoa%n"
                        + "2 - Alterar Pessoa%n"
                        + "3 - Excluir Pessoa%n"
                        + "4 - Buscar pelo ID%n"
                        + "5 - Exibir Todos%n"
                        + "0 - Finalizar Programa%n");
            System.out.println("========================");
            int n1 = scan.nextInt();
            
            switch (n1){
                case 1 -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    scan.nextLine();
                    String s1 = scan.nextLine();
                    
                
                    switch(s1){
                        case "F" ->{
                            System.out.println("Insira os Dados...");
                            System.out.println("Digite o Id da Pessoa:");
                            int n2 = scan.nextInt();
                               
                            System.out.println("Nome:");
                            scan.nextLine();
                            String s2 = scan.nextLine();
                        
                            System.out.println("Logradouro:");
                            String s3 = scan.nextLine();
                        
                            System.out.println("Cidade:");
                            String s4 = scan.nextLine();
                            
                            System.out.println("Estado:");
                            String s5 = scan.nextLine();
                            
                            System.out.println("Telefone:");
                            String s6 = scan.nextLine();
                            
                            System.out.println("Email:");
                            String s7 = scan.nextLine();
                            
                            System.out.println("Cpf:");
                            String s8 = scan.nextLine();
                            
                        
                            PessoaFisica pessoa = new PessoaFisica(n2,s2,s3,s4,s5,s6,s7,s8);
                        
                            persF.incluir(pessoa);     
                        }
                        case "J" ->{
                            System.out.println("Insira os Dados...");
                            System.out.println("Digite o Id da Pessoa:");
                            int n2 = scan.nextInt();
                            
                            System.out.println("Nome:");
                            scan.nextLine();
                            String s2 = scan.nextLine();
                        
                            System.out.println("Logradouro:");
                            String s3 = scan.nextLine();
                        
                            System.out.println("Cidade:");
                            String s4 = scan.nextLine();
                            
                            System.out.println("Estado:");
                            String s5 = scan.nextLine();
                            
                            System.out.println("Telefone:");
                            String s6 = scan.nextLine();
                            
                            System.out.println("Email:");
                            String s7 = scan.nextLine();
                            
                            System.out.println("Cnpj:");
                            String s8 = scan.nextLine();
                        
                            PessoaJuridica pessoa = new PessoaJuridica(n2,s2,s3,s4,s5,s6,s7,s8);
                        
                            persJ.incluir(pessoa);
                        }
                    }
                    break;
                }
                case 2 ->{
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    scan.nextLine();
                    String s1 = scan.nextLine();
                    
                    switch(s1){
                        case "F" ->{
                            System.out.println("Insira os Dados...");
                            System.out.println("Digite o Id da Pessoa:");
                            int n2 = scan.nextInt();
                               
                            System.out.println("Nome:");
                            scan.nextLine();
                            String s2 = scan.nextLine();
                        
                            System.out.println("Logradouro:");
                            String s3 = scan.nextLine();
                        
                            System.out.println("Cidade:");
                            String s4 = scan.nextLine();
                            
                            System.out.println("Estado:");
                            String s5 = scan.nextLine();
                            
                            System.out.println("Telefone:");
                            String s6 = scan.nextLine();
                            
                            System.out.println("Email:");
                            String s7 = scan.nextLine();
                            
                            System.out.println("Cpf:");
                            String s8 = scan.nextLine();
                            
                        
                            PessoaFisica pessoa = new PessoaFisica(n2,s2,s3,s4,s5,s6,s7,s8);
                            
                            persF.getPessoa(pessoa.id).exibir();
                            persF.alterar(pessoa);     
                        }
                        case "J" ->{
                            System.out.println("Insira os Dados...");
                            System.out.println("Digite o Id da Pessoa:");
                            int n2 = scan.nextInt();
                            
                            System.out.println("Nome:");
                            scan.nextLine();
                            String s2 = scan.nextLine();
                        
                            System.out.println("Logradouro:");
                            String s3 = scan.nextLine();
                        
                            System.out.println("Cidade:");
                            String s4 = scan.nextLine();
                            
                            System.out.println("Estado:");
                            String s5 = scan.nextLine();
                            
                            System.out.println("Telefone:");
                            String s6 = scan.nextLine();
                            
                            System.out.println("Email:");
                            String s7 = scan.nextLine();
                            
                            System.out.println("Cnpj:");
                            String s8 = scan.nextLine();
                        
                            PessoaJuridica pessoa = new PessoaJuridica(n2,s2,s3,s4,s5,s6,s7,s8);
                            
                            persJ.getPessoa(pessoa.id).exibir();
                            persJ.alterar(pessoa);
                        }
                    }
                    break;
                }
                case 3 ->{
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    scan.nextLine();
                    String s1 = scan.nextLine();
                    System.out.println("Digite o Id da Pessoa:");
                    int n2 = scan.nextInt();

                    switch(s1){
                        case "F" -> {
                            persF.excluir(n2);
                        }
                        case "J" -> {
                            persJ.excluir(n2);
                        }
                    }
                    break;
                }
                case 4 -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    scan.nextLine();
                    String s1 = scan.nextLine();
                    System.out.println("Digite o Id da Pessoa:");
                    int n2 = scan.nextInt();
                    
                    switch(s1){
                        case "F" ->{
                            persF.getPessoa(n2);
                        }
                        case "J" ->{
                            persJ.getPessoa(n2);
                        }
                    }
                    break;
                }
                case 5 -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    scan.nextLine();
                    String s1 = scan.nextLine();
                    
                    switch(s1){
                        case "F" ->{
                            persF.getPessoas();
                            
                        }
                        case"J" ->{
                            persJ.getPessoas();
                        }
                    }
                    break;
                }
                case 0 ->{
                    break;
                }
            }     
    }
}
