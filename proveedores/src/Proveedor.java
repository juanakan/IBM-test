public class Proveedor {
    private String idProveedor;
    private String nombre;
    private String fechaAlta;
    private String idCliente;

    public Proveedor() {
    }

    public Proveedor(String idProveedor, String nombre, String fechaAlta, String idCliente) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.idCliente = idCliente;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Id proveedor: " + idProveedor + "\n" +
                "Nombre: " + nombre + "\n" +
                "Fecha Alta: " + fechaAlta + "\n" +
                "Id cliente: " + idCliente;
    }
}
