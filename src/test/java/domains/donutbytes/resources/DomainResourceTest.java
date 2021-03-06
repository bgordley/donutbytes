package domains.donutbytes.resources;

import java.time.ZonedDateTime;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import domains.donutbytes.UnitTestBase;
import domains.donutbytes.models.DomainResponse;
import domains.donutbytes.models.RegisterDomainRequest;
import domains.donutbytes.models.RenewDomainRequest;
import domains.donutbytes.providers.DomainProvider;

public class DomainResourceTest extends UnitTestBase {

    private DomainResource domainResource;

    @BeforeMethod
    public void beforeMethod() {
        this.domainResource = new DomainResource(new DomainProvider());
    }

    @Test
    public void testRegisterDomain() {
        RegisterDomainRequest request = buildRegisterDomainRequest();

        Response response = domainResource.registerDomain(request);
        DomainResponse responseEntity = (DomainResponse) response.getEntity();

        Assert.assertEquals(responseEntity.getDomainName(), DOMAIN_NAME);
        Assert.assertEquals(responseEntity.getDomainExpirationDate().toLocalDate(),
                ZonedDateTime.now().plusYears(1).toLocalDate());
        Assert.assertEquals(response.getStatus(), Status.CREATED.getStatusCode());
    }

    @Test
    public void testRenewDomain() {
        domainResource.registerDomain(buildRegisterDomainRequest());
        RenewDomainRequest request = buildRenewDomainRequest();

        Response response = domainResource.renewDomain(request);
        DomainResponse responseEntity = (DomainResponse) response.getEntity();

        Assert.assertEquals(responseEntity.getDomainName(), DOMAIN_NAME);
        Assert.assertEquals(responseEntity.getDomainExpirationDate().toLocalDate(),
                ZonedDateTime.now().plusYears(1).toLocalDate());
        Assert.assertEquals(response.getStatus(), Status.OK.getStatusCode());
    }

    @Test
    public void testDeleteDomain() {
        domainResource.registerDomain(buildRegisterDomainRequest());
        Response response = domainResource.deleteDomain(DOMAIN_NAME);

        Assert.assertEquals(response.getStatus(), Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void testGetDomainInfo() {
        domainResource.registerDomain(buildRegisterDomainRequest());
        Response response = domainResource.getDomainInfo(DOMAIN_NAME);
        DomainResponse responseEntity = (DomainResponse) response.getEntity();

        Assert.assertEquals(responseEntity.getDomainName(), DOMAIN_NAME);
        Assert.assertEquals(responseEntity.getDomainExpirationDate().toLocalDate(),
                ZonedDateTime.now().plusYears(1).toLocalDate());
        Assert.assertEquals(response.getStatus(), Status.OK.getStatusCode());
    }
}
