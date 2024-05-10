package GaleriaEmpleados;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CajeroPersistencia {

    private static final String cajero_FILE = "cajero.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardarCajero(Cajero cajero) {
        try (FileWriter writer = new FileWriter(cajero_FILE)) {
            gson.toJson(cajero, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Cajero cargarCajero() {
        try (FileReader reader = new FileReader(cajero_FILE)) {
            return gson.fromJson(reader, Cajero.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
