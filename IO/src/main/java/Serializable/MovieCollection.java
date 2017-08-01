package Serializable;


import javax.swing.plaf.multi.MultiViewportUI;
import java.io.*;
import java.util.ArrayList;

public class MovieCollection {

    public static void serialize(final ArrayList<Movie> movies, final String outFile) throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outFile));
        objectOutputStream.writeObject(movies);
        objectOutputStream.close();
    }

    public static ArrayList<Movie> deserialize(final String input) throws IOException, ClassNotFoundException{
        File file = new File(input);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        return (ArrayList<Movie>)objectInputStream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ArrayList<Movie> movies = new ArrayList<>();
        Movie m1 = new Movie("VanDam","Boevik",121);
        Movie m2 = new Movie("TomKruz", "MissionImporsible", 125);
        movies.add(m1);
        movies.add(m2);
        MovieCollection.serialize(movies,"movies");

        ArrayList<Movie> desMovie = MovieCollection.deserialize("movies");

        desMovie.forEach(System.out::println);

    }
}
