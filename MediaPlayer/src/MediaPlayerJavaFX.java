import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;

/**
 * Created by johny on 17.12.15.
 * Class have responsibility to create functionality and logic of Media Player FX
 */
public class MediaPlayerJavaFX extends Application {

    String currentMovie = null;

    Stage window;
    Stage windowFromWeb;

    Media media;
    MediaPlayer player;
    MediaView view;

    //Movie control
    Button prevMovie;
    Button nextMovie;
    Button playMovie;
    Button pauseMovie;
    Button stopMovie;

    //Playlist
    Label playListTitle;
    ListView<String> moviePlaylist;
    Button addToPlayListFromWeb;
    Button addToPlayListFromFile;

    //hot keys combination
    final KeyCombination hotPrev = new KeyCodeCombination(KeyCode.LEFT, KeyCombination.CONTROL_DOWN);
    final KeyCombination hotStop = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
    final KeyCombination hotPlay = new KeyCodeCombination(KeyCode.G, KeyCombination.CONTROL_DOWN);
    final KeyCombination hotPause = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
    final KeyCombination hotNext = new KeyCodeCombination(KeyCode.RIGHT, KeyCombination.CONTROL_DOWN);
    final KeyCombination hotAddFile = new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN);
    final KeyCombination hotAddUrl = new KeyCodeCombination(KeyCode.U, KeyCombination.CONTROL_DOWN);


    /**
     * Create the UI of Media Player FX
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Movie Player");

        Media media = new Media("file:///home/johny/MediaPlayer/Playlist/batman.mp4");
        //Media media = new Media("http://127.0.0.1:8000/god.mp4");
        player = new MediaPlayer(media);
        view = new MediaView(player);


        HBox mainLayout = new HBox();

        VBox moviePanel = new VBox();

        //Movie controls
        HBox movieControl = new HBox();
        movieControl.setSpacing(20);
        movieControl.setAlignment(Pos.CENTER);


        prevMovie = new Button("Prev");
        prevMovie.setPadding(new Insets(20, 20, 20, 20));
        prevMovie.setOnAction(e -> prevMovieClicked());

        stopMovie = new Button("Stop");
        stopMovie.setPadding(new Insets(20, 20, 20, 20));
        stopMovie.setOnAction(e -> player.stop());

        playMovie = new Button("Play");
        playMovie.setPadding(new Insets(30, 30, 30, 30));
        playMovie.setOnAction(e -> playClicked());

        pauseMovie = new Button("Pause");
        pauseMovie.setPadding(new Insets(20, 20, 20, 20));
        pauseMovie.setOnAction(e -> player.pause());

        nextMovie = new Button("Next");
        nextMovie.setPadding(new Insets(20, 20, 20, 20));
        nextMovie.setOnAction(e -> nextMovieClicked());

        movieControl.getChildren().addAll(prevMovie, stopMovie, playMovie, pauseMovie, nextMovie);

        moviePanel.getChildren().addAll(view, movieControl);


       //Playlist controls
        VBox playListLayout = new VBox();
        playListLayout.setAlignment(Pos.CENTER);

        playListTitle = new Label();
        playListTitle.setTextAlignment(TextAlignment.CENTER);
        playListTitle.setAlignment(Pos.CENTER);
        playListTitle.setText("Play list");
        playListTitle.setFont(new Font(30));

        moviePlaylist = new ListView<String>();
        moviePlaylist.setPrefWidth(350);
        moviePlaylist.setPrefHeight(390);


        HBox addToPlayList = new HBox();
        addToPlayList.setAlignment(Pos.CENTER);

        addToPlayListFromFile = new Button("add to play list from \nFILE");
        addToPlayListFromFile.setFont(new Font(14));
        addToPlayListFromFile.setTextAlignment(TextAlignment.CENTER);
        addToPlayListFromFile.setOnAction(e -> addToPlaylistFromFileClicked());

        addToPlayListFromWeb = new Button("add to play list from \nWEB");
        addToPlayListFromWeb.setFont(new Font(14));
        addToPlayListFromWeb.setTextAlignment(TextAlignment.CENTER);
        addToPlayListFromWeb.setOnAction(e -> addToPlaylistFromWebClicked());

        addToPlayList.getChildren().addAll(addToPlayListFromFile, addToPlayListFromWeb);

        playListLayout.getChildren().addAll(playListTitle, moviePlaylist, addToPlayList);

        //main layout
        mainLayout.getChildren().addAll(moviePanel, playListLayout);

        mainLayout.setSpacing(15);
        final Scene scene = new Scene(mainLayout, 1019, 465, Color.BLACK);



        //for hot keys
        scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler() {

            @Override
            public void handle(Event event) {

                if (hotPrev.match((KeyEvent) event)) {
                    prevMovieClicked();
                }
                else if(hotStop.match((KeyEvent) event))
                {
                    player.stop();
                }
                else if(hotAddFile.match((KeyEvent) event))
                {
                    addToPlaylistFromFileClicked();
                }
                else if(hotAddUrl.match((KeyEvent) event))
                {
                    addToPlaylistFromWebClicked();
                }
                else if(hotNext.match((KeyEvent) event))
                {
                    nextMovieClicked();
                }
                else if(hotPlay.match((KeyEvent) event))
                {
                    playClicked();
                }
                else if (hotPause.match((KeyEvent) event))
                {
                    player.pause();
                }
            }
            });

/*
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Width= " + newValue);
            }
        });

        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("Height= " + newValue);
            }
        });
*/
        window.setScene(scene);
        window.setResizable(false);
        window.show();

        player.play();
    }

    /**
     * Show window within text field user must put in valid url for the movie
     */
    private void addToPlaylistFromWebClicked() {
        windowFromWeb = new Stage();

        windowFromWeb.initModality(Modality.APPLICATION_MODAL);
        windowFromWeb.setTitle("Add movie from web");


        VBox fromWebLayout = new VBox();
        fromWebLayout.setAlignment(Pos.CENTER);
        fromWebLayout.setSpacing(20);

        VBox urlSelection = new VBox();

        Label askLabel = new Label("Please insert the movie url");
        askLabel.setFont(new Font(30));
        Label example = new Label("Example: http://.....someMovie.mp4");
        example.setTextFill(Color.BROWN);
        TextField urlForConnect = new TextField();

        urlSelection.getChildren().addAll(example, urlForConnect);

        Button addToPlayListUrl = new Button("Add to play list");
        addToPlayListUrl.setOnAction(e -> addUrlToPlaylistClicked(urlForConnect.getText()));

        fromWebLayout.getChildren().addAll(askLabel, urlSelection, addToPlayListUrl);

        Scene fromWebScene = new Scene(fromWebLayout, 420, 150);
        windowFromWeb.setScene(fromWebScene);
        windowFromWeb.showAndWait();
    }

    /**
     * Put in the play list with movies the new current url
     * @param url url to put in the list
     */
    private void addUrlToPlaylistClicked(String url) {
        /* How to start http local server
          cd 'the folder that we want to share'
          python -m SimpleHTTPServer
          in browser or MediaPlayer -> http://127.0.0.1:8000/god.mp4
         */
        if (url != null) {
            if(!moviePlaylist.getItems().contains(url)) {
                moviePlaylist.getItems().add(url);
                windowFromWeb.close();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Not added");
                alert.setContentText("The movie already exist");
                alert.showAndWait();
            }
        }
    }

    /**
     * Take and play the previous movie in the playlist
     */
    private void prevMovieClicked() {
        if(moviePlaylist.getItems().contains(currentMovie))
        {
            int indexOfCurFilm = moviePlaylist.getItems().indexOf(currentMovie);
            try {
                if(indexOfCurFilm == 0) {
                    throw new IndexOutOfBoundsException();
                }
                String prevMovie = moviePlaylist.getItems().get(indexOfCurFilm-1);

                Media chosenMedia = new Media(prevMovie);
                player.stop();
                player = new MediaPlayer(chosenMedia);
                view.setMediaPlayer(player);
                currentMovie = prevMovie;
                moviePlaylist.getSelectionModel().select(indexOfCurFilm - 1);
            }
            catch (IndexOutOfBoundsException iobe)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Can't play movie");
                alert.setContentText("This is the first movie");
                alert.showAndWait();
            }
            catch (Exception ex)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Can't play file");
                alert.setContentText("The movie doesn't correct file");
                alert.showAndWait();
                moviePlaylist.getItems().remove(indexOfCurFilm - 1);
            }
            player.play();
        }
    }

    /**
     * Play the movie which user chose from playlist
     */
    private void playClicked() {
        String chosenMovie = moviePlaylist.getSelectionModel().getSelectedItem();
        if(chosenMovie != null  && !chosenMovie.equals(currentMovie)) {
            System.out.println(chosenMovie);

            try {
                Media chosenMedia = new Media(chosenMovie);
                player.stop();
                player = new MediaPlayer(chosenMedia);
                view.setMediaPlayer(player);
                currentMovie = chosenMovie;
            }
            catch (Exception ex)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Can't play file");
                alert.setContentText("The movie doesn't correct file");
                moviePlaylist.getItems().remove(chosenMovie);
                alert.showAndWait();
            }
        }
        player.play();
    }

    /**
     * Take and play the next movie in the list(the movie after current)
     */
    private void nextMovieClicked() {
        if(moviePlaylist.getItems().contains(currentMovie))
        {
            int indexOfCurFilm = moviePlaylist.getItems().indexOf(currentMovie);
            try {
                if(indexOfCurFilm == moviePlaylist.getItems().size()) {
                    throw new IndexOutOfBoundsException();
                }
                String nextMovie = moviePlaylist.getItems().get(indexOfCurFilm+1);

                Media chosenMedia = new Media(nextMovie);
                player.stop();
                player = new MediaPlayer(chosenMedia);
                view.setMediaPlayer(player);
                currentMovie = nextMovie;
                moviePlaylist.getSelectionModel().select(indexOfCurFilm + 1);
            }
            catch (IndexOutOfBoundsException ioobe)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Can't select file");
                alert.setContentText("This is the last movie");
                alert.showAndWait();
            }
            catch (Exception ex)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Can't play file");
                alert.setContentText("The movie doesn't correct file");
                moviePlaylist.getItems().remove(indexOfCurFilm + 1);
                alert.showAndWait();
            }
            player.play();
        }
    }

    /**
     * The user chose file from computer and add it to playlist
     */
    private void addToPlaylistFromFileClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All MP4 Files", "*.mp4"));
        File selectedFile = fileChooser.showOpenDialog(window);
        if (selectedFile != null) {
            if(!moviePlaylist.getItems().contains("file:///"+selectedFile.getAbsoluteFile().toString())) {
                moviePlaylist.getItems().add("file:///" + selectedFile.getAbsoluteFile().toString());
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Not added");
                alert.setContentText("The movie already exist");
                alert.showAndWait();
            }
        }
    }

}
