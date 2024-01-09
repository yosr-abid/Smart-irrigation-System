package com.supcom.cot.smartirrigation.boundaries;

import com.supcom.cot.smartirrigation.entities.Parcel;
import com.supcom.cot.smartirrigation.entities.Field;

import com.supcom.cot.smartirrigation.repositories.ParcelRepository;
import com.supcom.cot.smartirrigation.repositories.FieldRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
@Path("field")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FieldResource {
    private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);

    @Inject
    private FieldRepository repository;

    @Inject
    private ParcelRepository parcelRepository;

    @GET
    public List<Field> findAll() {
        return repository.findAll()
                .collect(toList());
    }

    @GET
    @Path("/{id}")
    public Field findById(@PathParam("id") String id) { return repository.findById(id).orElseThrow(NOT_FOUND);
    }

    @GET
    @Path("/parcels/{id}")
    public List<Parcel> findByIdField(@PathParam("id") String id) {
        return parcelRepository.findByIdField(id);
    }

    @POST
    public void save(Field field) {
        repository.save(field);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id, Field field) {
        repository.save(field);
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") String name) {
        repository.deleteById(name);
    }
}
