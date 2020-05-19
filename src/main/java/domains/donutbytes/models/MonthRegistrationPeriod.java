package domains.donutbytes.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MonthRegistrationPeriod extends RegistrationPeriod {

    public MonthRegistrationPeriod(int value) {
        super("month", value);
    }
}
