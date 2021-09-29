import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        int skip, targetIndex;
        List<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("Digite el número de soldados a omitir: ");
        skip = in.nextInt()-1;

        List<String> names = new ArrayList<>();
        String nameOfSoldier;

        do {
            System.out.println("Digite el nombre del soldado");
            nameOfSoldier = in.next();
            if(nameOfSoldier.equalsIgnoreCase("fin")) {
                break;
            } else {
                names.add(nameOfSoldier);
            }

        } while (true);


        for (String name : names) {
            list.add("Soldado " + name);
        }

        targetIndex = skip;
        System.out.println("El orden de salida es: ");


        while (!list.isEmpty())
        {

            if (list.size() > 1) {
                System.out.println(list.remove(targetIndex));
                targetIndex = (targetIndex + skip) % list.size();
            }
            if(list.size()==1){
                System.out.println("El ultimo soldado es: "+list.get(0));
                break;
            }
        }
        in.close();
    }
}

