package es.file.json.uno;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;

import es.file.json.utils.JsonUtil;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class CaballeroService extends JsonUtil{

    String path = "src/main/resources/caballeros.json";
    TypeReference<Set<Caballero>> typeReference = new TypeReference<Set<Caballero>>() {};
    Set<Caballero> caballeros = JsonUtil.jsonToSet(path, typeReference);

    /**
     * Constructor vacio.
     */
    public CaballeroService() {}

    /**
     * Busca a un caballero por su id.
     * @param id id del caballero a buscar.
     * @return retorna el caballero a buscar.
     */
    public Caballero findById(int id) {
        for (Caballero caballero : caballeros) {
            if(caballero.getId() == id) {
                return caballero;
            }
        }
        return null;
    }

    /**
     * Agrega un caballero a la lista.
     * @param obj caballero a agregar a la lista.
     * @return retorna true si el caballero fue agregado.
     */
    public boolean add(Caballero obj) {
        if(obj == null) return false;
        return caballeros.add(obj);
    }

    /**
     * Elimina un caballero de la lista.
     * @param obj caballero a eliminar de la lista.
     * @return retorna true si el caballero fue eliminado.
     */
    public boolean delete(Caballero obj) {
        if(obj == null) return false;
        return caballeros.removeIf(c -> c.equals(obj));
    }

    /**
     * Busca caballeros por su rango de fechas.
     * @param startDate fecha de inicio de rango.
     * @param endDate fecha de fin de rango.
     * @return retorna la lista de los caballeros que se encuentren en rango.
     */
    public List<Caballero> findByDateRange(String startDate, String endDate) {
        List<Caballero> lista = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);
            for (Caballero caballero : caballeros) {
                LocalDate fechaIngreso = LocalDate.parse(caballero.getFechaIngreso(), formatter);
                if(!fechaIngreso.isBefore(start) && !fechaIngreso.isAfter(end)) {
                    lista.add(caballero);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Muestra la lista de caballeros.
     * @return retorna la lista de los caballeros.
     */
    public List<Caballero> getList() {
        return new ArrayList<>(caballeros);
    }
    
    /**
     * Carga la lista de los caballeros.
     * @return retorna la lista de los caballeros.
     */
    public List<Caballero> loadAll() {
        return new ArrayList<>(caballeros);
    }
    
}
