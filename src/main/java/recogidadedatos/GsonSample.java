package recogidadedatos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GsonSample {

    public void guardarDatos(Persona p) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(p);

        File jsonFile = new File("datos.json");
        try {
            Files.writeString(jsonFile.toPath(), json);
            System.out.println("Datos guardados correctamente en datos.json");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}
