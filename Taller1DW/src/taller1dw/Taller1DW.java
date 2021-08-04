/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1dw;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Moxic Sama
 */
public class Taller1DW {

    public static ArrayList<Libro> libros;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        libros = new ArrayList<Libro>();
        cargarLibros();
        Scanner entrada = new Scanner(System.in);
        String opcion;
        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Taller #1 - Desarrollo web");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Bienvenido a la tienda de libros, ¿Que desea hacer?: ");
            System.out.println("1. Crear un libro.");
            System.out.println("2. Listar los libros por autor.");
            System.out.println("3. Detallar un libro.");
            System.out.println("4. Salir.");
            opcion = entrada.nextLine();

            if ("1".equals(opcion)) {
                Libro nuevoLibro = crearLibro(entrada);
                libros.add(nuevoLibro);
            } else if ("2".equals(opcion)) {
                listarLibros(entrada);
            } else if ("3".equals(opcion)) {
                datallarLibro(entrada);
            } else if ("4".equals(opcion)) {
                break;
            }
        }
    }

    private static Libro crearLibro(Scanner entrada) {
        String titulo;
        String descripcion;
        int precio;
        String nombre;
        String apellido;
        int fecha;
        int paginas;
        //PEDIR EL TITULO DEL LIBRO
        System.out.println("Ingresa el título del libro: ");
        while (true) {
            titulo = entrada.nextLine();
            if (titulo.length() < 5 || titulo.length() > 100) {
                System.out.println("El título debe tener mínimo 5 caracteres y máximo 100 caracteres");
                System.out.println("Por favor ingrese un título valido: ");
            } else {
                break;
            }
        }
        //PEDIR LA DESCRIPCIÓN DEL LIBRO
        System.out.println("Ingresa la descripción del libro: ");
        while (true) {
            descripcion = entrada.nextLine();
            if (descripcion.length() > 200) {
                System.out.println("La descripción no puede tener más de 200 caracteres.");
                System.out.println("Por favor ingrese una descripción valida: ");
            } else {
                break;
            }
        }
        //PEDIR EL PRECIO DEL LIBRO
        System.out.println("Ingresa el valor del libro: ");
        while (true) {
            try {
                precio = Integer.parseInt(entrada.nextLine());
            } catch (Exception e) {
                precio = -1;
            }
            if (precio < 10000) {
                System.out.println("El precio debe ser positivo, mayor a 10000 pesos y sin centavos.");
                System.out.println("Por favor ingrese un precio valido: ");
            } else {
                break;
            }
        }
        //PEDIR EL NOMBRE DEL AUTOR DEL LIBRO
        System.out.println("Ingresa el nombre del autor: ");
        while (true) {
            nombre = entrada.nextLine();
            if (nombre.length() < 1) {
                System.out.println("El ibro debe de tener un nombre del autor.");
                System.out.println("Por favor ingrese un nombre: ");
            } else {
                break;
            }
        }
        //PEDIR EL APELLIDO DEL AUTOR
        System.out.println("Ingresa el apellido del autor: ");
        while (true) {
            apellido = entrada.nextLine();
            if (apellido.length() < 1) {
                System.out.println("El ibro debe de tener un apellido del autor.");
                System.out.println("Por favor ingrese un apellido: ");
            } else {
                break;
            }
        }
        //PEDIR AÑO DE PUBLICACIÓN
        System.out.println("Ingresa el año de publicación del libro: ");
        while (true) {
            try {
                fecha = Integer.parseInt(entrada.nextLine());
            } catch (Exception e) {
                fecha = 1;
            }
            int digitos = (int) (Math.log10(fecha) + 1);
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            if (digitos < 4 || fecha > year) {
                System.out.println("El año de publicación debe ser un valor de año valido, no superior al año actual y con 4 dígitos.");
                System.out.println("Por favor ingrese un año valido: ");
            } else {
                break;
            }
        }
        //PEDIR NÚMERO DE PAGINAS DEL LIBRO
        System.out.println("Ingresa el número de paginas del libro: ");
        while (true) {
            try {
                paginas = Integer.parseInt(entrada.nextLine());
            } catch (Exception e) {
                paginas = -1;
            }
            if (paginas < 1 || paginas > 1500) {
                System.out.println("Las páginas deben ser numéricas positivas, y no pueden superar las 1500 páginas.");
                System.out.println("Por favor ingrese el número de paginas valido: ");
            } else {
                break;
            }
        }
        return new Libro(titulo, descripcion, precio, nombre, apellido, fecha, paginas);
    }

    private static void listarLibros(Scanner entrada) {
        ArrayList<Autor> listaAutores = new ArrayList<Autor>();
        for (int i = 0; i < libros.size(); i++) {
            if (!listaAutores.contains(libros.get(i).getAutor())) {
                listaAutores.add(libros.get(i).getAutor());
            }
        }
        System.out.println("Lista de autores: ");
        for (int i = 0; i < listaAutores.size(); i++) {
            System.out.println((i + 1) + ". " + listaAutores.get(i).getNombreAutor() + " " + listaAutores.get(i).getApellidoAutor());
        }
        System.out.println("Ingresa el numero del autor: ");
        int puesto = Integer.parseInt(entrada.nextLine());

        System.out.println("-------------------------------------");
        System.out.println("Autor #" + (puesto) + ": ");
        for (int j = 0; j < libros.size(); j++) {
            if (listaAutores.get(puesto - 1) == libros.get(j).getAutor()) {
                System.out.println(listaAutores.get(puesto - 1).getNombreAutor() + " " + listaAutores.get(puesto - 1).getApellidoAutor());
                System.out.println("Libros: ");
                System.out.println("Título: " + libros.get(j).getTitulo());

            }
        }
        System.out.println("-------------------------------------");
    }

    private static void datallarLibro(Scanner entrada) {
        System.out.println("Lista de libros: ");
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i + 1) + ". " + libros.get(i).getTitulo());
        }
        System.out.println("Ingresa el número del libro: ");
        int puesto = Integer.parseInt(entrada.nextLine());
        System.out.println("Título: " + libros.get(puesto - 1).getTitulo());
        System.out.println("Descripción: " + libros.get(puesto - 1).getDescripcion());
        System.out.println("Precio: " + libros.get(puesto - 1).getPrecio());
        System.out.println("Autor: " + libros.get(puesto - 1).autortoString());
        System.out.println("Año de publicación: " + libros.get(puesto - 1).getFecha());
        System.out.println("Número de paginas: " + libros.get(puesto - 1).getPaginas());
    }

    private static void cargarLibros() {
    libros.add(new Libro("La biblia","La Biblia es el conjunto de libros canónicos del judaísmo y el cristianismo. La canonicidad de cada libro varía dependiendo de la tradición adoptada. Según las religiones judía y cristiana, transmite la palabra de Dios",200000,"comunidad","religiosa",1000,1000));
    libros.add(new Libro("Harry Potter", "Harry Potter es una heptalogía de novelas fantásticas escrita por la autora británica J. K. Rowling, en la que se describen las aventuras del joven aprendiz de mago Harry Potter y sus amigos Hermione Granger y Ron Weasley, durante los siete años que pasan en el Colegio Hogwarts de Magia y Hechicería. El argumento se centra en la lucha entre Harry Potter y el malvado mago Lord Voldemort, quien mató a los padres de Harry en su afán de conquistar el mundo mágico.",50000,"J.K.","Rowling",2000,500));
    libros.add(new Libro("El señor de los anillos"," Su historia se desarrolla en la Tercera Edad del Sol de la Tierra Media, un lugar ficticio poblado por hombres y otras razas antropomorfas como los hobbits, los elfos o los enanos, así como por muchas otras criaturas reales y fantásticas. La novela narra el viaje del protagonista principal, el hobbit Frodo Bolsón, para destruir el Anillo Único y la consiguiente guerra que provocará el enemigo para recuperarlo, ya que es la principal fuente de poder de su creador, el Señor oscuro Sauron.",180000,"J.R.R.","Tolkien",1990,800));
    libros.add(new Libro("El alquimista","El libro trata sobre los sueños y los medios que utilizamos para alcanzarlos, sobre el azar en nuestra vida y las señales que se presentan a lo largo de esta.",60000,"Paulo","Coelho",2000,200));
    }
}
