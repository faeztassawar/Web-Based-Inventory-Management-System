import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Search extends HttpServlet {

    // Process the HTTP POST request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Get PrintWriter object
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
                String name = request.getParameter("p_name");

                    out.println("<html>");
                    out.println("<head><title>Response</title></head>");
                    out.println("<body>");

                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        String url = "jdbc:mysql://127.0.0.1:3306/users";
                        Connection con = DriverManager.getConnection(url, "root", "root");

                        String query = "SELECT * FROM product WHERE name = ?";
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, name);

                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            out.println("<h3>"+ rs.getString("name") +"</h3>");
                            out.println("<h3>"+ rs.getString("quantity") +"</h3>");
                            out.println("<h3>"+ rs.getInt("unit_price") +"</h3>");
                        } else {
                            out.println("<h2>No Product Found !</h2>");
                        }
                        ps.close();

                        out.println("</body></html>");
                        con.close();

                    } catch (Exception e) {
                        out.println("<h1>Error: " + e.getMessage() + "</h1>");
                    }
            }
        
        out.close();
    }
}