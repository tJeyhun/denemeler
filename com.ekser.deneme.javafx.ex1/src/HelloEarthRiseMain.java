import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import javafx.scene.GroupBuilder;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.shape.RectangleBuilder;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Main class for the "Hello World" style example
 */
public class HelloEarthRiseMain extends Application {
	/**
	 * @param args
	 *            the command-line arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		String message = "Earthrise at Christmas: "
				+ "[Forty] years ago this Christmas, a turbulent world "
				+ "looked to the heavens for a unique view of our home "
				+ "planet. This photo of Earthrise over the lunar horizon "
				+ "was taken by the Apollo 8 crew in December 1968, showing "
				+ "Earth for the first time as it appears from deep space. "
				+ "Astronauts Frank Borman, Jim Lovell and William Anders "
				+ "had become the first humans to leave Earth orbit, "
				+ "entering lunar orbit on Christmas Eve. In a historic live "
				+ "broadcast that night, the crew took turns reading from "
				+ "the Book of Genesis, closing with a holiday wish from "
				+ "Commander Borman: \"We close with good night, good luck, "
				+ "a Merry Christmas, and God bless all of you -- all of "
				+ "you on the good Earth.\"";

		// Reference to the Text
		Text textRef = TextBuilder.create().layoutY(100).textOrigin(VPos.TOP)
				.textAlignment(TextAlignment.JUSTIFY).wrappingWidth(400)
				.text(message).fill(Color.rgb(187, 195, 107))
				.font(Font.font("SansSerif", FontWeight.BOLD, 24)).build();
		// Provides the animated scrolling behavior for the text
		TranslateTransition transTransition = TranslateTransitionBuilder
				.create().duration(new Duration(75000)).node(textRef).toY(-820)
				.interpolator(Interpolator.LINEAR)
				.cycleCount(Timeline.INDEFINITE).build();
		Scene scene = SceneBuilder
				.create()
				.width(516)
				.height(387)
				.root(GroupBuilder
						.create()
						.children(
								ImageViewBuilder
										.create()
										.image(new Image(
												"http://projavafx.com/images/earthrise.jpg"))
										.build(),
								GroupBuilder
										.create()
										.layoutX(50)
										.layoutY(180)
										.children(textRef)
										.clip(RectangleBuilder.create()
												.width(430).height(85).build())
										.build()).build()).build();
		stage.setScene(scene);
		stage.setTitle("Hello Earthrise");
		stage.show();
		// Start the text animation
		transTransition.play();
	}
}