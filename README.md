# About

### ENG

API that creates and stores the most specific data from the home page of the [Nubank](https://nubank.com.br) App in a database on [Railway](https://railway.app) and returns it when requested

### PT-BR

API que cria e armazena os dados mais pontuais da pagina inicial do App da [Nubank](https://nubank.com.br) em uma database no [Railway](https://railway.app) e os retorna quando for solicitado

## Pagina Inicial - App Nubank

![Pagina Inicial Nubank](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwaAQ68I2VorcERiHpQAQz_hAgHX7ZtxQESA&s)

## Diagrama de Classes

``` mermaid
classDiagram
    class User {
        -String firstName
        -Number balance
        -Number anotherBankBalance
	-Feature[] features
	-Sponsor[] sponsors
	-CreditCard creditcard
    }
    
    class Feature {
        -string icon
        -string description
    }

    class Sponsor {
        -String icon
        -String description
    }

    class CreditCard {
        -Number balance
        -Number limit
    }

    User "1" *-- "N" Feature
    User "1" *-- "N" Sponsor
    User "1" *-- "1" CreditCard
```

>[!TIP] 
>
>**ENG**
>
>To use the API acess: api-rest-spring-production-6322.up.railway.app/swagger-ui.html
>
>**PT-BR**
>
>Para utilizar a API acesse: api-rest-spring-production-6322.up.railway.app/swagger-ui.html
