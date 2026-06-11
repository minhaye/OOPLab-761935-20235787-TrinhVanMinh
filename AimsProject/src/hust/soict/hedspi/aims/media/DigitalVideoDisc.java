package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
     {
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }
    
    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength() <= 0) {
            System.err.println("ERROR: DVD length is non-positive.");
            throw new PlayerException("ERROR: DVD length is non-positive.");
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength()); 
    }
}
