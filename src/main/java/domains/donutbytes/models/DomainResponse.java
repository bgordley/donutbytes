package domains.donutbytes.models;

import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class DomainResponse {
    private String domainName;
    private ZonedDateTime domainExpirationDate;
}