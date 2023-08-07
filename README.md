# Projet Digital Bank - Gestion Bancaire

Ce projet implémente une API RESTful en utilisant Spring Boot pour la gestion d'un système bancaire fictif. L'API permet de gérer les clients, les comptes et les opérations financières au sein de la banque.

## Fonctionnalités

- Gestion des clients : Ajout, consultation, mise à jour et suppression des informations des clients.
- Gestion des comptes : Création, consultation et fermeture de comptes bancaires. Association avec des clients.
- Gestion des opérations : Réalisation d'opérations telles que les dépôts, les retraits et les virements entre comptes.

## Technologies Utilisées

- Java 17
- Spring Boot
- Spring Data JPA pour l'accès aux données
- Spring Web pour l'exposition de l'API RESTful
- Base de données relationnelle MySQL
  
## L'architecture utilisée

![Capture d'écran 2023-08-07 115844](https://github.com/EchchebabyMohamed/Bank_back_end/assets/126407198/f3b42a41-ed5a-4e82-9dd7-f80e46ad1918)

- couche Web.
- Couche service.
- couche des DTO
- couche des entités JPA.
- Couche DAO

## Prérequis

- Java JDK 17 ou supérieur installé
- Un environnement de base de données configuré (par défaut, le projet est configuré pour Mysql Database)

## Installation et Exécution

1. Clonez ce dépôt sur votre machine locale :
