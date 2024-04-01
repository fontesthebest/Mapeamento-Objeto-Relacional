/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author naote
 */
public class PessoaFisica extends Pessoa{
    public String cpf;
    
    @Override
    public void exibir(){
        super.exibir();
        System.out.printf("CPF: %s%n",this.cpf);
    }
    
    public PessoaFisica(){
        
    }
    public PessoaFisica(int id,String nome,String logradouro, String cidade, String estado, String telefone, String email,String cpf){
        super(id,nome,logradouro,cidade,estado,telefone,email);
        this.cpf=cpf;
    }
}
