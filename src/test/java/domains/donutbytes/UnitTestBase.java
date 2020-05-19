package domains.donutbytes;

import domains.donutbytes.models.AbcVerifiedContact;
import domains.donutbytes.models.RegisterDomainRequest;
import domains.donutbytes.models.RenewDomainRequest;
import domains.donutbytes.models.YearRegistrationPeriod;

public abstract class UnitTestBase {
    protected static final String DOMAIN_NAME = "donutbytes.domains";

    protected RegisterDomainRequest buildRegisterDomainRequest() {
        RegisterDomainRequest request = new RegisterDomainRequest();
        request.setDomainName(DOMAIN_NAME);
        request.setRegistrationPeriod(new YearRegistrationPeriod(1));
        request.setVerifiedContact(new AbcVerifiedContact("test-client-id"));

        return request;
    }

    protected RenewDomainRequest buildRenewDomainRequest() {
        RenewDomainRequest request = new RenewDomainRequest();
        request.setDomainName(DOMAIN_NAME);
        request.setRegistrationPeriod(new YearRegistrationPeriod(1));

        return request;
    }
}