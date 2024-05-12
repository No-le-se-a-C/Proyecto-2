package GaleriaPieza;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class FotografiaPersistencia extends TypeAdapter<Fotografia> {

    @Override
    public void write(JsonWriter out, Fotografia fotografia) throws IOException {
        out.beginObject();
        out.name("titulo").value(fotografia.getTitulo());
        out.name("anioCreacion").value(fotografia.getAnioCreacion());
        out.name("lugarCreacion").value(fotografia.getLugarCreacion());
        // Aquí continúa con los demás atributos de Pieza y Fotografia
        out.name("filtro").value(fotografia.getFiltro());
        out.name("cantidadPixeles").value(fotografia.getCantidadPixeles());
        out.name("calidad").value(fotografia.getCalidad());
        out.endObject();
    }
    @Override
    public Fotografia read(JsonReader in) throws IOException {
        in.beginObject();
        String titulo = null;
        String anioCreacion = null;
        String lugarCreacion = null;
        // Continúa con los demás atributos de Pieza y Escultura
        String filtro = null;
        String cantidadPixeles = null;
        String calidad = null;
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
                case "filtro":
                    filtro = in.nextString();
                    break;
                case "cantidadPixeles":
                    cantidadPixeles = in.nextString();
                    break;
                case "calidad":
                    calidad = in.nextString();
                    break;
                default:
                    in.skipValue();
                    break;
            }
        }
        in.endObject();
        return new Fotografia(titulo, anioCreacion, lugarCreacion, null, false, null, false, false, 0, filtro, cantidadPixeles, calidad) ;   }
}