@REQ_POEI23P2G1-3
Feature: Voir le logo du Site "AT"
	#*En tant qu'*
	#
	#Utilisateur
	#
	#*Je souhaite*
	#
	#Voir le logo du Site "AT"
	#Règles de gestion :
	#RG1 : Le logo contient un lien qui doit rediriger le site sur la page accueil RG2 : Le logo doit être présent sur toutes les pages du site

	#Tests *En tant qu'*
	#
	#Utilisateur
	#
	#*Je souhaite*
	#
	#Voir le logo du Site "AT"
	#Règles de gestion :
	#RG1 : Le logo contient un lien qui doit rediriger le site sur la page accueil RG2 : Le logo doit être présent sur toutes les pages du site
	@TEST_POEI23P2G1-48 @TESTSET_POEI23P2G1-49 @authentification @tnrV6
	Scenario: Utiliser le logo AT pour se rediriger vers la page accueil
		Given je ouvre le site AT
		When  je click sur le lien My Account
		And   je saisis mon login  "<login>"
		And   je saisis mon mot de passe "<password>"
		And   je click sur le lien shop
		And   je click sur le premier produit a la Une
		And   je click sur le logo AT depuis la page product
		Then  le titre new arrivals est affiche