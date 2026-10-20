
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final String URL =
            "jdbc:mysql://localhost:3306/musica_db";

    private static final String USER = "root";

    // Replace with your actual MySQL password
    private static final String PASSWORD = "User123";

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            // 1. Insert a new record
            System.out.println("=== INSERTAR DISCO ===");

            System.out.print("Introduce el título del disco: ");
            String titulo = sc.nextLine();

            System.out.print("Introduce el artista: ");
            String artista = sc.nextLine();

            System.out.print("Introduce el año de lanzamiento: ");
            int lanzamiento = Integer.parseInt(sc.nextLine());

            insertarDisco(titulo, artista, lanzamiento);

            // 2. Display all records after insertion
            System.out.println("\n=== LISTA DE DISCOS ===");
            listarDiscos();

        } catch (SQLException e) {
            System.out.println("Error de base de datos:");
            e.printStackTrace();

        } catch (NumberFormatException e) {
            System.out.println("Error: introduce un año numérico.");
        }
    }

    // CREATE: insert a record
    public static void insertarDisco(
            String titulo, String artista, int lanzamiento)
            throws SQLException {

        String sql = """
                INSERT INTO discos (titulo, artista, lanzamiento)
                VALUES (?, ?, ?)
                """;

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, titulo);
            ps.setString(2, artista);
            ps.setInt(3, lanzamiento);

            int filas = ps.executeUpdate();

            System.out.println(
                    "Disco insertado correctamente. Filas: " + filas);
        }
    }

    // READ: retrieve and display all records
    public static void listarDiscos() throws SQLException {

        String sql = "SELECT * FROM discos";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean hayDiscos = false;

            while (rs.next()) {
                hayDiscos = true;

                System.out.println(
                        "ID: " + rs.getInt("id")
                                + " | Título: " + rs.getString("titulo")
                                + " | Artista: " + rs.getString("artista")
                                + " | Año: " + rs.getInt("lanzamiento")
                );
            }

            if (!hayDiscos) {
                System.out.println("No hay discos registrados.");
            }
        }
    }
}
