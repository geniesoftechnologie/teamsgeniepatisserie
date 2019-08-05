-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 05 août 2019 à 17:23
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `patisserie`
--

-- --------------------------------------------------------

--
-- Structure de la table `approvisionnement`
--

CREATE TABLE `approvisionnement` (
  `idap` int(11) NOT NULL,
  `idp` int(11) DEFAULT NULL,
  `categorie` varchar(25) NOT NULL,
  `designation` varchar(25) DEFAULT NULL,
  `pu` int(11) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `Dateap` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `approvisionnement`
--

INSERT INTO `approvisionnement` (`idap`, `idp`, `categorie`, `designation`, `pu`, `quantite`, `Dateap`) VALUES
(1, 1, 'Boisson', 'Coca-Cola', 300, 50, '2019-06-03'),
(2, 1, 'Boisson', 'Coca-Cola', 300, 20, '2019-06-04'),
(3, 1, 'Boisson', 'Coca-Cola', 300, 5, '2019-06-04'),
(4, 1, 'Boisson', 'Coca-Cola', 300, 5, '2019-06-04'),
(5, 1, 'Boisson', 'Coca-Cola', 300, 20, '2019-06-04'),
(6, 1, 'Boisson', 'Coca-Cola', 300, 5, '2019-06-04'),
(7, 2, 'Boisson', 'Fanta', 200, 21, '2019-06-04'),
(8, 3, 'Gateau', 'Forêt-Blanc', 1500, 12, '2019-06-04'),
(9, 4, 'Pain', 'Croissant', 300, 25, '2019-06-05'),
(10, 5, 'Boisson', 'pizza', 5000, 35, '2019-06-05'),
(11, 3, 'Gateau', 'Forêt-Blanc', 1500, 50, '2019-06-05'),
(12, 1, 'Boisson', 'Coca-Cola', 300, 9, '2019-06-09'),
(13, 6, 'Boisson', 'carotte', 250, 2, '2019-06-09'),
(14, 6, 'Boisson', 'carotte', 250, 20, '2019-06-10'),
(15, 6, 'Boisson', 'carotte', 250, 10, '2019-06-12'),
(16, 6, 'Boisson', 'carotte', 250, 25, '2019-06-12'),
(17, 7, 'Gateau', 'to', 250, 10, '2019-06-05'),
(18, 7, 'Gateau', 'to', 250, 8, '2019-06-05'),
(19, 1, 'Boisson', 'Coca-Cola', 300, 50, '2019-07-17'),
(20, 5, 'Pain', 'pizza', 5000, 20, '2019-07-17');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `numc` int(11) NOT NULL,
  `montant` int(11) DEFAULT NULL,
  `datef` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`numc`, `montant`, `datef`) VALUES
(1, 8400, '2019-06-04'),
(2, 300, '2019-06-04'),
(3, 300, '2019-06-04'),
(4, 3000, '2019-06-04'),
(5, 300, '2019-06-05'),
(6, 600, '2019-06-05'),
(7, 111500, '2019-06-05'),
(8, 3000, '2019-06-08'),
(9, 600, '2019-06-08'),
(10, 5700, '2019-06-09'),
(11, 7500, '2019-06-09'),
(12, 2400, '2019-06-09'),
(13, 10000, '2019-06-09'),
(14, 500, '2019-06-09'),
(15, 5600, '2019-06-10'),
(16, 8250, '2019-07-04'),
(17, 1500, '2019-07-04');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `idf` int(11) NOT NULL,
  `nom` varchar(80) DEFAULT NULL,
  `adresse` varchar(80) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`idf`, `nom`, `adresse`, `telephone`) VALUES
