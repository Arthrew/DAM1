
package practicandocrud;

import java.sql.Date;

/**
 *
 * @author lopez
 */
public class Pedidos {
    
    private Integer CodigoPedido;
    private Date FechaPedido;
    private Date FechaEsperada;
    private Date FechaEntrega;
    private String Estado;
    private String Comentarios;

    public Pedidos() {
    }

    public Pedidos(Integer CodigoPedido, Date FechaPedido, Date FechaEsperada, Date FechaEntrega, String Estado, String Comentarios) {
        this.CodigoPedido = CodigoPedido;
        this.FechaPedido = FechaPedido;
        this.FechaEsperada = FechaEsperada;
        this.FechaEntrega = FechaEntrega;
        this.Estado = Estado;
        this.Comentarios = Comentarios;
    }

    public Integer getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(Integer CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    public Date getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(Date FechaPedido) {
        this.FechaPedido = FechaPedido;
    }

    public Date getFechaEsperada() {
        return FechaEsperada;
    }

    public void setFechaEsperada(Date FechaEsperada) {
        this.FechaEsperada = FechaEsperada;
    }

    public Date getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(Date FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String Comentarios) {
        this.Comentarios = Comentarios;
    }
    
    
    
    
}
