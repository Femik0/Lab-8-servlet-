package SirenkoAlexandr_2kurs_10gruppa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.company.entity.ChatMessage;
import java.util.LinkedList;

public class MessageListServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
// Установить кодировку HTTP-ответа UTF-8
        response.setCharacterEncoding("utf8");
// Получить доступ к потоку вывода HTTP-ответа
        PrintWriter pw = response.getWriter();
// Записть в поток HTML-разметку страницы
        pw.println("<html><head><meta http-equiv='Content-Type' content='text/html;" +
                " charset=utf-8'/><meta http-equiv='refresh' content='10'></head>");
        pw.println("<body>");


        LinkedList<String> authors = new LinkedList<String>();
// В обратном порядке записать в поток HTML-разметку для каждого сообщения
        for (int i=messages.size()-1; i>=0; i--) {
            ChatMessage aMessage = messages.get(i);

            String nameOfAuthor = aMessage.getAuthor().getName();

            if (aMessage.getMessage().equals("NEWUSERINTHECHAT")) {
                pw.println("<div>Пользователь <strong>" + nameOfAuthor +"</strong> пришёл в чат" + "</div>");
            }
            else pw.println("<div><strong>" + nameOfAuthor
                    + "</strong>: " + aMessage.getMessage() + "</div>");
        }
        pw.println("</body></html>");
    }
}