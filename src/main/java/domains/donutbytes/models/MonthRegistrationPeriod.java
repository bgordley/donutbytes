package domains.donutbytes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class MonthRegistrationPeriod extends RegistrationPeriod {

    public MonthRegistrationPeriod(int value) {
        super("month", value);
    }
}
