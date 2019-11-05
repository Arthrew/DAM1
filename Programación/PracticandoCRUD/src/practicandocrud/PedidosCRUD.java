/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicandocrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList;

/**
 *
 * @author lopez
 */
public class PedidosCRUD {
    
    Connection conexion;

    public PedidosCRUD() {
        try {
            conexion = null;
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria", "academia","academia");
        } catch (SQLException sqlE) {
            System.out.println("Error de conexion: \n" + sqlE);
        }
    }

    public ArrayList<Pedidos> consulta() throws SQLException {

        ArrayList<Pedidos> lista = new ArrayList<>();
        Pedidos pedi = new Pedidos();
        String consulta = "select * from pedidos";

        ResultSet rs = conexion.createStatement().executeQuery(consulta);
        while (rs.next()) {
            Integer codi = rs.getInt("CodigoPedido");
            Date f_pedido = rs.getDate("FechaPedido");
            Date f_esperada = rs.getDate("FechaEsperada");
            Date f_entrega = rs.getDate("FechaEntrega");
            String estado = rs.getString("Estado");
            String comen = rs.getString("Comentarios");

            pedi.setCodigoPedido(codi);
            pedi.setFechaPedido(f_pedido);
            pedi.setFechaEsperada(f_esperada);
            pedi.setFechaEntrega(f_entrega);
            pedi.setEstado(estado);
            pedi.setComentarios(comen);

            lista.add(pedi);
        }
        return lista;
    } //listar pedi

    public Integer addPedido(Pedidos pedi) throws SQLException {
        Integer resultado = null;
        String sql = "INSERT INTO pedidos (CodigoPedido,FechaPedido,FechaEsperada,FechaEntrega,Estado,Comentarios) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, pedi.getCodigoPedido());
        ps.setDate(2, pedi.getFechaPedido());
        ps.setDate(3, pedi.getFechaEsperada());
        ps.setDate(4, pedi.getFechaEntrega());
        ps.setString(5, pedi.getEstado());
        ps.setString(6, pedi.getComentarios());

        resultado = ps.executeUpdate();

        return resultado;
    }

    public int updatePedido(Pedidos pedi) throws SQLException {
        String sql = "UPDATE pedidos SET FechaPedido = ?, FechaEsperada = ?, FechaEntrega = ?,  Estado = ?, Comentarios = ? WHERE CodigoPedido = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setDate(1, pedi.getFechaPedido());
        ps.setDate(2, pedi.getFechaEsperada());
        ps.setDate(3, pedi.getFechaEntrega());
        ps.setString(4, pedi.getEstado());
        ps.setString(5, pedi.getComentarios());
        ps.setInt(6, pedi.getCodigoPedido());

        return ps.executeUpdate();
    }

    public void borrarPedido(Integer id) throws SQLException {
        String sentencia = "delete from pedidos where CodigoPedido = " + id + ";";
        conexion.createStatement().executeUpdate(sentencia);

    }
    
}
