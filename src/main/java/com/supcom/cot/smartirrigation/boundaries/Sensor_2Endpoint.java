package com.supcom.cot.smartirrigation.boundaries;


import com.supcom.cot.smartirrigation.entities.Sensor_2;
import com.supcom.cot.smartirrigation.repositories.Sensor_2Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
@Path("sensor_2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Sensor_2Endpoint {

    private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);

    @Inject
    private Sensor_2Repository repository;
    @GET
    public List<Sensor_2> findAll() {
        return repository.findAll()
                .collect(toList());
    }
    @GET
    @Path("/{id}")
    public Sensor_2 findById(@PathParam("id") String id) {
        return repository.findById(id).orElseThrow(NOT_FOUND);
    }

    @POST
    public void save(Sensor_2 sensor_2) {
        repository.save(sensor_2);
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") String id) {
        repository.deleteById(id);
    }
}

