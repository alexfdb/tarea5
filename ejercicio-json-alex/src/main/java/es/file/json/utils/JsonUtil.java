package es.file.json.utils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public abstract class JsonUtil {
    
    /**
     * Constructor vacio.
     */
    protected JsonUtil() {}

    /**
     * Deserializa un Json a un Set generico.
     * @param <T> Tipo generico de los elementos del Set.
     * @param jsonPath Ruta del json.
     * @param typeRef TypeReference del Set con el tipo generico.
     * @return Retorna el Set tras la deserializacion.
     */
    public static <T> Set<T> jsonToSet(String jsonPath, TypeReference<Set<T>> typeRef) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(jsonPath), typeRef);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    /**
     * Serializa un Set a un Json.
     * @param <T> Tipo generico de los elementos del Set.
     * @param set Set a serializar.
     * @param jsonPath Ruta del json.
     * @return Retorna true si se serializo con exito.
     */
    public static <T> boolean setToJson(Set<T> set, String jsonPath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(jsonPath), set);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}