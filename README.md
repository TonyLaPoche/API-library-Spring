# Library API

Ce projet est une API REST de gestion de bibliothèques pour des livres de type RPG. Elle permet d’effectuer des opérations CRUD pour les livres, auteurs et genres, le tout en utilisant **Spring Boot**. Ce projet est un terrain d’entraînement pour explorer et maîtriser les concepts de développement d’API en Java avec Spring Boot.

## Statut du Projet

**En cours de développement** 🚧

Ce projet est activement en cours de construction et n’est pas encore finalisé. Il s’agit d’un environnement de pratique et de formation pour expérimenter divers aspects de Spring Boot.

## Fonctionnalités

L’API inclut les fonctionnalités suivantes (à différentes étapes de développement) :

- Gestion des **livres** (CRUD complet)
- Gestion des **auteurs** et des genres associés
- Validation des données via des DTO
- Gestion des exceptions personnalisées
- Mapping d’entités à DTO pour la sérialisation JSON
- Documentation API avec Swagger (prévu)

## Technologies Utilisées

- **Java 17** – Langage principal
- **Spring Boot** – Framework d’application
- **Spring Data JPA** – Gestion des données et ORM
- **Hibernate** – ORM pour la gestion de la persistance
- **H2 Database** – Base de données en mémoire pour le développement et les tests
- **MapStruct** – Mapper pour la conversion entités <-> DTO
- **Lombok** – Réduction du code boilerplate
- **Maven** – Gestion des dépendances et du cycle de vie du projet

## Installation et Lancement

1. Cloner le dépôt :

   ```bash
   git clone https://github.com/ton-username/rpg-library-api.git
   cd rpg-library-api
   ```

2. Installer les dépendances avec Maven :

   ```bash
   mvn clean install
   ```

3. Lancer l’application :

   ```bash
   mvn spring-boot:run
   ```

4. L’API sera accessible par défaut sur `http://localhost:8080`.

## Endpoints API

Quelques endpoints principaux (cette liste est non exhaustive) :

| Méthode HTTP | Endpoint            | Description                     |
|--------------|---------------------|---------------------------------|
| GET          | `/api/books`        | Liste de tous les livres        |
| POST         | `/api/books`        | Ajouter un nouveau livre        |
| PUT          | `/api/books/{id}`   | Mettre à jour un livre existant |
| DELETE       | `/api/books/{id}`   | Supprimer un livre              |
| GET          | `/api/authors`      | Liste de tous les auteurs       |
| GET          | `/api/kinds`        | Liste de tous les genres        |

## Note

Ce projet étant en développement, certaines fonctionnalités sont sujettes à des modifications ou des ajouts. N’hésitez pas à me faire part de vos retours ou suggestions pour améliorer le projet !

## Auteur

Créé par [TonyLaPoche](https://github.com/TonyLaPoche).