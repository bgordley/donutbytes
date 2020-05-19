package domains.donutbytes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterDomainRequest extends DomainRequest {
    @NonNull
    private VerifiedContact verifiedContact;
}
