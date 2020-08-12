package com.bitlab.utilidades;

import com.bitlab.controladores.UsuarioControlador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author henry
 */
@ManagedBean
@ViewScoped
public class ChatAyuda implements Serializable {

    private UsuarioControlador usControador;
    private List<String> listAyuda = new ArrayList<>();

    /**
     * Creates a new instance of ChatAyuda
     */
    public ChatAyuda() {
        usControador = new UsuarioControlador();
        llenarMenu();
    }

    public void llenarMenu() {
        listAyuda.add("Digita cualquier de los siguientes comandos para recibir asistencia:");
        listAyuda.add("*  Agregar -> Para saber como agregar un nuevo empleado");
        listAyuda.add("*  Actualizar -> Para saber como actualizar un empleado");
        listAyuda.add("*  Desactivar -> Para saber como desactivar un empleado despedido de la empresa");
        listAyuda.add("*  Planilla -> Para saber como ver y generar una planilla de pagos");
        listAyuda.add("*  Salarios -> Para saber como actualizar los salarios de los empleados");
    }

    public String handleCommand(String command, String[] params) {

        if (command.equalsIgnoreCase("Agregar")) {
            return "$ Para agregar un nuevo empleado, debes de ingresar al menú Gestión de Empleados -> Mantenimiento de Empleados y por hacer click en el botón Crear Nuevo Empleado e ingresar los datos necesarios, al finalizar dar click en Guardar. ";
        }
        if (command.equalsIgnoreCase("Desactivar")) {
            return "$ Para desactivar un empleado, debes de ingresar al menú Gestión de Empleados -> Mantenimiento de Empleados, en la columna Estado de Empleado debes desactivar el botón y listo!";
        }
        if (command.equalsIgnoreCase("Actualizar")) {
            return "$ Para actualizar un nuevo empleado, solo debes de ingresar al menú Gestión de Empleados -> Mantenimiento de Empleados y en la columna opción verás el ícono de lupa en cada empleado, das click para editar o actualizar sus datos.";
        }
        if (command.equalsIgnoreCase("Desactivar")) {
            return "";
        }
        if (command.equalsIgnoreCase("Planilla")) {
            return "$ Para ver y exportar la planilla en formato PDF o CVS ingresa al menú Gestión de Pagos -> Visualización de Planilla y elige la opción deseada.";
        }
        if (command.equalsIgnoreCase("Exportar")) {
            return "";
        }
        if (command.equalsIgnoreCase("Salarios")) {
            return "$ Para actualizar los salarios ingresa al men Gestión de Pagos -> Visualización de pagos generados y por último hacer click en la lupa del salario a actualizar";
        } else {
            return command + "$ Comando Inválido, por favor digite Ayuda para conocer los comandos válidos";
        }
    }

    public List<String> getListAyuda() {
        return listAyuda;
    }

    public void setListAyuda(List<String> listAyuda) {
        this.listAyuda = listAyuda;
    }

}
