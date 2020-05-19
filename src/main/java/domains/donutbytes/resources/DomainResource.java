package domains.donutbytes.resources;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import domains.donutbytes.errors.DomainProviderException;
import domains.donutbytes.models.DomainResponse;
import domains.donutbytes.models.RegisterDomainRequest;
import domains.donutbytes.models.RenewDomainRequest;
import domains.donutbytes.providers.IDomainProvider;

@Path("/domain")
@Produces(MediaType.APPLICATION_JSON)
public class DomainResource {

    private final IDomainProvider domainProvider;

    public DomainResource(IDomainProvider domainProvider) {
        this.domainProvider = domainProvider;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerDomain(@NotNull RegisterDomainRequest request) {
        DomainResponse response;
        try {
            response = domainProvider.createDomain(request);
        } catch (DomainProviderException e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.status(Status.CREATED).entity(response).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response renewDomain(@NotNull RenewDomainRequest request) {
        DomainResponse response;
        try {
            response = domainProvider.updateDomain(request);
        } catch (DomainProviderException e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.status(Status.OK).entity(response).build();
    }

    @DELETE
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDomain(@PathParam("name") String domainName) {
        try {
            domainProvider.deleteDomain(domainName);
        } catch (DomainProviderException e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDomainInfo(@PathParam("name") String domainName) {
        DomainResponse response;
        try {
            response = domainProvider.getDomain(domainName);
        } catch (DomainProviderException e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.status(Status.OK).entity(response).build();
    }
}
