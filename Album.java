import java.util.ArrayList;
import java.util.LinkedList;


public class Album{
    private String nombre, artista;
    private ArrayList<Song> canciones;

    public Album(String nombre, String artista){
        this.artista = artista;
        this.nombre = nombre;
        this.canciones = new ArrayList<Song>();
    }

    public boolean addSong(String titulo, double duracion){
        Song cancion = new Song(titulo, duracion);
        for (int i = 0; i<this.canciones.size(); i++){
            if (cancion.getTitulo().equalsIgnoreCase(canciones.get(i).getTitulo())){
                return false;
            }
        }
        this.canciones.add(cancion);
        return true;
    }

    private Song findSong(String titulo){
        for (int i = 0; i<canciones.size(); i++){
            if (canciones.get(i).getTitulo().equalsIgnoreCase(titulo)){
              return canciones.get(i);
            }
        }
        return null;
    }



    public boolean addToPlayList(int numpista, LinkedList<Song> playlist){
        if (numpista<0 || numpista>=canciones.size()){
            return false;
        }else{
            playlist.add(canciones.get(numpista));
        }
        return true;

    }



    public boolean addToPlayList(String titulo, LinkedList<Song> playlist){
        if (findSong(titulo) == null){
            return false;
        }else{
            playlist.add(findSong(titulo));
            return true;
        }
    }




}
