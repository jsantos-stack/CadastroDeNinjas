-- V2: Migrations para adicionar a coluna do RANK no banco e Que não dá para mudar é imutável

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);