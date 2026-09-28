package gestioncatalogobiblioteca;

public final class Libro {

    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;
    private int prestamosHistoricos;

    public Libro(String titulo, String autor, String isbn, int copiasDisponibles, double precioReposicion) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Título inválido (nulo o en blanco), se usó \"Sin título\" por defecto.");
            this.titulo = "Sin título";
        } else {
            this.titulo = titulo;
        }

        if (autor == null || autor.trim().isEmpty()) {
            System.out.println("Autor inválido (nulo o en blanco), se usó \"Autor desconocido\" por defecto.");
            this.autor = "Autor desconocido";
        } else {
            this.autor = autor;
        }

        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("ISBN inválido (nulo o en blanco), se usó \"ISBN pendiente\" por defecto.");
            this.isbn = "ISBN pendiente";
        } else {
            this.isbn = isbn;
        }

        if (copiasDisponibles < 0) {
            System.out.println("Cantidad de copias inválida (no puede ser negativa), se usó 0 por defecto.");
            this.copiasDisponibles = 0;
        } else {
            this.copiasDisponibles = copiasDisponibles;
        }

        this.precioReposicion = 15000.0;
        if (!setPrecioReposicion(precioReposicion)) {
            System.out.println("Precio de reposición inválido (debe ser mayor a 0), se usó $15000.0 por defecto.");
        }
    }

    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, 1, 15000.0);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public double getPrecioReposicion() {
        return precioReposicion;
    }

    public int getPrestamosHistoricos() {
        return prestamosHistoricos;
    }

    public boolean setPrecioReposicion(double precio) {
        if (precio > 0) {
            this.precioReposicion = precio;
            return true;
        }
        return false;
    }

    public boolean prestar() {
        prestamosHistoricos++;
        if (copiasDisponibles > 0) {
            copiasDisponibles--;
            System.out.println("Préstamo registrado: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
            return true;
        }
        System.out.println("Error: no hay copias disponibles de \"" + titulo + "\" para prestar.");
        return false;
    }

    public void devolver() {
        copiasDisponibles++;
        System.out.println("Devolución registrada: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
    }

    public void mostrarFicha() {
        System.out.println("=== Ficha de libro ===");
        System.out.println("Título:  " + titulo);
        System.out.println("Autor:   " + autor);
        System.out.println("ISBN:    " + isbn);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Precio de reposición: $" + precioReposicion);
        System.out.println("=======================");
    }
}
