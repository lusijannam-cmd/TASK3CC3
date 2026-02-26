
import java.sql.*;
import java.util.*;

public class Repository {

    private final String DB_URL = "jdbc:mysql://localhost:3306/cc3_task3?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Manila";
    private final String USER = "root";
    private final String PASS = "kyhoon0808"; 
    private Connection conn;

    public Repository() throws Exception {
        connect();
    }

    private void connect() throws Exception {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void save(Student s) throws Exception {
        
        String sql = "INSERT INTO students (first_name, middle_name, last_name, age, year_level, program, contact_no, barangay, email) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        

        ps.setString(1, s.getFirstName());
        ps.setString(2, s.getMiddleName());
        ps.setString(3, s.getLastName());
        ps.setInt(4, s.getAge());
        ps.setInt(5, s.getYearLevel());
        ps.setString(6, s.getProgram());
        ps.setString(7, s.getContactNo());
        ps.setString(8, s.getBarangay());
        ps.setString(9, s.getEmail());

        ps.executeUpdate();
        ps.close(); 
    }

    public List<Student> findAll() throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Student s = new Student.Builder()
                    .setStudentID(rs.getInt("student_id"))
                    .setFirstName(rs.getString("first_name"))
                    .setMiddleName(rs.getString("middle_name"))
                    .setLastName(rs.getString("last_name"))
                    .setAge(rs.getInt("age"))
                    .setYearLevel(rs.getInt("year_level"))
                    .setProgram(rs.getString("program"))
                    .setContactNo(rs.getString("contact_no"))
                    .setBarangay(rs.getString("barangay"))
                    .setEmail(rs.getString("email"))
                    .build();

            list.add(s);
        }
        return list;
    }

    public void close() throws Exception {
        conn.close();
    }
}
