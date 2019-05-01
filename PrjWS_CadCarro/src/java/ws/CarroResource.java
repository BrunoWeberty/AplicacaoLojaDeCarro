package ws;

import classesBO.CarroBO;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import objetos.Carro;

/**
 * REST Web Service
 *
 * @author Bruno_TI
 */
@Path("c")
public class CarroResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarroResource
     */
    public CarroResource() {
    }

    /**
     * Retrieves representation of an instance of ws.CarroResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carro> getJson() {
        //TODO return proper representation object
        return new CarroBO().getCarros();
    }

    /**
     * PUT method for updating or creating an instance of CarroResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)//Esse serviço esta consumindo algo do cliente
    @Produces(MediaType.APPLICATION_JSON)//O serviço ta produzindo conteudo para um cliente produzir
    public void putJson(String content) 
    {
        Gson g = new Gson();
        Carro c = g.fromJson(content, Carro.class);
        new CarroBO().salvar(c);
    }
}
