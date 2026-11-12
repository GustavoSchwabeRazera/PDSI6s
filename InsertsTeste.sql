-- =========================================================
-- DADOS DE TESTE - TrainUp
-- Rodar depois do Banco.txt (tabelas já criadas)
-- Senhas em texto puro, igual ao login do app (mín. 6 caracteres)
-- =========================================================

USE trainup;

-- Limpa dados de teste anteriores (o CASCADE apaga treinos e exercícios)
DELETE FROM treino_exercicio
WHERE treino_id IN (
    SELECT t.id FROM treino t
    JOIN usuario u ON u.id = t.usuario_id
    WHERE u.email LIKE '%@teste.com'
);
DELETE FROM usuario WHERE email LIKE '%@teste.com';


-- =========================================================
-- USUÁRIOS
-- =========================================================

INSERT INTO usuario (nome, email, senha, idade) VALUES
('Ana Souza',      'ana@teste.com',    '123456', 24),
('Bruno Lima',     'bruno@teste.com',  '123456', 31),
('Carla Mendes',   'carla@teste.com',  '123456', 19),
('Diego Ferreira', 'diego@teste.com',  '123456', 45);


-- =========================================================
-- TREINOS
-- =========================================================

INSERT INTO treino (nome, usuario_id) VALUES
('Treino A - Peito e Tríceps', (SELECT id FROM usuario WHERE email = 'ana@teste.com')),
('Treino B - Costas e Bíceps', (SELECT id FROM usuario WHERE email = 'ana@teste.com')),
('Treino C - Pernas',          (SELECT id FROM usuario WHERE email = 'ana@teste.com')),
('Full Body',                  (SELECT id FROM usuario WHERE email = 'bruno@teste.com')),
('Ombros e Abdômen',           (SELECT id FROM usuario WHERE email = 'bruno@teste.com')),
('Iniciante - Adaptação',      (SELECT id FROM usuario WHERE email = 'carla@teste.com'));
-- diego@teste.com fica sem treinos (testar lista vazia)


-- =========================================================
-- EXERCÍCIOS
-- =========================================================

-- Ana - Treino A
SET @t = (SELECT t.id FROM treino t JOIN usuario u ON u.id = t.usuario_id
          WHERE u.email = 'ana@teste.com' AND t.nome = 'Treino A - Peito e Tríceps');
INSERT INTO exercicio (nome, series, repeticoes, treino_id) VALUES
('Supino reto',          4, 10, @t),
('Supino inclinado',     3, 12, @t),
('Crucifixo',            3, 12, @t),
('Tríceps pulley',       4, 12, @t),
('Tríceps testa',        3, 10, @t);

-- Ana - Treino B
SET @t = (SELECT t.id FROM treino t JOIN usuario u ON u.id = t.usuario_id
          WHERE u.email = 'ana@teste.com' AND t.nome = 'Treino B - Costas e Bíceps');
INSERT INTO exercicio (nome, series, repeticoes, treino_id) VALUES
('Puxada frontal',       4, 10, @t),
('Remada curvada',       4, 10, @t),
('Remada unilateral',    3, 12, @t),
('Rosca direta',         3, 12, @t),
('Rosca martelo',        3, 12, @t);

-- Ana - Treino C
SET @t = (SELECT t.id FROM treino t JOIN usuario u ON u.id = t.usuario_id
          WHERE u.email = 'ana@teste.com' AND t.nome = 'Treino C - Pernas');
INSERT INTO exercicio (nome, series, repeticoes, treino_id) VALUES
('Agachamento livre',    4, 8,  @t),
('Leg press 45°',        4, 12, @t),
('Cadeira extensora',    3, 15, @t),
('Mesa flexora',         3, 12, @t),
('Panturrilha em pé',    4, 20, @t);

-- Bruno - Full Body
SET @t = (SELECT t.id FROM treino t JOIN usuario u ON u.id = t.usuario_id
          WHERE u.email = 'bruno@teste.com' AND t.nome = 'Full Body');
INSERT INTO exercicio (nome, series, repeticoes, treino_id) VALUES
('Levantamento terra',   3, 6,  @t),
('Supino reto',          3, 8,  @t),
('Barra fixa',           3, 8,  @t),
('Agachamento livre',    3, 8,  @t);

-- Bruno - Ombros e Abdômen
SET @t = (SELECT t.id FROM treino t JOIN usuario u ON u.id = t.usuario_id
          WHERE u.email = 'bruno@teste.com' AND t.nome = 'Ombros e Abdômen');
INSERT INTO exercicio (nome, series, repeticoes, treino_id) VALUES
('Desenvolvimento',      4, 10, @t),
('Elevação lateral',     3, 15, @t),
('Abdominal supra',      3, 20, @t),
('Prancha (segundos)',   3, 45, @t);

-- Carla - Iniciante (sem exercícios: testar treino vazio / exportar vazio)


-- =========================================================
-- TREINO_EXERCICIO (tabela de ligação)
-- Espelha o treino_id de cada exercício de teste
-- =========================================================

INSERT INTO treino_exercicio (treino_id, exercicio_id)
SELECT e.treino_id, e.id
FROM exercicio e
JOIN treino t  ON t.id = e.treino_id
JOIN usuario u ON u.id = t.usuario_id
WHERE u.email LIKE '%@teste.com';


-- =========================================================
-- CONFERIR
-- =========================================================

SELECT u.nome AS usuario, t.nome AS treino, COUNT(e.id) AS exercicios
FROM usuario u
LEFT JOIN treino t    ON t.usuario_id = u.id
LEFT JOIN exercicio e ON e.treino_id = t.id
WHERE u.email LIKE '%@teste.com'
GROUP BY u.id, t.id
ORDER BY u.id, t.id;
