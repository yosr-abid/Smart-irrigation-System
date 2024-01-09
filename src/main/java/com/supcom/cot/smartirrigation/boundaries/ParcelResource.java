package com.supcom.cot.smartirrigation.boundaries;

import com.supcom.cot.smartirrigation.entities.Parcel;
import com.supcom.cot.smartirrigation.entities.Sensor_2;

import com.supcom.cot.smartirrigation.repositories.ParcelRepository;
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
@Path("parcel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParcelResource {
    private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);

    @Inject
    private ParcelRepository repository;

    @Inject
    private Sensor_2Repository sensorRepository;

    @GET
    public List<Parcel> findAll() {
        return repository.findAll()
                .collect(toList());
    }
    @GET
    @Path("/{id}")
    public Parcel findById(@PathParam("id") String id) { return repository.findById(id).orElseThrow(NOT_FOUND);
    }

//    @GET
//    @Path("/sensor_2/{id}")
//    public List<Sensor_2> findByIdParcel(@PathParam("id") String id) {
//        return sensorRepository.findByIdParcel(id);
//    }

    @POST
    public void save(Parcel parcel) {
        repository.save(parcel);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") String id, Parcel parcel) {
        repository.save(parcel);
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") String plants) {
        repository.deleteById(plants);
    }
}
