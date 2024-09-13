import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SignIn extends HttpServlet {
	
	public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Process the HTTP POST request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Get PrintWriter object
        PrintWriter out = response.getWriter();

        String name = request.getParameter("u_name");
        String password = request.getParameter("password");

        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        out.println("<body>");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/users";
            Connection con = DriverManager.getConnection(url, "root", "root");

            String query = "SELECT * FROM ceredentials WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) 
            {
            	String role = rs.getString("type");
                HttpSession ses = request.getSession(true);
                ses.setAttribute("type", role);
                
                String type = (String)ses.getAttribute("type");
                
                if(type == null)
                	response.sendRedirect("./SignIn.html");
                else if(type.equals("admin"))
                	response.sendRedirect("./AdminHome.jsp");
                else if(type.equals("user"))
                	response.sendRedirect("./UserHome.jsp");
            } 
            else 
            {
                out.println("<h2>No User Found !</h2>");
            }

            out.println("</body></html>");
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}
