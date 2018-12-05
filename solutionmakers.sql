-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 05-Dez-2018 às 21:37
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
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(8) NOT NULL,
  `nome_completo` varchar(60) NOT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `cpf` varchar(25) NOT NULL,
  `pis` varchar(20) DEFAULT NULL,
  `empresa_id` int(8) NOT NULL,
  `usuario_id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome_completo`, `rg`, `cpf`, `pis`, `empresa_id`, `usuario_id`) VALUES
(1, 'Luiz Philip de Moraes Assunção', '12.345.678-9', '987.654.321-00', '394-34297.34', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `empresa`
--

CREATE TABLE `empresa` (
  `id` int(8) NOT NULL,
  `nome_fantasia` varchar(50) NOT NULL,
  `razao_social` varchar(50) NOT NULL,
  `cnpj` varchar(30) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `empresa`
--

INSERT INTO `empresa` (`id`, `nome_fantasia`, `razao_social`, `cnpj`, `endereco`) VALUES
(1, 'DanLimpão Serviços Gerais', 'Dan Serviços Gerais EIRELLI', '0006541.258/21', 'www.danlimpao.com.br');

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
(1, 'luiz@fapi.edu.br', 'login', '2018-10-26 14:35:23'),
(2, 'luiz@fapi.edu.br', 'Troca de Senha', '2018-11-13 17:30:57'),
(3, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:33:23'),
(4, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:33:54'),
(5, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:34:01'),
(6, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:34:08'),
(7, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:34:28'),
(8, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:34:41'),
(9, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:34:50'),
(10, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:35:54'),
(11, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:37:54'),
(12, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:38:30'),
(13, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:38:37'),
(14, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:40:05'),
(15, 'luiz@fapi.edu.br', 'Login', '2018-11-13 17:40:32'),
(16, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:20:55'),
(17, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:21:09'),
(18, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:21:12'),
(19, 'luiz@fapi.edu.br', 'Tentativa errada de acesso', '2018-11-18 14:21:18'),
(20, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:21:20'),
(21, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:23:39'),
(22, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:25:17'),
(23, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:25:57'),
(24, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:28:45'),
(25, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:29:22'),
(26, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:29:57'),
(27, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:31:12'),
(28, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:31:51'),
(29, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:32:05'),
(30, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:32:08'),
(31, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:32:16'),
(32, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:32:51'),
(33, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:34:21'),
(34, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:35:18'),
(35, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:36:50'),
(36, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:37:43'),
(37, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:39:53'),
(38, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:42:07'),
(39, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:42:10'),
(40, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:42:11'),
(41, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:45:50'),
(42, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:45:51'),
(43, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:45:51'),
(44, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:45:52'),
(45, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:45:52'),
(46, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:45:53'),
(47, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:46:15'),
(48, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:46:33'),
(49, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:46:37'),
(50, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:48:03'),
(51, 'luiz@fapi.edu.br', 'Tentativa errada de acesso', '2018-11-18 14:48:09'),
(52, 'luiz@fapi.edu.br', 'Login', '2018-11-18 14:48:10'),
(53, 'luiz@fapi.edu.br', 'Login', '2018-12-02 14:07:26'),
(54, 'luiz@fapi.edu.br', 'Login', '2018-12-02 14:08:41'),
(55, 'luiz@fapi.edu.br', 'Login', '2018-12-02 14:40:17'),
(56, 'luiz@fapi.edu.br', 'Login', '2018-12-02 14:50:47'),
(57, 'luiz@fapi.edu.br', 'Login', '2018-12-02 15:01:25'),
(58, 'admin@fapi.edu.br', 'Tentativa errada de acesso', '2018-12-02 15:07:53'),
(59, 'luiz@fapi.edu.br', 'Login', '2018-12-02 15:08:04'),
(60, 'luiz@fapi.edu.br', 'Login', '2018-12-02 15:12:23'),
(61, 'luiz@fapi.edu.br', 'Login', '2018-12-02 15:14:31'),
(62, 'luiz@fapi.edu.br', 'Tentativa errada de acesso', '2018-12-03 20:32:23'),
(63, 'luiz@fapi.edu.br', 'Login', '2018-12-03 20:32:38'),
(64, 'luiz@fapi.edu.br', 'Login', '2018-12-03 21:58:37'),
(65, 'luiz@fapi.edu.br', 'Login', '2018-12-03 22:48:15'),
(66, 'admin@fapi.edu.br', 'Tentativa errada de acesso', '2018-12-03 23:23:49'),
(67, 'admin@fapi.edu.br', 'Tentativa errada de acesso', '2018-12-03 23:24:08'),
(68, 'admin@fapi.edu.br', 'Login', '2018-12-03 23:24:27'),
(69, 'admin@fapi.edu.br', 'Login', '2018-12-04 19:29:28'),
(70, 'admin@fapi.edu.br', 'Tentativa errada de acesso', '2018-12-04 19:31:20'),
(71, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:25:20'),
(72, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:26:48'),
(73, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:28:15'),
(74, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:32:30'),
(75, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:35:06'),
(76, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:38:02'),
(77, 'admin@fapi.edu.br', 'Login', '2018-12-04 22:39:46'),
(78, 'luiz@fapi.edu.br', 'Tentativa errada de acesso', '2018-12-04 22:44:24'),
(79, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:44:36'),
(80, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:48:06'),
(81, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:49:42'),
(82, 'luiz@fapi.edu.br', 'Login', '2018-12-04 22:54:22'),
(83, 'luiz@fapi.edu.br', 'Login', '2018-12-04 23:01:32'),
(84, 'admin@fapi.edu.br', 'Login', '2018-12-04 23:10:30'),
(85, 'admin@fapi.edu.br', 'Login', '2018-12-04 23:13:15'),
(86, 'luiz@fapi.edu.br', 'Login', '2018-12-04 23:35:16'),
(87, 'luiz@fapi.edu.br', 'Login', '2018-12-04 23:53:22'),
(88, 'luiz@fapi.edu.br', 'Login', '2018-12-05 17:23:03'),
(89, 'admin@fapi.edu.br', 'Login', '2018-12-05 17:49:47'),
(90, 'luiz@fapi.edu.br', 'Tentativa errada de acesso', '2018-12-05 17:58:20'),
(91, 'luiz@fapi.edu.br', 'Login', '2018-12-05 17:58:30'),
(92, 'admin@fapi.edu.br', 'Login', '2018-12-05 18:16:00'),
(93, 'luiz@fapi.edu.br', 'Login', '2018-12-05 18:21:17'),
(94, 'luiz@fapi.edu.br', 'Login', '2018-12-05 18:23:02'),
(95, 'luiz@fapi.edu.br', 'Login', '2018-12-05 18:29:32'),
(96, 'luiz@fapi.edu.br', 'Login', '2018-12-05 18:32:22'),
(97, 'luiz@fapi.edu.br', 'Login', '2018-12-05 18:35:01');

-- --------------------------------------------------------

--
-- Estrutura da tabela `log_acoes`
--

CREATE TABLE `log_acoes` (
  `id` int(11) NOT NULL,
  `usuario_email` varchar(60) NOT NULL,
  `acao_user` varchar(50) NOT NULL,
  `data_hora` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `operador`
--

CREATE TABLE `operador` (
  `id` int(8) NOT NULL,
  `tickets_resolvidos` int(8) DEFAULT NULL,
  `usuario_id` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `operador`
--

INSERT INTO `operador` (`id`, `tickets_resolvidos`, `usuario_id`) VALUES
(1, 3, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ticket`
--

CREATE TABLE `ticket` (
  `id` int(9) NOT NULL,
  `titulo` varchar(80) NOT NULL,
  `descricao` varchar(1000) NOT NULL,
  `autor_nickname` varchar(16) NOT NULL,
  `autor_nivelAceso` int(11) DEFAULT NULL,
  `data_postagem` datetime NOT NULL,
  `resolvido` tinyint(1) DEFAULT NULL,
  `pChave1` varchar(16) DEFAULT NULL,
  `pChave2` varchar(16) DEFAULT NULL,
  `pChave3` varchar(16) DEFAULT NULL,
  `qtdRespostas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ticket`
--

INSERT INTO `ticket` (`id`, `titulo`, `descricao`, `autor_nickname`, `autor_nivelAceso`, `data_postagem`, `resolvido`, `pChave1`, `pChave2`, `pChave3`, `qtdRespostas`) VALUES
(1, 'Como programar em Java Servlets?', 'Gostaria de saber como criar um web site utilizando java Servlets para um trabalho da faculdade.', 'LuizMouraBR', 1, '2018-10-09 12:15:14', 0, 'Java', 'Servlets', 'Programação', NULL),
(2, 'Por que as pessoas insistem em utilizar Dot net?', 'Olá, eu uso Php e amo, com ele eu faço tudo, tudo mesmo. E eu gostaria de saber pq as pessoas não utilizam tanto ele?', 'SilvioSantos666', 4, '2018-10-19 13:23:08', 0, 'Php', 'dot net', NULL, NULL),
(3, 'Qual o sentido da vida?', 'Ouvi dizer que era 42, mas esse é só um número aleatório que os roteiristas de um filme escolheram :/', 'Bia_Kawaii', 3, '2018-10-19 06:34:24', 0, 'vida', 'me', 'ajuda', NULL),
(4, 'Por que patos fazem quack?', 'oi tenho uma duvida em relasão aos patos', 'Jub1scr3uz0', 3, '2018-10-19 13:19:13', 0, 'patos', NULL, NULL, NULL),
(5, 'Por que as pessoas compram iOS?', 'ANDROID SUPERIOR, RUINDOWS, VIVA O LINUX <3', 'MASTER_C0D3R', 4, '2018-10-14 13:26:20', 0, 'LINUX', 'SEMPRE', 'SUPERIOR!!!\n', NULL),
(20, 'Como deixar de gostar do Php?', 'php >>>>> mundo', 'LuizMouraBR', 1, '2018-10-02 17:28:10', 0, 'Php', 'Programação', NULL, NULL),
(21, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ-ABCDEFGHIJKLMNOPQRSTUVWXYZ-ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abc', 'LuizMouraBR', 1, '2018-06-06 00:00:00', 0, 'error', 'error', 'error', NULL),
(22, 'Como apagar todos os campos de um vetor', 'Ol, gostaria de saber como fao pra apagar todos os campos de um vetor do meu programa em C# utilizando ICollections', 'luizmourabr', 1, '2018-12-04 21:51:40', 0, 'Index', 'Arrays', 'C#', 0),
(23, 'Como fazer alguma coisa', 'Testando coisas', 'luizmourabr', 1, '2018-12-04 21:54:23', 0, 'Teste', 'de', 'Ticket', 0),
(24, 'a', 'c', 'luizmourabr', 1, '2018-12-04 21:58:03', 0, 'b', 'b', 'b', 0),
(25, 'Como apagar todos os campos de um vetor', 'Ol, gostaria de saber como apagar todos os campos de um array em C# utilizando ICollections', 'luizmourabr', 1, '2018-12-04 22:00:21', 0, 'Array', 'C#', 'ICollections', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ticket_comentario`
--

CREATE TABLE `ticket_comentario` (
  `id` int(9) NOT NULL,
  `topico_id` int(9) DEFAULT NULL,
  `usuario_id` int(9) NOT NULL,
  `usuarioNivelAcesso` int(11) DEFAULT NULL,
  `conteudo` varchar(255) NOT NULL,
  `isEditada` tinyint(1) DEFAULT NULL,
  `data_postagem` datetime DEFAULT NULL,
  `data_edicao` date DEFAULT NULL,
  `editor_id` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ticket_comentario`
--

INSERT INTO `ticket_comentario` (`id`, `topico_id`, `usuario_id`, `usuarioNivelAcesso`, `conteudo`, `isEditada`, `data_postagem`, `data_edicao`, `editor_id`) VALUES
(1, 2, 1, 1, 'Oi mundo :)', NULL, '2018-10-22 13:13:21', NULL, NULL),
(2, 1, 2, 1, 'Comentário 100% automático (quem me dera :/)', NULL, '2018-10-22 14:46:54', NULL, NULL),
(3, 2, 3, 2, 'YOLOOOOOOOOOO', NULL, '2018-10-22 14:49:23', NULL, NULL),
(4, 2, 3, 2, 'YOLOOOOOOOOOO', NULL, '2018-10-22 14:49:23', NULL, NULL),
(5, 2, 3, 2, 'ASDUAHSDUASHDAUSD', NULL, '2018-10-22 14:59:23', NULL, NULL),
(6, 2, 3, 2, 'oi', NULL, '2018-10-22 13:19:23', NULL, NULL),
(19, 2, 3, 2, 'ASDUAHSDUASHDAUSD', NULL, '2018-10-22 14:59:23', NULL, NULL),
(20, 2, 2, 1, 'dot net >>>>> ', NULL, '2018-12-04 20:18:55', NULL, NULL),
(21, 2, 2, 1, 'PATOS', NULL, '2018-12-04 20:21:46', NULL, NULL),
(22, 4, 2, 1, 'vc s esqueceu de fazer a pergunta mermo kk\r\n', NULL, '2018-12-04 20:22:27', NULL, NULL),
(23, 24, 2, 1, 'que?\r\n', NULL, '2018-12-04 22:03:53', NULL, NULL),
(24, 22, 2, 1, 'ICollections.AllAsync = null;', NULL, '2018-12-04 22:05:26', NULL, NULL),
(25, 3, 2, 1, 'na verdade 42 vem do Mochileiro das Galaxias que e um livro', NULL, '2018-12-04 22:14:34', NULL, NULL),
(26, 25, 2, 1, 'Use: <<suaColecao>>.AllAsync.Remove();', NULL, '2018-12-05 17:24:03', NULL, NULL);

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
(1, 'admin', 'admin@fapi.edu.br', '99999', 'O manda chuva do pedaço XD', 1, 0, '2018-10-19', '2018-10-10 00:00:00'),
(2, 'luizmourabr', 'luiz@fapi.edu.br', 'Amy', 'Um maluco do pedaço.', 1, 0, '2018-10-19', '2018-11-13 17:33:14'),
(3, 'kvolanski', 'kevin@fapi.edu.br', '12345', 'O cara da TI', 2, 0, '2018-10-19', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empresa_id` (`empresa_id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indexes for table `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `log_acesso`
--
ALTER TABLE `log_acesso`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `log_acoes`
--
ALTER TABLE `log_acoes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `operador`
--
ALTER TABLE `operador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ticket_comentario`
--
ALTER TABLE `ticket_comentario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `autor_id` (`usuario_id`),
  ADD KEY `topico_id` (`topico_id`),
  ADD KEY `autor_edicao` (`editor_id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `log_acesso`
--
ALTER TABLE `log_acesso`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;
--
-- AUTO_INCREMENT for table `log_acoes`
--
ALTER TABLE `log_acoes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `operador`
--
ALTER TABLE `operador`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `ticket_comentario`
--
ALTER TABLE `ticket_comentario`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`),
  ADD CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Limitadores para a tabela `operador`
--
ALTER TABLE `operador`
  ADD CONSTRAINT `operador_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);

--
-- Limitadores para a tabela `ticket_comentario`
--
ALTER TABLE `ticket_comentario`
  ADD CONSTRAINT `ticket_comentario_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `ticket_comentario_ibfk_2` FOREIGN KEY (`topico_id`) REFERENCES `ticket` (`id`),
  ADD CONSTRAINT `ticket_comentario_ibfk_3` FOREIGN KEY (`editor_id`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
