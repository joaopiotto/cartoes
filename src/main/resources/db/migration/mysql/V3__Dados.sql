insert into `usuario` values 
(default, 'Usuario 01', '14848682002', '$2a$10$FHayM6spzm5LGUa//VKYKe9iWLPlSnYpdwGEkvHMlCEZUIsr4EEIG', true);

insert into `regra` values (default, 'ROLE_ADM_USUARIO', 'Permite acesso aos serviços de usuário', true);
insert into `regra` values (default, 'ROLE_EXCLUSAO', 'Permite exclusão de cartões', true);

insert into `usuario_regra` values (1, 1);
insert into `usuario_regra` values (1, 2);