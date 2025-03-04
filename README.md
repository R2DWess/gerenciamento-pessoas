<p align="center">
  <img src="img.png" alt="Universidade Católica de Brasília">
</p>

## PROJETO PESSOAL - GERENCIAMENTO DE PESSOAS:

#### Descrição:
Projeto voltado para a criação de uma funcionalidade que cadastre pessoas no banco de dados local

#### Funcionalidades:
1. Cadastro de pessoas;
2. Listagem de pessoas;
3. Atualização de pessoas;
4. Exclusão de pessoas;
5. Busca de pessoas por ID;
6. Busca de pessoas por nome;
7. Busca de pessoas por sobrenome;
8. Busca de pessoas por data de nascimento;
9. Busca de pessoas por CPF;
10. Busca de pessoas por RG;
11. Busca de pessoas por endereço;

#### Tecnologias utilizadas:
- Java 23;
- Spring Boot;
- Gradle;
- JPA;
- MySQL;

#### Curl de exemplo:

1 - Cadastro de pessoa:
```cmd
curl --request POST \
  --url http://localhost:8080/v1/pessoas/cadastrar \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
  "nome": "João Silva",
  "idade": "30",
  "contatoModel": {
    "telefone": "123456789",
    "email": "joao.silva@example.com"
  },
  "enderecoModel": {
    "cidade": "Carapicuíba",
    "estado": "São Paulo",
    "pais": "Brasil"
  }
}'
```

2 - Listagem de pessoas:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/pessoas/listar \
  --header 'User-Agent: insomnia/10.3.1'
```

3 - Atualização de pessoa:
```cmd
curl --request PUT \
  --url http://localhost:8080/v1/pessoas/atualizar/1 \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.1' \
  --data '{
  "nome": "João Silva",
  "idade": "30",
  "contatoModel": {
    "telefone": "123456789",
    "email": "
    },
    "enderecoModel": {
        "cidade": "Carapicuíba",
        "estado": "São Paulo",
        "pais": "Brasil"
        }
}'
```

4 - Exclusão de pessoa:
```cmd
curl --request DELETE \
  --url http://localhost:8080/v1/pessoas/excluir/1 \
  --header 'User-Agent: insomnia/10.3.1'
```
    
5 - Busca de pessoa por ID:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/pessoas/buscar/1 \
  --header 'User-Agent: insomnia/10.3.1'
```

6 - Busca de pessoa por nome:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/pessoas/buscar/nome/João \
  --header 'User-Agent: insomnia/10.3.1'
```

7 - Busca de pessoa por sobrenome:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/pessoas/buscar/sobrenome/Silva \
  --header 'User-Agent: insomnia/10.3.1'
```

8 - Busca de pessoa por data de nascimento:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/pessoas/buscar/dataNascimento/1992-01-01 \
  --header 'User-Agent: insomnia/10.3.1'
```

9 - Busca de pessoa por CPF:
```cmd
curl --request GET \
  --url http://localhost:8080/v1/pessoas/buscar/cpf/12345678900 \
  --header 'User-Agent: insomnia/10.3.1'
```

10 - Busca de pessoa por RG:
```cmd

curl --request GET \
  --url http://localhost:8080/v1/pessoas/buscar/rg/123456789 \
  --header 'User-Agent: insomnia/10.3.1'
```

11 - Busca de pessoa por endereço:
```cmd

curl --request GET \
  --url http://localhost:8080/v1/pessoas/buscar/endereco/Carapicuíba \
  --header 'User-Agent: insomnia/10.3.1'
```
## 🛺 Autor

<table>
  <tr>
    <td align="center">
      <a href="https://www.linkedin.com/in/wesley-lima-244405251/" title="Wesley Lima">
        <img src="https://media.licdn.com/dms/image/v2/D4D03AQEVAsL2UL6A0w/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1721323972268?e=1746662400&v=beta&t=4_2RDPgz5FqJ2G-yRQk3y0vWMVRpSeAPKMAO7IOFXeE" width="100px;" alt="Foto do Wesley Lima"/><br>
        <sub>
          <b>Wesley Lima</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
