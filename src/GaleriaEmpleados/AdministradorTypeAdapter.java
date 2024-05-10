package GaleriaEmpleados;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class AdministradorTypeAdapter extends TypeAdapter<Administrador> {
    @Override
    public void write(JsonWriter out, Administrador administrador) throws IOException {
        out.beginObject();
        out.name("IDENTIFICADOR").value(administrador.getIDENTIFICADOR());
        // Otros campos si los hay
        out.endObject();
    }

    @Override
    public Administrador read(JsonReader in) throws IOException {
        // Implementa la lógica para deserializar aquí si es necesario
        return null;
    }
}
