# DonutBytes
A mini domain name registration (DNR) service.

---
## API Endpoints
| Method | Route          | Req. Body           | Res. Body      | Headers       |
|--------|----------------|---------------------|----------------|---------------|
| PUT    | /domain        | DomainCreateRequest | DomainResponse | Authorization |
| POST   | /domain        | DomainUpdateRequest | DomainResponse | Authorization |
| DELETE | /domain/{name} |                     |                | Authorization |
| GET    | /domain/{name} |                     | DomainResponse |               |

---
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

---
## Domain Registration
Newly registered domains must meet the following criteria.
- A minimum of 10 characters long 
    - ex. donutbytes.domains

---
## Technology Used
| Type          | Name       |
|---------------|------------|
| Language      | Java 8     |
| Web Framework | Dropwizard |