package testModelop;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runners.AllTests;

public class Snippet {
	public static void main(String[] args) {
		  // Ejecutar todas las pruebas JUnit en el paquete actual y subpaquetes
        Result result = JUnitCore.runClasses(AllTests.class);

        // Imprimir los resultados de la ejecución de las pruebas
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Verificar si todas las pruebas fueron exitosas
        if (result.wasSuccessful()) {
            System.out.println("Todas las pruebas pasaron exitosamente.");
        } else {
            System.out.println("Algunas pruebas fallaron.");
        }
    }
	
}

