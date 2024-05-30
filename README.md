# Desafio técnico da Mobiauto - Sistema de Revendas de Veículos

Desafio proposto para a vaga de desenvolvedor backend na empresa Mobiauto. Basicamente se trata de uma API com Java e Spring Boot para o gerenciamento de revendas de veículos, com todas as operações de CRUD e regras de negócio devidas.



## Requisitos da Aplicacao

- **Gestão de Revendas:** Cada Revenda deve possuir um código identificador único. O CNPJ da Revenda deve ser válido e único. A Revenda deve ter um nome social.

- **Autenticação e autorização:** Os usuários devem realizar login com base nas melhores práticas de segurança. A base de usuários deve incluir código identificador, nome, e-mail (único) e senha. Os usuários podem ter perfis associados às lojas, com cargos como Proprietário, Gerente ou Assistente. Apenas administradores podem cadastrar novos usuários, salvos proprietários e gerentes que podem cadastrar usuários em suas lojas.

- **Permissões de Usuários:** A edição manutenção de perfis só pode ser realizada por administradores ou Proprietários da loja. Administradores têm permissão para executar todas as ações em todas as Revendas. Usuários só podem acessar lojas que estão vinculados com seu devido cargo.

- **Gestão de Oportunidades:** Cada loja pode ter uma lista de oportunidades para atendimento/negociação. Cada oportunidade deve possuir um código identificador único. Cada oportunidade possui status que pode ser novo, em atendimento e concluído. O status inicial é novo e quando concluída, deve-se informar um motivo de conclusão. Dados do cliente, como nome, e-mail e telefone, devem ser registrados para cada oportunidade. Dados do veículo de interesse, como marca, modelo, versão e ano modelo, devem ser registrados para cada oportunidade.

- **Atendimento e Edição de Oportunidades:** O atendimento de uma oportunidade é realizado por um usuário da revenda. O sistema deve ter a inteligência de distribuir as oportunidades sem responsável para os assistentes da loja em forma de fila. Onde o próximo a receber seja o que possui a menor quantidade de oportunidades em andamento e maior tempo sem receber uma oportunidade Proprietários e gerentes possuem permissão de transferir uma oportunidade para outro assistente. Apenas o usuário associado à oportunidade pode editá-la, exceto para cargos de gerentes e proprietários que têm permissão para editar todas as oportunidades de sua loja. Deve ser registrada a data de atribuição da oportunidade pelo seu responsável e a data de conclusão.
