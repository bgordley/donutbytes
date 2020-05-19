package domains.donutbytes.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DomainCreateRequest extends DomainRequest {
    private VerifiedContact verifiedContact;
}
