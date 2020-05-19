package domains.donutbytes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class AbcVerifiedContact extends VerifiedContact {

    public AbcVerifiedContact(String contactId) {
        super("abc", contactId);
    }
}
