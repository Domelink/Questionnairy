package com.gmail.l.domelink;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Questionary", value = "/Questionary_result")
public class Questionary extends HttpServlet {

    private final AtomicInteger countContact1 = new AtomicInteger(0);
    private final AtomicInteger countContact2 = new AtomicInteger(0);

    private final AtomicInteger count2Contact1 = new AtomicInteger(0);
    private final AtomicInteger count2Contact2 = new AtomicInteger(0);

    private int result1 = 0;
    private int result2 = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("QuestionaryResult.jsp");
        rd.include(request, response);

        String contact = request.getParameter("contact");
        result1 = getResult1(contact);

        String contact2 = request.getParameter("contact2");
        result2 = getResult2(contact2);

        PrintWriter out = response.getWriter();
        print(out);
    }

    private int getResult2(String contact){
        if(contact != null) {
            result2 = 0;
            if (contact.equals("1")) {
                count2Contact1.incrementAndGet();
            } else if (contact.equals("2")) {
                count2Contact2.incrementAndGet();
            }
        }
        return count2Contact1.get() + count2Contact2.get();
    }

    private int getResult1(String contact){
        if(contact != null) {
            result1 = 0;
            if (contact.equals("1")) {
                countContact1.incrementAndGet();
            } else if (contact.equals("2")) {
                countContact2.incrementAndGet();
            }
        }
        return countContact1.get() + countContact2.get();
    }

    private void print(PrintWriter out){
        int count = 0;

        out.println("<html lang=\"ru\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Result</title>\n" +
                "</head><body>");
        out.println("<h3> " +
                "Ответили на первый вопрос: " + result1 + getChel(result1) +
                "</h3>");
        count = countContact1.get();
        out.println("<p> Предпочетают легковые' " + count + getChel(count) + "</p>");
        count = countContact2.get();
        out.println("<p> предпочетают внедорожники' " + count + getChel(count) + "</p>");
        out.println("<h3> " +
                "Ответили на второй вопрос: " + result2 + getChel(result2) +
                "</h3>");
        count = count2Contact1.get();
        out.println("<p> Предпочитают вождение -  " + count + getChel(count) + "</p>");
        count = count2Contact2.get();
        out.println("<p> Предпочетают быть пассажирами -  " + count + getChel(count) + "</p>");
        out.println("</body></html>");
    }

    private String getChel(int count){
        String str = Integer.toString(count);
        if(str.endsWith("2") || str.endsWith("3") || str.endsWith("4"))
            return " раз.";
        else
            return " раз.";
    }

    public void destroy() {
    }
}