@REQ_POEI23P2G1-10
Feature: Souscription à la Newsletter
	#*En tant qu'*
	#
	# Utilisateur
	#
	# *Je souhaite* 
	#
	#Souscrire à la newsletter
	#
	#*Afin de* 
	#
	#Me tenir informer des dernières nouvelles de la boutique en ligne 
	#
	#*Règles de gestion :* 
	#
	#*RG1 :* Un champ « SUBSCRIBE HERE » permet la saisie d’une adresse. Un bouton "SUBSCRIBE" permet la validation de cette adresse
	#
	# *RG2 :* L’adresse saisie doit être au format "xxx@yyy.zz" En cas d’erreur à la validation de l’adresse (format) un message "Please provide a valid email address" apparaît 
	#
	#*RG3 :* La fonctionnalité est présente sur les pages "Shop", "My Account" et "Panier" 
	#
	#*RG4 :* A la souscription, un mail de confirmation est reçu dans la boite mail de l’utilisateur

	#En tant qu'
	#Utilisateur
	#Je souhaite
	#Souscrire à la newsletter
	#Afin de
	#Me tenir informer des dernières nouvelles de la boutique en ligne
	#Règles de gestion :
	#RG1 : Un champ « SUBSCRIBE HERE » permet la saisie d’une adresse. Un bouton "SUBSCRIBE" permet la
	#validation de cette adresse
	#RG2 : L’adresse saisie doit être au format "xxx@yyy.zz" En cas d’erreur à la validation de l’adresse (format) un
	#message "Please provide a valid email address" apparaît
	#RG3 : La fonctionnalité est présente sur les pages "Shop", "My Account" et "Panier"
	#RG4 : A la souscription, un mail de confirmation est reçu dans la boite mail de l’utilisateur
	@TEST_POEI23P2G1-37 @TESTSET_POEI23P2G1-92 @TESTSET_POEI23P2G1-55 @Reseasu_Sociaux @confirmation
	Scenario Outline: Souscription a la newsletter depuis la page Shop
		Given je ouvre le site AT
		When  je click sur le lien shop
		And   je saisis  mon mail "<email>" a SUBSCRIRE
		And   je click sur le bouton SUBSCRIBE
		Then  un message de confirmation de subscription est affiche "<expectedMgs>"
		
		Examples:
		  |email                    |expectedMgs|
		  |xxx@yyy.fr                  |Thank you, your sign-up request was successful! Please check your email inbox to confirm.|
