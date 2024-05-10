package GaleriaEmpleados;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdministradorPersistencia {

    private static final String OPERADOR_FILE = "administrador.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardarAdministrador(Administrador administrador) {
        try (FileWriter writer = new FileWriter(OPERADOR_FILE)) {
            gson.toJson(administrador, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Administrador cargarAdministrador() {
        try (FileReader reader = new FileReader(OPERADOR_FILE)) {
            return gson.fromJson(reader, Administrador.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
