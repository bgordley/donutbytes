package domains.donutbytes;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import domains.donutbytes.config.DonutBytesConfig;

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
        // TODO: application initialization
    }

    @Override
    public void run(final DonutBytesConfig configuration, final Environment environment) {
        // TODO: implement application
    }

}
