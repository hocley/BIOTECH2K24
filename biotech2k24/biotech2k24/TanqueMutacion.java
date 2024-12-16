package biotech2k24;

import java.util.Random;

public class TanqueMutacion {
    public void mutar(String animalName, String apellido, String especie) {
        Random random = new Random();
        int maxRadiation = 100 + random.nextInt(901); // Generate random radiation level between 100 and 1000
        int currentRadiation = 100;

        System.out.println(animalName + " es un/una " + especie + " / " + animalName + apellido + " será mutada:");
        System.out.println("Irradiando:");

        while (currentRadiation <= maxRadiation) {
            try {
                // Clear the console to simulate a dynamic progress display
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("------------------- " + currentRadiation + " de " + maxRadiation + " (mSv)");

                Thread.sleep(200);
                currentRadiation++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Final message indicating the completion of the mutation process
        System.out.println("Mutación completada. " + animalName + apellido +" ha sido mutada exitosamente.");
    }
}