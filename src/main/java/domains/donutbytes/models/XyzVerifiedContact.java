package domains.donutbytes.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class XyzVerifiedContact extends VerifiedContact {
    private String decryptionPublicKey;
}
