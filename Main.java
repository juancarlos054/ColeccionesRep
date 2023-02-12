import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Album> albumlist = new ArrayList<Album>();
        Album album1 = new Album("Scorpion", "Drake");
        Album album2 = new Album("Blueprint I", "jay-z");
        albumlist.add(album1);
        albumlist.add(album2);

        album1.addSong("AAAA", 3.23);
        album1.addSong("BBBB", 2.12);
        album1.addSong("CCCC", 3.1 );
        album1.addSong("DDDD", 3.1 );
        album2.addSong("2AAAA", 2.11);


        LinkedList<Song> playlist = new LinkedList<Song>();
        album1.addToPlayList(0, playlist);
        album1.addToPlayList(1, playlist);
        album1.addToPlayList(2, playlist);
        album1.addToPlayList(3, playlist);
        album2.addToPlayList(0, playlist);

        Play(playlist);

    }

    public static void printPlayList(LinkedList<Song> playlist){
        Iterator<Song> it = playlist.iterator();
        System.out.println("PLAYLIST:");
        while(it.hasNext()){
            System.out.println("-- " + it.next());
        }
        System.out.println("----");
    }



    public static void printOptions(){
        System.out.println(" 0 -Salir de la lista de reproduccion \n 1 -Reproducir siguiente cancion \n 2 -Reproducir cancion previa \n 3 -Repetir cancion actual \n 4 -Imprimir canciones en la playlist \n 5 -Volver a imprimir menu \n 6 -Eliminar cancion actual");

    }

    public static void Play(LinkedList<Song> playlist){
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        ListIterator<Song> it = playlist.listIterator();

        if (playlist.isEmpty()){
            return;
        }else{
            printOptions();
        }

        while(continuar){
            String opt = sc.next();
            switch (opt){
                case "0":
                    System.out.println("Saliendo de playlist");
                    continuar = false;
                    break;

                case "1":
                    if (it.hasNext()){
                        it.next();
                        if (it.hasNext()){
                            System.out.println("Reproduciendo siguiente cancion --> " + it.next());
                        }else{
                            System.out.println("No hay siguientes canciones");
                        }
                        if (it.hasPrevious()){
                            it.previous();
                        }
                    }
                    break;

                case "2":
                    if (it.hasPrevious()){
                        System.out.println("Reproducionedo anterior cancion --> " + it.previous());
                    }else{
                        System.out.println("Reproduciendose primera cancion de playlist");
                    }
                    break;

                case "3":
                    System.out.println("Reproduciendo --> " + it.next());
                    if (it.hasPrevious()){
                        it.previous();
                    }
                    break;


                case "4":
                    printPlayList(playlist);
                    break;


                case "5":
                    printOptions();
                    break;

                case "6":

                    if(playlist.isEmpty()){
                        System.out.println("La playlist esta vacia");
                    }

                    if(!playlist.isEmpty()){
                       if(it.hasNext()){
                        System.out.println("Eliminado el tema: " + it.next());
                       }else if(it.hasPrevious()){
                        System.out.println("Eliminado el tema: " + it.previous());
                       }

                        it.remove();
                    }
                    break;


                default:
                    System.out.println("Opcion no valida");
                    break;

            }


        }

    }


}
