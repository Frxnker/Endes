import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido a la agenda de teléfonos");
        do {
            System.out.println("1. Añadir un contacto");
            System.out.println("2. Mostrar agenda");
            System.out.println("3. Borrar un contacto");
            System.out.println("0. Salir");


            opcion = Integer.parseInt(System.console().readLine());


            switch (opcion) {
                case 1:
                    añadirContacto();
                    break;
                case 2:
                    mostrarAgenda();
                    break;
                case 3:
                    borrarContacto();
                    break;
                case 0:
                    System.out.println("Hasta la próxima");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion != 0);
    }


    public static void añadirContacto() throws IOException {
        System.out.println("Introduce los datos del nuevo contacto");
        System.out.println("Nombre del contacto: ");
        String nombre = System.console().readLine();
        System.out.println("Teléfono del contacto: ");
        String telefono = System.console().readLine();
        FileWriter fw = new FileWriter("agenda.dat", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(nombre + "\n");
        bw.write(telefono + "\n");
        bw.close();
    }


    public static void mostrarAgenda() throws IOException {
        FileReader fr = new FileReader("agenda.dat");
        BufferedReader br = new BufferedReader(fr);
        String linea = "";
        while (linea != null) {
            linea = br.readLine();
            if (linea != null) {
                System.out.println(linea);
            }
        }
        br.close();
    }


    public static void borrarContacto() throws IOException {
        System.out.println("Introduce el nombre del contacto que quieres borrar");
        String nombre = System.console().readLine();
        FileReader fr = new FileReader("agenda.dat");
        BufferedReader br = new BufferedReader(fr);
        String linea = "";
        ArrayList<String> lista = new ArrayList<String>();
        while (linea != null) {
            linea = br.readLine();
            if (linea != null) {
                lista.add(linea);
            }
        }
        br.close();
        FileWriter fw = new FileWriter("agenda.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(nombre)) {
                lista.remove(i);
                lista.remove(i);
            }
        }
        for (int i = 0; i < lista.size(); i++) {
            bw.write(lista.get(i) + "\n");
        }
        bw.close();
    }
}
