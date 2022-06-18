import java.util.ArrayList;
import java.util.Collections;

public class Museum {
    public static void main(String[] args) {
        ArrayList<Art> museum = new ArrayList<Art>();
        museum.add(new Painting("Oil", "Mona Lisa", " Leonardo da Vinci", "The painting has been definitively identified to depict Italian noblewoman.."));
        museum.add(new Painting("Mural", "The Last Supper", "Leonardo da Vinci", "he work was commissioned as part of a plan of renovations to the church.."));
        museum.add(new Painting("Oil", "The Starry Night", "Vincent van Gogh", "The Starry Night is an oil-on-canvas painting"));

        //these were created without using the ninja bonus arraylist
        //painting1.viewArt();
        //painting2.viewArt();
        // painting3.viewArt();

        museum.add(new Sculpture("Marble", "Forever Bicycles", "Ai Weiwei", "This 3D sculpture was created from 1,200 bicycles"));
        museum.add(new Sculpture("Steel", "Singing Ringing Tree", "Mike Tonkin", "The sculpture won the National Award of the Royal Institute of British Architects"));
        //sculpture1.viewArt();
        //sculpture2.viewArt();

        Collections.shuffle(museum);

        for(Art art : museum){
            art.viewArt();
        }
    }


}
