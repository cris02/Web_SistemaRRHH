package com.bitlab.utilidades;
import com.bitlab.controladores.UsuarioControlador;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
/**
 *
 * @author henry
 */
@ManagedBean
@ViewScoped
public class ChatAyuda implements Serializable{
    private UsuarioControlador usControador;
    /**
     * Creates a new instance of ChatAyuda
     */
    public ChatAyuda() {
        usControador =  new UsuarioControlador();
    }
    public String handleCommand(String command, String[] params) {
        String ayuda = "$ Digita cualquier de los siguientes comandos para recibir asistencia:"
                        + "\nAgregar -> Para saber como agregar un nuevo empleado\nActualizar -> Para saber como actualizar un empleado"
                        + "\nDesactivar -> Para saber como desactivar un empleado despedido de la empresa"
                        + "\nPlanilla -> Para saber como ver y generar una planilla de pagos"
                        + "\nSalarios -> Para saber como actualizar los salarios de los empleados";
        if(command.equals("Hola")) {
           return "$ Hola, que desea saber?\n" +ayuda;
        }
        if(command.equals("Ayuda"))
            return "$ Has solicitado ayuda, con mucho gusto...\n"+  ayuda;
        if(command.equals("Agregar"))
            return "$ Para agregar un nuevo empleado, debes de ingresar al menú Gestión de Empleados -> Mantenimiento de Empleados y por hacer click en el botón Crear Nuevo Empleado e ingresar los datos necesarios, al finalizar dar click en Guardar.</a> ";
        if(command.equals("Desactivar"))
            return "$ Para desactivar un empleado, debes de ingresar al menú Gestión de Empleados -> Mantenimiento de Empleados, en la columna Estado de Empleado debes desactivar el botón y listo!";
        if(command.equals("Actualizar"))
            return "$ Para actualizar un nuevo empleado, solo debes de ingresar al menú Gestión de Empleados -> Mantenimiento de Empleados y en la columna opción verás el ícono de lupa en cada empleado, das click para editar o actualizar sus datos.";
        if(command.equals("Desactivar"))
            return "";
        if(command.equals("Planilla"))
            return "$ Para ver y exportar la planilla en formato PDF o CVS ingresa al menú Gestión de Pagos -> Visualización de Planilla y elige la opción deseada.";
        if(command.equals("Exportar"))
            return "";
        if(command.equals("Salarios"))
            return "$ Para actualizar los salarios ingresa al men Gestión de Pagos -> Visualización de pagos generados y por último hacer click en la lupa del salario a actualizar";
        else
            return command + "$ Comando Inválido, por favor digite Ayuda para conocer los comandos válidos";
        }
}