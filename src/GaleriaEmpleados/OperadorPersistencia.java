package GaleriaEmpleados;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OperadorPersistencia {

    private static final String OPERADOR_FILE = "operador.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardarOperador(Operador operador) {
        try (FileWriter writer = new FileWriter(OPERADOR_FILE)) {
            gson.toJson(operador, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Operador cargarOperador() {
        try (FileReader reader = new FileReader(OPERADOR_FILE)) {
            return gson.fromJson(reader, Operador.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
