import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Crear_Archivo {
    public void crearArchivo(String proveedorSeleccionado) {
        String ruta = "C:\\Users\\juanc\\Desktop\\archivo";
        String nombreArchivo = "\\proveedores.txt";
        File creoRuta = new File(ruta);
        File creoArchivo = new File(ruta + nombreArchivo);
        if (!creoArchivo.exists()) {
            creoRuta.mkdirs();
            try {
                creoArchivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try (PrintWriter escritor = new PrintWriter(new FileWriter(creoArchivo))) {
            escritor.println(proveedorSeleccionado);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
