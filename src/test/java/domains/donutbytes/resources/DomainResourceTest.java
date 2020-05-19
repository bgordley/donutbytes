package domains.donutbytes.resources;

import java.time.ZonedDateTime;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import domains.donutbytes.models.AbcVerifiedContact;
import domains.donutbytes.models.DomainResponse;
import domains.donutbytes.models.RegisterDomainRequest;
import domains.donutbytes.models.RenewDomainRequest;
import domains.donutbytes.models.YearRegistrationPeriod;

public class DomainResourceTest {

    private static final String DOMAIN_NAME = "donutbytes.domains";

    private DomainResource domainResource;

    @BeforeClass
    public void setup() {
        this.domainResource = new DomainResource();
    }

    @Test
    public void testRegisterDomain() {
        RegisterDomainRequest request = new RegisterDomainRequest();
        request.setDomainName(DOMAIN_NAME);
        request.setRegistrationPeriod(new YearRegistrationPeriod(1));
        request.setVerifiedContact(new AbcVerifiedContact("test-client-id"));

        Response response = domainResource.registerDomain(request);
        DomainResponse responseEntity = (DomainResponse) response.getEntity();

        Assert.assertEquals(responseEntity.getDomainName(), DOMAIN_NAME);
        Assert.assertEquals(responseEntity.getDomainExpirationDate().toLocalDate(),
                ZonedDateTime.now().plusYears(1).toLocalDate());
        Assert.assertEquals(response.getStatus(), Status.CREATED.getStatusCode());
    }

    @Test
    public void testRenewDomain() {
        RenewDomainRequest request = new RenewDomainRequest();
        request.setDomainName(DOMAIN_NAME);
        request.setRegistrationPeriod(new YearRegistrationPeriod(1));

        Response response = domainResource.renewDomain(request);
        DomainResponse responseEntity = (DomainResponse) response.getEntity();

        Assert.assertEquals(responseEntity.getDomainName(), DOMAIN_NAME);
        Assert.assertEquals(responseEntity.getDomainExpirationDate().toLocalDate(),
                ZonedDateTime.now().plusYears(1).toLocalDate());
        Assert.assertEquals(response.getStatus(), Status.OK.getStatusCode());
    }

    @Test
    public void testDeleteDomain() {
        Response response = domainResource.deleteDomain(DOMAIN_NAME);

        Assert.assertEquals(response.getStatus(), Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void testGetDomainInfo() {
        Response response = domainResource.getDomainInfo(DOMAIN_NAME);
        DomainResponse responseEntity = (DomainResponse) response.getEntity();

        Assert.assertEquals(responseEntity.getDomainName(), DOMAIN_NAME);
        Assert.assertEquals(responseEntity.getDomainExpirationDate().toLocalDate(),
                ZonedDateTime.now().plusYears(1).toLocalDate());
        Assert.assertEquals(response.getStatus(), Status.OK.getStatusCode());
    }
}
