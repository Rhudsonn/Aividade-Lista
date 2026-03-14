Lógica do Código
Fluxo Geral
O projeto é uma aplicação de console (CLI) feita com Spring Boot que gerencia uma lista de tarefas em memória. O fluxo segue o padrão Controller → Service → Utils.
________________________________________
Lógica por Classe
TarefaController atua como ponto de entrada da aplicação via CommandLineRunner, o que permite executar código no terminal assim que o Spring sobe. Ele exibe o menu em loop com do/while, lê a opção do usuário e delega cada ação ao TarefaService. O loop só encerra quando o usuário digita 0.
TarefaService centraliza toda a regra de negócio. Mantém um ArrayList<TarefaEntradaDto> em memória como "banco de dados" e um contador inteiro para gerar códigos sequenciais. Cada método representa uma operação CRUD: cadastrar (sempre inicia com status PENDENTE), listar, concluir (busca por código e muda o status para CONCLUIDO) e remover (busca por código e remove da lista).
TarefaEntradaDto carrega os dados de uma tarefa: código, título, descrição e status. Serve tanto para receber entrada do usuário quanto para armazenar os objetos na lista do service.
StatusEnum define os dois estados possíveis de uma tarefa (PENDENTE e CONCLUIDO), garantindo que apenas valores válidos sejam atribuídos.
ConsoleUtils é uma classe utilitária estática que evita repetição de código, concentrando a exibição do menu, leitura de Strings do terminal, impressão de tarefas e criação do DTO a partir da entrada do usuário.
________________________________________
Por que não há Entity nem DTO de Saída?
Sem Entity porque a aplicação não possui banco de dados. Uma Entity existe para mapear um objeto a uma tabela (JPA/Hibernate). Como os dados vivem apenas no ArrayList durante a execução, introduzir uma Entity seria uma abstração sem propósito real aqui.
Sem DTO de saída porque a aplicação não tem API REST retornando JSON. Um DTO de saída (como TarefaRespostaDto) faz sentido quando você precisa controlar exatamente quais campos expor em uma resposta HTTP, separando o que entra do que sai. No console, a "saída" é diretamente o System.out.println dentro do ConsoleUtils.imprimirTarefa(), tornando esse tipo de classe desnecessária.
Em resumo, a arquitetura foi simplificada ao mínimo necessário para o contexto: sem persistência, sem API, sem necessidade de camadas extras.

Assinado: Rhudsonn Oliveira.
