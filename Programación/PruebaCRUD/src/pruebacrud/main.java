
package pruebacrud;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author lopez
 */
public class main {

    public static void main(String[] args) throws SQLException {

        CursosCRUD cursosCRUD = new CursosCRUD();
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

                            System.out.println("+---------+------------------------------+-------------+-----------------+-----------------+-----------------+-------------------+");
                            System.out.printf("| %5s | %-28s | %5s | %-15s | %-15s | %-10s | %-15s |\n", "IdCurso", "Nombre Curso", "Duracion(h)", "Inicio", "Fin", "Nombre profesor", "Apellido Profesor");
                            for (int i = 0; i < cursosCRUD.consultaMix().size(); i++) {
                                try {
                                    System.out.println("+---------+------------------------------+-------------+-----------------+-----------------+-----------------+-------------------+");
                                    System.out.printf("| %7s | %-28s | %11s | %-15s | %-15s | %-15s | %-17s |\n",
                                            cursosCRUD.consultaMix().get(i).getIdCurso(),
                                            cursosCRUD.consultaMix().get(i).getNombreCurso(),
                                            cursosCRUD.consultaMix().get(i).getDuracionCurso(),
                                            cursosCRUD.consultaMix().get(i).getFechaInicio(),
                                            cursosCRUD.consultaMix().get(i).getFechaFin(),
                                            cursosCRUD.consultaMix().get(i).getProfesores().getNombre(),
                                            cursosCRUD.consultaMix().get(i).getProfesores().getApellidos());
                                } catch (SQLException ex) {
                                    System.out.println("No se puedo hacer la consulta");
                                }
                            }
                            System.out.println("+---------+------------------------------+-------------+-----------------+-----------------+-----------------+-------------------+");

                            System.out.println("----------MENÚ(mostrar)----------");
                            System.out.printf("1.Editar\n2.Borrar\n \n0.Salir\n");
                            switch (sc.nextLine()) {
                                case "1":
                                    Scanner scUpdte = new Scanner(System.in);

                                    Cursos cursos = new Cursos();

                                    System.out.print("ID curso --> ");
                                    cursos.setIdCurso(sc.nextInt());
                                    System.out.print("Nuevo nombre del curso: ");
                                    String nombreCurso = scUpdte.nextLine();
                                    cursos.setNombreCurso(nombreCurso);
                                    System.out.print("Nueva duracion del curso: ");
                                    cursos.setDuracionCurso(sc.nextInt());
                                    System.out.print("Id del profesor: ");
                                    cursos.setIdProfesor(sc.nextInt());
                                    while (true) {
                                        try {
                                            System.out.print("Nueva fecha de inicio: ");
                                            String fecha = scUpdte.nextLine();
                                            String formato = "YYYY-MM-DD";
                                            cursos.setFechaInicio(java.sql.Date.valueOf(LocalDate.parse(fecha, DateTimeFormatter.ofPattern(formato))));
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Algo salió mal, asegurate que el formato es YYYY-MM-DD");
                                        }
                                    }
                                    System.out.println(cursos.getFechaInicio());

                                    while (true) {
                                        try {
                                            System.out.print("Nueva fecha de Final: ");
                                            String fecha = scUpdte.nextLine();
                                            String formato = "YYYY-MM-DD";
                                            cursos.setFechaFin(java.sql.Date.valueOf(LocalDate.parse(fecha, DateTimeFormatter.ofPattern(formato))));
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("formato es YYYY-MM-DD");
                                        }
                                    }

                                    cursosCRUD.updateCurso(cursos);

                                    System.out.println("Se ha editado");
                                    break;
                                case "2":
                                    System.out.print("Borrar por ID: ");
                                    cursosCRUD.borrarCurso(sc.nextInt());
                                    break;
                                case "0":
                                    fin2 = true;
                                    break;
                            }
                        }

                    } catch (SQLException ex) {
                        System.err.println("No se pudo hacer la consulta");
                    }
                    break;
                case "2":
                    Scanner scAdd = new Scanner(System.in);
                    Cursos cursos = new Cursos();

                    System.out.print("Nombre del curso: ");
                    String nombreCurso = scAdd.nextLine();
                    cursos.setNombreCurso(nombreCurso);
                    System.out.print("Duracion del curso: ");
                    cursos.setDuracionCurso(sc.nextInt());
                    System.out.print("Id del profesor: ");
                    cursos.setIdProfesor(sc.nextInt());
                    while (true) {
                        try {
                            System.out.print("Fecha de inicio: ");
                            String fecha = scAdd.nextLine();
                            String formato = "YYYY-MM-DD";
                            cursos.setFechaInicio(java.sql.Date.valueOf(LocalDate.parse(fecha, DateTimeFormatter.ofPattern(formato))));
                            break;
                        } catch (Exception e) {
                            System.out.println("formato es YYYY-MM-DD");
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("Fecha de Final: ");
                            String fecha = scAdd.nextLine();
                            String formato = "YYYY-MM-DD";
                            cursos.setFechaFin(java.sql.Date.valueOf(LocalDate.parse(fecha, DateTimeFormatter.ofPattern(formato))));
                            break;
                        } catch (Exception e) {
                            System.out.println("formato es YYYY-MM-DD");
                        }
                    }
                    cursosCRUD.addCurso(cursos);
                    break;

                case "0":
                    fin = true;
                    break;

            }
        }
    }
}
