import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/QuestionServlet")
public class ex5_b extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String userName = request.getParameter("userName");
        String userAge = request.getParameter("userAge");
        String musicGenre = request.getParameter("musicGenre");
        String livePerformance = request.getParameter("livePerformance");
        String listeningFrequency = request.getParameter("listeningFrequency");

        StringBuilder validationErrors = new StringBuilder();

        if (userName == null || userName.trim().isEmpty()) {
            validationErrors.append("Name is required.<br>");
        } else if (!userName.matches("[a-zA-Z ]+")) {
            validationErrors.append("Name can only contain alphabetic characters and spaces.<br>");
        }
        
        if (userAge == null || userAge.trim().isEmpty()) {
            validationErrors.append("Age is required.<br>");
        } else {
            try {
                int age = Integer.parseInt(userAge);
                if (age < 0 || age > 120) {
                    validationErrors.append("Please enter a realistic age (0-120).<br>");
                }
            } catch (NumberFormatException e) {
                validationErrors.append("Please enter a valid age in numbers.<br>");
            }
        }
        
        if (musicGenre == null || musicGenre.trim().isEmpty()) {
            validationErrors.append("Music genre is required.<br>");
        } else if (!musicGenre.matches("[a-zA-Z ]+")) {
            validationErrors.append("Music genre should only contain alphabetic characters and spaces.<br>");
        }
        
        if (livePerformance == null || livePerformance.trim().isEmpty()) {
            validationErrors.append("Live performance preference is required.<br>");
        } else if (!livePerformance.equalsIgnoreCase("Yes") && !livePerformance.equalsIgnoreCase("No")) {
            validationErrors.append("Live performance preference should be either 'Yes' or 'No'.<br>");
        }
        
        if (listeningFrequency == null || listeningFrequency.trim().isEmpty()) {
            validationErrors.append("Listening frequency is required.<br>");
        } else if (!listeningFrequency.matches("(?i)Daily|Weekly|Monthly|Rarely")) {
            validationErrors.append("Listening frequency should be 'Daily', 'Weekly', 'Monthly', or 'Rarely'.<br>");
        }        

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (validationErrors.length() > 0) {
            out.println("<h2>Form Submission Error</h2>");
            out.println("<p>" + validationErrors.toString() + "</p>");
        } else {
            out.println("<h2>Thank you for your response!</h2>");
            out.println("<p>Name: " + userName + "</p>");
            out.println("<p>Age: " + userAge + "</p>");
            out.println("<p>Favorite Music Genre: " + musicGenre + "</p>");
            out.println("<p>Live Performance Preference: " + livePerformance + "</p>");
            out.println("<p>Listening Frequency: " + listeningFrequency + "</p>");
        }
        out.println("</body></html>");
    }
}
