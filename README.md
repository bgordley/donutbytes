# DonutBytes
A mini domain name registration (DNR) service.

## Getting Started
1. Run `mvn clean install` to build the service
    - Tests will be run automatically as part of this step
1. Start the service with `java -jar target/service-0.0.1-SNAPSHOT.jar server config.yml`
1. The service should now be reachable via `http://localhost:8080`

## API Endpoints
| Method | Route          | Req. Body             | Res. Body      | Headers       |
|--------|----------------|-----------------------|----------------|---------------|
| PUT    | /domain        | RegisterDomainRequest | DomainResponse | Authorization |
| POST   | /domain        | RenewDomainRequest    | DomainResponse | Authorization |
| DELETE | /domain/{name} |                       |                | Authorization |
| GET    | /domain/{name} |                       | DomainResponse |               |


## Authorization
JWT Header Structure
```
{
  "alg": "HS256",
  "typ": "JWT"
}
```

JWT Payload Structure
```
{
  "CustomerId": "ABC123"
}
```

Below is an example authorization header including a complete JWT token.
```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJDdXN0b21lcklkIjoiQUJDMTIzIn0.SOmWEVz1hu6XoRLgxepZ_IQpFwMiZSMzVKJcMdRdbkc
```


## Domain Registration
Newly registered domains must meet the following criteria.
- A minimum of 10 characters long 
    - ex. donutbytes.domains


## Technology Used
| Type          | Name       |
|---------------|------------|
| Language      | Java 8     |
| Web Framework | Dropwizard |