/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Mercadoria;

/**
 *
 * @author Leandro
 */
public class MercadoriaDAO {

    private final Connection connection;
    private PreparedStatement pstm;
    private boolean res;

    public MercadoriaDAO() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    public Integer create(Mercadoria mercadoria) {
        ResultSet rs;
        String sql = "INSERT INTO mercadoria ("
                + "tipo_mercadoria, "
                + "nome_mercadoria, "
                + "quantidade_mercadoria, "
                + "preco_unidade_mercadoria) "
                + "VALUES (?, ?, ?, ?)";
        int key = 0;

        try {
            pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, mercadoria.getTipo());
            pstm.setString(2, mercadoria.getNome());
            pstm.setInt(3, mercadoria.getQuantidade());
            pstm.setDouble(4, mercadoria.getPreco());
            res = pstm.execute();
            rs = pstm.getGeneratedKeys();

            if (rs != null && rs.next()) {
                key = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MercadoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    public ArrayList<Mercadoria> read() {
        ArrayList<Mercadoria> mercadorias = new ArrayList<>();
        String sql = "SELECT * FROM mercadoria";
        try {
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                mercadorias.add(new Mercadoria(rs.getInt("id_mercadoria"), rs.getString("tipo_mercadoria"), rs.getString("nome_mercadoria"), rs.getInt("quantidade_mercadoria"), rs.getDouble("preco_unidade_mercadoria")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MercadoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mercadorias;
    }

}
