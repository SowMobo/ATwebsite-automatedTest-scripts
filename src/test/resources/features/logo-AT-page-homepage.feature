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
	@TEST_POEI23P2G1-19 @TESTSET_POEI23P2G1-49 @authentification @tnrV6
	Scenario: Utiliser le logo  AT pour se rediriger vers la page d'accueil
		Given je ouvre le site AT
		And   je click sur le logo AT
		Then  le titre new arrivals est affiche
