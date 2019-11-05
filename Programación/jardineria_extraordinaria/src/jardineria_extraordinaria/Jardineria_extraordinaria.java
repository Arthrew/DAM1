/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardineria_extraordinaria;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel Flórez
 */
public class Jardineria_extraordinaria {
    public static boolean isNumeric(String numero) {
        boolean resultado;
        try {
            Integer.parseInt(numero);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Empleados empleados = null;
        // Conexion con tabla empleados
        try {
            empleados = new Empleados();
            System.out.println("\t\tConexion se ha realizado con exito...");
        } catch (SQLException ex) {
            System.err.println("Error al abrir la base de datos: " + ex.getMessage());
            System.exit(1);
        }
        System.out.println("\t\t\t\t Bienvenido a la base de datos jardineria");
        boolean salir = false;
        String n = null;
        while (!salir) {

            try {
                ArrayList<Empleado> emp = empleados.lista();
                System.out.println("\n|Codigo Empleado    | Nombre\t          | Apellido1   | Apellido2 | Extension   | Email\t \t      |Codigo Oficina     |   Codigo Jefe     |  Puesto ");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (Empleado emp1 : emp) {
                    System.out.printf("| %17s | %-20s | %-10s | %-10s | %-10s | %-25s | %-17s | %17s | %-17s  \n", emp1.getCodigoEmpleado(), emp1.getNombre(), emp1.getApellido1(), emp1.getApellido2(), emp1.getExtension(), emp1.getEmail(), emp1.getCodigoOficina(), emp1.getCodigoJefe(), emp1.getPuesto());

                }

            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
            
        System.out.println("|1.-Buscar |\n\n|2.-Añadir |\n\n|3.-Modificar/Borrar |\n\n|0.-Cerrar |\n");
        
      try {
                System.out.println("\n Elija una opción");
                n = sc.nextLine();

                switch (n) {
                    //Buscar registros
                    case "1":
                        System.out.println("Seleccione código de empleado: ");

                        try {
                            
                            String opcion = sc.nextLine();
                            Empleado emp = empleados.read(opcion);

                            if (emp == null) {
                                while (emp == null) {

                                    System.out.println("Error en la introducción, inténtelo de nuevo o pulse ENTER para salir");
                                    opcion = sc.nextLine();
                                    if (opcion.equals("")) {
                                        System.out.println("Pruebe con otra opcion");
                                        break;
                                    }
                                    emp = empleados.read(opcion);

                                    if (emp != null) {
                                        System.out.println(emp.toString() + "\n");
                                    }

                                }
                            } else {
                                System.out.println(emp.toString() + "\n");
                            }

                        } catch (SQLException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                    break; 
                    //Añadir registro
                    case "2"://------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                        /*Create*/
                        try {

                            System.out.println("Crear empleado: ");
                            System.out.println("Codigo del empleado: ");
                            String idEmpleado = sc.nextLine();
                            Empleado p = empleados.read(idEmpleado);
                            if (p != null) {
                                while (p != null) {
                                    System.out.println("Seleccione otro ID: ");
                                    idEmpleado = sc.nextLine();
                                    p = empleados.read(idEmpleado);
                                }
                            }

                            System.out.println("Nombre:");
                            String nombre = sc.nextLine();
                            System.out.println("Primer Apellido: ");
                            String apellido1 = sc.nextLine();
                            System.out.println("Segundo Apellido: ");
                            String apellido2 = sc.nextLine();
                            System.out.println("Extension: (Solo admite valores numericos)");                            
                            String extension = sc.nextLine();
                            if (isNumeric(extension) != true) {
                                while (isNumeric(extension) != true) {
                                    System.out.println("Solo admite numeros.");
                                    System.out.print("Pruebe otra vez: ");
                                    extension = sc.nextLine();
                                    if (isNumeric(extension) == true) {
                                        break;
                                    }
                                }
                            }
                            
                            System.out.println("Puesto: ");
                            String puesto = sc.nextLine();
                            
                            System.out.println("Email: ");
                            String email = sc.nextLine();

                            System.out.println("Codigo Oficina: (El formato original es NNN-NN)");
                            String codigoOficina = sc.nextLine();
               
                            System.out.println("Codigo Jefe (Puede ser nulo):");
                            String codigoJefe = sc.nextLine();
                            if (!codigoJefe.equals("")) {
                                if (isNumeric(codigoJefe) != true) {
                                    while (isNumeric(codigoJefe) != true) {
                                        System.out.println("Introduce un número");
                                        codigoJefe = sc.nextLine();
                                        if (isNumeric(codigoJefe) == true) {
                                            break;
                                        }
                                    }
                                }
                            }
                            
                            
                            
                            Empleado empleado = empleados.read(idEmpleado);
                            if (empleado != null) {
                                while (empleado == null) {
                                    System.out.println("No existe este empleado, inroduzca de nuevo los datos: ");
                                    codigoJefe = sc.nextLine();
                                    empleado = empleados.read(idEmpleado);
                                    if (empleado != null) {
                                        break;
                                    }
                                }
                            }

                            if (!"".equals(nombre) && !"".equals(apellido1) && !"".equals(apellido2) && !"".equals(extension) && !"".equals(email) && !"".equals(codigoOficina) && !"".equals(puesto)) {

                                Integer idJefeI = Integer.parseInt(codigoJefe);
                                if (!codigoJefe.equals("")) {
                                    Integer codigoJefeI = Integer.parseInt(codigoJefe);
                                } else {
                                    idJefeI = null;
                                }
                                System.out.println("¿Está seguro de que quiere crear este objeto?");
                                System.out.println("1.- Si\n2.-No");
                                String x = sc.nextLine();
                               
                                if (x.equals("1") || x.equals("2")) {
                                    switch (x) {
                                        case "1":
                                            Empleado empleado1 = new Empleado(idEmpleado, nombre, apellido1, apellido2, extension, email, codigoOficina, codigoJefe, puesto);
                                            empleados.create(empleado1);
                                            System.out.println("Objeto creado");
                                            break;
                                        case "2":
                                            System.out.println("No se ha creado el objeto");
                                            break;
                                    }
                                } else {
                                    while (!x.equals("1") || !x.equals("2")) {
                                        System.out.println("Introduzca un valor válido (1/2)");
                                        x = sc.nextLine();
                                        if (x.equals("1") || x.equals("2")) {
                                            switch (x) {
                                                case "1":
                                                    Empleado empleado2 = new Empleado(idEmpleado, nombre, apellido1, apellido2, extension, email, codigoOficina, codigoJefe, puesto);
                                                    empleados.create(empleado2);
                                                    System.out.println("Obejo creado");
                                                    break;
                                                case "2":
                                                    System.out.println("No se ha creado el objeto");
                                                    break;
                                            }
                                            break;
                                        }
                                    }
                                }
                            }

                            while ("".equals(codigoOficina) || "".equals(nombre) || "".equals(apellido1) || "".equals(apellido2) || "".equals(extension) || "".equals(email) || "".equals(codigoOficina) || "".equals(puesto)) {
                                if ("".equals(codigoOficina) || "".equals(nombre) || "".equals(apellido1) || "".equals(apellido2) || "".equals(extension) || "".equals(email) || "".equals(codigoOficina) || "".equals(puesto)) {
                                    System.out.println("Introduzca datos correctos");
                                    System.out.println("Codigo del empleado:");
                                    idEmpleado = sc.nextLine();
                                    p = empleados.read(idEmpleado);

                                    if (p != null) {
                                        while (p != null) {
                                            System.out.println("Este Id ya está en uso, eliga otro");
                                            idEmpleado = sc.nextLine();

                                            p = empleados.read(idEmpleado);
                                        }
                                    }
                                    System.out.println("Nombre:");
                                    nombre = sc.nextLine();
                                    
                               empleado = empleados.read(idEmpleado);
                                    if (empleado == null) {
                                        while (empleado == null) {
                                            System.out.println("El empleado no se encuentra en la base de datos, intoduzca uno nuevo");
                                            idEmpleado = sc.nextLine();
                                            empleado = empleados.read(idEmpleado);
                                            if (empleado != null) {
                                                break;
                                            }
                                        }
                                    }
                                    System.out.println("Id del empleado (Puede ser nulo):");
                                    idEmpleado = sc.nextLine();
                                    if (!idEmpleado.equals("")) {
                                        if (isNumeric(idEmpleado) != true) {
                                            while (isNumeric(idEmpleado) != true) {
                                                System.out.println("Introduce un número");
                                                idEmpleado = sc.nextLine();
                                                if (isNumeric(idEmpleado) == true) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    
                                }
                                if (!"".equals(codigoOficina) || !"".equals(nombre) && !"".equals(apellido1) && !"".equals(apellido2) && !"".equals(extension) && !"".equals(email) && !"".equals(codigoOficina) && !"".equals(puesto)) {

                                    Integer idJefeI = Integer.parseInt(codigoJefe);
                                if (!codigoJefe.equals("")) {
                                    Integer codigoJefeI = Integer.parseInt(codigoJefe);
                                } else {
                                    idJefeI = null;
                                }
                                    System.out.println("¿Está seguro de que quiere crear este objeto?");
                                    System.out.println("1.- Si\n2.-No");

                                    Integer x = sc.nextInt();

                                    if (x == 1 || x == 2) {
                                        switch (x) {
                                            case 1:
                                                Empleado empleado3 = new Empleado(idEmpleado, nombre, apellido1, apellido2, extension, email, codigoOficina, codigoJefe, puesto);
                                                empleados.create(empleado3);
                                                System.out.println("Objeto creado");
                                                break;
                                            case 2:
                                                System.out.println("No se ha creado el objeto");
                                                break;
                                        }
                                    } else {
                                        while (x != 1 || x != 2) {
                                            System.out.println("Introduzca un valor válido (1/2)");
                                            x = sc.nextInt();
                                            if (x == 1 || x == 2) {
                                                switch (x) {
                                                    case 1:
                                                        Empleado empleado4 = new Empleado(idEmpleado, nombre, apellido1, apellido2, extension, email, codigoOficina, codigoJefe, puesto);
                                                        empleados.create(empleado4);
                                                        System.out.println("Objeto creado");
                                                        break;
                                                    case 2:
                                                        System.out.println("No se ha creado el objeto");
                                                        break;
                                                }
                                                break;
                                            }

                                        }

                                    }

                                }
                            }

                        } catch (SQLException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                    case "3":

                        boolean MB = false;
                        String opcion2;

                        while (!MB) {
                            //ArrayList para mostrar todos los registros
                            try {
                                ArrayList<Empleado> empleado2 = empleados.lista();
                               System.out.println("\n|Codigo Empleado    | Nombre\t          | Apellido1   | Apellido2 | Extension   | Email\t \t      |Codigo Oficina     |   Codigo Jefe     |  Puesto ");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                                for (Empleado emplea : empleado2) {
                                     System.out.printf("| %17s | %-20s | %-10s | %-10s | %-10s | %-25s | %-17s | %17s | %-17s  \n", emplea.getCodigoEmpleado(), emplea.getNombre(), emplea.getApellido1(), emplea.getApellido2(), emplea.getExtension(), emplea.getEmail(), emplea.getCodigoOficina(), emplea.getCodigoJefe(), emplea.getPuesto());

                                }

                            } catch (SQLException e) {
                                System.err.println("Error: " + e.getMessage());
                            }

                            System.out.println("1.-Modificar\n2.-Borrar\n0.-Volver al menú pricipal");

                            try {

                                opcion2 = sc.nextLine();

                                switch (opcion2) {
                                    //Actualizar 
                                    case "1":

                                        System.out.println("Elige el código de empleado que quieres actualizar");
                                        String cod = sc.nextLine();
                                        Empleado e = empleados.read(cod);
                                        if (e == null) {
                                            while (e== null) {
                                                System.out.println("Este codigo de empleado ya está en uso, elija otro");
                                                cod = sc.nextLine();

                                                e = empleados.read(cod);
                                            }
                                        }
                                        //Seleccionar los campos y si no quiere rellenarlos pulsa enter, se estableceran como campos vacios.
                                        try {
                                            Empleado empl = empleados.read(cod);
                                            System.out.println("Actualizar: (Pulse enter si no quiere actualizar)");

                                            System.out.println("Nombre: ");
                                            String valor = sc.nextLine();

                                            if (!"".equals(valor)) {
                                                empl.setNombre(valor);
                                            } else {
                                                System.out.println("");
                                            }
                                            
                                            System.out.println("Primer Apellido: ");
                                            valor = sc.nextLine();
                                             if (!"".equals(valor)) {
                                                empl.setApellido1(valor);
                                            } else {
                                                System.out.println("");
                                            }
                                            
                                            System.out.println("Segundo Apellido: ");
                                            valor = sc.nextLine();
                                             if (!"".equals(valor)) {
                                                empl.setApellido2(valor);
                                            } else {
                                                System.out.println("");
                                            }
                                            
                                            System.out.println("Extension: ");
                                            valor= sc.nextLine();
                                            if (isNumeric(valor) != true) {
                                                    while (isNumeric(valor) != true) {
                                                        System.out.println("Introduce un número o deje el campo vacío");
                                                        valor = sc.nextLine();
                                                        if (isNumeric(valor) == true || valor.equals("")) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                if (!"".equals(valor)) {
                                                    empl.setExtension(valor);
                                                } else {
                                                    System.out.println("");
                                                }    
                                            System.out.println("Email: ");
                                            valor = sc.nextLine();
                                            empl.setEmail(valor);
                                            
                                            System.out.println("Codigo Oficina: ");
                                            valor = sc.nextLine();
                                            empl.setCodigoOficina(valor);
                                            
                                            System.out.println("Codigo Jefe: ");
                                            valor = sc.nextLine();
                                            empl.setCodigoJefe(valor);
                                            
                                            if (!"".equals(valor)) {
                                                if (isNumeric(valor) != true) {
                                                    while (isNumeric(valor) != true) {
                                                        System.out.println("Introduce un número o deje el campo vacío");
                                                        valor = sc.nextLine();
                                                        if (isNumeric(valor) == true || valor.equals("")) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                if (!"".equals(valor)) {
                                                    empl.setCodigoJefe(valor);
                                                } else {
                                                    System.out.println("");
                                                }
                                            } else {
                                                System.out.println("");
                                            }
                                            
                                            System.out.println("Puesto: ");
                                            valor = sc.nextLine();
                                            empl.setPuesto(valor);
                                            
                                            Empleado empleado1 = empleados.read(valor);
                                            //Comprueba que existe el empleado en la base de datos.
                                            if (empleado1 != null) {
                                                while (empleado1 == null) {
                                                    System.out.println("El empleado no se encuentra en la base de datos, introduzca uno nuevo o pulse 0 para cancelar");
                                                    valor = sc.nextLine();

                                                    empleado1 = empleados.read(valor);
                                                    if (valor.equals("0")) {
                                                        System.out.println("Se ha cancelado la accion.");
                                                        break;
                                                    }
                                                    if (empleado1 != null) {                                                       
                                                        empl.setCodigoEmpleado(valor);
                                                        empleados.update(empl);
                                                        break;
                                                    }
                                                }
                                            }
                                            empleados.update(empl);
                                            System.out.println("Objeto actualizado");

                                        } catch (SQLException ex) {
                                            System.err.println("Error: " + ex.getMessage());
                                        }

                                        break;
                                    case "2":
                                        //Delete
                                        System.out.println("Elige el código de la oficina que quieres borrar");

                                        try {

                                            String codigoOficina = sc.nextLine();
                                            Empleado cu = empleados.read(codigoOficina);
                                            if (cu == null) {
                                                while (cu == null) {
                                                    System.out.println("No existe la oficina, vuelva a intentarlo o pulse 0 para cancelar");
                                                    codigoOficina = sc.nextLine();
                                                    cu = empleados.read(codigoOficina);
                                                    if (codigoOficina.equals("0")) {

                                                        break;
                                                    }
                                                    if (cu != null) {
                                                        empleados.delete(codigoOficina);
                                                        System.out.println("Se ha borrado la oficina " + codigoOficina);
                                                    }
                                                }
                                            } else {
                                                empleados.delete(codigoOficina);
                                                System.out.println("Se ha borrado la oficina " + codigoOficina);
                                            }

                                        } catch (SQLException ex) {
                                            System.err.println("Error: " + ex.getMessage());
                                        }

                                        System.out.println("Borrar");
                                        break;

                                    case "0":
                                        System.out.println("Volver al menu principal");
                                        MB = true;
                                        break;
                                    default:
                                        System.out.println("Eliga un valor válido");
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Debes insertar un número");
                                sc.next();
                            }
                        }

            break;            

                    //Close connection/Cerrar el menú
                    case "0":
                        try {
                            empleados.close();
                            System.out.println("Conexión cerrada");
                            System.exit(0);
                        } catch (SQLException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        salir = true;
                        break;
                    default:
                        System.out.println("Elija un valor válido");
                }

            } catch (InputMismatchException e) {
                System.out.println("Inserte un número");
                sc.next();
            }
        }

    }

