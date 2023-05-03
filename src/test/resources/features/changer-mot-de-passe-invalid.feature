@REQ_POEI23P2G1-5
Feature: Gestion de compte
	#*En tant qu'*
	#
	#Utilisateur
	#
	#*Je souhaite*
	#
	#Depuis la page "My Account" visualiser mes informations de compte
	#
	#*Afin de*
	#
	#Pouvoir gérer mon compte
	#
	#Règles de gestion :
	#RG1 : Dans la page "My Account", un lien "Account Details" redirige vers les informations de comptes (nom prénom, mail)
	#RG2 : Un espace permet de changer son mot de passe, l'utilisateur doit saisir son mot de passe actuel, saisir un nouveau mot de passe et le confirmer. En cas de succés un message "Account details changed successfully." s'affiche, sinon un message d'erreur s'affiche suivant la nature du problème ("Your current password is incorrect.", "New passwords do not match.")

	#Tests *En tant qu'*
	#
	#Utilisateur
	#
	#*Je souhaite*
	#
	#Depuis la page "My Account" visualiser mes informations de compte
	#
	#*Afin de*
	#
	#Pouvoir gérer mon compte
	#
	#Règles de gestion :
	#RG1 : Dans la page "My Account", un lien "Account Details" redirige vers les informations de comptes (nom prénom, mail)
	#RG2 : Un espace permet de changer son mot de passe, l'utilisateur doit saisir son mot de passe actuel, saisir un nouveau mot de passe et le confirmer. En cas de succés un message "Account details changed successfully." s'affiche, sinon un message d'erreur s'affiche suivant la nature du problème ("Your current password is incorrect.", "New passwords do not match.")
	@TEST_POEI23P2G1-21 @TESTSET_POEI23P2G1-49 @authentification @tnrV6 @changer-mot-de-passe-invalid
	Scenario Outline: Changer un mot de passe
		Given je me connecte avec "<login>" et "<password>"
		When  je click sur le lien Account Details
		And   je saisis mon de passe passe actuel "<passowrd>"
		And   je saisis mon nouveau mot de passe "<newPassword>"
		And   je confirme mon nouveau mot de passe "<newPassowrd>"
		Then  le nom utilisateur est affichee sur la page My Acount "<expectedUserName>"
		Examples:
		  |login                             |password                     |firstName       |lastName        |newPassword               |   
		   |ooumayma.sebbata@gmail.com       |passwordOumaymaSebbata1&      |oumayma        |sebbata         |passwordOumaymaSebbata2&  |
