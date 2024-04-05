## Pass-in 
<p align="center">
  <img height="520" width="880" src="https://github.com/Lucianosm28/Imagens/blob/main/Imagens/Assets/Wallpaper%20-%201400x900.png" alt="Imagem da nlw Unite">
</p>

## Sobre o projeto

O pass.in é uma aplicação de gestão de participantes em eventos presenciais desenvolvida no evento de programação Next Level Week Unite da Rocketseat.
 
- A ferramenta permite que o organizador cadastre um evento e abra uma página pública de inscrição.
- Os participantes inscritos podem emitir uma credencial para check-in no dia do evento.
- O sistema fará um scan da credencial do participante para permitir a entrada no evento.

## Requisitos funcionais
- O organizador deve poder cadastrar um novo evento;
- O organizador deve poder visualizar dados de um evento;
- O organizador deve poder visualizar a lista de participantes;
- O participante deve poder se inscrever em um evento;
- O participante deve poder visualizar seu crachá de inscrição;
- O participante deve poder realizar check-in no evento;

## Regras de negócio
- O participante só pode se inscrever em um evento uma única vez;
- O participante só pode se inscrever em eventos com vagas disponíveis;
- O participante só pode realizar check-in em um evento uma única vez;

## Requisitos não-funcionais
O check-in no evento será realizado através de um QRCode;

## Tecnologias utilizadas
- Java
- Spring (Spring Web, Flyway, Dev Tools, Lombok, JPA)
- Maven
- Rest Client(Insomnia)


## Diagrama
<p align="center">
  <img height="720" width="1080" src="https://github.com/Lucianosm28/Imagens/blob/main/Imagens/Assets/erd.svg" alt="Imagem">
</p>

## Banco de dados
Foi utilizado banco de dados relacional(SQL).

# Estrutura do banco (SQL)

```
CREATE TABLE "events" (
    "id" TEXT NOT NULL PRIMARY KEY,
    "title" TEXT NOT NULL,
    "details" TEXT,
    "slug" TEXT NOT NULL,
    "maximum_attendees" INTEGER
);
CREATE TABLE "attendees" (
    "id" TEXT NOT NULL PRIMARY KEY,
    "name" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "event_id" TEXT NOT NULL,
    "created_at" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT "attendees_event_id_fkey" FOREIGN KEY ("event_id") REFERENCES "events" ("id") ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE TABLE "check_ins" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "created_at" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "attendeeId" TEXT NOT NULL,
    CONSTRAINT "check_ins_attendeeId_fkey" FOREIGN KEY ("attendeeId") REFERENCES "attendees" ("id") ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE UNIQUE INDEX "events_slug_key" ON "events"("slug");
CREATE UNIQUE INDEX "attendees_event_id_email_key" ON "attendees"("event_id", "email");
CREATE UNIQUE INDEX "check_ins_attendeeId_key" ON "check_ins"("attendeeId");
```
## Especificações da API
```
https://nlw-unite-nodejs.onrender.com/docs/static/index.html#
```

## Como executar o projeto

- Pré-requisitos: Java 17
- Insomnia, Apidog, ou outra ferramenta para testar as requisições Http.

```bash
# Clonar repositório
git clone https://github.com/Lucianosm28/pass-in-nlw.git

# Entrar na pasta do projeto (Exemplo, coloque o endereço onde você guardou a pasta do projeto "pass-in-nlw" dentro do seu computador)
cd C:\Users\(seu nome de usuário)\Desktop\Meusprojetos\pass-in-nlw...

# Executar o projeto(No terminal do seu editor de código ou IDE, exemplo: VsCode, Intellij...)
mvn spring-boot:run

```

## Autor(a)

Fernanda Kipper

Software Enginner


