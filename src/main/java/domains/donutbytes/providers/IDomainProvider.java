package domains.donutbytes.providers;

import domains.donutbytes.errors.DomainProviderException;
import domains.donutbytes.models.DomainResponse;
import domains.donutbytes.models.RegisterDomainRequest;
import domains.donutbytes.models.RenewDomainRequest;

public interface IDomainProvider {
    DomainResponse createDomain(RegisterDomainRequest request) throws DomainProviderException;
    DomainResponse updateDomain(RenewDomainRequest renew) throws DomainProviderException;
    DomainResponse getDomain(String domainName) throws DomainProviderException;
    void deleteDomain(String domainName) throws DomainProviderException;
}