package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.GenericDao;
import entity.Categoria;

public class CategoriaController {
    
    GenericDao gDao = new GenericDao();

    public void createCategoria(Categoria c) throws ClassNotFoundException, SQLException {
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO Categoria (nome, descricao) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, c.getNome());
        ps.setString(2, c.getDescricao());
        
        ps.execute();
        ps.close();
        conn.close();
    }
}