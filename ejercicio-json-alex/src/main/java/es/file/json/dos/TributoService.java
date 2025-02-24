package es.file.json.dos;

import java.io.File;
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
public class TributoService {

    private String path = "src/main/resources/tributos.json";
    private File file = new File(path);
    private TypeReference<Set<Tributo>> typeReference = new TypeReference<Set<Tributo>>() {};
    private Set<Tributo> tributos = JsonUtil.jsonToSet(file, typeReference);

    /**
     * Constructor vacio.
     */
    public TributoService() {}

    /**
     * Buscar un tributo por su id.
     * @param id id del tributo a buscar.
     * @return retorna el tributo buscado.
     */
    public Tributo findById(int id) {
        for (Tributo tributo : tributos) {
            if(tributo.getId() == id) {
                return tributo;
            }
        }
        return null;
    }

    /**
     * Agrega un tributo a la lista.
     * @param obj tributo a agregar a la lista.
     * @return retorna true si el tributo fue agregado.
     */
    public boolean add(Tributo obj) {
        if(obj == null) return false;
        if(tributos.add(obj)) {
            return JsonUtil.setToJson(tributos, file);
        }
        return false;
    }

    /**
     * Elimina un tributo de la lista.
     * @param obj tributo a eliminar de la lista.
     * @return retorna true si el tributo fue eliminado.
     */
    public boolean delete(Tributo obj) {
        if(obj == null) return false;
        if(tributos.removeIf(t -> t.equals(obj))) {
            return JsonUtil.setToJson(tributos, file);
        }
        return false;
    }

    /**
     * Busca tributos por su rango de fechas.
     * @param startDate fecha de inicio de rango.
     * @param endDate fecha de fin de rango.
     * @return retorna la lista de los tributos que se encuentren en rango.
     */
    public List<Tributo> findByDateRange(String startDate, String endDate) {
        List<Tributo> lista = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);
            for (Tributo tributo : tributos) {
                LocalDate fechaSeleccion = LocalDate.parse(tributo.getFechaSeleccion(), formatter);
                if(!fechaSeleccion.isBefore(start) && !fechaSeleccion.isAfter(end)) {
                    lista.add(tributo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Muestra la lista de tributos.
     * @return retorna la lista de tributos.
     */
    public List<Tributo> getList() {
        return new ArrayList<>(tributos);
    }
    
    /**
     * Carga la lista de tributos.
     * @return retorna la lista de tributos.
     */
    public List<Tributo> loadAll() {
        return new ArrayList<>(tributos);
    }
    
}
