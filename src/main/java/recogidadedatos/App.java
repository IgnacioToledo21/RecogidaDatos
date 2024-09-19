package recogidadedatos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    private TextField nombre;
    private TextField apellidos;
    private TextField edad;
    private Button botonGuardar;
    private Button botonLimpiar;
    private Label nombreLabel;
    private Label apellidoLabel;
    private Label edadLabel;
    private Label mensajeLabel;

    // Instancia de GsonSample para usar su método de guardado
    private GsonSample gsonSample = new GsonSample();

    @Override
    public void start(Stage stage) throws Exception {

        // Inicialización de los TextFields
        nombre = new TextField();
        apellidos = new TextField();
        edad = new TextField();

        //Componentes de la ventana
        nombreLabel = new Label("Nombre: ");
        apellidoLabel = new Label("Apellido: ");
        edadLabel = new Label("Edad: ");
        mensajeLabel = new Label(); // Label para mostrar mensajes al usuario

        // Botón Guardar datos
        botonGuardar = new Button("Guardar");
        botonGuardar.setOnAction(event -> {
            // Capturamos los datos de los TextFields
            String nombreTexto = nombre.getText();
            String apellidosTexto = apellidos.getText();
            String edadTexto = edad.getText();

            // Verificamos que todos los campos estén llenos
            if (!nombreTexto.isEmpty() && !apellidosTexto.isEmpty() && !edadTexto.isEmpty()) {
                try {
                    // Convertimos la edad a un número entero
                    Integer edadNumero = Integer.parseInt(edadTexto);

                    // Creamos un objeto Persona con los datos introducidos
                    Persona persona = new Persona();
                    persona.setNombre(nombreTexto);
                    persona.setApellidos(apellidosTexto);
                    persona.setEdad(edadNumero);

                    // Usamos GsonSample para guardar los datos en JSON
                    gsonSample.guardarDatos(persona);

                    mensajeLabel.setText("Datos guardados correctamente.");
                } catch (NumberFormatException e) {
                    mensajeLabel.setText("Por favor, ingrese un número válido para la edad.");
                }
            } else {
                mensajeLabel.setText("Por favor, complete todos los campos.");
            }
        });

        // Botón Limpiar datos
        botonLimpiar = new Button("Limpiar");
        botonLimpiar.setOnAction(event -> {
            // Limpiar los campos de texto y el mensaje
            nombre.clear();
            apellidos.clear();
            edad.clear();
            mensajeLabel.setText("");
        });

        // Caja Nombre
        HBox nombrebox = new HBox(5, nombreLabel, nombre);
        nombrebox.setBorder(new Border(new BorderStroke(Color.BLUE, null, null, null)));
        nombrebox.setPadding(new Insets(5));
        nombrebox.setAlignment(Pos.CENTER);

        // Caja Apellidos
        HBox apellidobox = new HBox(5, apellidoLabel, apellidos);
        apellidobox.setBorder(new Border(new BorderStroke(Color.BLUE, null, null, null)));
        apellidobox.setPadding(new Insets(5));
        apellidobox.setAlignment(Pos.CENTER);

        // Caja Edad
        HBox edadbox = new HBox(5, edadLabel, edad);
        edadbox.setBorder(new Border(new BorderStroke(Color.BLUE, null, null, null)));
        edadbox.setPadding(new Insets(5));
        edadbox.setAlignment(Pos.CENTER);

        // Caja para los botones
        HBox botonesBox = new HBox(10); // Espaciado de 10 entre botones
        botonesBox.setAlignment(Pos.CENTER); // Centrar los botones en la caja
        botonesBox.getChildren().addAll(botonGuardar, botonLimpiar); // Añadir los botones

        // Ventana principal
        VBox root = new VBox(10, nombrebox, apellidobox, edadbox, botonesBox, mensajeLabel);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Recogida De Datos");
        stage.setScene(scene);
        stage.show();
    }

}

