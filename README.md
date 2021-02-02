# Programme-de-Parking-Thread
Créer un Programme de Parking, en passant sa taille au constructeur, et qui propose deux méthodes (synchronized), leave() et accept().
 accept() réserve la place et retourne vrai si il y a de la place (incrémente le nombre de places occupées), et faux sinon.
 leave () pour décrémenter le nombre de places occupées une fois la voiture quitte le parking.

#Programme-de-Baigneur

L’activité humaine regorge de situations où les êtres humains doivent se synchroniser pour accomplir une activité. Un baigneur se rendant à la piscine doit aussi tenir compte des autres et se synchroniser par rapport à eux.
Il doit attendre quand il n’y a plus de panier pour y mettre ses vêtements ;
Il doit attendre si toutes les cabines sont occupées. Son activité peut se résumer comme suit :
Processus baigneur arriver à la piscine

o P (panier) Puis-je prendre un panier ?

o prendre un panier

o P (cabine) Puis-je avoir une cabine ?

o choisir une cabine (déshabillage)

o V (cabine) Libérer la cabine

o se baigner

o P (cabine) Puis-je avoir une cabine ?

o choisir une cabine (rhabillage)

o V (cabine) Libérer la cabine

o V (panier) Rendre le panier

o quitter la piscine 

Chaque thread baigneur écrit son numéro et son état dans un tube commun à tous les baigneurs. 
