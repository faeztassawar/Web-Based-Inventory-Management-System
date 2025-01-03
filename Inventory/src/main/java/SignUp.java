import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SignUp extends HttpServlet {

    // Process the HTTP POST request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Get PrintWriter object
        PrintWriter out = response.getWriter();

        String name = request.getParameter("u_name");
        String password = request.getParameter("c_password");

        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        out.println("<body>");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/users";
            Connection con = DriverManager.getConnection(url, "root", "root");
            
            String checkUserQuery = "SELECT * FROM ceredentials WHERE username = ?";
            PreparedStatement checkUserStmt = con.prepareStatement(checkUserQuery);
            checkUserStmt.setString(1, name);

            ResultSet rsCheck = checkUserStmt.executeQuery();
            if (rsCheck.next()) {
                out.println("<h2>Username Already Exists.<br> Please Choose a Different Username.</h2>");
            }
            else {
            	String query = "INSERT INTO ceredentials (username, password) VALUES (?, ?)";
            	PreparedStatement ps = con.prepareStatement(query);
            	ps.setString(1, name);
            	ps.setString(2, password);

            	int rs = ps.executeUpdate();

            	if (rs == 1) {
            		out.println("<h2>SignUp Successful</h2>");
            	} else {
            		out.println("<h2>Fail to Sign Up.</h2>");
            	}
            	ps.close();
            }
            out.println("</body></html>");
            checkUserStmt.close();
            con.close();

        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}
