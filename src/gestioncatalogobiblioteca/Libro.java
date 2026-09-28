package gestioncatalogobiblioteca;

// Clase marcada como final: garantiza sus invariantes exclusivamente en el
// constructor canónico, y no está pensada para que una subclase pueda
// heredar y romper esa garantía agregando o alterando comportamiento.
public final class Libro {

    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;
    private int prestamosHistoricos;

    public Libro(String titulo, String autor, String isbn, int copiasDisponibles, double precioReposicion) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Título inválido, se usó \"Sin título\" por defecto.");
            this.titulo = "Sin título";
        } else {
            this.titulo = titulo;
        }

        if (autor == null || autor.trim().isEmpty()) {
            System.out.println("Autor inválido, se usó \"Autor desconocido\" por defecto.");
            this.autor = "Autor desconocido";
        } else {
            this.autor = autor;
        }

        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("ISBN inválido, se usó \"ISBN pendiente\" por defecto.");
            this.isbn = "ISBN pendiente";
        } else {
            this.isbn = isbn;
        }

        if (copiasDisponibles < 0) {
            System.out.println("Cantidad de copias inválida, se usó 0 por defecto.");
            this.copiasDisponibles = 0;
        } else {
            this.copiasDisponibles = copiasDisponibles;
        }

        // El precio arranca en 15000.0 (el valor por defecto) y solo se
        // reemplaza si setPrecioReposicion -la MISMA regla que usa el
        // setter público- acepta el valor recibido. Así la validación del
        // precio no está escrita dos veces.
        this.precioReposicion = 15000.0;
        if (!setPrecioReposicion(precioReposicion)) {
            System.out.println("Precio de reposición inválido, se usó $15000.0 por defecto.");
        }
    }

    public Libro(String titulo, String autor, String isbn) {
        // Constructor de conveniencia: this(...) tiene que ser la primera
        // sentencia. Delega toda la validación en el constructor canónico,
        // arrancando con 1 copia y el precio por defecto.
        this(titulo, autor, isbn, 1, 15000.0);
    }

    // new Libro(); no compilaría: al declarar estos dos constructores propios,
    // el constructor sin argumentos que el compilador regalaba por defecto
    // dejó de existir.

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
