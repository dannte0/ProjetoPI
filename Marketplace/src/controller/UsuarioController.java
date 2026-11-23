package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GenericDao;
import entity.Usuario;

public class UsuarioController 
{
    GenericDao gDao = new GenericDao();


    public void createUsuario(Usuario usu) throws ClassNotFoundException, SQLException 
    {
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO Usuario (nome, email, senha, cpf, telefone) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, usu.getNome());
        ps.setString(2, usu.getEmail());
        ps.setString(3, usu.getSenha());
        ps.setString(4, usu.getCPF());
        ps.setString(5, usu.getTelefone());
        
        ps.execute();
        ps.close();
        conn.close();
    }
    

    public Usuario findOneUsuario(Usuario usu) throws ClassNotFoundException, SQLException
    {
        Connection conn = gDao.getConnection();
        String sql = "SELECT id, nome, email, cpf, telefone FROM usuario WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, usu.getId());
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            usu.setId(rs.getInt("id"));
            usu.setNome(rs.getString("nome"));
            usu.setEmail(rs.getString("email"));
            usu.setCPF(rs.getString("cpf"));
            usu.setTelefone(rs.getString("telefone"));
        }
        rs.close();
        ps.close();
        conn.close();
        return usu;
    }


    public List<Usuario> findAllUsuario() throws ClassNotFoundException, SQLException
    {
        List<Usuario> lista = new ArrayList<>();
        Connection conn = gDao.getConnection();
        String sql = "SELECT id, nome, email, cpf, telefone FROM usuario";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            Usuario usu = new Usuario();
                 
            usu.setId(rs.getInt("id"));
            usu.setNome(rs.getString("nome"));
            usu.setEmail(rs.getString("email"));
            usu.setCPF(rs.getString("cpf"));
            usu.setTelefone(rs.getString("telefone"));
                
            lista.add(usu);
        }
         
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }


    public void updateUsuario(Usuario usu) throws ClassNotFoundException, SQLException
    {
        Connection conn = gDao.getConnection();
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, cpf = ?, telefone = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, usu.getNome());
        ps.setString(2, usu.getEmail());
        ps.setString(3, usu.getSenha());
        ps.setString(4, usu.getCPF());
        ps.setString(5, usu.getTelefone());
        ps.setInt(6, usu.getId());
        
        ps.execute();
        ps.close();
        conn.close();
    }


    public void deleteUsuario(Usuario usu) throws ClassNotFoundException, SQLException
    {
        Connection conn = gDao.getConnection();
        String sql = "DELETE FROM usuario WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, usu.getId());
        ps.execute();
        ps.close();
        conn.close();
    }
}