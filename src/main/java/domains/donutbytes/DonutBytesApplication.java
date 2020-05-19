package domains.donutbytes;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import domains.donutbytes.config.DonutBytesConfig;
import domains.donutbytes.health.ServiceHealthCheck;
import domains.donutbytes.resources.DomainResource;

public class DonutBytesApplication extends Application<DonutBytesConfig> {

    public static void main(final String[] args) throws Exception {
        new DonutBytesApplication().run(args);
    }

    @Override
    public String getName() {
        return "DonutBytes";
    }

    @Override
    public void initialize(final Bootstrap<DonutBytesConfig> bootstrap) {
        bootstrap.getObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public void run(final DonutBytesConfig configuration, final Environment environment) {
        environment.healthChecks().register("service", new ServiceHealthCheck());
        environment.jersey().register(new DomainResource());
    }

}
