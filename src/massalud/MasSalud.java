/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massalud;

import java.sql.Connection;
import java.time.LocalDate;
import massalud.AccesoDatos.AfiliadoData;
import massalud.AccesoDatos.Conexion;
import massalud.AccesoDatos.OrdenData;
import massalud.Entidades.Afiliado;
import massalud.Entidades.Empleado;
import massalud.Entidades.Especialidad;
import massalud.Entidades.Orden;
import massalud.Entidades.Prestador;
import massalud.Entidades.Prestador;
import massalud.AccesoDatos.EspecialidadData;
import massalud.AccesoDatos.PrestadorData;

/**
 *
 * @author DANILO
 */
public class MasSalud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       
//        Connection con=Conexion.getConexion();
//        Empleado juan = new Empleado(1,"Max", "Power", 12345678, "Maxpower", "contraseña123", 1234567890, "Password123", true);
//        Afiliado a=new Afiliado(1,"Candela","Romero",12345678,"Junin 987",2147483647,juan,true);
//        Especialidad e=new Especialidad(1,"Cardiología",true);
//        Prestador p=new Prestador(1,"Juan","Pérez","Hospital ABC","Calle Principal 123","123456789","juan@example.com",e ,true);
//        Orden ord=new Orden(LocalDate.of(1999,5,22),"Efvo",20.20,a,p);
//      OrdenData ordD=new OrdenData();
//        ordD.guardarOrden(ord); 

        
        
        

//CLASE PRESTADOR


//        Connection con = Conexion.getConexion();
//        EspecialidadData especialidadData = new EspecialidadData(con); // 
//        PrestadorData prestadorData = new PrestadorData();
//
//        int id = 10;
//        Prestador prestador = (Prestador) prestadorData.buscarPrestador(id);
//
//        if (prestador == null) {
//            System.out.println("Prestador con ID " + id + " no encontrado.");
//        } else {
//            System.out.println("Prestador encontrado:");
//            System.out.println("ID: " + prestador.getId());
//            System.out.println("Nombre: " + prestador.getNombre());
//            System.out.println("Apellido: " + prestador.getApellido());
//            System.out.println("Institución: " + prestador.getInstitucion());
//            System.out.println("Dirección: " + prestador.getDireccion());
//            System.out.println("Telefono: " + prestador.getTelefono());
//            System.out.println("Email: " + prestador.getEmail());
//
//            if (prestador.getEstado()) {
//                System.out.println("Estado: Activo");
//            } else {
//                System.out.println("Estado: Inactivo");
//            }
//
//            int idEspecialidad = prestador.getEspecialidad().getIdEspecialidad();
//            String nombreEspecialidad = especialidadData.buscarEspecialidadPorId(idEspecialidad).getNombre();
//
//            System.out.println("Número de Especialidad: " + idEspecialidad);
//            System.out.println("Nombre de Especialidad: " + nombreEspecialidad);
//        }
    }
}

//       
//        Connection con=Conexion.getConexion();
//        Empleado juan = new Empleado("Juan", "Fernandez", 42078248, "JuanFer", "juan1234", 155348604, "alfa23", true);
//        Afiliado a=new Afiliado(1,"Candela","Romero",12345678,"Junin 987",2147483647,juan,true);
//        Especialidad e=new Especialidad(1,"Cardiología",true);
//        Prestador p=new Prestador("Juan","Pérez","Hospital ABC","Calle Principal 123",123456789,"juan@example.com",e ,true);
//        Orden ord=new Orden(LocalDate.of(1999,5,22),"Efvo",20.20,a,p);
//      OrdenData ordD=new OrdenData();
//        ordD.guardarOrden(ord); 
//        
//        
        
        
//        Empleado juan = new Empleado("Juan", "Fernandez", 42078248, "JuanFer", "juan1234", 155348604, "alfa23", true);
//        EmpleadoData emp = new EmpleadoData();
        
        // Agregado de Empleado 
//        emp.guardarEmpleado(juan);
        
        // Modificado de Empleado
//        Empleado juan = new Empleado(11,"Juan Antonio", "Fernandez", 42078248, "JuanFer2307", "juan1234", 155348604, "alfa23", true);
//        emp.modificarEmpleado(juan);

        // Eliminar un Empleado
//        emp.eliminarEmpleado(11);

        // Buscar un Empleado Por DNI
//        Empleado empxdni = emp.buscarEmpleadoPorDni(42078248);//Dado de Baja
//        Empleado empxdni = emp.buscarEmpleadoPorDni(23456789);//No dado de Baja
//          if(empxdni!= null){
//            System.out.println("DNI: "+empxdni.getDni());
//            System.out.println("Apellido: "+empxdni.getApellido());
//            System.out.println("Nombre: "+empxdni.getNombre());
//            System.out.println("Telefono: "+empxdni.getTel());
//            System.out.println("Estado: "+empxdni.isEstado());
//          }

        // Buscar un Empleado por su ID
//        Empleado empxid = emp.buscarEmpleado(11);//Dado de Baja
//        Empleado empxid = emp.buscarEmpleado(10);//No dado de Baja
//          if(empxid!= null){
//            System.out.println("DNI: "+empxid.getDni());
//            System.out.println("Apellido: "+empxid.getApellido());
//            System.out.println("Nombre: "+empxid.getNombre());
//            System.out.println("Telefono: "+empxid.getTel());
//            System.out.println("Estado: "+empxid.isEstado());
//          }

        // Lista de Empleados
//        for (Empleado empleado : emp.listarEmpleado()) {
//            System.out.println("DNI: " + empleado.getDni());
//            System.out.println("Apellido:" + empleado.getApellido());
//            System.out.println("Nombre: " + empleado.getNombre());
//            System.out.println("Telefono: " + empleado.getTel());
//            System.out.println("Estado:" + empleado.isEstado());
//            System.out.println("-------------------------------");
//        }
     //   AfiliadoData ad=new AfiliadoData();
//         Empleado e=new Empleado(1,"Max","Power",12345678,"Maxpower","contraseña123", 1234567890,"pasword123", true);
//        Afiliado a=new Afiliado(15,"Danilo","Garay",98124510,"Riobamba 785",32145689, e ,true);    
//        ad.guardarAfiliado(a); guardar afiliado

//        ad.modificarAfiliado(a); modificar afiliado

//          ad.eliminarAfiliado(15); eliminado logico de afiliado
//          Afiliado afi=ad.buscarAfiliado(10);
//          if(afi!=null){
//              System.out.println("Nombre "+afi.getNombre());
//              System.out.println("Apellido "+afi.getApellido());
//              System.out.println("DNI "+afi.getDni());
          

//              Afiliado afi=ad.buscarAfiliadoPorDni(12345678);
//                if(afi!=null){
//              System.out.println("Nombre "+afi.getNombre());
//              System.out.println("Apellido "+afi.getApellido());
//              System.out.println("DNI "+afi.getDni());
//          }
//          for(Afiliado a: ad.listarAfiliado()){
//          
//              System.out.println("ID "+a.getIdafiliaado());
//              System.out.println("Nombre "+a.getNombre());
//              System.out.println("Apellido "+a.getApellido());
//              System.out.println("Domicilio "+a.getDomicilio());
//          
//          }
          
          
    
    
    
    
    
    

        

