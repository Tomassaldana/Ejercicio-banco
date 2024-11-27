package ejercicio.banco;


public class Cliente {
    
    private String nombre;
    private int identificacion;
    private Cuenta cuenta;
    
    public Cliente(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

}
