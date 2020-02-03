package examen3ªev_pr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

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
        Cursos cursos = null;
        Profesores profesor = null;
        //Abrir conexion a la base de Datos
        try {
            cursos = new Cursos();
        } catch (SQLException ex) {
            System.err.println("Error al abrir la base de datos: " + ex.getMessage());
            System.exit(1);
        }
        try {
            profesor = new Profesores();
        } catch (SQLException ex) {
            System.err.println("Error al abrir la base de datos: " + ex.getMessage());
            System.exit(1);
        }
        System.out.println("Susccessful connection");

        System.out.println("\t\t\t\t\t\tBase de Datos Academia");

        boolean salir = false;
        String n = null;

        while (!salir) {
            //ArrayList para mostrar todos los registros
            try {
                ArrayList<Curso> cur = cursos.lista();
                System.out.println("\n| Codigo Curso  | Nombre\t          | Duración   | Final del curso | Inicio del curso |   Id_Profesor   |    Nombre  |   Apellidos  |  email ");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (Curso cu : cur) {
                                    System.out.printf("| %-13d | %-23s | %-10d | %-15s | %-15s | %-10d | %-15s | %-15s | %-15s  \n", cu.getIdCurso(), cu.getNombreCurso(), cu.getDuracionCurso(), cu.getFechaFin(), cu.getFechaInicio(), cu.getIdProfesor(),cu.getProfesor().getNombre(), cu.getProfesor().getApellidos(), cu.getProfesor().getEmail());

                }

            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }

            System.out.println("1.-Buscar un registro\n2.-Añadir registro\n3.-Modificar/Borrar registro\n0.-Cerrar menú");

            try {

                n = sc.nextLine();

                switch (n) {
                    //Buscar registros
                    case "1":
                        System.out.println("Elige el código del curso");

                        try {

                            String o = sc.nextLine();
                            Curso cu = cursos.read(o);

                            if (cu == null) {
                                while (cu == null) {

                                    System.out.println("No existe el curso, vuelva a intentarlo o pulse '0' para salir");
                                    o = sc.nextLine();
                                    if (o.equals("0")) {
                                        break;
                                    }
                                    cu = cursos.read(o);

                                    if (cu != null) {
                                        System.out.println(cu.toString() + "\n");
                                    }

                                }
                            } else {
                                System.out.println(cu.toString() + "\n");
                            }

                        } catch (SQLException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

//Añadir registro
                    case "2"://------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                        /*Create*/
                        try {

                            System.out.println("Introduce los datos del curso que quieres crear");
                            System.out.println("Codigo del curso:");
                            String idCur = sc.nextLine();
                            Curso c = cursos.read(idCur);

                            if (c != null) {
                                while (c != null) {
                                    System.out.println("Este Id ya está en uso, eliga otro");
                                    idCur = sc.nextLine();

                                    c = cursos.read(idCur);
                                }
                            }

                            System.out.println("Nombre:");
                            String nombre = sc.nextLine();
                            System.out.println("Duracion (Horas):");
                            String duracion = sc.nextLine();
                            if (isNumeric(duracion) != true) {
                                while (isNumeric(duracion) != true) {
                                    System.out.println("Introduce un número");
                                    duracion = sc.nextLine();
                                    if (isNumeric(duracion) == true) {
                                        break;
                                    }
                                }

                            }

                            System.out.println("Id del profesor (Puede ser nulo):");
                            String idProfesor = sc.nextLine();
                            if (!idProfesor.equals("")) {
                                if (isNumeric(idProfesor) != true) {
                                    while (isNumeric(idProfesor) != true) {
                                        System.out.println("Introduce un número");
                                        idProfesor = sc.nextLine();
                                        if (isNumeric(idProfesor) == true) {
                                            break;
                                        }
                                    }
                                }
                            }
                            Profesor profe = profesor.read(idProfesor);
                            if (profe == null) {
                                while (profe == null) {
                                    System.out.println("El profesor no se encuentra en la base de datos, intoduzca uno nuevo");
                                    idProfesor = sc.nextLine();
                                    profe = profesor.read(idProfesor);
                                    if (profe != null) {
                                        break;
                                    }
                                }
                            }

                            System.out.println("Fecha de Inicio (aaaa-mm-dd):");
                            String fechaInicio = sc.nextLine();
                            System.out.println("Fecha de fin del Curso (aaaa-mm-dd):");
                            String fechaFin = sc.nextLine();

                            if (!"".equals(idCur) && !"".equals(nombre) && !"".equals(duracion) && !"".equals(fechaFin) && !"".equals(fechaInicio)) {

                                Integer idCurI = Integer.parseInt(idCur);
                                Integer duracionI = Integer.parseInt(duracion);
                                Integer idProfesorI;
                                if (!idProfesor.equals("")) {
                                    idProfesorI = Integer.parseInt(idProfesor);
                                } else {
                                    idProfesorI = null;
                                }

                                System.out.println("¿Está seguro de que quiere crear este objeto?");
                                System.out.println("1.- Si\n2.-No");

                                String x = sc.nextLine();

                                if (x.equals("1") || x.equals("2")) {
                                    switch (x) {
                                        case "1":
                                            Curso cur = new Curso(idCurI, nombre, duracionI, idProfesorI, fechaInicio, fechaFin);
                                            cursos.create(cur);
                                            System.out.println("Obejo creado");
                                            break;
                                        case "2":
                                            System.out.println("No se crea el objeto");
                                            break;
                                    }
                                } else {
                                    while (!x.equals("1") || !x.equals("2")) {
                                        System.out.println("Introduze un valor válido (1/2)");
                                        x = sc.nextLine();
                                        if (x.equals("1") || x.equals("2")) {
                                            switch (x) {
                                                case "1":
                                                    Curso cur = new Curso(idCurI, nombre, duracionI, idProfesorI, fechaInicio, fechaFin);
                                                    cursos.create(cur);
                                                    System.out.println("Obejo creado");
                                                    break;
                                                case "2":
                                                    System.out.println("No se crea el objeto");
                                                    break;
                                            }
                                            break;
                                        }

                                    }

                                }

                            }

                            while ("".equals(idCur) || "".equals(nombre) || "".equals(duracion) || "".equals(fechaFin) || "".equals(fechaInicio)) {
                                if ("".equals(idCur) || "".equals(nombre) || "".equals(duracion) || "".equals(fechaFin) || "".equals(fechaInicio)) {
                                    System.out.println("Introduce bien los datos del curso");
                                    System.out.println("Codigo del curso:");
                                    idCur = sc.nextLine();
                                    c = cursos.read(idCur);

                                    if (c != null) {
                                        while (c != null) {
                                            System.out.println("Este Id ya está en uso, eliga otro");
                                            idCur = sc.nextLine();

                                            c = cursos.read(idCur);
                                        }
                                    }
                                    System.out.println("Nombre:");
                                    nombre = sc.nextLine();
                                    System.out.println("Duracion (Horas):");
                                    duracion = sc.nextLine();
                                    if (isNumeric(duracion) != true) {
                                        while (isNumeric(duracion) != true) {
                                            System.out.println("Introduce un número");
                                            duracion = sc.nextLine();
                                            if (isNumeric(duracion) == true) {
                                                break;
                                            }
                                        }

                                    }
                                    profe = profesor.read(idProfesor);
                                    if (profe == null) {
                                        while (profe == null) {
                                            System.out.println("El profesor no se encuentra en la base de datos, intoduzca uno nuevo");
                                            idProfesor = sc.nextLine();
                                            profe = profesor.read(idProfesor);
                                            if (profe != null) {
                                                break;
                                            }
                                        }
                                    }

                                    System.out.println("Id del profesor (Puede ser nulo):");
                                    idProfesor = sc.nextLine();
                                    if (!idProfesor.equals("")) {
                                        if (isNumeric(idProfesor) != true) {
                                            while (isNumeric(idProfesor) != true) {
                                                System.out.println("Introduce un número");
                                                idProfesor = sc.nextLine();
                                                if (isNumeric(idProfesor) == true) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    System.out.println("Fecha de Inicio (aaaa-mm-dd):");
                                    fechaInicio = sc.nextLine();
                                    System.out.println("Fecha de fin del Curso (aaaa-mm-dd):");
                                    fechaFin = sc.nextLine();

                                }
                                if (!"".equals(idCur) && !"".equals(nombre) && !"".equals(duracion) && !"".equals(fechaFin) && !"".equals(fechaInicio)) {

                                    Integer idCurI = Integer.parseInt(idCur);
                                    Integer duracionI = Integer.parseInt(duracion);
                                    Integer idProfesorI = null;
                                    if (!idProfesor.equals("")) {
                                        idProfesorI = Integer.parseInt(idProfesor);
                                    } else {
                                        idProfesorI = null;
                                    }
                                    System.out.println("¿Está seguro de que quiere crear este objeto?");
                                    System.out.println("1.- Si\n2.-No");

                                    Integer x = sc.nextInt();

                                    if (x == 1 || x == 2) {
                                        switch (x) {
                                            case 1:
                                                Curso cur = new Curso(idCurI, nombre, duracionI, idProfesorI, fechaInicio, fechaFin);
                                                cursos.create(cur);
                                                System.out.println("Obejo creado");
                                                break;
                                            case 2:
                                                System.out.println("No se crea el objeto");
                                                break;
                                        }
                                    } else {
                                        while (x != 1 || x != 2) {
                                            System.out.println("Introduze un valor válido (1/2)");
                                            x = sc.nextInt();
                                            if (x == 1 || x == 2) {
                                                switch (x) {
                                                    case 1:
                                                        Curso cur = new Curso(idCurI, nombre, duracionI, idProfesorI, fechaInicio, fechaFin);
                                                        cursos.create(cur);
                                                        System.out.println("Obejo creado");
                                                        break;
                                                    case 2:
                                                        System.out.println("No se crea el objeto");
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
                        String m;

                        while (!MB) {
                            //ArrayList para mostrar todos los registros
                            try {
                                ArrayList<Curso> cur = cursos.lista();
                              System.out.println("\n| Codigo Curso  | Nombre\t          | Duración   | Final del curso | Inicio del curso |   Id_Profesor   |    Nombre  |   Apellidos  |  email ");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                for (Curso cu : cur) {
                                    System.out.printf("| %-13d | %-23s | %-10d | %-15s | %-15s | %-10d | %-15s | %-15s | %-15s  \n", cu.getIdCurso(), cu.getNombreCurso(), cu.getDuracionCurso(), cu.getFechaFin(), cu.getFechaInicio(), cu.getIdProfesor(),cu.getProfesor().getNombre(), cu.getProfesor().getApellidos(), cu.getProfesor().getEmail());

                }

                            } catch (SQLException e) {
                                System.err.println("Error: " + e.getMessage());
                            }

                            System.out.println("1.-Modificar\n2.-Borrar\n0.-Volver al menú pricipal");

                            try {

                                m = sc.nextLine();

                                switch (m) {
                                    //Update
                                    case "1":

                                        System.out.println("Elige el código del curso que quieres actualizar");
                                        String cod = sc.nextLine();
                                        Curso c = cursos.read(cod);
                                        if (c == null) {
                                            while (c == null) {
                                                System.out.println("Este Id ya está en uso, eliga otro");
                                                cod = sc.nextLine();

                                                c = cursos.read(cod);
                                            }
                                        }

                                        try {
                                            Curso cu = cursos.read(cod);
                                            System.out.println("Actualizar: (Pulse enter si no quiere actualizar)");

                                            System.out.println("Nombre: ");
                                            String valor = sc.nextLine();

                                            if (!"".equals(valor)) {
                                                cu.setNombreCurso(valor);
                                            } else {
                                                System.out.println("No se cambia");
                                            }

                                            System.out.println("Duracion (Horas): ");
                                            valor = sc.nextLine();

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
                                                    Integer valorI = Integer.parseInt(valor);
                                                    cu.setDuracionCurso(valorI);
                                                } else {
                                                    System.out.println("No se cambia");
                                                }
                                            } else {
                                                System.out.println("No se cambia");
                                            }

                                            System.out.println("Id del profesor: (Puede ser nulo)");
                                            valor = sc.nextLine();

                                            Profesor profe = profesor.read(valor);

                                            if (profe == null) {
                                                while (profe == null) {
                                                    System.out.println("El profesor no se encuentra en la base de datos, introduzca uno nuevo o pulse 0 para cancelar");
                                                    valor = sc.nextLine();

                                                    profe = profesor.read(valor);
                                                    if(valor.equals("0"))break;
                                                    if (profe != null) {
                                                        Integer valorI = Integer.parseInt(valor);
                                                        cu.setIdProfesor(valorI);
                                                        break;
                                                    }
                                                }
                                            }

                                            System.out.println("Fecha de Inicio (aaaa-mm-dd): ");
                                            valor = sc.nextLine();
                                            if (!"".equals(valor)) {
                                                cu.setFechaInicio(valor);
                                            } else {
                                                System.out.println("No se cambia");
                                            }
                                            System.out.println("Fecha del fin del curso (aaaa-mm-dd): ");
                                            valor = sc.nextLine();
                                            if (!"".equals(valor)) {
                                                cu.setFechaFin(valor);
                                            } else {
                                                System.out.println("No se cambia");
                                            }

                                            cursos.update(cu);
                                            System.out.println("Objeto actualizado");

                                        } catch (SQLException e) {
                                            System.err.println("Error: " + e.getMessage());
                                        }

                                        break;
                                    case "2":
                                        //Delete
                                        System.out.println("Elige el código de la oficina que quieres borrar");

                                        try {

                                            String o = sc.nextLine();
                                            Curso cu = cursos.read(o);
                                            if (cu == null) {
                                                while (cu == null) {

                                                    System.out.println("No existe la oficina, vuelva a intentarlo o pulse 0 para cancelar");
                                                    o = sc.nextLine();
                                                    cu = cursos.read(o);
                                                    if (o.equals("0")) {

                                                        break;
                                                    }
                                                    if (cu != null) {
                                                        cursos.delete(o);
                                                        System.out.println("Se ha borrado la oficina " + o);
                                                    }
                                                }
                                            } else {
                                                cursos.delete(o);
                                                System.out.println("Se ha borrado la oficina " + o);
                                            }

                                        } catch (SQLException e) {
                                            System.err.println("Error: " + e.getMessage());
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
                            cursos.close();
                            System.out.println("Conexión cerrada\nCerrando base de datos...");
                            System.exit(0);
                        } catch (SQLException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        salir = true;
                        break;
                    default:
                        System.out.println("Eliga un valor válido");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }

    }

}
