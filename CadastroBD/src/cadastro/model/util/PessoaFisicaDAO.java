/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import java.sql.PreparedStatement;
import cadastrobd.model.Pessoa;
import cadastrobd.model.PessoaFisica;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naote
 */
public class PessoaFisicaDAO <E,K> {
    public PessoaFisica getPessoa(int id){
        ConectorBD bd = new ConectorBD();
        PessoaFisica pessoa = new PessoaFisica();
        PreparedStatement ps = bd.getPrepared("SELECT * FROM Pessoa a INNER JOIN PessoaFisica b ON a.idPessoa = b.idPessoa WHERE idPessoa = ?");
       
        try {
            ps.setInt(1,id);
            ResultSet r1 = bd.getSelect(ps);
            if(r1.next())
               pessoa = new PessoaFisica(r1.getInt("idPessoa"), r1.getString("nome"), r1.getString("logradouro"), r1.getString("cidade"), r1.getString("estado"), r1.getString("telefone"), r1.getString("email"), r1.getString("cpf"));
        } catch (SQLException ex) {
            return pessoa;
        }
        
        bd.close(ps);
        return pessoa;
    }
    
    public ArrayList<Pessoa> getPessoas(){
        ConectorBD bd = new ConectorBD();
        ArrayList<Pessoa> lista= new ArrayList<>();
        PreparedStatement ps = bd.getPrepared("SELECT * FROM Pessoa a INNER JOIN PessoaFisica b ON a.idPessoa = b.idPessoa ");
       
        try {
            
            ResultSet r1 = bd.getSelect(ps);
            while(r1.next())
               lista.add(new PessoaFisica(r1.getInt("idPessoa"), r1.getString("nome"), r1.getString("logradouro"), r1.getString("cidade"), r1.getString("estado"), r1.getString("telefone"), r1.getString("email"),r1.getString("cpf")));
        } catch (SQLException ex) {
            return lista;
        }
        
        bd.close(ps);
        lista.stream().map(e -> {
            e.exibir();
            return e;
        }).forEachOrdered(_item -> {
            System.out.println("--------------------------");
        });
        return lista;
    }
    
    public void incluir(PessoaFisica pessoa){
        ConectorBD bd = new ConectorBD();
        PreparedStatement ps = bd.getPrepared("INSERT INTO Pessoa VALUES (?,?,?,?,?,?,?) INSERT INTO PessoaFisica VALUES (?,?)");
        try {
            ps.setInt(1, pessoa.id);
            ps.setString(2,pessoa.nome);
            ps.setString(3,pessoa.logradouro);
            ps.setString(4,pessoa.cidade);
            ps.setString(5,pessoa.estado);
            ps.setString(6,pessoa.telefone);
            ps.setString(7,pessoa.email);
            ps.setInt(8,pessoa.id);
            ps.setString(9,pessoa.cpf);
            ps.executeUpdate();
            bd.close(ps);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaFisicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterar(PessoaFisica pessoa){
        this.excluir(pessoa.id);
        this.incluir(pessoa);
    }
    
    public void excluir(int id){
        ConectorBD bd = new ConectorBD();        
        PreparedStatement ps2 = bd.getPrepared(" DELETE FROM PessoaFisica WHERE idPessoa IN (?) DELETE FROM Pessoa WHERE idPessoa IN (?)");
        
        try {
            ps2.setInt(1, id);
            ps2.setInt(2,id);
            ResultSet r2 = bd.getSelect(ps2);
            bd.close(ps2);
        } catch (SQLException ex) {    
        }
    
    }
}
