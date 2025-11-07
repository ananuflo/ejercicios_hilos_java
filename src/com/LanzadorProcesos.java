package com;

import java.io.*;

import java.util.concurrent.*;

public class LanzadorProcesos {

	public static void main(String[] args) {
		// Definimos los comandos que queremos ejecutar
        String[][] comandos = {
            {"ping", "-c", "2", "google.com"},
            {"java", "-version"},
            {"ls", "-l"} // En Windows usar: {"cmd", "/c", "dir"}
        };

        // Crear un hilo por cada comando
        for (String[] comando : comandos) {
            Thread hilo = new Thread(() -> ejecutarProceso(comando));
            hilo.start();
        }
    }

    private static void ejecutarProceso(String[] comando) {
        try {
            System.out.println("🚀 Ejecutando: " + String.join(" ", comando));
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.redirectErrorStream(true); // Unir salida y errores
            Process proceso = pb.start();

            // Leer la salida del proceso
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(Thread.currentThread().getName() + " → " + linea);
                }
            }

            int exitCode = proceso.waitFor();
            System.out.println("✅ Proceso finalizado con código: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("❌ Error al ejecutar proceso: " + e.getMessage());
        }
    }
}
