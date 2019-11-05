
package practicandocrud;

import java.sql.Date;

/**
 *
 * @author lopez
 */
public class Productos {
    
    private String CodigoProducto;
    private String Nombre;
    private String Gama;
    private String Dimensiones;
    private String Proveedor;
    private String Descripcion;
    private Integer CantidadEnStock;
    private Integer PrecioVenta;
    private Integer PrecioProveedor;
    private Pedidos pedidos;

    public Productos() {
    }

    public Productos(String CodigoProducto, String Nombre, String Gama, String Dimensiones, String Proveedor, String Descripcion, Integer CantidadEnStock, Integer PrecioVenta, Integer PrecioProveedor) {
        this.CodigoProducto = CodigoProducto;
        this.Nombre = Nombre;
        this.Gama = Gama;
        this.Dimensiones = Dimensiones;
        this.Proveedor = Proveedor;
        this.Descripcion = Descripcion;
        this.CantidadEnStock = CantidadEnStock;
        this.PrecioVenta = PrecioVenta;
        this.PrecioProveedor = PrecioProveedor;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGama() {
        return Gama;
    }

    public void setGama(String Gama) {
        this.Gama = Gama;
    }

    public String getDimensiones() {
        return Dimensiones;
    }

    public void setDimensiones(String Dimensiones) {
        this.Dimensiones = Dimensiones;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getCantidadEnStock() {
        return CantidadEnStock;
    }

    public void setCantidadEnStock(Integer CantidadEnStock) {
        this.CantidadEnStock = CantidadEnStock;
    }

    public Integer getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(Integer PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public Integer getPrecioProveedor() {
        return PrecioProveedor;
    }

    public void setPrecioProveedor(Integer PrecioProveedor) {
        this.PrecioProveedor = PrecioProveedor;
    }
    
    
    
    
}
