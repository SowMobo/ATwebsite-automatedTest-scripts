@REQ_POEI23P2G1-2
Feature: Connexion a un compte
	#*En tant qu'*
	#
	#Utilisateur
	#
	#*Je souhaite*
	#
	#Me connecter à mon compte
	#
	#*Afin de*
	#
	#Gérer mes commandes et mes informations personnelles
	#
	#Règles de gestion :
	#RG1 : Dans l'espace ""My Account"" un pavé ""Login"" permet de saisir son login et son mot de passe et de valider avec un bouton ""LOGIN""
	#RG2 : En se connectant à son compte l'écran ""Dashboard"" doit s'afficher, et des liens renvoyant aux pages suivantes sont présentes : Dashboard, Orders, Download, Adresses, Account Details, Logout
	#RG3 : En cas de connexion avec un mot de passe erroné, un message ""ERROR: The password you entered for the username ""Email"" incorrect s'affiche
	#RG4 : Une case à cocher ""Remember me"" permet de garder son login pré-rempli à la prochaine connexion

	#Tests *En tant qu'*
	#
	#Utilisateur
	#
	#*Je souhaite*
	#
	#Me connecter à mon compte
	#
	#*Afin de*
	#
	#Gérer mes commandes et mes informations personnelles
	#
	#Règles de gestion :
	#RG1 : Dans l'espace ""My Account"" un pavé ""Login"" permet de saisir son login et son mot de passe et de valider avec un bouton ""LOGIN""
	#RG2 : En se connectant à son compte l'écran ""Dashboard"" doit s'afficher, et des liens renvoyant aux pages suivantes sont présentes : Dashboard, Orders, Download, Adresses, Account Details, Logout
	#RG3 : En cas de connexion avec un mot de passe erroné, un message ""ERROR: The password you entered for the username ""Email"" incorrect s'affiche
	#RG4 : Une case à cocher ""Remember me"" permet de garder son login pré-rempli à la prochaine connexion
	@TEST_POEI23P2G1-17 @TESTSET_POEI23P2G1-49 @authentification @tnrV6 @valid-login
	Scenario Outline: Se connecter avec identifiants valides
		Given je ouvre le site AT
		When  je click sur le lien My Account
		And   je saisis mon login  "<login>"
		And   je saisis mon mot de passe "<password>"
		And   je click sur le button LOGIN
		Then  le nom utilisateur est affichee sur la page My Account "<expectedUserName>"
		Examples:
		  |login                     |password             |expectedUserName|
		  |sowmodibo62@gmail.com     |passwordSowModibo1&  |sowmodibo62|
		  |user.1@yahoo.fr            |passwordUser1&       |user.1|
