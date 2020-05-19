package domains.donutbytes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class DomainRequest {
    @NonNull
    private String domainName;
    @NonNull
    private RegistrationPeriod registrationPeriod;
}
