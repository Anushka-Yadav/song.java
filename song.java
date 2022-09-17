
public class song{
    
    String title;
    double duration;
    public song(String title,double duration){
        this.title = title;
        this.duration = duration;
    }
public song(){

}
public String getTitle(){
    return title;
}
public double getDuration(){
    return duration;
}
public String toString(){
    return "Song{itle : "+title+",duration : "+duration+"}";
}

}
