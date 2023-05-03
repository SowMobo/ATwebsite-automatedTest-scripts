@REQ_POEI23P2G1-4
Feature:  Re-initialisation de mot de passe oublié
	#*En tant qu'*
	#
	#Utilisateur
	#
	#*Je souhaite*
	#
	#Ré-initialiser mon mot de passe oublié
	#
	#Règles de gestion :
	#RG1 : Un lien "Lost your password?" doit rediriger vers une page permettant de saisir son login et de valider la demande de ré-initialisation
	#RG2 : La demande validée génére l'envoi automatique d'un lien de réinitialisation dans la boite mail de l'utilisateur
	#RG3: Le lien reçu dans le mail renvoi vers une page de l'application permettant de saisir un nouveau mot de passe. L'utilisateur doit re-confirmer son mot de passe

	#Tests *En tant qu'*
	#
	#Utilisateur
	#
	#*Je souhaite*
	#
	#Ré-initialiser mon mot de passe oublié
	#
	#Règles de gestion :
	#RG1 : Un lien "Lost your password?" doit rediriger vers une page permettant de saisir son login et de valider la demande de ré-initialisation
	#RG2 : La demande validée génére l'envoi automatique d'un lien de réinitialisation dans la boite mail de l'utilisateur
	#RG3: Le lien reçu dans le mail renvoi vers une page de l'application permettant de saisir un nouveau mot de passe. L'utilisateur doit re-confirmer son mot de passe
	@TEST_POEI23P2G1-20 @TESTSET_POEI23P2G1-49 @authentification @tnrV6 @reset-paassword
	Scenario Outline: Re-initialiser un mot de passe oublié
		Given je ouvre le site AT
		When  je click sur le lien My Account
		And   je click sur le lien Lost your password
		And   je saisis mon login  sur la page lost password "<login>"
		And   je click sur le button RESET PASSWORD
		And   je ouvre la page accueil de ma boite email "<urlHomePageEmail>"
		And   je ouvre ma boite de reception emails "<login>"
		Then  je recois un email au bout de dix min "<expectedFirstEmailTitle>"

		Examples:
			|login                   |urlHomePageEmail                   				 |expectedFirstEmailTitle|
			|cafard@yopmail.com      |https://yopmail.com/fr/wm                  |Automation Testing|