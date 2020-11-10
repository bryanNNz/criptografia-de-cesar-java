## Criptografia de César 

Trata-se de uma implementação da [Criptografia de César](https://pt.wikipedia.org/wiki/Cifra_de_C%C3%A9sar) em forma de serviços.
Decidi construir este projeto para relembrar como utilizar (de maneira simples) o Spring Boot.

## Tecnologias

[Spring](https://github.com/spring-projects/spring-boot) - Para construção dos serviços
[Lombok](https://github.com/rzwitserloot/lombok) - Muito útil para redução de código

## Recursos

| Verbo | Recurso |
| ----- | ------- |
| POST | /rest/criptografar |
| POST | /rest/descriptografar |

## Parâmetros

* **Texto**: Texto a ser criptografado/descriptografado
* **Chave**: Valor fixo para troca de letra

## Modelo

>{
>	"texto": String
>	"chave": Inteiro
>}