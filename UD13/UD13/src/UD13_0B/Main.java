package UD13_0B;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un botón
        Button boton = new Button();
        boton.setText("Haz clic aquí");

        // Configurar un evento para el clic del botón
        boton.setOnAction(e -> System.out.println("?Hola, mundo desde JavaFX!"));

        // Crear un contenedor de dise?o (layout) apilado (stack)
        StackPane layout = new StackPane();
        layout.getChildren().add(boton);

        // Crear la escena y a?adir el contenedor de dise?o
        Scene scene = new Scene(layout, 300, 250);

        // Configurar el escenario (ventana principal)
        primaryStage.setTitle("Mi Ventana JavaFX");
        primaryStage.setScene(scene);

        // Mostrar la ventana
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

