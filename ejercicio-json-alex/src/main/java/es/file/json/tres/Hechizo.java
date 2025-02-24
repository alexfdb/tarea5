package es.file.json.tres;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.util.Objects;
/**
 * @author alexfdb
 * @version 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hechizo {
    private int id;
    private String nombre;
    private String tipo;
    private boolean esOscuro;
    private String fechaCreacion;

    /**
     * Constructor vacio.
     */
    public Hechizo() {}

    /**
     * Constructor solo con id.
     * @param id id del hechizo.
     */
    public Hechizo(@JsonProperty("id") int id) {
        this.id = id;
    }

    /**
     * Constructor general.
     * @param id id del hechizo.
     * @param nombre nombre del hechizo.
     * @param tipo tipo del hechizo.
     * @param esOscuro oscuridad del hechizo.
     * @param fechaCreacion fechaCreacion del hechizo.
     */
    @JsonCreator
    public Hechizo(@JsonProperty("id") int id,
                   @JsonProperty("nombre") String nombre,
                   @JsonProperty("tipo") String tipo,
                   @JsonProperty("esOscuro") boolean esOscuro,
                   @JsonProperty("fechaCreacion") String fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.esOscuro = esOscuro;
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public boolean getEsOscuro() {
        return this.esOscuro;
    }

    public boolean isEsOscuro() {
        return this.esOscuro;
    }

    public String getFechaCreacion() {
        return this.fechaCreacion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Hechizo)) {
            return false;
        }
        Hechizo hechizo = (Hechizo) o;
        return Objects.equals(id, hechizo.id);
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
            ", tipo='" + getTipo() + "'" +
            ", esOscuro='" + isEsOscuro() + "'" +
            ", fechaCreacion='" + getFechaCreacion() + "'" +
            "}";
    }

}