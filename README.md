# 🧵 Tricol - Gestion des Approvisionnements

## 🏢 Contexte du projet

**Tricol** est une entreprise spécialisée dans la conception et la fabrication de vêtements destinés aux professionnels.  
Les dirigeants souhaitent mettre en place une application permettant une **gestion efficace des approvisionnements** de l'entreprise.

Dans cette première version, le projet se concentre sur le **module de gestion des fournisseurs**, posant les bases d’un système complet qui inclura ultérieurement la gestion des produits, des commandes et des stocks.

---

## 🎯 Objectif du projet

Développer une **application Java** reposant sur **Spring Core**, assurant une architecture modulaire, extensible et respectant les bonnes pratiques de développement (injection de dépendances, découplage, couches logiques bien définies).

---

## ⚙️ Exigences fonctionnelles

### 🧾 Gestion des fournisseurs
L’application doit permettre :

- ➕ **Ajouter un fournisseur** :  
  Enregistrer un fournisseur avec les informations suivantes :
    - Société
    - Adresse
    - Contact
    - Email
    - Téléphone
    - Ville
    - ICE (Identifiant Commun Entreprise)

- ✏️ **Modifier un fournisseur** :  
  Mettre à jour les informations d’un fournisseur existant.

- ❌ **Supprimer un fournisseur** :  
  Retirer un fournisseur du système.

- 📋 **Consulter la liste des fournisseurs** :  
  Afficher tous les fournisseurs avec des options de tri (ex. par nom).

---

## 🧠 Exigences techniques

### 🧩 Technologies principales
- **Java**
- **Spring Core**
- **Spring MVC**
- **Spring Data JPA**

### 🧱 Concepts Spring utilisés
- Conteneur **IoC** pour la gestion des dépendances
- **Spring Beans** et leurs **scopes**
- **ApplicationContext** et **BeanFactory**
- **Configuration Spring** :
    - XML
    - Annotations
    - Java Config
- **Component Scanning** pour la détection automatique des composants

---

## 🧩 Architecture

L’application est basée sur une **architecture en couches** :

- **Controller** → Gère les requêtes HTTP et les endpoints REST
- **Service** → Contient la logique métier
- **Repository** → Gère l’accès aux données via Spring Data JPA

### 🔁 Design Patterns utilisés
- **Service Pattern**
- **Controller Pattern**
- **Repository Pattern**

---

## 💾 Persistance

- Utilisation de **Spring Data JPA** pour la couche d’accès aux données
- Requêtes standards générées automatiquement :
    - `findAll()`
    - `findById()`
    - `count()`
- Méthodes personnalisées via **Query Methods** :
    - `findByNom(...)`
    - `findByEmailEndingWith(...)`

---

## 🌐 API REST

Les endpoints REST suivants sont exposés :

| Méthode | Endpoint | Description |
|----------|-----------|-------------|
| **GET** | `/Tricol/api/tricol` | Récupérer la liste des fournisseurs |
| **GET** | `/Tricol/api/tricol?id=1` | Récupérer un fournisseur par ID |
| **POST** | `/Tricol/api/tricol` | Ajouter un nouveau fournisseur |
| **PUT** | `/Tricol/api/tricol?id=1` | Modifier un fournisseur existant |
| **DELETE** | `/Tricol/api/tricol?id=1` | Supprimer un fournisseur |

---

## 🧪 Tests

L’API peut être testée à l’aide de **Postman** :

- Vérifier l’ajout, la mise à jour, la suppression et la récupération des fournisseurs.
- Assurez-vous que les réponses sont au format **JSON** et que les statuts HTTP sont corrects (`200`, `201`, `404`, `400`, etc.).

---

## 🧰 Outils utilisés

- **IntelliJ IDEA** (ou Eclipse)
- **Apache Tomcat**
- **Maven**
- **Postman**
- **Git / GitHub**

---

## 👨‍💻 Auteur

**Ayoub Ben Omar**  
Projet développé dans le cadre de la formation YouCode — module **Spring Core / Spring MVC**
