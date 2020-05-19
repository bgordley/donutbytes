package domains.donutbytes.providers;

import java.time.ZonedDateTime;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import domains.donutbytes.UnitTestBase;
import domains.donutbytes.errors.DomainProviderException;
import domains.donutbytes.errors.DomainProviderException.DomainNotFoundException;
import domains.donutbytes.errors.DomainProviderException.DomainPreviouslyRegisteredException;
import domains.donutbytes.models.DomainResponse;
import domains.donutbytes.models.RegisterDomainRequest;
import domains.donutbytes.models.RenewDomainRequest;

public class DomainProviderTest extends UnitTestBase {

    private DomainProvider provider;

    @BeforeMethod
    public void beforeMethod() {
        provider = new DomainProvider();
    }

    @Test
    public void testCreateDomain() throws DomainProviderException {
        RegisterDomainRequest request = buildRegisterDomainRequest();

        DomainResponse response  = provider.createDomain(request);

        Assert.assertEquals(response.getDomainName(), DOMAIN_NAME);
        Assert.assertEquals(response.getDomainExpirationDate().toLocalDate(),
                ZonedDateTime.now().plusYears(1).toLocalDate());
    }

    @Test(expectedExceptions = DomainPreviouslyRegisteredException.class)
    public void testCreateDomainPreviouslyRegistered() throws DomainProviderException {
        RegisterDomainRequest request = buildRegisterDomainRequest();

        provider.createDomain(request);
        provider.createDomain(request);
    }

    @Test
    public void testUpdateDomain() throws DomainProviderException {
        RenewDomainRequest request = buildRenewDomainRequest();

        provider.createDomain(buildRegisterDomainRequest());
        DomainResponse response = provider.updateDomain(request);

        Assert.assertEquals(response.getDomainName(), DOMAIN_NAME);
        Assert.assertEquals(response.getDomainExpirationDate().toLocalDate(),
                ZonedDateTime.now().plusYears(1).toLocalDate());
    }

    @Test(expectedExceptions = DomainNotFoundException.class)
    public void testUpdateDomainNotFound() throws DomainProviderException {
        RenewDomainRequest request = buildRenewDomainRequest();

        provider.updateDomain(request);
    }

    @Test
    public void testGetDomain() throws DomainProviderException {
        provider.createDomain(buildRegisterDomainRequest());
        DomainResponse response = provider.getDomain(DOMAIN_NAME);
        
        Assert.assertEquals(response.getDomainName(), DOMAIN_NAME);
        Assert.assertEquals(response.getDomainExpirationDate().toLocalDate(),
                ZonedDateTime.now().plusYears(1).toLocalDate());
    }

    @Test(expectedExceptions = DomainNotFoundException.class)
    public void testGetDomainNotFound() throws DomainProviderException {
        provider.getDomain(DOMAIN_NAME);
    }

    @Test(expectedExceptions = DomainNotFoundException.class)
    public void testDeleteDomain() throws DomainProviderException {
        provider.createDomain(buildRegisterDomainRequest());
        provider.deleteDomain(DOMAIN_NAME);
        provider.getDomain(DOMAIN_NAME);
    }

    @Test(expectedExceptions = DomainNotFoundException.class)
    public void testDeleteDomainNotFound() throws DomainProviderException {
        provider.deleteDomain(DOMAIN_NAME);
    }
}