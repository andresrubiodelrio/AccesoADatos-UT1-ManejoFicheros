package ficherosjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CrudPersonasJSON {

    private static final String RUTA_ARCHIVO = "datos/json/alumnos.json";
    private final ObjectMapper mapper = new ObjectMapper();

    // ----------- LECTURA AUTOMÁTICA -----------

    public List<Persona> leer() {
        File file = new File(RUTA_ARCHIVO);
        if (!file.exists()) return new ArrayList<>();

        try {
            JsonNode rootNode = mapper.readTree(file);

            // Si el JSON es una lista
            if (rootNode.isArray()) {
                return mapper.convertValue(rootNode, new TypeReference<List<Persona>>() {});
            }

            // Si el JSON es un solo objeto
            if (rootNode.isObject()) {
                Persona persona = mapper.convertValue(rootNode, Persona.class);
                List<Persona> lista = new ArrayList<>();
                lista.add(persona);
                return lista;
            }

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        return new ArrayList<>();
    }

    // ----------- ESCRITURA AUTOMÁTICA -----------

    public void escribir(List<Persona> personas) {
        try {
            if (personas.size() == 1) {
                // Si solo hay una persona, escribir como objeto único
                mapper.writerWithDefaultPrettyPrinter()
                        .writeValue(new File(RUTA_ARCHIVO), personas.get(0));
            } else {
                // Si hay varias, escribir como lista
                mapper.writerWithDefaultPrettyPrinter()
                        .writeValue(new File(RUTA_ARCHIVO), personas);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ----------- CRUD BÁSICO -----------

    public void agregar(Persona p) {
        List<Persona> personas = leer();
        personas.add(p);
        escribir(personas);
    }

    public void modificar(int id, Persona nuevaPersona) {
        List<Persona> personas = leer();
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == id) {
                personas.set(i, nuevaPersona);
                break;
            }
        }
        escribir(personas);
    }

    public void borrar(int id) {
        List<Persona> personas = leer();
        personas.removeIf(p -> p.getId() == id);
        escribir(personas);
    }

    // ----------- LECTURA DE UN SOLO OBJETO -----------

    public Persona leerPrimero() {
        List<Persona> personas = leer();
        return personas.isEmpty() ? null : personas.get(0);
    }
}
