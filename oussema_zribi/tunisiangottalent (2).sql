-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 11 fév. 2020 à 23:39
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tunisiangottalent`
--

-- --------------------------------------------------------

--
-- Structure de la table `amitie`
--

DROP TABLE IF EXISTS `amitie`;
CREATE TABLE IF NOT EXISTS `amitie` (
  `idUser1` int(11) NOT NULL,
  `idUser2` int(11) NOT NULL,
  `Etat` tinyint(1) NOT NULL,
  `SenderId` int(11) NOT NULL,
  `BlockId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
CREATE TABLE IF NOT EXISTS `annonce` (
  `idAnnonce` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Prix` double NOT NULL,
  `Etat` enum('vendu','disponible') NOT NULL,
  PRIMARY KEY (`idAnnonce`),
  KEY `annonce_ibfk_1` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`idAnnonce`, `idUser`, `Nom`, `Description`, `Prix`, `Etat`) VALUES
(2, 1, 'Guitarre', 'Desctiption', 654, 'vendu');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `idCommentaire` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `idPublication` int(11) NOT NULL,
  `contenue` varchar(255) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`idCommentaire`),
  KEY `idUser` (`idUser`),
  KEY `idPublication` (`idPublication`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commentaireannonce`
--

DROP TABLE IF EXISTS `commentaireannonce`;
CREATE TABLE IF NOT EXISTS `commentaireannonce` (
  `idCommentaire` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `idAnnonce` int(11) NOT NULL,
  `contenue` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`idCommentaire`),
  KEY `idUser` (`idUser`),
  KEY `commentaireannonce_ibfk_2` (`idAnnonce`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commentaireannonce`
--

INSERT INTO `commentaireannonce` (`idCommentaire`, `idUser`, `idAnnonce`, `contenue`, `date`) VALUES
(1, 1, 2, 'oussema bech ybi3 oo Khter wfewlou flous ', '11-02-2020'),
(2, 1, 2, 'oussema bech ybi3 oo Khter wfewlou flous ', '11-02-2020'),
(3, 1, 2, 'oussema bech ybi3 oo Khter wfewlou flous ', '11-02-2020'),
(4, 1, 2, 'oussema bech ybi3 oo Khter wfewlou flous ', '11-02-2020'),
(5, 1, 2, 'oussema bech ybi3 oo Khter wfewlou flous ', '11-02-2020');

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

DROP TABLE IF EXISTS `competition`;
CREATE TABLE IF NOT EXISTS `competition` (
  `idCompetition` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `Titre` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `TypeDeTalent` enum('Dance','Musique','Comedie','BeatBox') NOT NULL,
  `DateDebut` date NOT NULL,
  `DateFin` date NOT NULL,
  `Cout` int(11) NOT NULL,
  PRIMARY KEY (`idCompetition`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `conversation`
--

DROP TABLE IF EXISTS `conversation`;
CREATE TABLE IF NOT EXISTS `conversation` (
  `idConversation` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `DateCreation` date NOT NULL,
  `DernierMisAjour` date NOT NULL,
  `idUser1` int(11) NOT NULL,
  `idUser2` int(11) NOT NULL,
  `User1Status` tinyint(1) NOT NULL,
  `User2Status` tinyint(1) NOT NULL,
  PRIMARY KEY (`idConversation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `idMessage` int(11) NOT NULL AUTO_INCREMENT,
  `idUserSender` int(11) NOT NULL,
  `idUserReciever` int(11) NOT NULL,
  `Message` int(11) NOT NULL,
  `idConversation` int(11) NOT NULL,
  PRIMARY KEY (`idMessage`),
  KEY `idConversation` (`idConversation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participer`
--

DROP TABLE IF EXISTS `participer`;
CREATE TABLE IF NOT EXISTS `participer` (
  `idUser` int(11) NOT NULL,
  `idCompetition` int(11) NOT NULL,
  KEY `idUser` (`idUser`),
  KEY `idCompetition` (`idCompetition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

DROP TABLE IF EXISTS `publication`;
CREATE TABLE IF NOT EXISTS `publication` (
  `idPublication` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Contenue` varchar(255) NOT NULL,
  `Visibilite` enum('MoiUniquement','Public','Exception') NOT NULL,
  PRIMARY KEY (`idPublication`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `publicite`
--

DROP TABLE IF EXISTS `publicite`;
CREATE TABLE IF NOT EXISTS `publicite` (
  `idAnnonce` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `DateDebut` varchar(255) NOT NULL,
  `DateFin` varchar(255) NOT NULL,
  `Etat` enum('true','false') NOT NULL,
  `prix` float NOT NULL,
  KEY `publicite_ibfk_1` (`idAnnonce`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `publicite`
--

INSERT INTO `publicite` (`idAnnonce`, `idUser`, `DateDebut`, `DateFin`, `Etat`, `prix`) VALUES
(2, 1, 'date', 'date1', 'true', 546),
(2, 1, 'date', 'date1', 'true', 546),
(2, 1, 'date', 'date1', 'true', 546);

-- --------------------------------------------------------

--
-- Structure de la table `reaction`
--

DROP TABLE IF EXISTS `reaction`;
CREATE TABLE IF NOT EXISTS `reaction` (
  `idUser` int(11) NOT NULL,
  `idPublication` int(11) NOT NULL,
  `TypeReaction` enum('Happy','Like','Dislike','Sick','Sad','Hot','Calm') NOT NULL,
  `Date` date NOT NULL,
  KEY `idUser` (`idUser`,`idPublication`),
  KEY `idPublication` (`idPublication`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `idUser` int(11) NOT NULL,
  `Objet` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Photo` varchar(255) NOT NULL,
  `Etat` enum('Traité','nonTraité') NOT NULL,
  `DateReclamation` varchar(255) NOT NULL,
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `idTicket` int(11) NOT NULL AUTO_INCREMENT,
  `idCompetition` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `Photo` varchar(255) NOT NULL,
  `MotDePasse` int(11) NOT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `idCompetition` (`idCompetition`,`idUser`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Login` varchar(255) NOT NULL,
  `MotDePasse` varchar(100) NOT NULL,
  `Sexe` varchar(10) NOT NULL,
  `DateNaissance` date NOT NULL,
  `NumTelephone` int(8) NOT NULL,
  `TypeCompte` enum('SimpleUtilisateur','Administrateur','ChasseurTalent') NOT NULL,
  `TypeTalent` enum('Dance','Musique','Comedie','BeatBox') NOT NULL,
  `ImgUser` varchar(255) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `Nom`, `Prenom`, `Email`, `Login`, `MotDePasse`, `Sexe`, `DateNaissance`, `NumTelephone`, `TypeCompte`, `TypeTalent`, `ImgUser`) VALUES
(1, 'zribi', 'oussema ', 'oussema.zribi@esprit.tn', 'oussema_zribi', 'azerty', 'homme', '2020-02-03', 23544544, 'SimpleUtilisateur', 'Dance', 'oussemaa');

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

DROP TABLE IF EXISTS `vote`;
CREATE TABLE IF NOT EXISTS `vote` (
  `idUser` int(11) NOT NULL,
  `idPublication` int(11) NOT NULL,
  `Type` int(11) NOT NULL,
  `Date` date NOT NULL,
  KEY `idUser` (`idUser`,`idPublication`),
  KEY `idPublication` (`idPublication`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `annonce_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `commentaire_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `commentaire_ibfk_2` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`idPublication`);

--
-- Contraintes pour la table `commentaireannonce`
--
ALTER TABLE `commentaireannonce`
  ADD CONSTRAINT `commentaireannonce_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commentaireannonce_ibfk_2` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`idAnnonce`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `competition`
--
ALTER TABLE `competition`
  ADD CONSTRAINT `competition_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`idConversation`) REFERENCES `conversation` (`idConversation`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participer`
--
ALTER TABLE `participer`
  ADD CONSTRAINT `participer_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `participer_ibfk_2` FOREIGN KEY (`idCompetition`) REFERENCES `competition` (`idCompetition`);

--
-- Contraintes pour la table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `publication_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `publicite`
--
ALTER TABLE `publicite`
  ADD CONSTRAINT `publicite_ibfk_1` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`idAnnonce`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicite_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reaction`
--
ALTER TABLE `reaction`
  ADD CONSTRAINT `reaction_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `reaction_ibfk_2` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`idPublication`);

--
-- Contraintes pour la table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`idCompetition`) REFERENCES `competition` (`idCompetition`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `vote`
--
ALTER TABLE `vote`
  ADD CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`idPublication`),
  ADD CONSTRAINT `vote_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
