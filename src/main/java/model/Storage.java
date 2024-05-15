package model;
import controller.lab3Servlets;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
public class Storage {
    public void addItem(Textile textile) throws IOException{
        JSONObject json = new JSONObject().put("name", textile.getName());
        json.put("comp", textile.getCompound());
        json.put("color", textile.getColor());
        json.put("country", textile.getCountry());
        json.put("pattern", textile.getPattern());

        String path = null;
        try {
            path = new File(lab3Servlets.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getParentFile().getParentFile().getParent() + File.separator + "out" + File.separator + "artifacts"+ File.separator + "myapp2_war_exploded" + File.separator + "listTextile.json";
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String jsonContent = new String(Files.readAllBytes(Path.of(path)));

        JSONArray jsonArray = new JSONArray(jsonContent);
        jsonArray.put(json);
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(jsonArray.toString(4));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(jsonArray.toString(4));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
