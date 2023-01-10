alter table `vol-med`.medico add ativo tinyint;
update `vol-med`.medico set ativo = 1;

alter table `vol-med`.paciente add ativo tinyint;
update `vol-med`.paciente set ativo = 1;

ALTER TABLE `vol-med`.medico
    CHANGE COLUMN `ativo` `ativo` tinyint NOT NULL;

ALTER TABLE `vol-med`.paciente
    CHANGE COLUMN `ativo` `ativo` tinyint NOT NULL;
