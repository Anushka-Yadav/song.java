import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;


public class main {
    private static ArrayList<album> albums = new ArrayList<>();
    public static void main(String[] args) {

       

        album Album = new album("album1","AC/DC");

        Album.addsong("TNT\n", 3.0);
        Album.addsong("Highway to Hell\n", 2.0);
        Album.addsong("ThunderStruk\n", 5.5);
        albums.add(Album);
         
        Album = new album("album2", "enimen");

        Album.addsong("Rap God\n", 4.0);
        Album.addsong("Not Afraid\n", 1.5);
        Album.addsong("Lose Yourself\n", 2.5);

        albums.add(Album);
        LinkedList<song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlaylist("TNT", playList_1);

        albums.get(0).addToPlaylist("TNT\n", playList_1);
        albums.get(0).addToPlaylist("Highway to Hell\n", playList_1);
        albums.get(1).addToPlaylist("Rap God\n", playList_1);
        albums.get(1).addToPlaylist("Lose Yourself\n", playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward =true;
        ListIterator<song> listIterator = playList.listIterator();

        if(playList.size()==0){
            System.out.println("this playlist have no song");
        }  
        else{
            System.out.println("now playing"+ listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action=sc.nextInt();
            sc.nextLine();

        switch(action){
            case 0:
                System.out.println("playlist completed");
                quit = true;
                break;
            case 1:
                if(!forward)
                {
                    if(listIterator.hasNext())
                    {
                        listIterator.next();
                    }
                    forward = true;
                }
                    if(listIterator.hasNext())
                    {
                    System.out.println("now playing"+listIterator.next().toString());
                    }
                    else
                    {
                    System.out.println("no song available,reached to end of list");
                    forward = false;
                    }
                break;
            case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();

                        }
                        forward=false;

                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("now playing"+listIterator.previous().toString());
                    }else{
                        System.out.println("we are at first song");
                        forward=false;
                    }
                    break;
                    

            case 3:
                if(forward)
                {
            
                    if(listIterator.hasPrevious())
                    {
                    System.out.println(("now playing")+listIterator.previous().toString());
                        forward = false;
                    }
                     else 
                    {
                    System.out.println("we are at the start of list");
                    }

                }
                else{
                    if(listIterator.hasNext()){
                        System.out.println("now playing"+listIterator.next().toString());
                        forward=true;
                    }else{
                        System.out.println("we reached to end of list");
                    }
                }
                break;

            case 4:
                printList(playList);
                break;
            case 5:
                printMenu();;
                break;
            case 6:
                if(playList.size()>0){
                    listIterator.remove();
                    if(listIterator.hasNext()){
                        System.out.println("now playing"+listIterator.next().toString());
                        forward=true;                    }
                }else{
                    if(listIterator.hasPrevious())
                    System.out.println("now playing"+listIterator.previous().toString());
                }
            
        }
    
    }}
    private static void printMenu(){
        System.out.println("avaiable options\n press");
        System.out.println("0 - to quit\n"+
                            "1 - to play next song\n"+
                            "2 - to replay the previous song\n"+
                            "3 - to replay the current song"+
                            "4 - list of all songs\n"+
                            "5 - print all available options\n"+
                            "6 - delete current song\n");
    }
    private static void printList(LinkedList<song> playList){
        Iterator<song> iterator = playList.iterator();
        System.out.println("_______________________");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("_____________________");

    }  
}
