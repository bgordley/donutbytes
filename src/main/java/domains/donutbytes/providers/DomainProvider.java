package domains.donutbytes.providers;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import domains.donutbytes.errors.DomainProviderException;
import domains.donutbytes.models.DomainResponse;
import domains.donutbytes.models.MonthRegistrationPeriod;
import domains.donutbytes.models.RegisterDomainRequest;
import domains.donutbytes.models.RegistrationPeriod;
import domains.donutbytes.models.RenewDomainRequest;
import domains.donutbytes.models.YearRegistrationPeriod;

/**
 * For the sake of time I stopped here at the provider-level. Normally we would wire up a repository
 * to handle CRUD operations for a DB or other microservice. In this case we are mocking persistence
 * using an in-memory map.
 */
public class DomainProvider implements IDomainProvider {

    private Map<String, DomainResponse> mockDomainMap;

    public DomainProvider() {
        mockDomainMap = new HashMap<>();
    }

    @Override
    public DomainResponse createDomain(RegisterDomainRequest request)
            throws DomainProviderException {

        String domainName = request.getDomainName();

        if (mockDomainMap.containsKey(domainName)) {
            throw new DomainProviderException.DomainPreviouslyRegisteredException(domainName);
        }

        DomainResponse response = new DomainResponse(domainName,
                getExpirationDateTime(request.getRegistrationPeriod()));

        mockDomainMap.put(domainName, response);

        return response;
    }

    @Override
    public DomainResponse updateDomain(RenewDomainRequest request) throws DomainProviderException {

        String domainName = request.getDomainName();

        if (!mockDomainMap.containsKey(domainName)) {
            throw new DomainProviderException.DomainNotFoundException(domainName);
        }

        DomainResponse response = mockDomainMap.get(domainName);

        response.setDomainExpirationDate(getExpirationDateTime(request.getRegistrationPeriod()));

        mockDomainMap.put(domainName, response);

        return response;
    }

    @Override
    public DomainResponse getDomain(String domainName) throws DomainProviderException {
        if (!mockDomainMap.containsKey(domainName)) {
            throw new DomainProviderException.DomainNotFoundException(domainName);
        }

        return mockDomainMap.get(domainName);
    }

    @Override
    public void deleteDomain(String domainName) throws DomainProviderException {
        if (!mockDomainMap.containsKey(domainName)) {
            throw new DomainProviderException.DomainNotFoundException(domainName);
        }

        mockDomainMap.remove(domainName);
    }

    private ZonedDateTime getExpirationDateTime(RegistrationPeriod registrationPeriod) {
        ZonedDateTime expiration = ZonedDateTime.now();

        if (registrationPeriod instanceof YearRegistrationPeriod) {
            expiration = expiration.plusYears(registrationPeriod.getValue());
        } else if (registrationPeriod instanceof MonthRegistrationPeriod) {
            expiration = expiration.plusMonths(registrationPeriod.getValue());
        }

        return expiration;
    }
}
