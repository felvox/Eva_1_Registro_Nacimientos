package Modelo;

import java.util.Date;

/**
 * Clase Nacimiento para representar los datos de un nacimiento.
 * 
 * @author felvo
 */
public class Nacimiento {
    
    private int id;
    private String nombre;
    private int peso;
    private Date fechaNacimiento;
    private boolean prematuro;
    private char sexo;
    private String centro;

    // Constructor
    public Nacimiento(int id, String nombre, int peso, Date fechaNacimiento, boolean prematuro, char sexo, String centro) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.prematuro = prematuro;
        this.sexo = sexo;
        this.centro = centro;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if (peso > 0) {
            this.peso = peso;
        } else {
            throw new IllegalArgumentException("El peso debe ser un número positivo.");
        }
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isPrematuro() {
        return prematuro;
    }

    public void setPrematuro(boolean prematuro) {
        this.prematuro = prematuro;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("El sexo debe ser 'M' o 'F'.");
        }
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getDescripcionSexo() {
        return this.sexo == 'M' ? "Masculino" : "Femenino";
    }

    @Override
    public String toString() {
        return "Nacimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", fechaNacimiento=" + fechaNacimiento +
                ", prematuro=" + prematuro +
                ", sexo=" + sexo +
                ", centro='" + centro + '\'' +
                '}';
    }
}
