INSERT INTO plano (nome, valor) VALUES ('Básico', 99.90);
INSERT INTO plano (nome, valor) VALUES ('Premium', 199.90);
INSERT INTO plano (nome, valor) VALUES ('Avançado', 149.90);
INSERT INTO plano (nome, valor) VALUES ('Estudante', 79.90);
INSERT INTO plano (nome, valor) VALUES ('VIP', 299.90);

INSERT INTO instrutor (nome, cref) VALUES ('Carlos Silva', 'CREF1234');
INSERT INTO instrutor (nome, cref) VALUES ('Mariana Souza', 'CREF5678');
INSERT INTO instrutor (nome, cref) VALUES ('João Pereira', 'CREF9012');
INSERT INTO instrutor (nome, cref) VALUES ('Ana Costa', 'CREF3456');
INSERT INTO instrutor (nome, cref) VALUES ('Felipe Santos', 'CREF7890');

INSERT INTO aluno (nome, email, data_nascimento, ativo, plano_id) VALUES ('Mateus Rocha', 'mateus@email.com', '2000-05-10', true, 1);
INSERT INTO aluno (nome, email, data_nascimento, ativo, plano_id) VALUES ('Julia Lima', 'julia@email.com', '1998-03-22', true, 2);
INSERT INTO aluno (nome, email, data_nascimento, ativo, plano_id) VALUES ('Pedro Alves', 'pedro@email.com', '1995-07-15', false, 3);
INSERT INTO aluno (nome, email, data_nascimento, ativo, plano_id) VALUES ('Marcos Dias', 'marcos@email.com', '2002-11-30', true, 4);
INSERT INTO aluno (nome, email, data_nascimento, ativo, plano_id) VALUES ('Carla Nunes', 'carla@email.com', '1999-01-05', true, 5);

INSERT INTO treino (nome, foco_principal, instrutor_id) VALUES ('Hipertrofia', 'Músculos', 1);
INSERT INTO treino (nome, foco_principal, instrutor_id) VALUES ('Resistência', 'Cardio', 2);
INSERT INTO treino (nome, foco_principal, instrutor_id) VALUES ('Emagrecimento', 'Perda de peso', 3);
INSERT INTO treino (nome, foco_principal, instrutor_id) VALUES ('Alongamento', 'Flexibilidade', 4);
INSERT INTO treino (nome, foco_principal, instrutor_id) VALUES ('Funcional', 'Performance', 5);

INSERT INTO aluno_treino (id, data_inicio, concluido, aluno_id, treino_id) VALUES (1, '2024-01-10', false, 1, 1);
INSERT INTO aluno_treino (id, data_inicio, concluido, aluno_id, treino_id) VALUES (2, '2024-02-15', true, 2, 2);
INSERT INTO aluno_treino (id, data_inicio, concluido, aluno_id, treino_id) VALUES (3, '2024-03-20', false, 3, 3);
INSERT INTO aluno_treino (id, data_inicio, concluido, aluno_id, treino_id) VALUES (4, '2024-04-05', true, 4, 4);
INSERT INTO aluno_treino (id, data_inicio, concluido, aluno_id, treino_id) VALUES (5, '2024-05-12', false, 5, 5);
