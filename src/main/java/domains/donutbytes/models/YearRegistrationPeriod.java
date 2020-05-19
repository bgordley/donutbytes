package domains.donutbytes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class YearRegistrationPeriod extends RegistrationPeriod {

    public YearRegistrationPeriod(int value) {
        super("year", value);
    }
}
