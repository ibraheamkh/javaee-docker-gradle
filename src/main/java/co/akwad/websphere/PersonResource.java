package co.akwad.websphere;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.json.Json;


@Path("persons")
public class PersonResource {

    @Inject
    PersonDatabase database;

    @GET
    @Produces("application/json")
    public Person[] get() {
        return database.currentList();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Person get(@PathParam("id") int id) {
        return database.getPerson(id);
    }
}
