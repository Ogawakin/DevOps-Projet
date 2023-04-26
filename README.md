[![Maven](https://maven-badges.herokuapp.com/maven-central/cz.jirutka.rsql/rsql-parser/badge.svg)](https://maven.apache.org/)
![Coverage](https://img.shields.io/endpoint?url=https%3A%2F%2Fgist.githubusercontent.com%2FOgawakin%2F8e07fede48571430cfd340cb3829b165%2Fraw%2F766b11478a7ee75a0711215402ab5f9df1e862e6%2FDevOps-Projet-jacoco-coverage.json)
[![Tests](https://badgen.net/badge/icon/Tests?icon=bitcoin-lightning&label)](https://junit.org/junit5/)
[![Eclipse](https://badgen.net/badge/icon/eclipse?icon=eclipse&label)](https://junit.org/junit5/)

# **DevOps-Projet**

## **Fonctionnalités**

Toutes les fonctionnalités se trouvent dans la branche main de notre github

### Constructeur

3 constructeurs de dataframe existent :
- créer une dataframe vide
- créer une dataframe via un nombre quelconque de colonne
- créer une dataframe via un fichier csv simplifié, le fichier csv doit contenir sur ça première ligne le type des colonnes. Il doit s'agir de `string`,`int`,`float` ou `double`

2 constructeurs de colonnes existent, ils prènent à minima le nom de la colonne :
- créer une colonne vide
- créer une colonne via un vecteur d'éléments

On peut également ajouter un élément à une colonne et une colonne à une dataframe.

### Affichage

Nous avons 3 méthodes d'affichage différentes :
- `print` affiche le dataframe entièrement.
- `printStart` affiche les 5 premières lignes du dataframe.
- `printEnd` affiche les 5 dernières lignes du dataframe.
    
Le dataframe est toujours afficher de façon a ce qu'un label soit suivit de tout les éléments de sa colonne séparé par un espace le tout encadré de crochet. Chaque label est séparé par un retour à la ligne.

### Selection

Nous avons aussi 3 méthodes de sélection d'un dataframe qui retourne chacune un nouveau dataframe :
- `SelectLine` retourne un dataframe composé de toutes les lignes dont les index ont été donné en argument.
- `SelectColumn` retourne un dataframe composé de toutes les colonnes dont les labels ont été donné en argument.
- `SelectWhere` retourne un dataframe composé de toutes les lignes où la valeur, donné en argument, du label, donné en argument, est égale. La colonne au label donné en argument n'est pas présente dans ce dataframe.

### Opérations

Il existe plusieurs fonctions permettant de manipuler les colonnes du dataframe. Tout d'abord il est possible d'avoir la valeur Min et la valeur Max de chaque colonne. Ces methodes devraint fonctionner avec tous les types car ils doivent extends Comparable. De plus nous avons deux méthodes permettant d'obtenir la moyenne et la somme des colonnes pour les type `Integer`, `Float` et `Double`. Pour les autres types, une exception est levée. 


## **Choix d'outils**

## **Workflow mis en place**
Le workflow est organisé dans le fichier `maven.yaml` du dossier `.github/workflows`.

Le workflow dispose de deux commandes : 
- ```build``` : initialise Maven, et lance une commande `verify` en compilation Maven. Le fichier XML `jacoco.xml` sera garder en tant qu'artefact afinde le transmettre/traiter dans les jobs suivants.
- ``coverage`` : utilse une action du marketplace GitHub pour générer un badge contenant le pourcentage de code couvert.

## **Procédure de validation des demandes de Pull/Merge**

Premièrement, la branche `main` a été configurée au sein de l'interface GitHub pour ne pas accepter de Pull//Merge requests sans validations.
Nous avons fonctionné avec le principe de `feature branch`.\
Dans un second temps, les requests étaient faites uniquement dans le cas où les tests réussissaient et que la couverture de code était satisfaisante (généralement supérieure à 90%).

## **Description des images Docker produites/lien vers leur depôt**

Nous avons commencé à regarder comment créer des images docker automatiquement afin de les transférer dans Docker Hub. Cependant nous n'avons pas eu le temps d'aller au bout. Ce qu'on nous avions commencé à faire se trouve dans la branche "dockerfile".

## **Feedbacks**
