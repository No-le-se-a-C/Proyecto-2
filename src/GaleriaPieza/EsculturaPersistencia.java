package GaleriaPieza;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class EsculturaPersistencia extends TypeAdapter<Escultura> {

    @Override
    public void write(JsonWriter out, Escultura escultura) throws IOException {
        out.beginObject();
        out.name("titulo").value(escultura.getTitulo());
        out.name("anioCreacion").value(escultura.getAnioCreacion());
        out.name("lugarCreacion").value(escultura.getLugarCreacion());
        // Aquí continúa con los demás atributos de Pieza y Escultura
        out.name("material").value(escultura.getMaterial());
        out.name("altura").value(escultura.getAltura());
        out.name("ancho").value(escultura.getAncho());
        out.endObject();
    }

    @Override
    public Escultura read(JsonReader in) throws IOException {
        in.beginObject();
        String titulo = null;
        String anioCreacion = null;
        String lugarCreacion = null;
        // Continúa con los demás atributos de Pieza y Escultura
        String material = null;
        String altura = null;
        String ancho = null;
        while (in.hasNext()) {
            String name = in.nextName();
            switch (name) {
                case "titulo":
                    titulo = in.nextString();
                    break;
                case "anioCreacion":
                    anioCreacion = in.nextString();
                    break;
                case "lugarCreacion":
                    lugarCreacion = in.nextString();
                    break;
                // Aquí continúa con los demás atributos de Pieza y Escultura
                case "material":
                    material = in.nextString();
                    break;
                case "altura":
                    altura = in.nextString();
                    break;
                case "ancho":
                    ancho = in.nextString();
                    break;
                default:
                    in.skipValue();
                    break;
            }
        }
        in.endObject();
        return new Escultura(ancho, ancho, ancho, null, false, null, false, false, 0, ancho, ancho, ancho);
    }
}
