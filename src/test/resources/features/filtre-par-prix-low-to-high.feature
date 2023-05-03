@REQ_POEI23P2G1-7
Feature: Passation des commandes
	#*En tant qu'*
	#
	# Utilisateur
	#
	# *Je souhaite*
	#
	# Depuis la page ""Shop"", ajouter des articles dans mon panier 
	#
	#*Afin de*
	#
	# Pouvoir passer des commandes
	#
	# *Règles de gestion :* 
	#
	#*RG1 :* La page "Shop" contient les articles en vente
	#
	# *RG2 :* Chaque article possède un bouton "ADD TO BASKET" permettant d'ajouter l'article au panier. A chaque ajout, un lien ""VIEW BASKET"" apparaît au-dessous l'article, si l'article n'est pas en stock, un bouton "READ MORE" apparaît à la place du bouton "ADD TO BASKET" 
	#
	#*RG3 :* Le lien ""View Basket"" redirige vers le panier. Le panier peut être consulté depuis toutes les pages avec un lien contenu dans une icône en entête
	#
	# *RG4 :* Un filtre permet d'affiner la vue des articles par prix 
	#
	#*RG5 :* Un filtre permet d'affiner la vue des articles par thème
	#
	# RG6 : Chaque article contient une photo descriptive, un libellé et le prix affiché au-dessous. Un lien actif sur ces 3 éléments redirige vers le détail de l'article

	#Tests *En tant qu'*
	#
	# Utilisateur
	#
	# *Je souhaite*
	#
	# Depuis la page ""Shop"", ajouter des articles dans mon panier 
	#
	#*Afin de*
	#
	# Pouvoir passer des commandes
	#
	# *Règles de gestion :* 
	#
	#*RG1 :* La page "Shop" contient les articles en vente
	#
	# *RG2 :* Chaque article possède un bouton "ADD TO BASKET" permettant d'ajouter l'article au panier. A chaque ajout, un lien ""VIEW BASKET"" apparaît au-dessous l'article, si l'article n'est pas en stock, un bouton "READ MORE" apparaît à la place du bouton "ADD TO BASKET" 
	#
	#*RG3 :* Le lien ""View Basket"" redirige vers le panier. Le panier peut être consulté depuis toutes les pages avec un lien contenu dans une icône en entête
	#
	# *RG4 :* Un filtre permet d'affiner la vue des articles par prix 
	#
	#*RG5 :* Un filtre permet d'affiner la vue des articles par thème
	#
	# RG6 : Chaque article contient une photo descriptive, un libellé et le prix affiché au-dessous. Un lien actif sur ces 3 éléments redirige vers le détail de l'article
	@TEST_POEI23P2G1-103 @Commande @tnrV6 @filter-price-low-to-high
	Scenario Outline: Filtrer les ouvrages par prix Low To High
		Given je ouvre le site AT
		When  je click sur le lien shop
		And   je je select le filtre price Low to High
		Then  le prix du premier ouvrage est correct "<expectedFirstProductPrice>"
		And   le prix du second ouvrage est correct "<expectedSecondProductPrice>"
		Examples:
		  |expectedFirstProductPrice       |expectedSecondProductPrice|
		  |₹150.00                         |₹180.00|
