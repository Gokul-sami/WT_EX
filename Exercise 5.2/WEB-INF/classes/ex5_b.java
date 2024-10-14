import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formServe")
public class ex5_b extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if (name == null || name.isEmpty()) {
                out.println("Name is required.");
            } 
            else if (!name.matches("[a-zA-Z\\s]+")) {
                out.println("Name must not contain numbers or special characters.");
            } 
            else if (email == null || email.isEmpty()) {
                out.println("Email is required.");
            } 
            else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                out.println("Email must be in a valid format.");
            }
            else if (password == null || password.isEmpty()) {
                out.println("Password is required.");
            } 
            else if (password.length() < 8 || !password.matches(".*\\d.*") || !password.matches(".*[a-zA-Z].*")) {
                out.println("<p style='color:red;'>Password is weak. Please choose a password with at least 8 characters, including both letters and numbers.</p>");
            }
            else {
                out.println("</div>");
               out.println("<p><strong>Email:</strong> " + email + "</p>");
               out.println("<p><strong>Name:</strong> " + name + "</p>");
               out.println("<h2>Form submitted successfully!</h2>");
               out.println("<div style='font-family: Arial, sans-serif; font-size: 16px; color: green;'>");
            } 
        } 
        finally {
            out.close();
        } 
    } 
} 
