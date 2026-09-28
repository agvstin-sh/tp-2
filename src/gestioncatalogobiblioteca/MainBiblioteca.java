package gestioncatalogobiblioteca;

public class MainBiblioteca {
    public static void main(String[] args) {
        // Demostración de rechazo 1: título en blanco, se usa el valor por
        // defecto. No es uno de los libros "reales" del catálogo, solo sirve
        // para comprobar con getTitulo() que la validación funcionó.
        Libro libroDemo = new Libro("", "Autor de prueba", "0000000000000", 2, 20000.0);
        System.out.println("Título usado tras el rechazo: \"" + libroDemo.getTitulo() + "\"");
        System.out.println();

        // Al menos tres libros, combinando el constructor canónico y el de
        // conveniencia.
        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "9780132350884");
        Libro libro2 = new Libro("Efectivo con Java", "Ana Restrepo", "9781234567897", 3, 22000.0);
        Libro libro3 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "9780307474728", 2, 18500.0);

        // Demostración de rechazo 2: setPrecioReposicion con un valor
        // inválido. Se comprueba con el boolean devuelto y con el getter que
        // el precio anterior no se modificó.
        double precioAnteriorLibro2 = libro2.getPrecioReposicion();
        boolean precioAceptado = libro2.setPrecioReposicion(-100.0);
        System.out.println("¿Se aceptó el precio -100.0? " + precioAceptado
                + " (se mantiene el precio anterior: $" + precioAnteriorLibro2 + ")");
        System.out.println();

        libro1.mostrarFicha();
        libro2.mostrarFicha();
        libro3.mostrarFicha();

        // Agotamos las copias de libro1 (arrancó con 1 copia, por venir del
        // constructor de conveniencia) y probamos el préstamo de más.
        libro1.prestar();
        libro1.prestar();
        libro1.devolver();

        // Actualización válida de precio, para comparar contra el rechazo
        // anterior.
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
