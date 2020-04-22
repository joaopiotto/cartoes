INSERT INTO `usuario` (`id`, `nome`, `cpf`, `senha`, `ativo`) VALUES
(NULL, 'Usuario 01', '14848682002', '$2a$10$FHayM6spzm5LGUa//VKYKe9iWLPlSnYpdwGEkvHMlCEZUIsr4EEIG', true);

INSERT INTO `usuario` (`id`, `nome`, `cpf`, `senha`, `ativo`) VALUES
(NULL, 'Usuario 02', '27546823099', '$2a$10$FHayM6spzm5LGUa//VKYKe9iWLPlSnYpdwGEkvHMlCEZUIsr4EEIG', true);

INSERT INTO `regra` (`id`, `nome`, `descricao`, `ativo`) VALUES
(NULL, 'ROLE_ADM_USUARIO', 'Permite acesso aos serviços de usuário', true);

INSERT INTO `regra` (`id`, `nome`, `descricao`, `ativo`) VALUES
(NULL, 'ROLE_EXCLUSAO', 'Permite exclusão de cartões', true);

INSERT INTO `usuario_regra` (`usuario_id`, `regra_id`) VALUES
(1, 1);

INSERT INTO `usuario_regra` (`usuario_id`, `regra_id`) VALUES
(1, 2);
