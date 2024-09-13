import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Update extends HttpServlet {

    // Process the HTTP POST request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Get PrintWriter object
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
            String type = (String) session.getAttribute("type");
            if (type != null && type.equals("admin")) {
                String productIdString = request.getParameter("id");
                String name = request.getParameter("p_name");
                String quantity = request.getParameter("quan");
                String priceString = request.getParameter("price");
                
                    int productId = Integer.parseInt(productIdString);
                    int price = Integer.parseInt(priceString);

                    out.println("<html>");
                    out.println("<head><title>Response</title></head>");
                    out.println("<body>");

                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        String url = "jdbc:mysql://127.0.0.1:3306/users";
                        Connection con = DriverManager.getConnection(url, "root", "root");

                        String query = "UPDATE product SET name = ?, quantity = ?, unit_price = ? WHERE id = ?";
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, name);
                        ps.setString(2, quantity);
                        ps.setInt(3, price);
                        ps.setInt(4, productId);

                        int rs = ps.executeUpdate();
                        if (rs == 1) {
                            out.println("<h2>Product Updated Successfully.</h2>");
                        } else {
                            out.println("<h2>Failed to Update.</h2>");
                        }
                        ps.close();

                        out.println("</body></html>");
                        con.close();

                    } catch (Exception e) {
                        out.println("<h1>Error: " + e.getMessage() + "</h1>");
                    }
                } else {
                    out.println("<h1>Error: You don't have permission to access this page.</h1>");
               } 
        }else {
            out.println("<h1>Error: Session not found.</h1>");
        }

        // Close PrintWriter object
        out.close();
    }
}
