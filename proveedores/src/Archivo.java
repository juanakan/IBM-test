import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Archivo {
    public static void main(String[] args) {
        String proveedorSeleccionado = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Proveedor> proveedores = new ArrayList<>();

        try {
            Connection conn;
            conn = Conexion.getInstance();
            Statement stmt = conn.createStatement();
            ResultSet resultado;
            if (args.length == 0) {
                resultado = stmt.executeQuery("SELECT * FROM proveedores WHERE id_cliente=" + null);
            } else {
                resultado = stmt.executeQuery("SELECT * FROM proveedores WHERE id_cliente=" + args[0]);
            }

            while (resultado.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(resultado.getString("id_proveedor"));
                proveedor.setNombre(resultado.getString("nombre"));
                proveedor.setFechaAlta(sdf.format(resultado.getDate("fecha_alta")));
                proveedor.setIdCliente(resultado.getString("id_cliente"));

                proveedores.add(proveedor);
            }

            resultado.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (proveedores.size() != 0) {
            for (Proveedor p : proveedores) {
                proveedorSeleccionado = proveedorSeleccionado + p.toString();
            }
        } else {
            proveedorSeleccionado = "El cliente no tiene proveedores asignados.";
            System.out.println(proveedorSeleccionado);
        }

        Crear_Archivo archivo = new Crear_Archivo();
        archivo.crearArchivo(proveedorSeleccionado);
    }
}

