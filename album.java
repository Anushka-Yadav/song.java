import java.util.ArrayList;
import java.util.LinkedList;
public class album 
{
    private String name;
    private String artist;
    private ArrayList<song> songs;

    public album(String name,String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<song>();
    }
    public album(){

    }
    public song findSong(String title)
    {
        for(song checkedSong :songs)
        {
            if(checkedSong.getTitle().equals(title))
            return checkedSong;
        }
        return null;
    }
    public boolean addsong(String title,double duration)
    {
        if(findSong(title) == null)
        {
            songs.add(new song(title,duration));
            System.out.println(title+"sucessfully added to list");
            return true;

        }
        else
        {
            System.out.println("song with namr"+title+"already exist in list");
            return false;
        }
    }
    public boolean addToPlaylist( int tracknumber,LinkedList<song> PlayList)
    {
        int index = tracknumber - 1;
        if(index>0 && index<=this.songs.size())
        {
            PlayList.add((this.songs.get(index)));
            return true;
        }
        System.out.println("song does not on track"+tracknumber);
        return false;
    }
    public boolean addToPlaylist(String title, LinkedList<song> playList)
    {
        for(song checkedSong:this.songs)
        {
            if(checkedSong.getTitle().equals(title)){
                playList.add(checkedSong);
            return true;
        }
        }
        System.out.println("no such song  found");
        return false;
        
    }
}
  

