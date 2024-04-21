/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

import java.util.Arrays;

/**
 *
 * @author naote
 */
public class Pessoa {
    public int id;
    public String nome;
    public String logradouro;
    public String cidade;
    public String estado;
    public String telefone;
    public String email;
    
    public void exibir(){
        System.out.printf("Id: %d%n",this.id);
        System.out.printf("Nome: %s%n",this.nome);
        System.out.printf("Logradouro: %s%n",this.logradouro);
        System.out.printf("Cidade: %s%n",this.cidade);
        System.out.printf("Estado: %s%n",this.estado);
        System.out.printf("Telefone: %s%n",this.telefone);
        System.out.printf("Email: %s%n",this.email);
    }
    
    public Pessoa(){
        
    }
    public Pessoa(int id,String nome,String logradouro, String cidade, String estado, String telefone, String email){
        this.id=id;
        this.nome=nome;
        this.logradouro=logradouro;
        this.cidade=cidade;
        this.estado=estado;
        this.telefone=telefone;
        this.email=email;
    }
}
