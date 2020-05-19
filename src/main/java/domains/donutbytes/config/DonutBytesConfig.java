package domains.donutbytes.config;

import io.dropwizard.Configuration;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class DonutBytesConfig extends Configuration {
    @NotNull
    private DomainValidationConfig domainValidation;
}
