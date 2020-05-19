package domains.donutbytes.resources;

import java.time.ZonedDateTime;
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
import domains.donutbytes.models.DomainResponse;
import domains.donutbytes.models.MonthRegistrationPeriod;
import domains.donutbytes.models.RegisterDomainRequest;
import domains.donutbytes.models.RenewDomainRequest;
import domains.donutbytes.models.YearRegistrationPeriod;

@Path("/domain")
@Produces(MediaType.APPLICATION_JSON)
public class DomainResource {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerDomain(@NotNull RegisterDomainRequest request) {
        // Call provider

        ZonedDateTime exp = ZonedDateTime.now();
        if (request.getRegistrationPeriod() instanceof YearRegistrationPeriod) {
            exp = exp.plusYears(request.getRegistrationPeriod().getValue());
        } else if (request.getRegistrationPeriod() instanceof MonthRegistrationPeriod) {
            exp = exp.plusMonths(request.getRegistrationPeriod().getValue());
        }

        return Response
            .status(Status.CREATED)
            .entity(new DomainResponse(request.getDomainName(), exp))
            .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response renewDomain(@NotNull RenewDomainRequest request) {
        // Call provider

        ZonedDateTime exp = ZonedDateTime.now();
        if (request.getRegistrationPeriod() instanceof YearRegistrationPeriod) {
            exp = exp.plusYears(request.getRegistrationPeriod().getValue());
        } else if (request.getRegistrationPeriod() instanceof MonthRegistrationPeriod) {
            exp = exp.plusMonths(request.getRegistrationPeriod().getValue());
        }

        return Response
            .status(Status.OK)
            .entity(new DomainResponse(request.getDomainName(), exp))
            .build();
    }

    @DELETE
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDomain(@PathParam("name") String domainName) {
        // Call provider

        return Response
            .status(Status.NO_CONTENT)
            .build();
    }

    @GET
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDomainInfo(@PathParam("name") String domainName) {
        // Call provider

        ZonedDateTime exp = ZonedDateTime.now().plusYears(1);

        return Response
            .status(Status.OK)
            .entity(new DomainResponse(domainName, exp))
            .build();
    }
}
