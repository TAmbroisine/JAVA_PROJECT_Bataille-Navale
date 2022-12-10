package Affichages;

import java.util.*;

public class MenuGame
{
    Scanner userReader;

    public MenuGame(){
        userReader = new Scanner(System.in);
    }

   public int[] SelectBoat() {

       int shipchoice, shipnumber;
       List<Integer> list = Arrays.asList(1, 2, 3, 4);
       int[] playerschoice = new int[2];
       int value = 3;
       boolean check = false;
       System.out.println("CHOISIR UN TYPE DE BATEAU : \n" +
               "\t[1] : SOUS MARINS\n" +
               "\t[2] : DESTROYER\n" +
               "\t[3] : CROISEUR\n" +
               "\t[4] : CUIRASSE");
       shipchoice = userReader.nextInt();
       while (!list.contains(shipchoice)) {
           shipchoice = userReader.nextInt();
       }
       switch (shipchoice) {
           case 1: // choisir quel sous marins
               list = Arrays.asList(1, 2, 3, 4);
               System.out.println("""
                       CHOISIR QUELS SOUS MARINS\s
                       \t[1] : SOUS MARIN 1
                       \t[2] : SOUS MARIN 2
                       \t[3] : SOUS MARIN 3
                       \t[4] : SOUS MARIN 4
                       """);
               shipnumber = userReader.nextInt();
               while (!list.contains(shipnumber)) {
                   shipnumber = userReader.nextInt();
               }
               playerschoice[0] = shipchoice;
               playerschoice[1] = shipnumber;
               return playerschoice;
           case 2: // choisir quel destroyer
               list = Arrays.asList(1, 2, 3);
               System.out.println("""
                       CHOISIR QUELS DESTROYER\s
                       \t[1] : DESTROYER 1
                       \t[2] : DESTROYER 2
                       \t[3] : DESTROYER 3
                       """);
               shipnumber = userReader.nextInt();
               while (!list.contains(shipnumber)) {
                   shipnumber = userReader.nextInt();
               }
               playerschoice[0] = shipchoice;
               playerschoice[1] = shipnumber;
               return playerschoice;
           case 3: // choisir quel croiseur
               list = Arrays.asList(1, 2);
               System.out.println("""
                       CHOISIR QUELS CROISEUR\s
                       \t[1] : CROISEUR 1
                       \t[2] : CROISEUR 2
                       """);
               shipnumber = userReader.nextInt();
               while (!list.contains(shipnumber)) {
                   shipnumber = userReader.nextInt();
               }
               playerschoice[0] = shipchoice;
               playerschoice[1] = shipnumber;
               return playerschoice;
           case 4:
               playerschoice[0] = shipchoice;
               playerschoice[1] = 1;
               return playerschoice;

       }
       return null;
   }

   public boolean ShootOrMove(){
       int choice;
        System.out.println("""
                CHOISIR TIRER OU DEPLACER
                [1] : DEPLACER
                [2] : TIRER""");
        choice = userReader.nextInt();
        do
        {
            if (choice == 1)
            {
                return true;
                // apelle les méthodes qui TIRE

            } else if (choice == 2)
            {
                // apelle les méthodes qui DEPLACE
                return false;
            }else
            {
                System.out.println("ERREUR : Saisir [1] ou [2]");
                choice = userReader.nextInt();
            }
        }while (choice !=1 & choice!= 2);
        return  false;
    }
  public Object[] CoordonatesShoots ()
  {
      int x = 0;
      char y;
      ArrayList<Integer> RangeX = new ArrayList<Integer>();
      // try catch InputMismatch
      for (int i = 0; i < 16;i++){
          RangeX.add(i);
      }
      ArrayList<Character> RangeY = new ArrayList<Character>();
      char n = 'a';
      for (int k = 0; k < 16; k++)
      {
          RangeY.add(n);
          n++;
      }
      System.out.println("Sélectionner la coordonnee en x");
      x = userReader.nextInt();
      while (!RangeX.contains(x))
      {
          System.out.println(" ERREUR : reselectionner la coordonee en x");
          x = userReader.nextInt();
      }
      System.out.println("Sélectionner la coordonnée en minuscule y");
      y = userReader.next().charAt(0);
      while (!RangeY.contains(y))
      {
          System.out.println("ERREUR : reselectionner la coordonee en y");
          y = userReader.next().charAt(0);
      }
      return new Object[] {x,y};
  }
   public boolean WichDirection(String orientation){
        int choice;
        List<Integer> list = Arrays.asList(1, 2);
        String horizontal = """
                Direction du déplacement:
                [1] : DROITE
                [2] : GAUCHE""";
        String vertical= """
                Direction du déplacement:
                [1] : HAUT
                [2] : BAS""";

        if (Objects.equals(orientation, "horizontal")){
            System.out.println(horizontal);
            choice = userReader.nextInt();
            while (!list.contains(choice)) {
                System.out.println("ERREUR : Saisir [1] ou [2]\n"+horizontal);
                choice = userReader.nextInt();
            }
        }else {
            System.out.println(vertical);
            choice = userReader.nextInt();
            while (!list.contains(choice)) {
                System.out.println("ERREUR : Saisir [1] ou [2]\n"+vertical);
                choice = userReader.nextInt();
            }
        }
       if (choice == 1) {return true;}
       else if (choice == 2) {return false;}
       return false;
    }

   public void printMoveError(){
       System.out.println("Déplacement Impossible!!!");
   }
}
