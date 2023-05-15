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

	#Tests *En tant qu'*
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
	@TEST_POEI23P2G1-116 @Commande @tnrV6 @-2-diminuer-quantite
	Scenario Outline: Diminuer la quantité à commander
		Given je me connecte avec "<login>" et "<password>"
#		When  je click sur le lien shop
#		And   je click le button ADD TO BASKET
		When   je click sur le logo BASKET
		And   je diminue la quantite "<quantity>"
		And   je clcik sur le button UPDATE BASKET
		Then  le prix total est correct "<expectedTotal>"
		Examples:
		  |login                   		|password   |quantity    |expectedTotal|
		  |ibrahima.bah12@yahoo.com		|tapha85/!  |2           |₹700.00|
