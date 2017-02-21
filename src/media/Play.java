package media;
///
// adaptado de
// https://en.wikipedia.org/wiki/Java_Media_Framework
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;

import javafx.scene.media.*;

public class Play extends Frame {
    public static void main(String args[]){
//        javafx.scene.media.Media media = new javafx.scene.media.Media("./Cm7aiyWWIAE4K7k.mp4");
        
        try {
            Frame f = new Play();
            f.pack();
            f.setVisible(true);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public Play()
    throws java.io.IOException
    ,      java.net.MalformedURLException
    ,      javafx.scene.media.MediaException
    {
//        FileDialog fd = new FileDialog(this, "Play", FileDialog.LOAD);
//        fd.setVisible(true);
//        File f = new File(fd.getDirectory(), fd.getFile());
        javafx.scene.media.Media m = new javafx.scene.media.Media("/Users/ubrals/git/Pingado/Cm7aiyWWIAE4K7k.mp4");
        javafx.scene.media.MediaPlayer p;
//        p = new MediaPlayer(m);
//        p = javafx.scene.media.MediaPlayerBuilder.create();
        
        Component c;
        
//        add(p);
//        Player p = Manager.createRealizedPlayer
    }
}
