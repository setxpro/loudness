# SWAGGER DOCUMENTATION

#### Define o Caminho para a Documentação do OpenAPI no formato JSON.
````properties
    springdoc.api-docs.path=/v3/api-docs
````
---

#### Define o Caminho para a Documentação do Swagger-ui no formato HTML.

````properties
    springdoc.swagger-ui.path=/swagger-ui.html
````
---

#### Define a ordem em que os Recursos serão exibidos no Swagger-ui.
    
````properties
    springdoc.swagger-ui.operations-sorter=method
````
---
#### Desabilita a URL padrão do Swagger-ui (Exemplo no site do Swagger).

````properties
    springdoc.swagger-ui.disable-swagger-default-url=true
````
---


#### Define o nome da Package da Camada Controladora (Controller).

````properties
    springdoc.packages-to-scan=br.com.loudness.ecommerce.controllers
````

---

#### Define o Swagger-ui como a página inicial da aplicação
````properties
    springdoc.swagger-ui.use-root-path=true 
````
---

<h1>AFTER THE APPLICATION HAS BEEN RUN</h1>

GET FORMAT JSON
--
<a href="http://localhost:8080/v3/api-docs">ACCESS FORMAT JSON</a>

GO TO SWAGGER
--
<a href="https://editor.swagger.io/">ACCESS SWAGGER EDITION</a>




