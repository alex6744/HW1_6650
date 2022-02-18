import io.swagger.client.ApiException;
import io.swagger.client.api.ResortsApi;
import io.swagger.client.model.SeasonsList;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SkierServlet", value = "/skiers/*")
public class SkierServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String urlPath = request.getPathInfo();
    if (urlPath == null || urlPath.isEmpty()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      response.getWriter().write("missing parameters");
    }
    String[] urlParts = urlPath.split("/");
    if(!isUrlValid(urlParts)){
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getWriter().write("url is not valid");
    }



   PrintWriter out = response.getWriter();
   //out.println("<h1>" + "msg" + "</h1>");
    out.println("1");
   // response.getWriter().write(request.getPathInfo());

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String urlPath = request.getPathInfo();
      if (urlPath == null || urlPath.isEmpty()) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        response.getWriter().write("missing parameters");
      }
      String[] urlParts = urlPath.split("/");
      if(!isUrlValid(urlParts)){
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().write("url is not valid");
      }
      response.setStatus(HttpServletResponse.SC_CREATED);
  }
  private boolean isUrlValid(String[] urlPath){
    if(urlPath.length!=8||urlPath.length!=3){
      return false;
    }
    if(!urlPath[2].equals("seasons")||!urlPath[2].equals("vertical")){
      return false;
    }
    if(urlPath[2].equals("seasons")){
      if(urlPath[4].equals("days")){
        if(!urlPath[6].equals("skiers")){
          return false;
        }
      }else{
        return false;
      }
    }
    return true;
  }

}