(1, 'Diarra', 'bamako(mali)', '88-88-88-88');

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `ido` bigint(20) NOT NULL,
  `id_vendeur` int(11) DEFAULT NULL,
  `dateo` datetime DEFAULT CURRENT_TIMESTAMP,
  `total_paie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`ido`, `id_vendeur`, `dateo`, `total_paie`) VALUES
(1, 1, '2019-06-04 00:11:36', 3000),
(2, 1, '2019-06-04 00:12:20', 4500),
(3, 1, '2019-06-04 19:10:35', 300),
(4, 1, '2019-06-04 19:10:52', 600),
(5, 1, '2019-06-04 19:11:42', 300),
(6, 1, '2019-06-04 19:11:59', 300),
(7, 1, '2019-06-04 19:26:01', 3000),
(8, 0, '2019-06-05 11:04:47', 300),
(9, 0, '2019-06-05 11:36:53', 600),
(10, 1, '2019-06-05 11:38:47', 1500),
(11, 1, '2019-06-05 18:26:07', 1500),
(12, 1, '2019-06-05 18:27:36', 10000),
(13, 1, '2019-06-05 18:27:50', 100000),
(14, 1, '2019-06-08 20:59:36', 3000),
(15, 1, '2019-06-08 23:36:23', 600),
(16, 1, '2019-06-08 23:36:57', 600),
(17, 1, '2019-06-09 15:19:23', 4500),
(18, 1, '2019-06-09 15:19:29', 600),
(19, 1, '2019-06-09 15:19:55', 7500),
(20, 1, '2019-06-09 15:20:08', 2400),
(21, 1, '2019-06-09 15:21:04', 10000),
(22, 1, '2019-06-09 15:26:32', 500),
(23, 1, '2019-06-10 20:08:02', 600),
(24, 1, '2019-06-10 20:08:28', 5000),
(25, 1, '2019-06-10 20:09:48', 5000),
(26, 1, '2019-06-12 23:25:02', 1250),
(27, 1, '2019-07-04 12:24:30', 2000),
(28, 1, '2019-07-04 12:25:02', 1500);

-- --------------------------------------------------------

--
-- Structure de la table `operationdetail`
--

CREATE TABLE `operationdetail` (
  `idod` bigint(20) NOT NULL,
  `id_operation` bigint(20) DEFAULT NULL,
  `categorie` varchar(25) DEFAULT NULL,
  `designation` varchar(25) DEFAULT NULL,
  `pu` int(11) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `dated` date DEFAULT NULL,
  `numf` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `operationdetail`
--

INSERT INTO `operationdetail` (`idod`, `id_operation`, `categorie`, `designation`, `pu`, `quantite`, `dated`, `numf`) VALUES
(1, 1, 'Boisson', 'Coca-Cola', 300, 10, '2019-06-04', 1),
(2, 2, 'Boisson', 'Coca-Cola', 300, 15, '2019-06-04', 1),
(3, 3, 'Boisson', 'Coca-Cola', 300, 1, '2019-06-04', 1),
(4, 4, 'Boisson', 'Coca-Cola', 300, 2, '2019-06-04', 1),
(5, 5, 'Boisson', 'Coca-Cola', 300, 1, '2019-06-04', 2),
(6, 6, 'Boisson', 'Coca-Cola', 300, 1, '2019-06-04', 3),
(7, 7, 'Boisson', 'Coca-Cola', 300, 10, '2019-06-04', 4),
(8, 8, 'Pain', 'Croissant', 300, 1, '2019-06-05', 5),
(9, 9, 'Pain', 'Croissant', 300, 2, '2019-06-05', 6),
(10, 11, 'Boisson', 'Coca-Cola', 300, 5, '2019-06-05', 7),
(11, 12, 'Boisson', 'pizza', 5000, 2, '2019-06-05', 7),
(12, 13, 'Boisson', 'pizza', 5000, 20, '2019-06-05', 7),
(13, 14, 'Gateau', 'Forêt-Blanc', 1500, 2, '2019-06-08', 8),
(14, 15, 'Boisson', 'Coca-Cola', 300, 2, '2019-06-08', 9),
(15, 16, 'Boisson', 'Coca-Cola', 300, 2, '2019-06-08', 10),
(16, 17, 'Gateau', 'Forêt-Blanc', 1500, 3, '2019-06-09', 10),
(17, 18, 'Boisson', 'Coca-Cola', 300, 2, '2019-06-09', 10),
(18, 19, 'Gateau', 'Forêt-Blanc', 1500, 5, '2019-06-09', 11),
(19, 20, 'Boisson', 'Coca-Cola', 300, 8, '2019-06-09', 12),
(20, 21, 'Pain', 'pizza', 5000, 2, '2019-06-09', 13),
(21, 22, 'Boisson', 'carotte', 250, 2, '2019-06-09', 14),
(22, 23, 'Boisson', 'Coca-Cola', 300, 2, '2019-06-10', 15),
(23, 24, 'Pain', 'pizza', 5000, 1, '2019-06-10', 15),
(24, 25, 'Boisson', 'carotte', 250, 20, '2019-06-10', 16),
(25, 26, 'Boisson', 'carotte', 250, 5, '2019-06-12', 16),
(26, 27, 'Boisson', 'carotte', 250, 8, '2019-07-04', 16),
(27, 28, 'Gateau', 'Forêt-Blanc', 1500, 1, '2019-07-04', 17);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `idp` int(11) NOT NULL,
  `categorie` varchar(25) NOT NULL,
  `designation` varchar(25) DEFAULT NULL,
  `pu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idp`, `categorie`, `designation`, `pu`) VALUES
(1, 'Boisson', 'Coca-Cola', 300),
(3, 'Gateau', 'Forêt-Blanc', 1500),
(5, 'Pain', 'pizza', 5000),
(6, 'Boisson', 'carotte', 250),
(7, 'Gateau', 'to', 250);

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

CREATE TABLE `stock` (
  `ids` int(11) NOT NULL,
  `idp` int(11) DEFAULT NULL,
  `categorie` varchar(25) NOT NULL,
  `designation` varchar(25) DEFAULT NULL,
  `pu` int(11) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `stock`
--

INSERT INTO `stock` (`ids`, `idp`, `categorie`, `designation`, `pu`, `quantite`) VALUES
(1, 1, 'Boisson', 'Coca-Cola', 300, 78),
(2, 2, 'Boisson', 'Fanta', 200, 21),
(3, 3, 'Gateau', 'Forêt-Blanc', 1500, 51),
(4, 4, 'Pain', 'Croissant', 300, 22),
(5, 5, 'Pain', 'pizza', 5000, 30),
(6, 5, 'Pain', 'pizza', 5000, 30),
(7, 6, 'Boisson', 'carotte', 250, 22),
(8, 7, 'Gateau', 'to', 250, 18);

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

CREATE TABLE `vendeur` (
  `idv` int(11) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `login` varchar(25) DEFAULT NULL,
  `pasword` varchar(25) DEFAULT NULL,
  `profil` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vendeur`
