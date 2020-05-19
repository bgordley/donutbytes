package domains.donutbytes.models;

import lombok.Data;

@Data
public abstract class DomainRequest {
    private String domainName;
    private RegistrationPeriod registrationPeriod;
}
