-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 12 fév. 2020 à 00:00
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
  `Etat` tinyint(1) NOT NULL,
  PRIMARY KEY (`idAnnonce`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Structure de la table `competition`
--

DROP TABLE IF EXISTS `competition`;
CREATE TABLE IF NOT EXISTS `competition` (
  `idCompetition` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `Titre` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `TypeDeTalent` enum('Dance','Musique','Comedie','BeatBox') NOT NULL,
  `DateDebut` varchar(255) NOT NULL,
  `DateFin` varchar(255) NOT NULL,
  `Cout` int(11) NOT NULL,
  PRIMARY KEY (`idCompetition`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `competition`
--

INSERT INTO `competition` (`idCompetition`, `idUser`, `Titre`, `Description`, `TypeDeTalent`, `DateDebut`, `DateFin`, `Cout`) VALUES
(11, 21, 'event', 'barcha jaaw', 'Musique', '25-6-2020', '27-06-2020', 100),
(37, 23, 'NescafeMedia', 'cute event', 'Comedie', '25-08-1998', '29-08-1998', 200),
(38, 24, 'Karaoke', 'ija marhaba biik', 'Musique', '06-06-2020', '06-07-2020', 120);

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
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `idUser` int(11) NOT NULL,
  `idCompetition` int(11) NOT NULL,
  KEY `idUser` (`idUser`),
  KEY `idCompetition` (`idCompetition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`idUser`, `idCompetition`) VALUES
(22, 37),
(22, 11),
(21, 11),
(23, 37),
(24, 38);

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
  `idReclamation` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `Objet` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Photo` mediumblob NOT NULL,
  `Etat` tinyint(1) NOT NULL,
  `DateReclamation` date NOT NULL,
  PRIMARY KEY (`idReclamation`),
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
  `idUser` int(255) NOT NULL,
  `Photo` varchar(255) NOT NULL,
  `MotDePasse` varchar(11) NOT NULL,
  `DateEmission` datetime NOT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `idCompetition` (`idCompetition`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ticket`
--

INSERT INTO `ticket` (`idTicket`, `idCompetition`, `idUser`, `Photo`, `MotDePasse`, `DateEmission`) VALUES
(36, 37, 21, 'hahalouay', 'louay', '2020-02-11 03:09:24'),
(37, 37, 21, 'haha', 'louay', '2020-02-11 03:10:03'),
(41, 11, 22, 'haha', '0hello', '2020-02-11 03:29:30'),
(45, 11, 21, 'haha', '0hello', '2020-02-11 12:09:43'),
(46, 37, 21, 'dfdfdfgdg', 'esprit', '2020-02-11 12:44:00'),
(48, 37, 23, 'haha', 'U0, C0', '2020-02-11 13:28:38'),
(49, 37, 23, 'haha', 'U0, C0', '2020-02-11 19:34:53'),
(50, 37, 23, 'haha', 'U0, C0', '2020-02-11 19:36:09'),
(51, 37, 23, 'haha', 'U23C37', '2020-02-11 19:54:26'),
(52, 38, 24, 'haha', 'U24C38', '2020-02-11 19:58:38'),
(53, 38, 24, 'haha', 'U1924C2038', '2020-02-11 20:04:29');

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
  `DateNaissance` varchar(255) NOT NULL,
  `NumTelephone` int(8) NOT NULL,
  `TypeCompte` enum('SimpleUtilisateur','Administrateur','ChasseurTalent') NOT NULL,
  `TypeTalent` enum('Dance','Musique','Comedie','BeatBox') NOT NULL,
  `ImgUser` varchar(255) NOT NULL,
  `NbDiament` int(255) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `Nom`, `Prenom`, `Email`, `Login`, `MotDePasse`, `Sexe`, `DateNaissance`, `NumTelephone`, `TypeCompte`, `TypeTalent`, `ImgUser`, `NbDiament`) VALUES
(21, 'louay', 'yahyaoui', 'hahaha', 'hahaha', 'haahha', 'haha', '589', 2345, 'Administrateur', 'Dance', 'jajaja', 50),
(22, 'maysa', 'habbachi', 'hahaha', 'hahaha', 'haahha', 'haha', '589', 2345, 'Administrateur', 'Dance', 'jajaja', 50000),
(23, 'fedi', 'benMansour', 'hahaha', 'hahaha', 'haahha', 'male', '589', 2345, 'ChasseurTalent', 'BeatBox', 'jajaja', 19400),
(24, 'aroma', 'coffee', 'aromacoffee@esprit.tn', 'aroma1920', 'aroma123', 'male', '05-05-2020', 23422387, 'SimpleUtilisateur', 'BeatBox', 'aroma.png', 260);

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
  ADD CONSTRAINT `annonce_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `commentaire_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `commentaire_ibfk_2` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`idPublication`);

--
-- Contraintes pour la table `competition`
--
ALTER TABLE `competition`
  ADD CONSTRAINT `competition_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`idConversation`) REFERENCES `conversation` (`idConversation`);

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participation_ibfk_2` FOREIGN KEY (`idCompetition`) REFERENCES `competition` (`idCompetition`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `publication_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `reaction`
--
ALTER TABLE `reaction`
  ADD CONSTRAINT `reaction_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `reaction_ibfk_2` FOREIGN KEY (`idPublication`) REFERENCES `publication` (`idPublication`);

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `reclamation_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`idCompetition`) REFERENCES `competition` (`idCompetition`) ON DELETE CASCADE ON UPDATE CASCADE;

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
