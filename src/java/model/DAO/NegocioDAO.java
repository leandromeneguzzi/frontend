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
import model.bean.Negocio;

/**
 *
 * @author Leandro
 */
public class NegocioDAO {

    private final Connection connection;
    private PreparedStatement pstm;
    private boolean res;

    public NegocioDAO() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    public Integer create(Negocio negocio) {
        ResultSet rs;
        String sql = "INSERT INTO negocio ("
                + "tipo_negocio, "
                + "telefone_negociador, "
                + "nome_negociador, "
                + "id_mercadoria) "
                + "VALUES (?, ?, ?, ?)";
        int key = 0;

        try {
            pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, negocio.getTipo());
            pstm.setString(2, negocio.getTelefone());
            pstm.setString(3, negocio.getNome());
            pstm.setInt(4, negocio.getId_mercadoria());
            res = pstm.execute();
            rs = pstm.getGeneratedKeys();

            if (rs != null && rs.next()) {
                key = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    public ArrayList<Negocio> read() {
        ArrayList<Negocio> negocios = new ArrayList<>();
        String sql = "SELECT * FROM negocio";
        try {
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                negocios.add(new Negocio(rs.getInt("id_negocio"), rs.getString("tipo_negocio"), rs.getString("telefone_negociador"), rs.getString("nome_negociador"), rs.getInt("id_mercadoria")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NegocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return negocios;
    }
}
