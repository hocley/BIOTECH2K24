package biotech2k24;

import java.util.Scanner;
import biotech2k24.fanerozoico.*;

public class Sistema {

    private String ESPECIE;
    private String[] AGNATOS = {"Hagfishes", "Lampreys"};
    private String[] PECES_ALETAS_LOBULADAS = {"Coelacanth", "Lungfish"};
    private String[] ANFIBIOS = {"Caecilians", "Salamanders", "Frogs"};
    private String[] REPTILES = {"Turtles", "Tuatara", "LizardsAndSnakes", "Crocodilians, Birds"};
    private String[] MAMIFEROS = {"Monotremes", "Marsupials", "Placentals"};

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        // Authenticate the biotech2k24.BiologoRuso
        System.out.println("Ingrese su apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese su cédula:");
        String cedula = scanner.nextLine();
        System.out.println("Ingrese su género (hombre/mujer):");
        String genero = scanner.nextLine();

        BiologoRuso biologo = new BiologoRuso(apellido, cedula, genero);

        System.out.println("Bienvenido, " + biologo.getApellido() + "!");
        System.out.println("Cargando árbol filogenético...");

// Simulate loading
        for (int i = 0; i <= 100; i++) {
            try {
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Display the loading progress with rotating symbol
                System.out.print("\r" + (i % 4 == 0 ? "\\" : i % 4 == 1 ? "|" : i % 4 == 2 ? "/" : "-"));
                System.out.print(" " + i + "%");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print phylogenetic tree
        System.out.println("\nARBOL FILOGENÉTICO:");
        new Hagfishes();
        new Lampreys();
        new CartilaginousFishes();
        new RayFinnedFishes();
        new Coelacanth();
        new Lungfish();
        new Caecilians();
        new Salamanders();
        new Frogs();
        new Turtles();
        new Tuatara();
        new LizardsAndSnakes();
        new Crocodilians();
        new Birds();
        new Monotremes();
        new Marsupials();
        new Placentals();

        // Determine classification based on cedula
        String[] ANIMAL_OPCIONES = null;
        int lastDigit = biologo.getUltimoDigitoCedula();
        String classification = "";
        switch (lastDigit) {
            case 0: case 5: classification = "Agnatos"; ANIMAL_OPCIONES = AGNATOS; break;
            case 1: case 6: classification = "Peces de aletas lobuladas"; ANIMAL_OPCIONES = PECES_ALETAS_LOBULADAS; break;
            case 2: case 7: classification = "Anfibios"; ANIMAL_OPCIONES = ANFIBIOS ;break;
            case 3: case 8: classification = "Reptiles"; ANIMAL_OPCIONES = REPTILES; break;
            case 4: case 9: classification = "Mamíferos"; ANIMAL_OPCIONES = MAMIFEROS; break;
        }

        System.out.println("Último dígito de cédula: ["+lastDigit+"]"+"\nClasificación asignada: " + classification);
        System.out.println("Ingrese el número del animal que desea crear:");

        for (int i = 0; i < ANIMAL_OPCIONES.length; i++) {
            System.out.println(i + " - " + ANIMAL_OPCIONES[i]);
        }

        int animal = scanner.nextInt();
        scanner.nextLine();

        ESPECIE = ANIMAL_OPCIONES[animal];

        System.out.println("Ingrese el nombre del animal:");
        String animalName = scanner.nextLine();

        // Behavior
        if (biologo.getGenero().equals("hombre")) {
            System.out.println(animalName + "es un/una " + ESPECIE);
            System.out.println(animalName + " saluda a todos");
            System.out.println(animalName + " saluda a " + biologo.getApellido());
        } else {
            System.out.println(animalName + "es un/una " + ESPECIE);
            System.out.println(animalName + " está comiendo");
        }

        // Mutation process
        System.out.println("Ingrese clave del tanque de mutación:");
        String clave = scanner.nextLine();
        if (clave.equals("321mutar")) {
            TanqueMutacion tanque = new TanqueMutacion();
            tanque.mutar(animalName, biologo.getApellido(), ESPECIE);
        } else {
            System.out.println("Clave incorrecta.");
        }
        scanner.close();
    }
}
