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
public class ProductosCRUD {
    
    Connection conexion;

    public ProductosCRUD() {
        try {
            conexion = null;
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria", "academia","academia");
        } catch (SQLException sqlE) {
            System.out.println("Error de conexion: \n" + sqlE);
        }
    }

    public ArrayList<Productos> consulta() throws SQLException {

        ArrayList<Productos> lista = new ArrayList<>();
        Productos produc = new Productos();
        String consulta = "select * from productos";

        ResultSet rs = conexion.createStatement().executeQuery(consulta);
        while (rs.next()) {
            String codproduc = rs.getString("CodigoProducto");
            String nombre = rs.getString("nombre");
            String gama = rs.getString("Gama");
            String dimen = rs.getString("Dimensiones");
            String prov = rs.getString("Proveedor");
            String descrp = rs.getString("Descripcion");
            Integer stock = rs.getInt("CantidadEnStock");
            Integer p_venta = rs.getInt("PrecioVenta");
            Integer p_prov = rs.getInt("PrecioProveedor");

            produc.setCodigoProducto(codproduc);
            produc.setNombre(nombre);
            produc.setGama(gama);
            produc.setDimensiones(dimen);
            produc.setProveedor(prov);
            produc.setDescripcion(descrp);
            produc.setCantidadEnStock(stock);
            produc.setPrecioVenta(p_venta);
            produc.setPrecioProveedor(p_prov);

            lista.add(produc);
        }
        return lista;
    } //listar produc
    
    public ArrayList<Productos> consultaMix() throws SQLException {

        ArrayList<Productos> lista = new ArrayList<Productos>();

        String consulta = "select * from productos "
                + "join detallepedidos "
                + "on cursos.CodigoProducto = detallepedidos.CodigoProducto "
                + "join pedidos "
                + "on detallepedidos.CodigoPedido = pedidos.CodigoPedido "
                + "order by(productos.CodigoProducto)";

        ResultSet rs = conexion.createStatement().executeQuery(consulta);
        while (rs.next()) {
            Productos produc = new Productos();
            Pedidos pedi = new Pedidos();
            String codproduc = rs.getString("CodigoProducto");
            String nombre = rs.getString("nombre");
            String gama = rs.getString("Gama");
            String dimen = rs.getString("Dimensiones");
            String prov = rs.getString("Proveedor");
            String descrp = rs.getString("Descripcion");
            Integer stock = rs.getInt("CantidadEnStock");
            Integer p_venta = rs.getInt("PrecioVenta");
            Integer p_prov = rs.getInt("PrecioProveedor");

            produc.setCodigoProducto(codproduc);
            produc.setNombre(nombre);
            produc.setGama(gama);
            produc.setDimensiones(dimen);
            produc.setProveedor(prov);
            produc.setDescripcion(descrp);
            produc.setCantidadEnStock(stock);
            produc.setPrecioVenta(p_venta);
            produc.setPrecioProveedor(p_prov);

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

            produc.setPedidos(pedi);

            lista.add(produc);
        }
        return lista;
    } //listar ambas

    public Integer addProduc(Productos produc) throws SQLException {
        Integer resultado = null;
        String sql = "INSERT INTO productos (CodigoProducto, nombre, Gama, Dimensiones, Proveedor, Descripcion, CantidadEnStock, PrecioVenta, PrecioProveedor) VALUES (?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, produc.getCodigoProducto());
        ps.setString(2, produc.getNombre());
        ps.setString(3, produc.getGama());
        ps.setString(4, produc.getDimensiones());
        ps.setString(5, produc.getProveedor());
        ps.setString(6, produc.getDescripcion());
        ps.setInt(7, produc.getCantidadEnStock());
        ps.setInt(8, produc.getPrecioVenta());
        ps.setInt(9, produc.getPrecioProveedor());

        resultado = ps.executeUpdate();

        return resultado;
    }

    public int updateProfe(Productos produc) throws SQLException {
        String sql = "UPDATE profesores SET nombre = ?, Gama = ?, Dimensiones = ?, Proveedor = ?, Descripcion = ?, CantidadEnStock = ?, PrecioVenta = ?, PrecioProveedor = ?, WHERE CodigoProducto = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, produc.getNombre());
        ps.setString(2, produc.getGama());
        ps.setString(3, produc.getDimensiones());
        ps.setString(4, produc.getProveedor());
        ps.setString(5, produc.getDescripcion());
        ps.setInt(6, produc.getCantidadEnStock());
        ps.setInt(7, produc.getPrecioVenta());
        ps.setInt(8, produc.getPrecioProveedor());
        ps.setString(9, produc.getCodigoProducto());

        return ps.executeUpdate();
    }

    public void borrarProduc(Integer id) throws SQLException {
        String sentencia = "delete from productos where CodigoProducto = " + id + ";";
        conexion.createStatement().executeUpdate(sentencia);

    }
    
}
