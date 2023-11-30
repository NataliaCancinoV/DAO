package mx.uv.App;
import static spark.Spark.*;
import com.google.gson.*;
import java.util.HashMap;
import java.util.UUID;

public class App 
{
    static Gson gson = new Gson();
    static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        port(80);

        get("/usuarios",(request,response)->{
            response.type(("application/json"));
            //return gson.toJson(usuarios);
            return gson.toJson(DAO.)
        });

        post("/usuarios", (request, response)-> {
            String payload = request.body();
            Usuario u = gson.fromJson(payload, classOfT:Usuario.class);
            String id = UUID.randomUUID().toString();
            u.setId(id,u);
            //usuarios.put(id, u); //se almacena en un diccionario
            DAO.crearUsuario(u);

            System.out.println("payload: " + payload);
            System.out.println("n: " + u.getNombre());
            System.out.println("p: " + u.getPassword());

            JsonObject respuesta = new new JsonObject();
            respuesta.addProperty("msj", "creado");
            respuesta.addProperty("id", id);

            return respuesta;

        })
    }
}
