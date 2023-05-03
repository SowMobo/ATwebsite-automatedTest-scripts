@REQ_POEI23P2G1-9
Feature: Finalisation des achats
	#*En tant qu'*
	#
	# Utilisateur 
	#
	#*Je souhaite*
	#
	# Consulter mon panier 
	#
	#*Afin de*
	#
	# Finaliser mes achats
	#
	# *Règles de gestion :*
	#
	# *RG1 :* La page panier affiche un récapitulatif des articles ajoutés spécifiant la quantité, le prix unitaire et le prix total 
	#
	#*RG2 :* Chaque article peut être supprimé par un bouton, la quantité de chaque article peut être modifié par le champ quantité 
	#
	#*RG3 :* Au-dessous du récapitulatif des articles, un champ "Coupon code" et un bouton "APPLY COUPON" permettant d’apppliquer un code promotionnel sur la commande 
	#
	#*RG4 :* Un pavé récapitulatif "Basket Totals" spécifie le prix total et la taxe associée 
	#
	#*RG5 :* Un bouton "Proceed to Checkout" permet de valider la commande et de passer au paiement"

	@TEST_POEI23P2G1-33 @TESTSET_POEI23P2G1-51 @Commande @recap-ajout-panier
	Scenario Outline: Valider que la page panier affiche un récapitulatif des articles ajoutes
		Given je me connecte avec "<login>" et "<password>"
		When  je click sur le lien shop
		And   je clique sur la photo de un disponible
		And   je click le button ADD TO BASKET depuis la page produit
		And   je click sur le button VIEW BASKET
		Then  le titre du produit est correct "<expectedTitle>"
		And   le prix est correct "<expectedPrice>"
		Examples:
		  |login                  |password                             |expectedTitle             |expectedPrice|
		  |user.1@yahoo.fr        |passwordUser1&                            |Mastering JavaScript      |₹350.00|
