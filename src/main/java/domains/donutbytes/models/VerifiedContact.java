package domains.donutbytes.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.EXISTING_PROPERTY, 
  property = "provider")
@JsonSubTypes({ 
  @Type(value = AbcVerifiedContact.class, name = "abc"),
  @Type(value = XyzVerifiedContact.class, name = "xyz")
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class VerifiedContact {
  @NonNull
  private String provider;
  @NonNull
  private String contactId;
}