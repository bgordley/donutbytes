package domains.donutbytes.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.Data;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.EXISTING_PROPERTY, 
  property = "unit")
@JsonSubTypes({ 
  @Type(value = YearRegistrationPeriod.class, name = "year"), 
  @Type(value = MonthRegistrationPeriod.class, name = "month") 
})
@Data
public abstract class RegistrationPeriod {
    private int value;
    private String unit;
}