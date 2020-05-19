package domains.donutbytes.models;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DomainResponse {
    @NonNull
    private String domainName;
    @NonNull
    private ZonedDateTime domainExpirationDate;
}
