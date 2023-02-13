public class Song{
    private String titulo;
    private double duracion;

    public Song(String titulo, double duracion){
        this.duracion = duracion;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString(){
        return this.titulo + " : " + this.duracion;
    }


}
