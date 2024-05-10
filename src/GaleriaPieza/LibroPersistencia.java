package GaleriaPieza;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class LibroPersistencia extends TypeAdapter<Libro> {

    @Override
    public void write(JsonWriter out, Libro libro) throws IOException {
        out.beginObject();
        out.name("titulo").value(libro.getTitulo());
        out.name("anioCreacion").value(libro.getAnioCreacion());
        out.name("lugarCreacion").value(libro.getLugarCreacion());
        // Aquí continúa con los demás atributos de Pieza y Escultura
        out.name("genero").value(libro.getGenero());

        out.endObject();
    }

    @Override
    public Libro read(JsonReader in) throws IOException {
        in.beginObject();
        String titulo = null;
        String anioCreacion = null;
        String lugarCreacion = null;
        // Continúa con los demás atributos de Pieza y libro
        String genero = null;

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
                // Aquí continúa con los demás atributos de Pieza y libro
                case "genero":
                    genero = in.nextString();
                    break;
                
            }
        }
        in.endObject();
        return new Libro(titulo, anioCreacion, lugarCreacion, null, false, null, false, false, 0, genero);
    }
}