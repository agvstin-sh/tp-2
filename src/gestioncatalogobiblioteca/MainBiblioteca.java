package gestioncatalogobiblioteca;

public class MainBiblioteca {
    public static void main(String[] args) {
        // new Libro(); // no compila: al declarar constructores propios, el constructor sin argumentos que regalaba el compilador dejó de existir.
        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "9780132350884");
        Libro libro2 = new Libro("Efectivo con Java", "Ana Restrepo", "9781234567897", 3, 22000.0);
        Libro libro3 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "9780307474728", 2, 18500.0);

        Libro libroInvalido = new Libro("", "Autor de prueba", "0000000000000", -2, 0);
        System.out.println("Título usado tras el rechazo: \"" + libroInvalido.getTitulo() + "\"");
        System.out.println("Copias usadas tras el rechazo: " + libroInvalido.getCopiasDisponibles());
        System.out.println("Precio usado tras el rechazo: $" + libroInvalido.getPrecioReposicion());
        System.out.println();

        double precioAntes = libro2.getPrecioReposicion();
        boolean precioAceptado = libro2.setPrecioReposicion(-100.0);
        System.out.println("¿Se aceptó el precio -100.0? " + precioAceptado);
        System.out.println("Precio antes: $" + precioAntes + " / después: $" + libro2.getPrecioReposicion());
        System.out.println();

        libro1.mostrarFicha();
        libro2.mostrarFicha();
        libro3.mostrarFicha();
        libroInvalido.mostrarFicha();

        System.out.println();
        boolean prestamo1 = libro3.prestar();
        System.out.println("Resultado del préstamo: " + prestamo1);
        boolean prestamo2 = libro3.prestar();
        System.out.println("Resultado del préstamo: " + prestamo2);
        boolean prestamo3 = libro3.prestar();
        System.out.println("Resultado del préstamo: " + prestamo3);
        System.out.println("Copias disponibles de \"" + libro3.getTitulo() + "\": " + libro3.getCopiasDisponibles());
        libro3.devolver();
        System.out.println("Préstamos históricos de \"" + libro3.getTitulo() + "\": " + libro3.getPrestamosHistoricos());

        System.out.println();
        double precioViejoLibro1 = libro1.getPrecioReposicion();
        boolean actualizado = libro1.setPrecioReposicion(18000.0);
        if (actualizado) {
            System.out.println("Precio de reposición actualizado de \"" + libro1.getTitulo()
                    + "\": $" + precioViejoLibro1 + " -> $" + libro1.getPrecioReposicion());
        }
    }
}
