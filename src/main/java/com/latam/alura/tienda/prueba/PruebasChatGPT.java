package com.latam.alura.tienda.prueba;

import java.util.Random;
import java.util.Scanner;

public class PruebasChatGPT {
	
	public static void main(String[] args) {
	
	 Scanner scanner = new Scanner(System.in);
     Random random = new Random();

     int numeroAdivinar = random.nextInt(10) + 1;
     int intentos = 5;
     int intento = 0;

     System.out.println("¡Bienvenido al juego de adivinar el número!");
     System.out.println("Estoy pensando en un número del 1 al 10. Tienes 5 intentos para adivinarlo.");

     while (intento < intentos) {
         System.out.print("Introduce tu adivinanza: ");
         int numeroAdivinado = scanner.nextInt();
         intento++;

         if (numeroAdivinado == numeroAdivinar) {
             System.out.println("¡Felicidades! Adivinaste el número " + numeroAdivinar + " en " + intento + " intentos.");
             break;
         } else if (numeroAdivinado < numeroAdivinar) {
             System.out.println("El número a adivinar es mayor. Te quedan " + (intentos - intento) + " intentos.");
         } else {
             System.out.println("El número a adivinar es menor. Te quedan " + (intentos - intento) + " intentos.");
         }
     }

     if (intento == intentos) {
         System.out.println("¡Lo siento! No lograste adivinar el número. Era " + numeroAdivinar + ".");
     }

     System.out.println("Gracias por jugar.");
     scanner.close();
 }
}

