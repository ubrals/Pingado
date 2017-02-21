package media;
///
// adaptado de:
// https://blogs.oracle.com/javafx/entry/mpeg_4_multimedia_support_in
//
// ver depois:
// http://docs.oracle.com/javafx/2/threads/jfxpub-threads.htm

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.Track;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * A sample media player which loops indefinitely over the same video
 */
public class MiguelMediaPlayer extends Application {
//    private static final String MEDIA_URL = "file://Users/ubrals/git/Pingado/Cm7aiyWWIAE4K7k.mp4";
//    private static final String MEDIA_URL = "/Users/ubrals/git/Pingado/Cm7aiyWWIAE4K7k.mp4";
    private static final String MEDIA_URL = "http://pvbps-sambavideos.akamaized.net/account/259/21/2017-02-17/video/cab7acff8fb3e1233254e21449a626f9/cab7acff8fb3e1233254e21449a626f9_360p.mp4";
    
    private static String arg1;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Miguel Media Player");

        // Create media player
        Media media = new Media((arg1 != null) ? arg1 : MEDIA_URL);
        javafx.scene.media.MediaPlayer mediaPlayer = new javafx.scene.media.MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
        
        /////
        Duration d = mediaPlayer.getCurrentTime();
        /////
        
        // Print track and metadata information
        media.getTracks().addListener(new ListChangeListener<Track>() {
            public void onChanged(Change<? extends Track> change) {
                System.out.println("Track> "+change.getList());
                //////
                while(mediaPlayer.getCurrentTime().toMillis() <= mediaPlayer.getTotalDuration().toMillis())
                    System.out.println(d.toMillis());
                //////
            }
        });
        media.getMetadata().addListener(new MapChangeListener<String,Object>() {
            public void onChanged(MapChangeListener.Change<? extends String, ? extends Object> change) {
                System.out.println("Metadata> "+change.getKey()+" -> "+change.getValueAdded());
                //////
                while(mediaPlayer.getCurrentTime().toMillis() <= mediaPlayer.getTotalDuration().toMillis())
                    System.out.println(d.toMillis());
                /////
            }
        });

        // Add media display node to the scene graph
        MediaView mediaView = new MediaView(mediaPlayer);
        Group root = new Group();
        Scene scene = new Scene(root,800,600);
        root.getChildren().add(mediaView);
        stage.setScene(scene);
        stage.show();
        while(mediaPlayer.getCurrentTime().toMillis() <= mediaPlayer.getTotalDuration().toMillis())
            System.out.println(d.toMillis());
    }
    
    public static void main(String[] args) {
        if (args.length > 0) {
            arg1 = args[0];
        }
        Application.launch(args);
    }
}
