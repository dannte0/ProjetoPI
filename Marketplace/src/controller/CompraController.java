package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.GenericDao;
import entity.Compra;

public class CompraController 
{
    GenericDao gDao = new GenericDao();

    public void createCompra(Compra com) throws ClassNotFoundException, SQLException 
    {
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO Compra (id_anuncio, Data_Hora, id_usuario) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, com.getAnuncioIdProduto());
        ps.setTimestamp(2, Timestamp.valueOf(com.getDataHora()));
        ps.setInt(3, com.getUsuarioIdComprador());
        
        ps.execute();
        ps.close();
        conn.close();
    }

    public Compra findOneCompra(Compra com) throws ClassNotFoundException, SQLException
    {
        Connection conn = gDao.getConnection();
        String sql = "SELECT id_anuncio, Data_Hora, id_usuario FROM Compra WHERE id_anuncio = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, com.getAnuncioIdProduto());
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            com.setAnuncioIdProduto(rs.getInt("id_anuncio"));
            com.setDataHora(rs.getTimestamp("Data_Hora").toLocalDateTime());
            com.setUsuarioIdComprador(rs.getInt("id_usuario"));
        }
        rs.close();
        ps.close();
        conn.close();
        return com;
    }

    public List<Compra> findAllCompra() throws ClassNotFoundException, SQLException
    {
        List<Compra> lista = new ArrayList<>();
        Connection conn = gDao.getConnection();
        String sql = "SELECT id_anuncio, Data_Hora, id_usuario FROM Compra";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            Compra com = new Compra();
                 
            com.setAnuncioIdProduto(rs.getInt("id_anuncio"));
            com.setDataHora(rs.getTimestamp("Data_Hora").toLocalDateTime());
            com.setUsuarioIdComprador(rs.getInt("id_usuario"));
                
            lista.add(com);
        }
         
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }

    public void updateCompra(Compra com) throws ClassNotFoundException, SQLException
    {
        Connection conn = gDao.getConnection();
        String sql = "UPDATE Compra SET Data_Hora = ?, id_usuario = ? WHERE id_anuncio = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setTimestamp(1, Timestamp.valueOf(com.getDataHora()));
        ps.setInt(2, com.getUsuarioIdComprador());
        ps.setInt(3, com.getAnuncioIdProduto());
        
        ps.execute();
        ps.close();
        conn.close();
    }

    public void deleteCompra(Compra com) throws ClassNotFoundException, SQLException
    {
        Connection conn = gDao.getConnection();
        String sql = "DELETE FROM Compra WHERE id_anuncio = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, com.getAnuncioIdProduto());
        ps.execute();
        ps.close();
        conn.close();
    }
}