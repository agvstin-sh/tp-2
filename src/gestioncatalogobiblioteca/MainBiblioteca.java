package gestioncatalogobiblioteca;

public class MainBiblioteca {
    public static void main(String[] args) {
        // new Libro(); // no compila: al declarar constructores propios, el constructor sin argumentos que regalaba el compilador dejó de existir.
        Libro libroDemo = new Libro("", "Autor de prueba", "0000000000000", 2, 20000.0);
        System.out.println("Título usado tras el rechazo: \"" + libroDemo.getTitulo() + "\"");
        System.out.println();

        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "9780132350884");
        Libro libro2 = new Libro("Efectivo con Java", "Ana Restrepo", "9781234567897", 3, 22000.0);
        Libro libro3 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "9780307474728", 2, 18500.0);

        double precioAnteriorLibro2 = libro2.getPrecioReposicion();
        boolean precioAceptado = libro2.setPrecioReposicion(-100.0);
        System.out.println("¿Se aceptó el precio -100.0? " + precioAceptado
                + " (se mantiene el precio anterior: $" + precioAnteriorLibro2 + ")");
        System.out.println();

        libro1.mostrarFicha();
        libro2.mostrarFicha();
        libro3.mostrarFicha();

        libro1.prestar();
        libro1.prestar();
        libro1.devolver();

        double precioViejoLibro1 = libro1.getPrecioReposicion();
        boolean actualizado = libro1.setPrecioReposicion(18000.0);
        if (actualizado) {
            System.out.println("Precio de reposición actualizado de \"" + libro1.getTitulo()
                    + "\": $" + precioViejoLibro1 + " -> $" + libro1.getPrecioReposicion());
        }

        System.out.println();
        System.out.println("Préstamos históricos de \"" + libro1.getTitulo() + "\": "
                + libro1.getPrestamosHistoricos());
    }
}
