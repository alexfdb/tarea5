package es.file.json.tres;


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
public class HechizoService   {

    String path = "src/main/resources/hechizos.json";
    TypeReference<Set<Hechizo>> typeReference = new TypeReference<Set<Hechizo>>() {};
    Set<Hechizo> hechizos = JsonUtil.jsonToSet(path, typeReference);
    
    /**
     * Constructor vacio.
     */
    public HechizoService() {}

    /**
     * Busca un hechizo por su id.
     * @param id id del hechizo a buscar.
     * @return retorna el hechizo buscado.
     */
    public Hechizo findById(int id) {
        for (Hechizo hechizo : hechizos) {
            if(hechizo.getId() == id) {
                return hechizo;
            }
        }
        return null;
    }

    /**
     * Agrega un hechizo a la lista.
     * @param obj hechizo a agregar a la lista.
     * @return retorna true si el hechizo fue agregado.
     */
    public boolean add(Hechizo obj) {
        if(obj == null) return false;
        return hechizos.add(obj);
    }

    /**
     * Elimina un hechizo de la lista.
     * @param obj hechizo a eliminar de la lista.
     * @return retorna true si el hechizo fue eliminado.
     */
    public boolean delete(Hechizo obj) {
        if(obj == null) return false;
        return hechizos.removeIf(h -> h.equals(obj));
    }

    /**
     * Busca hechizos por su rango de fechas.
     * @param startDate fecha de inicio de rango.
     * @param endDate fecha de fin de rango.
     * @return retorna la lista de los hechizos que se encuentren en rango.
     */
    public List<Hechizo> findByDateRange(String startDate, String endDate) {
        List<Hechizo> lista = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);
            for (Hechizo hechizo : hechizos) {
                LocalDate fechaCreacion = LocalDate.parse(hechizo.getFechaCreacion(), formatter);
                if(!fechaCreacion.isBefore(start) && !fechaCreacion.isAfter(end)) {
                    lista.add(hechizo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Muestra la lista de hechizos.
     * @return retorna la lista de hechizos.
     */
    public List<Hechizo> getList() {
        return new ArrayList<>(hechizos);
    }
    
    /**
     * Carga la lista de hechizos.
     * @return retorna la lista de hechizos.
     */
    public List<Hechizo> loadAll() {
        return new ArrayList<>(hechizos);
    }
    
}