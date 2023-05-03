@REQ_POEI23P2G1-6
Feature: Déconnexion de l’espace Client
	#*En tant qu'*
	#
	# Utilisateur 
	#
	#*Je souhaite* 
	#
	#Me déconnecter 
	#
	#*Afin de* 
	#
	#Ne plus pouvoir accèder à mon espace client 
	#
	#*Règles de gestion :*
	#
	# *RG1 :* Dans l'espace "My Account" un lien "Logout" permet la déconnexion, la page Account affiche les pavé de "Login" et de "Register”

	@TEST_POEI23P2G1-24 @TESTSET_POEI23P2G1-49 @authentification @deconnexion
	Scenario Outline: Valider la déconnexion en cliquant sur le lien logout
		Given je me connecte avec "<login>" et "<password>"
		When je click sur le lien Logout
		Then le titre Login est affichee sur la page authentification
		
		Examples:
		  |login                  |password|
		  |sowmodibo62@gmail.com  |passwordSowModibo1&|
		  |user.1                 |passwordUser1&|
