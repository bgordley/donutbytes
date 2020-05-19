package domains.donutbytes.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "unit")
@JsonSubTypes({
  @Type(value = YearRegistrationPeriod.class, name = "year"),
  @Type(value = MonthRegistrationPeriod.class, name = "month")
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class RegistrationPeriod {
  @NonNull
  private String unit;
  @NonNull
  private int value;
}
