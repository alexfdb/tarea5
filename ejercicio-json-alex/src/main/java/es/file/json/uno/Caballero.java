package es.file.json.uno;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.util.Objects;
/**
 * @author alexfdb
 * @version 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Caballero {
    private int id;
    private String nombre;
    private String constelacion;
    private int nivel;
    private String fechaIngreso;

    /**
     * Constructor vacio.
     */
    public Caballero() {
    }

    /**
     * Constructor solo con id.
     * @param id id del caballero.
     */
    public Caballero(@JsonProperty("id") int id) {
        this.id = id;
    }

    /**
     * Constructor general.
     * @param id id del caballero.
     * @param nombre nombre del caballero.
     * @param constelacion constelacion del caballero.
     * @param nivel nivel del caballero.
     * @param fechaIngreso fecha de ingreso del caballero
     */
    @JsonCreator
    public Caballero(@JsonProperty("id") int id,
                     @JsonProperty("nombre") String nombre,
                     @JsonProperty("constelacion") String constelacion,
                     @JsonProperty("nivel") int nivel,
                     @JsonProperty("fechaIngreso") String fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.constelacion = constelacion;
        this.nivel = nivel;
        this.fechaIngreso = fechaIngreso;
    }
    
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getConstelacion() {
        return this.constelacion;
    }

    public int getNivel() {
        return this.nivel;
    }

    public String getFechaIngreso() {
        return this.fechaIngreso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Caballero)) {
            return false;
        }
        Caballero caballero = (Caballero) o;
        return Objects.equals(id, caballero.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
   
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", constelacion='" + getConstelacion() + "'" +
            ", nivel='" + getNivel() + "'" +
            ", fechaIngreso='" + getFechaIngreso() + "'" +
            "}";
    }

}