package GaleriaPieza;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class PinturaPersistencia extends TypeAdapter<Pintura> {

    @Override
    public void write(JsonWriter out, Pintura pintura) throws IOException {
        out.beginObject();
        out.name("titulo").value(pintura.getTitulo());
        out.name("anioCreacion").value(pintura.getAnioCreacion());
        out.name("lugarCreacion").value(pintura.getLugarCreacion());
        // Aquí continúa con los demás atributos de Pieza y pintura
        out.name("altura").value(pintura.getAltura());
        out.name("ancho").value(pintura.getAncho());
        out.name("estilo").value(pintura.getEstilo());

        out.endObject();
    }

    @Override
    public Pintura read(JsonReader in) throws IOException {
        in.beginObject();
        String titulo = null;
        String anioCreacion = null;
        String lugarCreacion = null;
        // Continúa con los demás atributos de Pieza y pintura
        String altura = null;
        String ancho = null;
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
                // Aquí continúa con los demás atributos de Pieza y pintura
                
                case "altura":
                    altura = in.nextString();
                    break;
                case "ancho":
                    ancho = in.nextString();
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
        return new Pintura(titulo, anioCreacion, lugarCreacion, null, false, null, false, false, 0, altura, ancho, estilo);
    }
}