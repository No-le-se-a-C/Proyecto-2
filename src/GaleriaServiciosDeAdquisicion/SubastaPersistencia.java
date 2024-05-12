package GaleriaServiciosDeAdquisicion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SubastaPersistencia {

    private static final String SUBASTA_FILE = "subasta.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardarSubasta(Subasta subasta) {
        try (FileWriter writer = new FileWriter(SUBASTA_FILE)) {
            gson.toJson(subasta, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Subasta cargarSubasta() {
        try (FileReader reader = new FileReader(SUBASTA_FILE)) {
            return gson.fromJson(reader, Subasta.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void guardarSubastas(ArrayList<Subasta> subastas) {
        try (FileWriter writer = new FileWriter(SUBASTA_FILE)) {
            gson.toJson(subastas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
	public static ArrayList<Subasta> cargarSubastas() {
        try (FileReader reader = new FileReader(SUBASTA_FILE)) {
            return gson.fromJson(reader, new ArrayList<Subasta>().getClass());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
