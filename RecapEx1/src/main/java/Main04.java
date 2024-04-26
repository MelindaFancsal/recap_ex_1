
import java.sql.*;
import java.util.Arrays;

public class Main04 {
    //1) adaugati o intregistrare in tabela book - inserati o carte in tabela boo;s
    //isert into books(title,...) values (?,?,?);
    //2)afisati din tablea books toate cartile si puneti rezultatul intr un array de books

    public static final String DB_PRDUCTS_URL = "jdbc:mysql://localhost:3306/books?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&characterEncoding=utf8";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "Mel1nda11";

    public static void main(String[] args) {

        adaugareCarte();
        afisareCarti();

    }

    private static void adaugareCarte() {
        String insertBook = "insert into books(name, description, price) values (? , ?, ?)";
        //cu scanner citim numeCarte, an si numar pagihi
        String nume ="nume";
        int nrPag = 0;
        String publisher = "";
        try (PreparedStatement statement = getConnection().prepareStatement(insertBook)) {
            statement.setString(1,nume );
            statement.setString(2,publisher );
            statement.setInt(3,nrPag );

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exceptie in insert method: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void afisareCarti() {

        try (Statement statement = getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery("select * from books");

            Book[] userArray = new Book[]{};

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int pages = rs.getInt("pages");
                String publisher = rs.getString("publisher");

                Book user = new Book();
                user.setPages(pages);
                user.setPublisher(publisher);
                user.setId(id);
                user.setTitle(title);

                userArray = addToArray(user, userArray);
            }


            System.out.println(Arrays.toString(userArray));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static Book[] addToArray(Book u, Book[] users) {
        Book[] tmpUsers = Arrays.copyOf(users, users.length + 1); // Creates a table copy increased by 1.
        tmpUsers[users.length] = u; // Adds object in the last position.
        return tmpUsers; // Returns new table.
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_PRDUCTS_URL, DB_USER, DB_PASS);
    }
}
