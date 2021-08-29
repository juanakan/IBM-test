import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Archivo {
    public static void main(String[] args) {
        Proveedor proveedor = new Proveedor();
        String proveedorSeleccionado = "El cliente no tiene proveedores asignados";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Proveedor> proveedores = new ArrayList<>();

        try {
            Connection conn;
            conn = Conexion.getInstance();

            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM proveedores WHERE id_proveedor=" + args[0]);

            while (resultado.next()) {
                proveedor.setIdProveedor(resultado.getString("id_proveedor"));
                proveedor.setNombre(resultado.getString("nombre"));
                proveedor.setFechaAlta(sdf.format(resultado.getDate("fecha_alta")));
                proveedor.setIdCliente(resultado.getString("id_cliente"));

                proveedores.add(proveedor);

                if (proveedores.size() == 1) {
                    for (Proveedor seleccionado : proveedores) {
                        proveedorSeleccionado = seleccionado.toString();
                    }
                }
                resultado.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Crear_Archivo archivo = new Crear_Archivo();
        archivo.crearArchivo(proveedorSeleccionado);
    }
}

