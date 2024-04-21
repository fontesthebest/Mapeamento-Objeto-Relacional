/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

/**
 *
 * @author naote
 */
public class PessoaJuridica extends Pessoa{
    public String cnpj;

    public PessoaJuridica() {
        
    }
    
    public void exibir(){
        super.exibir();
        System.out.printf("CNPJ: %s%n",this.cnpj);
    }
    
    public PessoaJuridica(int id,String nome,String logradouro, String cidade, String estado, String telefone, String email,String cnpj){
        super(id,nome,logradouro,cidade,estado,telefone,email);
        this.cnpj=cnpj;
    }
}