--

INSERT INTO `vendeur` (`idv`, `nom`, `prenom`, `login`, `pasword`, `profil`) VALUES
(1, 'Koné', 'Mohamed', 'admin', '123', 'Administrateur'),
(2, 'Agent', 'Agent', 'agent', '123', 'Agent'),
(3, 'Issa', 'Telly', 'Rkely', '123', 'Administateur'),
(4, 'Agent', 'Agent', 'kk', '123', 'Agent');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `approvisionnement`
--
ALTER TABLE `approvisionnement`
  ADD PRIMARY KEY (`idap`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`numc`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`idf`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`ido`);

--
-- Index pour la table `operationdetail`
--
ALTER TABLE `operationdetail`
  ADD PRIMARY KEY (`idod`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`idp`);

--
-- Index pour la table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`ids`);

--
-- Index pour la table `vendeur`
--
ALTER TABLE `vendeur`
  ADD PRIMARY KEY (`idv`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `approvisionnement`
--
ALTER TABLE `approvisionnement`
  MODIFY `idap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `idf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `ido` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `operationdetail`
--
ALTER TABLE `operationdetail`
  MODIFY `idod` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `idp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `stock`
--
ALTER TABLE `stock`
  MODIFY `ids` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `vendeur`
--
ALTER TABLE `vendeur`
  MODIFY `idv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
