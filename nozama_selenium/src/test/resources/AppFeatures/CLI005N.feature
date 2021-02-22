#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Effectuer une commande

Scenario Outline: Linternaute finalise sa commande en rentrant les informations
  Given Linternaute demande a commande le contenu de son panier
  When Linternaute sidentifie avec son "<login>" et son "<mdp>"
  When linternaute saisit son "<nom>", "<prenom>", "<rue>", "<ville>", "<codepostal>"
  When linternaute coche la case pour les selection automatique pour les donnees de facturation
  When linternaute saisit ses informations bancaire avec "<numerocarte>", "<datecarte>",  "<codecrypto>"
  When linternaute valide sa commande
  Then la commande est validee
  Examples: 
    | login  | mdp  	| nom     | prenom | rue                 | ville  | codepostal  | numerocarte      | datecarte | codecrypto |
    | demo1  | demo1  |  Dupont | Marc   | 2 rue de Bretagne   | Rennes | 35000       | 5584439845217150 | 01/2022	 | 125				|
    | demo2  | demo2  |  Aurel  | Marc   | 2 rue de BZH			   | Rennes | 35100       | 5584439845217150 | 01/2024	 | 125				|
    | demo3  | demo3  |  Lavoine| Marc   | 2 rue de Bretonne   | Rennes | 35200       | 5584439845217150 | 01/2025	 | 125				|