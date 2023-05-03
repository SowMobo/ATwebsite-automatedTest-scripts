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
	@TEST_POEI23P2G1-27 @TESTSET_POEI23P2G1-92 @TESTSET_POEI23P2G1-49 @tnrV6 @authentification @confirmation @invalid-login
	Scenario Outline: Se connecter avec un mot de passe invalide
		Given je ouvre le site AT
		When  je click sur le lien My Account
		And   je saisis mon login  "<login>"
		And   je saisis mon mot de passe "<password>"
		And   je click sur le button LOGIN
		Then  un message erreur est affiche sur la page Authentification "<expectedErrorMessage>"
		Examples:
		  |login                  |password      						|expectedErrorMessage|
		  |sowmodibo62@gmail.com  |passwordSowModibo1  					|Error: the password you entered for the username sowmodibo62@gmail.com is incorrect. Lost your password?|
		  |user.1@yahoo.fr    	  |Vegeta!   							|Error: the password you entered for the username user.1@yahoo.fr is incorrect. Lost your password?|
		  |user.1@yahoo.fr    	  |vegeta?  							|Error: the password you entered for the username user.1@yahoo.fr is incorrect. Lost your password?|
		  |user.1@yahoo.fr    	  |  									|Error: the password you entered for the username user.1@yahoo.fr is incorrect. Lost your password?|
		  |user.1@yahoo.fr    	  |vEgeta0 0o  							|Error: the password you entered for the username user.1@yahoo.fr is incorrect. Lost your password?|
		  |user.1@yahoo.fr    	  |.   								    |Error: Password is required.|
		  |user.1@yahoo.fr    	  |/idjd9   							|Error: the password you entered for the username user.1@yahoo.fr is incorrect. Lost your password?|
		  |user.1@yahoo.fr    	  |veget8&  							|Error: the password you entered for the username user.1@yahoo.fr is incorrect. Lost your password?|
		  |user.1@yahoo.fr    	  |gdvdgdcf#@   						|Error: the password you entered for the username user.1@yahoo.fr is incorrect. Lost your password?|

