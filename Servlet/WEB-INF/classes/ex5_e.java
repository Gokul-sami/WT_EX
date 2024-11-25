import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/QuestionServlete")
public class ex5_e extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // Initialize the hit count in ServletContext
        ServletContext context = getServletContext();
        if (context.getAttribute("hitCount") == null) {
            context.setAttribute("hitCount", 0);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType("text/html");

        // Increment the hit count
        ServletContext context = getServletContext();
        synchronized (context) {
            int hitCount = (int) context.getAttribute("hitCount");
            hitCount++;
            context.setAttribute("hitCount", hitCount);
        }

        // Retrieve form parameters
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userAge = request.getParameter("userAge");
        String userPassword = request.getParameter("userPassword");
        String musicGenre = request.getParameter("musicGenre");

        StringBuilder validationErrors = new StringBuilder();

        // Validate inputs
        if (userName == null || userName.trim().isEmpty() || !userName.matches("[a-zA-Z ]+")) {
            validationErrors.append("Invalid name. ");
        }
        if (userEmail == null || userEmail.trim().isEmpty() || !userEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            validationErrors.append("Invalid email. ");
        }
        if (userPassword == null || userPassword.trim().isEmpty() || userPassword.length() < 8) {
            validationErrors.append("Password must be at least 8 characters. ");
        }
        try {
            int age = Integer.parseInt(userAge);
            if (age < 5 || age > 120) validationErrors.append("Age out of realistic range. ");
        } catch (NumberFormatException e) {
            validationErrors.append("Invalid age. ");
        }
        if (musicGenre == null || musicGenre.trim().isEmpty()) {
            validationErrors.append("Music genre is required. ");
        }

        PrintWriter out = response.getWriter();
        if (validationErrors.length() > 0) {
            out.println("<html><body>");
            out.println("<h2>Form Submission Error</h2>");
            out.println("<p>" + validationErrors.toString() + "</p>");
            out.println("<h3>Total Visits: " + context.getAttribute("hitCount") + "</h3>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Form Submission Successful</h2>");
            out.println("<p>Your data has been successfully submitted.</p>");
            out.println("<h3>Total Visits: " + context.getAttribute("hitCount") + "</h3>");
            out.println("</body></html>");
        }
    }
}
