
package practicandocrud;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductosCRUD productosCRUD = new ProductosCRUD();
        Scanner sc = new Scanner(System.in);
        boolean fin = false;
        while (fin == false) {

            System.out.println("----------MENÚ----------");
            System.out.printf("1.Mostrar\n2.Crear\n \n0.Salir\n");
            switch (sc.nextLine()) {
                case "1":
                    try {

                        boolean fin2 = false;
                        while (fin2 == false) {

                            System.out.println("+----------------+------------------------------+-------------+-----------------+-----------------+-----------------+-------------------+");
                            System.out.printf("| %14s | %-28s | %5s | %-15s | %-15s | %-10s | %-15s |\n", "CodigoProducto", "Nombre", "Gama", "Dimensiones", "Descripcion", "CodigoPedido", "FechaEntrega");
                            for (int i = 0; i < productosCRUD.consultaMix().size(); i++) {
                                try {
                                    System.out.println("+---------+------------------------------+-------------+-----------------+-----------------+-----------------+-------------------+");
                                    System.out.printf("| %7s | %-28s | %11s | %-15s | %-15s | %-15s | %-17s |\n",
                                            productosCRUD.consultaMix().get(i).getCodigoProducto(),
                                            productosCRUD.consultaMix().get(i).getNombre(),
                                            productosCRUD.consultaMix().get(i).getGama(),
                                            productosCRUD.consultaMix().get(i).getDimensiones(),
                                            productosCRUD.consultaMix().get(i).getDescripcion(),
                                            productosCRUD.consultaMix().get(i).getPedidos().getCodigoPedido(),
                                            productosCRUD.consultaMix().get(i).getPedidos().getFechaEntrega());
                                } catch (SQLException ex) {
                                    System.out.println("No se puedo hacer la consulta");
                                }
                            }
                            System.out.println("+---------+------------------------------+-------------+-----------------+-----------------+-----------------+-------------------+");

                            System.out.println("----------MENÚ(mostrar)----------");
                            System.out.printf("1.Editar\n2.Borrar\n \n0.Salir\n");
                        }

                    } catch (SQLException ex) {
                        System.err.println("No se pudo hacer la consulta");
                    }

            }
        }
    
    }
    
}
