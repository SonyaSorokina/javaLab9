package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import model.Storage;
import model.Textile;
import org.json.JSONArray;
import org.json.JSONObject;

public class lab3Servlets extends HttpServlet {
    private final Storage storage = new Storage();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/lab3.jsp");
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String compound = request.getParameter("compound");
        String color = request.getParameter("color");
        String country = request.getParameter("country");
        String pattern = request.getParameter("pattern");

        Textile newTextile = new Textile(name, compound, color, country, pattern);

        storage.addItem(newTextile);

        doGet(request, response);
    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
//        request.setCharacterEncoding("UTF-8");
//
//        JSONObject json = new JSONObject().put("name", request.getParameter("name"));
//        json.put("comp", request.getParameter("compound"));
//        json.put("color", request.getParameter("color"));
//        json.put("country", request.getParameter("country"));
//        json.put("pattern", request.getParameter("pattern"));
//
//        String path = null;
//        try {
//            path = new File(lab3Servlets.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getParentFile().getParentFile().getParent() + File.separator + "out" + File.separator + "artifacts"+ File.separator + "myapp2_war_exploded" + File.separator + "listTextile.json";
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//
//        String jsonContent = new String(Files.readAllBytes(Path.of(path)));
//
//        JSONArray jsonArray = new JSONArray(jsonContent);
//        jsonArray.put(json);
//        try (FileWriter writer = new FileWriter(path)) {
//            writer.write(jsonArray.toString(4));
//        }
//        catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try (FileWriter writer = new FileWriter(path)) {
//            writer.write(jsonArray.toString(4));
//        }
//        catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        doGet(request, response);
//    }
}
