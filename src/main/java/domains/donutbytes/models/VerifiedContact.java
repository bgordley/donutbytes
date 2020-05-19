package domains.donutbytes.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.Data;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.EXISTING_PROPERTY, 
  property = "provider")
@JsonSubTypes({ 
  @Type(value = AbcVerifiedContact.class, name = "abc"),
  @Type(value = XyzVerifiedContact.class, name = "xyz")
})
@Data
public abstract class VerifiedContact {
    private String provider;
    private String contactId;
}