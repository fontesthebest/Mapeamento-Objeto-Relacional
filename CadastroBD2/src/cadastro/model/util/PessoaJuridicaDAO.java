/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import cadastrobd.model.Pessoa;
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naote
 */
public class PessoaJuridicaDAO <E,K> {
     public PessoaJuridica getPessoa(int id){
        ConectorBD bd = new ConectorBD();
        PessoaJuridica pessoa = new PessoaJuridica();
        PreparedStatement ps = bd.getPrepared("SELECT * FROM Pessoa a INNER JOIN PessoaJuridica b ON a.idPessoa = b.idPessoa WHERE idPessoa = ?");
       
        try {
            ps.setInt(1,id);
            ResultSet r1 = bd.getSelect(ps);
            if(r1.next())
               pessoa = new PessoaJuridica(r1.getInt("idPessoa"), r1.getString("nome"), r1.getString("logradouro"), r1.getString("cidade"), r1.getString("estado"), r1.getString("telefone"), r1.getString("email"), r1.getString("cnpj"));
        } catch (SQLException ex) {
            return pessoa;
        }
        
        bd.close(ps);
        return pessoa;
    }
    
    public ArrayList<Pessoa> getPessoas(){
        ConectorBD bd = new ConectorBD();
        ArrayList<Pessoa> lista= new ArrayList<>();
        PreparedStatement ps = bd.getPrepared("SELECT * FROM Pessoa a INNER JOIN PessoaJuridica b ON a.idPessoa = b.idPessoa ");
       
        try {
            
            ResultSet r1 = bd.getSelect(ps);
            while(r1.next())
               lista.add(new PessoaJuridica(r1.getInt("idPessoa"), r1.getString("nome"), r1.getString("logradouro"), r1.getString("cidade"), r1.getString("estado"), r1.getString("telefone"), r1.getString("email"),r1.getString("cnpj")));
        } catch (SQLException ex) {
            return lista;
        }
            lista.stream().map(e -> {
                e.exibir();
                return e;
            }).forEachOrdered(_item -> {
                System.out.println("--------------------------");
            });
        bd.close(ps);
        return lista;
    }
    
    public void incluir(PessoaJuridica pessoa){
        ConectorBD bd = new ConectorBD();
        PreparedStatement ps = bd.getPrepared("INSERT INTO Pessoa VALUES (?,?,?,?,?,?,?) INSERT INTO PessoaJuridica VALUES (?,?)");
        try {
            ps.setInt(1, pessoa.id);
            ps.setString(2,pessoa.nome);
            ps.setString(3,pessoa.logradouro);
            ps.setString(4,pessoa.cidade);
            ps.setString(5,pessoa.estado);
            ps.setString(6,pessoa.telefone);
            ps.setString(7,pessoa.email);
            ps.setInt(8,pessoa.id);
            ps.setString(9,pessoa.cnpj);
            ps.executeUpdate();
            bd.close(ps);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterar(PessoaJuridica pessoa){
        this.excluir(pessoa.id);
        this.incluir(pessoa);
        
    }
    
    public void excluir(int id){
        ConectorBD bd = new ConectorBD();        
        PreparedStatement ps2 = bd.getPrepared(" DELETE FROM PessoaJuridica WHERE idPessoa IN (?) DELETE FROM Pessoa WHERE idPessoa IN (?)");
        
        try {
            ps2.setInt(1, id);
            ps2.setInt(2,id);
            ResultSet r2 = bd.getSelect(ps2);
            bd.close(r2);
        } catch (SQLException ex) {
            
        }
        
        
    }
}
