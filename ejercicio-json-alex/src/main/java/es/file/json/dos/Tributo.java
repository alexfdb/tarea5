package es.file.json.dos;

import com.fasterxml.jackson.annotation.*;
import java.util.Objects;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class Tributo {
    private int id;
    private String nombre;
    private int distrito;
    private boolean voluntario;
    private String fechaSeleccion;

    /**
     * Constructor vacio.
     */
    public Tributo() {
    }
    
    /**
     * Constructor solo con id.
     * @param id id del tributo.
     */
    public Tributo(@JsonProperty("id") int id) {
        this.id = id;
    }

    /**
     * Constructor general.
     * @param id id del tributo.
     * @param nombre nombre del tributo.
     * @param distrito distrito del tributo.
     * @param voluntario voluntariado del tributo.
     * @param fechaSeleccion fecha de seleccion del tributo.
     */
    @JsonCreator
    public Tributo(@JsonProperty("id") int id,
                   @JsonProperty("nombre") String nombre,
                   @JsonProperty("distrito") int distrito,
                   @JsonProperty("voluntario") boolean voluntario,
                   @JsonProperty("fechaSeleccion") String fechaSeleccion) {
        this.id = id;
        this.nombre = nombre;
        this.distrito = distrito;
        this.voluntario = voluntario;
        this.fechaSeleccion = fechaSeleccion;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getDistrito() {
        return this.distrito;
    }

    public boolean getVoluntario() {
        return this.voluntario;
    }

    public boolean isVoluntario() {
        return this.voluntario;
    }

    public String getFechaSeleccion() {
        return this.fechaSeleccion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tributo)) {
            return false;
        }
        Tributo tributo = (Tributo) o;
        return Objects.equals(id, tributo.id);
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
            ", distrito='" + getDistrito() + "'" +
            ", voluntario='" + isVoluntario() + "'" +
            ", fechaSeleccion='" + getFechaSeleccion() + "'" +
            "}";
    }

}
