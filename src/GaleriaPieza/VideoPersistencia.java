package GaleriaPieza;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class VideoPersistencia extends TypeAdapter<Video> {

    @Override
    public void write(JsonWriter out, Video video) throws IOException {
        out.beginObject();
        out.name("titulo").value(video.getTitulo());
        out.name("anioCreacion").value(video.getAnioCreacion());
        out.name("lugarCreacion").value(video.getLugarCreacion());
        // Aquí continúa con los demás atributos de Pieza y video
        out.name("duracion").value(video.getDuracion());
        out.name("formato").value(video.getFormato());
        out.name("estilo").value(video.getEstilo());
        out.endObject();
    }

    @Override
    public Video read(JsonReader in) throws IOException {
        in.beginObject();
        String titulo = null;
        String anioCreacion = null;
        String lugarCreacion = null;
        // Continúa con los demás atributos de Pieza y video
        String duracion = null;
        String formato = null;
        String estilo = null;
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
                // Aquí continúa con los demás atributos de Pieza y video
                case "duracion":
                    duracion = in.nextString();
                    break;
                case "formato":
                    formato= in.nextString();
                    break;
                case "estilo":
                    estilo = in.nextString();
                    break;
                default:
                    in.skipValue();
                    break;
            }
        }
        in.endObject();
        return new Video(titulo, anioCreacion, lugarCreacion, null, false, null, false, false, 0, duracion, formato, estilo);
    }
}
