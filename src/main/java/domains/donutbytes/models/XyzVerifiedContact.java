package domains.donutbytes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class XyzVerifiedContact extends VerifiedContact {
    @NonNull
    private String decryptionPublicKey;

    public XyzVerifiedContact(String clientId, String decryptionPublicKey) {
        super("xyz", clientId);
        this.decryptionPublicKey = decryptionPublicKey;
    }
}
