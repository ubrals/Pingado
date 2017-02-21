package media;
///
// adaptado de:
// http://aprendendo-javafx.blogspot.com.br/2012/07/tocando-audio-e-video.html

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class TocandoVideo extends Application {

// private String VIDEO_URL = getClass().getResource(
//   "http://pvbps-sambavideos.akamaized.net/account/259/21/2017-02-17/video/cab7acff8fb3e1233254e21449a626f9/cab7acff8fb3e1233254e21449a626f9_360p.mp4").toString();
    private String VIDEO_URL = "http://pvbps-sambavideos.akamaized.net/account/259/21/2017-02-17/video/cab7acff8fb3e1233254e21449a626f9/cab7acff8fb3e1233254e21449a626f9_360p.mp4".toString();

 public static void main(String[] args) {
  launch();
 }

 @Override
 public void start(Stage palco) throws Exception {

  Media media = new Media(VIDEO_URL); // 1
  MediaPlayer mediaPlayer = new MediaPlayer(media); // 2
  MediaView mediaView = new MediaView(mediaPlayer); // 3

  StackPane raiz = new StackPane();
  raiz.getChildren().add(mediaView); // 4
  Scene cena = new Scene(raiz, 600, 400);
  palco.setTitle("Tocando Video em JavaFX");
  palco.setScene(cena);
  palco.show();

  mediaPlayer.play(); // 4
 }
}
