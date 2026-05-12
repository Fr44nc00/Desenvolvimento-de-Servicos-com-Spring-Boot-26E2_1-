# Desenvolvimento-de-Servicos-com-Spring-Boot-26E2_1-

1 - Escolha da Ferramenta de Construção

Escolhi o Maven pois é mais fácil de utilizar, já estava acostumado com os procedimentos e ele traz mais simplicidade e clareza que o Gradle.

2 - Iniciação do Projeto

<img src="./Capturas de tela/Item 2(1).png"/>
<img src="./Capturas de tela/Item 2(2).png"/>

Spring Initializr Web é melhor para iniciantes ou quando prefere uma abordagem mais visual e fácil de entender. Já o Spring Boot CLI seria melhor em ambientes de automação, scripts ou quando se deseja rapidez sem abrir navegador. Nesse caso, apenas fiz com o CLI para demonstrar como seria, porém o projeto foi desenvolvido com o Spring Initializr, principalmente pois foi a forma com a qual o professor ensinou os procedimentos em aula.

3 - Gerenciamento de Dependências

Usar o Maven garante um controle centralizado no pom.xml, fixa versões estáveis para evitar conflitos, utiliza BOM (Bill of Materials) do Spring Boot para manter compatibilidade, evita dependências redundantes e torna o ciclo de vida mais previsível, builds se tornam reprodutíveis e há menos problemas de compatibilidade.

4 - Utilização de Autoconfiguração

Com o Spring Boot, não é necessário configurar manualmente DispatcherServlet, Jackson, etc. Apenas anotando a classe principal com @SpringBootApplication, o framework já configura o servidor embutido (Tomcat), JSON converter e mapeamento de rotas. Isso elimina código repetitivo e arquivos XML.

5 - Configuração da IDE

<img src="./Capturas de tela/Item 5(1).png"/>
<img src="./Capturas de tela/Item 5(2).png"/>
<img src="./Capturas de tela/Item 5(3).png"/>

6 - Desenvolvimento de Serviços REST

Usei o controller para os endpoints, de forma que o código ficasse o mais claro e limpo possível. Também usei rotas claras como /math/add e /math/subtract para as operações. Criei um arquivo separado do Main para que o Controller ficasse correto e limpo.

a
