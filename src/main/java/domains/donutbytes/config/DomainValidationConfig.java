package domains.donutbytes.config;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DomainValidationConfig {
    @NotEmpty
    private int minimumLength;
}
