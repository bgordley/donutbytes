package domains.donutbytes;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DonutBytesApplication extends Application<DonutBytesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DonutBytesApplication().run(args);
    }

    @Override
    public String getName() {
        return "DonutBytes";
    }

    @Override
    public void initialize(final Bootstrap<DonutBytesConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DonutBytesConfiguration configuration, final Environment environment) {
        // TODO: implement application
    }

}
