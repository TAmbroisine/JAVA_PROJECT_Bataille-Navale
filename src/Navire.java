abstract class Navire
{
    //No need for Deplacement to be abstract because it works the same for Every ship
    //Pas besoin pour Deplacement d'être abstrait car il fonctionne de la même manière pour tout les bateaux
    public void Deplacement (){
        
        int x = 1;
    }
    abstract public void Tir (int x, int y);
    abstract public void Positionnement ();

}

