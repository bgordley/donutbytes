package domains.donutbytes.errors;

public class DomainProviderException extends Exception {
    public DomainProviderException(String message) {
        super(message);
    }

    public static class DomainPreviouslyRegisteredException extends DomainProviderException {
        public DomainPreviouslyRegisteredException(String domainName) {
            super(String.format("Domain with name '%s' has already been registered.", domainName));
        }
    }
    
    public static class DomainNotFoundException extends DomainProviderException {
        public DomainNotFoundException(String domainName) {
            super(String.format("Unable to locate domain with name '%s'.", domainName));
        }
    }
}
