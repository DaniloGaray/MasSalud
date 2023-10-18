/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package massalud.AccesoDatos;

/**
 *
 * @author Leroom
 */

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import massalud.Entidades.Especialidad;
import massalud.Entidades.Prestador;
import massalud.AccesoDatos.EspecialidadData;

public class PrestadorData {

    private Connection connection=null;
    private EspecialidadData especialidadData;
    public PrestadorData() {
        connection=Conexion.getConexion();
    }
    Prestador prestador = new Prestador();
    
 ////CREAR UN NUEVO PRESTADOR-------------------------------------------------------------------------------------////
    public void guardarPrestador(Prestador prestador) {
    try {
        if (prestador.getNombre() == null || prestador.getApellido() == null) {
            return;
        }

        String query = "INSERT INTO prestador (nombre, apellido, dni, institucion, direccion, telefono, email, idespecialidad, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, prestador.getNombre());
            statement.setString(2, prestador.getApellido());
            statement.setInt(3, prestador.getDni());
            statement.setString(4, prestador.getInstitucion());
            statement.setString(5, prestador.getDireccion());
            statement.setString(6, prestador.getTelefono());
            statement.setString(7, prestador.getEmail());
            statement.setInt(8, prestador.getEspecialidad().getIdEspecialidad());
            statement.setBoolean(9, prestador.isEstado());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                prestador.setIdPrestador(generatedKeys.getInt(1));
                JOptionPane.showMessageDialog(null, "Nuevo Prestador agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el nuevo Prestador.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062) {
            JOptionPane.showMessageDialog(null, "Error: El DNI ingresado ya existe en la base de datos.", "DNI Duplicado", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Error al guardar el prestador: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al guardar el Prestador: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

////METODO ACTUALIZAR QUE MUESTRA SOLO LOS CAMBIOS------------------------------------------------------////

public void actualizarPrestador(Prestador prestador) {
    try {
        if (prestador.getIdPrestador() == 0) {
            return;
        }
        String query = "UPDATE prestador SET nombre = ?, apellido = ?, dni = ?, institucion = ?, direccion = ?, telefono = ?, email = ?, idespecialidad = ?, estado = ? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, prestador.getNombre());
            statement.setString(2, prestador.getApellido());
            statement.setInt(3,prestador.getDni());
            statement.setString(4, prestador.getInstitucion());
            statement.setString(5, prestador.getDireccion());
            statement.setString(6, prestador.getTelefono());
            statement.setString(7, prestador.getEmail());
            statement.setInt(8, prestador.getEspecialidad().getIdEspecialidad());
            statement.setBoolean(9, prestador.isEstado());
            statement.setInt(10, prestador.getIdPrestador());
            statement.executeUpdate();
            
            String mensaje = "Prestador fue actualizado exitosamente.\n";
            mensaje += "Datos modificados:\n";
            mensaje += "Nombre: " + prestador.getNombre() + "\n";
            mensaje += "Apellido: " + prestador.getApellido() + "\n";
            mensaje += "DNI: " + prestador.getDni() + "\n";
            mensaje += "Institución: " + prestador.getInstitucion() + "\n";
            mensaje += "Dirección: " + prestador.getDireccion() + "\n";
            mensaje += "Teléfono: " + prestador.getTelefono() + "\n";
            mensaje += "Email: " + prestador.getEmail() + "\n";
            mensaje += "Especialidad: " + prestador.getEspecialidad().getNombre() + "\n";
            mensaje += "Estado: " + (prestador.isEstado() ? "Activo" : "Inactivo");

            JOptionPane.showMessageDialog(null, mensaje);
        }
    } catch (SQLException e) {
        System.out.println("Error al actualizar el prestador: " + e.getMessage());
    }
}

////ELIMINAR UN PRESTADOR A TRAVES DE SU ID------------------------------------------------------------------////
 public void eliminarPrestador(int id) {
    try {
        String query = "UPDATE prestador SET estado = 0 WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                String mensajeConfirmacion = "El prestador con ID " + id + " fue eliminado exitosamente.";
                JOptionPane.showMessageDialog(null, mensajeConfirmacion, "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);

            } else {
                String mensajeError = "Error: No se encontró prestador con ID " + id + " para eliminar.";
                JOptionPane.showMessageDialog(null, mensajeError, "Error al Eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        String mensajeError = "Error al eliminar el prestador: " + e.getMessage();
        JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

////MOSTRAR LISTA DE PRESTADORES EXISTENTES-----------------------------------------------------------------////
public List<Prestador> obtenerPrestadores() {
    List<Prestador> prestadores = new ArrayList<>();
    try {
        String sql = "SELECT * FROM prestador";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Prestador prestador = new Prestador();
                prestador.setIdPrestador(resultSet.getInt("id"));
                prestador.setNombre(resultSet.getString("nombre"));
                prestador.setApellido(resultSet.getString("apellido"));
                prestador.setDni(resultSet.getInt("dni"));
                prestador.setInstitucion(resultSet.getString("institucion"));
                prestador.setDireccion(resultSet.getString("direccion"));
                prestador.setTelefono(resultSet.getString("telefono"));
                prestador.setEmail(resultSet.getString("email"));
                EspecialidadData ed = new EspecialidadData();
                Especialidad especialidad = ed.buscarEspecialidadPorId(resultSet.getInt("idespecialidad"));
                prestador.setEspecialidad(especialidad);
                prestador.setEstado(resultSet.getBoolean("estado"));
                prestadores.add(prestador);
            }

            if (prestadores.isEmpty()) {
                String mensajeError = "Error: No se encontraron prestadores.";
                JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                StringBuilder mensajeExito = new StringBuilder("La lista de prestadores es:\n");
                for (Prestador p : prestadores) {
                    mensajeExito.append("ID: ").append(p.getIdPrestador()).append("\n");
                    mensajeExito.append("Nombre: ").append(p.getNombre()).append("\n");
                    mensajeExito.append("Apellido: ").append(p.getApellido()).append("\n");
                    mensajeExito.append("DNI: ").append(p.getDni()).append("\n");
                    mensajeExito.append("Institución: ").append(p.getInstitucion()).append("\n");
                    mensajeExito.append("Dirección: ").append(p.getDireccion()).append("\n");
                    mensajeExito.append("Teléfono: ").append(p.getTelefono()).append("\n");
                    mensajeExito.append("Email: ").append(p.getEmail()).append("\n");
                    mensajeExito.append("Especialidad: ").append(p.getEspecialidad().getNombre()).append("\n");
                    mensajeExito.append("Estado: ").append(p.isEstado() ? "Activo" : "Inactivo").append("\n");
                    mensajeExito.append("-------------------------------------------------\n");
                }

                JTextArea textArea = new JTextArea(mensajeExito.toString());
                textArea.setWrapStyleWord(true);
                textArea.setLineWrap(true);
                textArea.setCaretPosition(0);

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(600, 400));


                JOptionPane.showMessageDialog(null, scrollPane, "Prestadores Encontrados", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    } catch (SQLException e) {
       
    }
    return prestadores;
}
////BUSCAR UN PRESTADOR POR ID Y MOSTRAR TODOS SUS DATOS-----------------------------------------------////
public Prestador buscarPrestador(int idABuscar) {
    Prestador prestador = null;
    try {
        String sql = "SELECT * FROM prestador WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idABuscar);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            EspecialidadData ed = new EspecialidadData();
            prestador = new Prestador();
            prestador.setIdPrestador(resultSet.getInt("id"));
            prestador.setNombre(resultSet.getString("nombre"));
            prestador.setApellido(resultSet.getString("apellido"));
            prestador.setDni(resultSet.getInt("dni"));
            prestador.setInstitucion(resultSet.getString("institucion"));
            prestador.setDireccion(resultSet.getString("direccion"));
            prestador.setTelefono(resultSet.getString("telefono"));
            prestador.setEmail(resultSet.getString("email"));
            Especialidad especialidad = ed.buscarEspecialidadPorId(resultSet.getInt("idespecialidad"));
            prestador.setEspecialidad(especialidad);
            prestador.setEstado(resultSet.getBoolean("estado"));

            String mensaje = "El prestador fue encontrado exitosamente:\n";
            mensaje += "ID: " + prestador.getIdPrestador() + "\n";
            mensaje += "Nombre: " + prestador.getNombre() + "\n";
            mensaje += "Apellido: " + prestador.getApellido() + "\n";
            mensaje += "DNI: " + prestador.getDni() + "\n";
            mensaje += "Institución: " + prestador.getInstitucion() + "\n";
            mensaje += "Dirección: " + prestador.getDireccion() + "\n";
            mensaje += "Teléfono: " + prestador.getTelefono() + "\n";
            mensaje += "Email: " + prestador.getEmail() + "\n";
            mensaje += "Especialidad: " + prestador.getEspecialidad().getNombre() + "\n";
            mensaje += "Estado: " + (prestador.isEstado() ? "Activo" : "Inactivo");

            JOptionPane.showMessageDialog(null, mensaje, "Prestador Encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException p) {
        String mensaje = "Error al obtener prestador: " + p.getMessage();
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    return prestador;
}
 ////BUSCAR PRESTADOR POR NOMBRE DE ESPECIALIDAD------------------------------------------------------------////
public List<Prestador> buscarPrestadoresPorEspecialidad(String nombreEspecialidad) {
    List<Prestador> prestadores = new ArrayList<>();
    try {
        String sql = "SELECT p.* FROM prestador p INNER JOIN especialidad e ON p.idespecialidad = e.idespecialidad WHERE e.nombre = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nombreEspecialidad);
        ResultSet resultSet = ps.executeQuery();
        EspecialidadData ed = new EspecialidadData();

        while (resultSet.next()) {
            Prestador prestador = new Prestador();
            prestador.setIdPrestador(resultSet.getInt("id"));
            prestador.setNombre(resultSet.getString("nombre"));
            prestador.setApellido(resultSet.getString("apellido"));
            prestador.setDni(resultSet.getInt("dni"));
            prestador.setInstitucion(resultSet.getString("institucion"));
            prestador.setDireccion(resultSet.getString("direccion"));
            prestador.setTelefono(resultSet.getString("telefono"));
            prestador.setEmail(resultSet.getString("email"));
            Especialidad especialidad = ed.buscarEspecialidadPorId(resultSet.getInt("idespecialidad"));
            prestador.setEspecialidad(especialidad);
            prestador.setEstado(resultSet.getBoolean("estado"));
            prestadores.add(prestador);
        }

        if (!prestadores.isEmpty()) {
            StringBuilder mensaje = new StringBuilder("Prestadores encontrados con la especialidad '" + nombreEspecialidad + "':\n");
            for (Prestador prestador : prestadores) {
                mensaje.append("Nombre: ").append(prestador.getNombre()).append("\n");
                mensaje.append("Apellido: ").append(prestador.getApellido()).append("\n");
                mensaje.append("DNI: ").append(prestador.getDni()).append("\n");
                mensaje.append("Especialidad: ").append(prestador.getEspecialidad()).append("\n");
                mensaje.append("Institución: ").append(prestador.getInstitucion()).append("\n");
                mensaje.append("Dirección: ").append(prestador.getDireccion()).append("\n");
                mensaje.append("Teléfono: ").append(prestador.getTelefono()).append("\n");
                mensaje.append("Email: ").append(prestador.getEmail()).append("\n");
                mensaje.append("Estado: ").append(prestador.isEstado() ? "Activo" : "Inactivo").append("\n");
                mensaje.append("------------------------------\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        } else {
            String mensajeError = "Error: No se encontraron prestadores con especialidad '" + nombreEspecialidad + "'";
            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException p) {
        String mensaje = "Error al obtener prestadores: " + p.getMessage();
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    return prestadores;
}
}