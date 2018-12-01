-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 26-Out-2018 às 19:52
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `solutionmakers`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `log_acesso`
--

CREATE TABLE `log_acesso` (
  `id` int(9) NOT NULL,
  `usuario_email` varchar(60) NOT NULL,
  `acao_user` varchar(50) NOT NULL,
  `data_hora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `log_acesso`
--

INSERT INTO `log_acesso` (`id`, `usuario_email`, `acao_user`, `data_hora`) VALUES
(1, 'luiz@fapi.edu.br', 'login', '2018-10-26 14:35:23');

-- --------------------------------------------------------

--
-- Estrutura da tabela `topico`
--

CREATE TABLE `topico` (
  `id` int(9) NOT NULL,
  `titulo` varchar(80) NOT NULL,
  `descricao` varchar(1000) NOT NULL,
  `autor_nickname` varchar(16) NOT NULL,
  `data_postagem` datetime NOT NULL,
  `qtd_respostas` int(9) NOT NULL,
  `resolvido` tinyint(1) DEFAULT NULL,
  `pChave1` varchar(16) DEFAULT NULL,
  `pChave2` varchar(16) DEFAULT NULL,
  `pChave3` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `topico`
--

INSERT INTO `topico` (`id`, `titulo`, `descricao`, `autor_nickname`, `data_postagem`, `qtd_respostas`, `resolvido`, `pChave1`, `pChave2`, `pChave3`) VALUES
(1, 'Como programar em Java Servlets?', 'Gostaria de saber como criar um web site utilizando java Servlets para um trabalho da faculdade.', 'LuizMouraBR', '2018-10-09 12:15:14', 0, 0, 'Java', 'Servlets', 'Programação'),
(2, 'Por que as pessoas insistem em utilizar Dot net?', 'Olá, eu uso Php e amo, com ele eu faço tudo, tudo mesmo. E eu gostaria de saber pq as pessoas não utilizam tanto ele?', 'SilvioSantos666', '2018-10-19 13:23:08', 0, 0, 'Php', 'dot net', NULL),
(3, 'Qual o sentido da vida?', 'Ouvi dizer que era 42, mas esse é só um número aleatório que os roteiristas de um filme escolheram :/', 'Bia_Kawaii', '2018-10-19 06:34:24', 0, 0, 'vida', 'me', 'ajuda'),
(4, 'Por que patos fazem quack?', 'oi tenho uma duvida em relasão aos patos', 'Jub1scr3uz0', '2018-10-19 13:19:13', 0, 0, 'patos', NULL, NULL),
(5, 'Por que as pessoas compram iOS?', 'ANDROID SUPERIOR, RUINDOWS, VIVA O LINUX <3', 'MASTER_C0D3R', '2018-10-14 13:26:20', 0, 0, 'LINUX', 'SEMPRE', 'SUPERIOR!!!\n'),
(20, 'Como deixar de gostar do Php?', 'php >>>>> mundo', 'LuizMouraBR', '2018-10-02 17:28:10', 0, 0, 'Php', 'Programação', NULL),
(21, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ-ABCDEFGHIJKLMNOPQRSTUVWXYZ-ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abc', 'LuizMouraBR', '2018-06-06 00:00:00', 0, 0, 'error', 'error', 'error');

-- --------------------------------------------------------

--
-- Estrutura da tabela `topico_comentario`
--

CREATE TABLE `topico_comentario` (
  `id` int(9) NOT NULL,
  `topico_id` int(9) DEFAULT NULL,
  `usuario_id` int(9) NOT NULL,
  `conteudo` varchar(255) NOT NULL,
  `data_postagem` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `topico_comentario`
--

INSERT INTO `topico_comentario` (`id`, `topico_id`, `usuario_id`, `conteudo`, `data_postagem`) VALUES
(1, 2, 1, 'Oi mundo :)', '2018-10-22 13:13:21'),
(2, 1, 2, 'Comentário 100% automático (quem me dera :/)', '2018-10-22 14:46:54'),
(3, 2, 3, 'YOLOOOOOOOOOO', '2018-10-22 14:49:23'),
(4, 2, 3, 'YOLOOOOOOOOOO', '2018-10-22 14:49:23'),
(5, 2, 3, 'ASDUAHSDUASHDAUSD', '2018-10-22 14:59:23'),
(6, 2, 3, 'oi', '2018-10-22 13:19:23'),
(19, 2, 3, 'ASDUAHSDUASHDAUSD', '2018-10-22 14:59:23');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(9) NOT NULL,
  `nickname` varchar(16) NOT NULL,
  `email` varchar(70) NOT NULL,
  `senha` varchar(16) NOT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `nivelAcesso` int(9) NOT NULL,
  `bloqueado` tinyint(1) NOT NULL,
  `dataCriacao` date NOT NULL,
  `ultimoAcesso` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nickname`, `email`, `senha`, `bio`, `nivelAcesso`, `bloqueado`, `dataCriacao`, `ultimoAcesso`) VALUES
(1, 'admin', 'admin@fapi.edu.br', '99999', NULL, 1, 0, '2018-10-19', '2018-10-10 00:00:00'),
(2, 'luizmourabr', 'luiz@fapi.edu.br', 'Amy', 'Um maluco do pedaço.', 1, 0, '2018-10-19', '2018-10-22 12:23:14'),
(3, 'kvolanski', 'kevin@fapi.edu.br', '12345', 'O cara da TI', 1, 0, '2018-10-19', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `log_acesso`
--
ALTER TABLE `log_acesso`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `topico`
--
ALTER TABLE `topico`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `topico_comentario`
--
ALTER TABLE `topico_comentario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `autor_id` (`usuario_id`),
  ADD KEY `topico_id` (`topico_id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `log_acesso`
--
ALTER TABLE `log_acesso`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `topico`
--
ALTER TABLE `topico`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `topico_comentario`
--
ALTER TABLE `topico_comentario`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `topico_comentario`
--
ALTER TABLE `topico_comentario`
  ADD CONSTRAINT `topico_comentario_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `topico_comentario_ibfk_2` FOREIGN KEY (`topico_id`) REFERENCES `topico` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
