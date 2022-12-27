package com.example.demo3;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.net.URL;
import java.util.*;

import javafx.scene.Group;
import javafx.scene.paint.Color;


public class Game extends Application implements Initializable, Serializable {

    private Hero hero;

    @FXML
    private Rectangle rect;
    Group root = new Group();

    @FXML
    private Label location;

    private int loc;

    @FXML
    private Label coins;

    @FXML
    private TextField namefield;

    private Group objects;

    HashMap<Integer,String> objs=new HashMap<>();
    ArrayList<Object> obj=new ArrayList<>();
    public final double[] count = {0,0,0};

    public Game game;
    public static ImageView background;
    private int flag=0;

    private void move(Scene scene, Group objects, Rectangle rect) {

       // Node Hero= scene.lookup("#rect");

        //B.getChildren().add(Hero);
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                TranslateTransition transition=new TranslateTransition();
                transition.setByX(-105);
                transition.setDuration(Duration.seconds(0.1));
                //transition.setCycleCount(Animation.INDEFINITE);
                transition.setNode(objects);
                transition.play();
                /*
                count[0]++;
                location.setText(Integer.toString(count[0]));
                //Bounds boundsInScene = node.localToScene(node.getBoundsInLocal());
                //rect;
                /*
                Bounds bounds = rect.localToScreen(rect.getBoundsInLocal());
                //System.out.println(bounds.getMaxX());

                for(int i=0;i<objects.getChildren().size();i++) {
                    if (bounds.intersects(objects.getChildren().get(i).localToScreen(objects.getChildren().get(i).getBoundsInLocal()))) {
                        System.out.println(obj.get(i));
                    }
                }
                /*for(int i=0;i<objects.getChildren().size();i++) {
                    System.out.println(objects.getBoundsInParent().intersects(rect.));
                }*/
            }
        });
    }

    private Group add_coins(double x) {
        Group coins=new Group();
        ImageView coin1 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\resources\\Coin.jpg", 50, 50, false, true));
        ImageView coin2 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\resources\\Coin.jpg", 50, 50, false, true));
        ImageView coin3 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\resources\\Coin.jpg", 50, 50, false, true));
        coins.getChildren().add(coin1);
        coin1.setX(x);
        coin2.setX(coin1.getX()+60);
        coin3.setX(coin2.getX()+60);
        coins.getChildren().add(coin2);
        coins.getChildren().add(coin3);
        coins.setLayoutY(100);
        return coins;
    }

    private AnchorPane saveme_ta;
    private AnchorPane game_over_pane;
    private Button saveme;

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        game=new Game();

        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("Game.fxml"));
        AnchorPane pane =fxmlLoader.load();
        rect=(Rectangle)pane.getChildren().get(1);
        saveme_ta=(AnchorPane)pane.getChildren().get(9);
        game_over_pane=(AnchorPane)pane.getChildren().get(16);
        saveme=(Button)((AnchorPane)pane.getChildren().get(9)).getChildren().get(1);
        namefield=(TextField) ((AnchorPane)pane.getChildren().get(2)).getChildren().get(2);
        sp=(Button)((AnchorPane)pane.getChildren().get(14)).getChildren().get(2);
        resume=(Button)((AnchorPane)((AnchorPane)pane.getChildren().get(11)).getChildren().get(1)).getChildren().get(0);
        String player_name=namefield.getText();

        hero=new Hero(rect,player_name);

        coins=(Label)pane.getChildren().get(10);
        coins.setText(Integer.toString(hero.get_coins()));
        background=new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\clouds.jpg",900,630,false,true));

        location=new Label("0");
        location.setLayoutX(450);
        location.setLayoutY(50);

        location.setTextFill(Color.BLACK);

        location.setFont(Font.font("Palatino Linotype Bold",30));
        location.setStyle("-fx-font-weight: bold");



        objects=new Group();

        double k=10;

        Random random=new Random();
            int i;
            for ( i = 0; i < 27; i++) {
                //ImageView platform = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\platforms.gif", 300, 100, false, true));
                //ImageView platform=new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\main\\images\\Islands"+(i+1)+".png"));
                Platform platform =new Platform();

                if(i!=0) {
                    int r1 = random.nextInt(3);
                    if (r1 == 0) {
                        //platform.setScaleX(1.25);
                        platform.setY(350);
                    } else if (r1 == 1) {
                        platform.setY(300);
                    } else {
                        platform.setY(400);
                    }
                }
                else platform.setY(350);

                platform.setX(k);
                //k+=600+(50*j);
                objects.getChildren().add(platform.get_image());
                obj.add(platform);
                objs.put(i, "platform" + (i + 1));

                ImageView tree1 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\Tree4.png", 150, 200, false, true));
                tree1.setX(k + 130);
                tree1.setY(platform.getY() - 200);
                objects.getChildren().add(tree1);
                obj.add("tree1x"+(k + 130)+"y"+(platform.getY() - 200));
                objs.put(i, "tree1" + (i + 1));

                ImageView tree2 = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\Tree2.png", 30, 75, false, true));
                tree2.setX(k+20);
                tree2.setY(platform.getY() - 75);
                objects.getChildren().add(tree2);
                obj.add("tree2x"+(k + 20)+"y"+(platform.getY() - 75));
                objs.put(i, "tree2" + (i + 1));

                if(i!=0) {

                    int r2 = random.nextInt(4);

                    if (i % 4 == 0 && r2!=2 && i%12!=0) {

                        ImageView windmill = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\windmill.png", 75, 150, false, true));
                        windmill.setX(k + 160);
                        windmill.setY(platform.getY() - 150);
                        objects.getChildren().add(windmill);
                        obj.add("windmill");
                        objs.put(i, "windmill" + (i + 1));
                        Fan fan=new Fan(k + 100,platform.getY() - 225);
                        objects.getChildren().add(fan.getImage());
                        obj.add(fan);
                        objs.put(i, "fan" + (i + 1));

                        tree1.setOpacity(0);
                        tree2.setOpacity(0);
                        if (i % 12 == 0) {
                            windmill.setX(k + 160);
                        }
                        if ((r2 == 1 || r2==0) && i % 12 == 0) {
                            windmill.setY(platform.getY() - 210);
                        }
                        Group coins=add_coins(platform.getX());
                        Coin c=new Coin(coins);
                        objects.getChildren().add(coins);
                        obj.add(c);
                    }
                        //int r2=0;
                        if (r2 == 0) {
                            tree2.setOpacity(0);
                            if (i % 12 == 0) {
                                platform.get_image().setScaleX(1.5);
                                platform.get_image().setScaleY(1.25);

                                GreenOrc green_orc=new GreenOrc(k + 10,platform.getY() - 60);
                                /*
                                ImageView green_orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\green orc.jpg", 50, 50, false, true));
                                green_orc.setX(k + 10);
                                green_orc.setY(platform.getY() - 60);

                                 */
                                objects.getChildren().add(green_orc.get_image());
                                obj.add(green_orc);
                                objs.put(i, "green_orc" + (i + 1));
                            } else {
                                GreenOrc green_orc=new GreenOrc(k + 80,platform.getY() - 50);
                                objects.getChildren().add(green_orc.get_image());
                                obj.add(green_orc);
                                objs.put(i, "green_orc" + (i + 1));

                                /*
                                ImageView green_orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\green orc.jpg", 50, 50, false, true));
                                green_orc.setX(k + 80);
                                green_orc.setY(platform.getY() - 50);
                                objects.getChildren().add(green_orc);
                                obj.add("green_orc");
                                objs.put(i, "green_orc" + (i + 1));

                                 */
                            }
                        } else if (r2 == 1) {

                            tree2.setOpacity(0);

                            if (i % 12 == 0) {
                                platform.get_image().setScaleX(1.5);
                                platform.get_image().setScaleY(1.25);

                                RedOrc red_orc=new RedOrc(k + 10,platform.getY() - 60);
                                objects.getChildren().add(red_orc.get_image());
                                obj.add(red_orc);
                                objs.put(i, "red_orc" + (i + 1));
                                /*
                                ImageView red_orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\redorc.jpg", 50, 50, false, true));
                                red_orc.setX(k + 10);
                                red_orc.setY(platform.getY() - 60);
                                objects.getChildren().add(red_orc);
                                obj.add("red_orc");
                                objs.put(i, "red_orc" + (i + 1));

                                 */
                            } else {
                                RedOrc red_orc=new RedOrc(k + 80,platform.getY() - 50);
                                objects.getChildren().add(red_orc.get_image());
                                obj.add(red_orc);
                                objs.put(i, "red_orc" + (i + 1));
                                /*
                                ImageView red_orc = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\redorc.jpg", 50, 50, false, true));
                                red_orc.setX(k + 80);
                                red_orc.setY(platform.getY() - 50);
                                objects.getChildren().add(red_orc);
                                obj.add("red_orc");
                                objs.put(i, "red_orc" + (i + 1));

                                 */
                            }
                        }
                        else if(r2==2 && i%4==0 && i%3!=0) {

                            TNT tnt=new TNT(k+60,platform.getY() - 70);
                            objects.getChildren().add(tnt.get_image());
                            obj.add(tnt);
                            objs.put(i, "tnt" + (i + 1));
                        }

                        else if (i % 3 != 0) {
                            CoinChest coin_chest=new CoinChest(k + 150,platform.getY() - 75, 20*i);
                            objects.getChildren().add(coin_chest.get_image());

                            /*
                            ImageView coin_chest = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\coin chest.jpg", 100, 75, false, true));
                            coin_chest.setX(k + 150);
                            coin_chest.setY(platform.getY() - 75);
                            objects.getChildren().add(coin_chest);

                             */
                            obj.add(coin_chest);
                            objs.put(i, "coin_chest" + (i + 1));

                            tree1.setOpacity(0);
                            if (i % 4 == 0) {
                                coin_chest.get_image().setX(k + 110);
                            }
                        }
                        if (i % 3 == 0) {
                            WeaponChest weapon_chest=new WeaponChest(k + 160,platform.getY() - 75);
                            objects.getChildren().add(weapon_chest.get_image());

                            /*
                            ImageView weapon_chest = new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\weapon chest.gif", 100, 75, false, true));
                            weapon_chest.setX(k + 160);
                            weapon_chest.setY(platform.getY() - 75);
                            objects.getChildren().add(weapon_chest);

                             */
                            obj.add(weapon_chest);
                            objs.put(i, "weapon_chest" + (i + 1));

                            tree1.setOpacity(0);
                            if (i % 12 == 0) {
                                weapon_chest.get_image().setX(k + 110);
                            }
                            if (i % 12 == 0 && (r2 == 1 || r2==0)) {
                                weapon_chest.get_image().setY(platform.getY() - 85);
                            }
                        }

                }
                k = platform.get_image().getLayoutBounds().getMaxX() + 100;
            }

        Platform platform = new Platform();
        platform.get_image().setLayoutX(10710);
        platform.get_image().setFitWidth(1500);
        platform.get_image().setY(350);
        objects.getChildren().add(platform.get_image());
        obj.add(platform);
        objs.put(i+1, "boss_platform");

        TNT tnt=new TNT(10950,275);
        objects.getChildren().add(tnt.get_image());
        obj.add(tnt);
        objs.put(i, "tnt" + (i + 1));

        BossOrc boss_orc=new BossOrc(11235,platform.get_image().getY() - 200);
        objects.getChildren().add(boss_orc.get_image());
        obj.add(boss_orc);
        objs.put(i+2, "orc_boss");




        Group A=new Group();
        A.getChildren().add(background);
        A.getChildren().add(location);
        A.getChildren().add(objects);
        A.getChildren().add(pane);

        Group B =new Group();

        flag=1;
        System.out.println(flag);

        System.out.println(obj);
        setupTimeline();

        Scene scene=new Scene(A,900,630);

        move(scene,objects,rect);
        gravity(hero);

        stage.setScene(scene);
        stage.setTitle("Will Hero!");
        stage.setResizable(false);
        stage.show();

    }

    public Group getObjects() {return objects;}

    public void setupTimeline(){
        KeyFrame kf = new KeyFrame(Duration.millis(20), new CollideHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    int check=0;
    private class CollideHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event) {
            Bounds bounds = rect.localToScreen(rect.getBoundsInLocal());
            //System.out.println(bounds.getMaxY());

            if(bounds.getMaxY()>500) {
                hero.set_life_status("dead");

            }
            if(sp.getScaleX()==1.1 && flag!=5) {
                flag=5;
                try {
                    Serialize();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    SerializeHero();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(resume.getScaleX()==1.1 && flag!=7) {
                flag=7;
                try {
                    Serialize();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    SerializeHero();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for(int j=0;j<objects.getChildren().size();j++) {
                if(hero.get_life_status().equals("alive")) {
                    if(!((BossOrc)obj.get(obj.size()-1)).isAlive() && check!=5) {
                        game_over();
                        check=5;
                    }
                    else if (!(obj.get(j) instanceof String) && bounds.intersects(objects.getChildren().get(j).localToScreen(objects.getChildren().get(j).getBoundsInLocal()))) {
                        //System.out.println(obj.get(j));
                        if (obj.get(j) instanceof TNT || obj.get(j) instanceof Orc && ((Orc) obj.get(j)).isAlive() || obj.get(j) instanceof TreasureChest && ((TreasureChest) obj.get(j)).isAlive()) {
                            TranslateTransition trans = new TranslateTransition();
                            trans.setDuration(Duration.seconds(0.01));
                            //System.out.println(rect.getX());
                            trans.setByX(100);

                            //trans.setAutoReverse(reverse);
                            trans.setCycleCount(1);
                            //-1 for indefinite
                            trans.setNode(objects);
                            trans.play();
                        }
                        if(obj.get(j) instanceof Coin) {
                            if(((Coin) obj.get(j)).getGroup().getOpacity()!=0) {
                                hero.update_coins(hero.get_coins() + 3);
                                ((Coin) obj.get(j)).getGroup().setOpacity(0);
                            }
                        }
                        else {
                            ((Game_Objects) obj.get(j)).collide(hero);
                        }

                        count[1] = objects.getTranslateX();
                        location.setText((Integer.toString((int) ((-1) * count[1] / 105))));
                        coins.setText(Integer.toString(hero.get_coins()));
                    }
                }
                else if(check==0){
                    resurrect();
                    check=1;
                }
                //else if(check==3) System.out.println("goo");
                else if(saveme.getScaleX()==1.1) {
                    //hero.set_life_status("alive");
                    check=2;
                }
            }
        }
    }


    public void gravity(Hero h) {
        AnimationTimer timer= new AnimationTimer() {
            double mytime=0.05;
            int dir=1;
            double velocity_Y=0;
            double damp=0.7;

            final double gravity=9.8;
            double previous_Velocity=0;
            int counter=0;


            @Override
            public void handle(long l) {

                counter++;
                double currX = rect.getLayoutX();
                double currY = rect.getLayoutY();
                velocity_Y += gravity * 0.5 * mytime * mytime;
                double deltaY = velocity_Y;
                double deltaX = 0;
                double newX = currX + deltaX;
                double newY = currY + deltaY;
                //  hitspace=true;
                if (h.getHitPlatform()) {
                    velocity_Y = -10;
                    mytime = 0.13;
                    h.setHitPlatform(false);
                }


                rect.relocate(newX, newY);


                previous_Velocity = velocity_Y;
                mytime += 0.005;

                if(check==2 && hero.get_life_status().equals("dead")) {
                    rect.relocate(50,50);
                    hero.set_life_status("alive");
                    check=3;
                }

            }
        };
        timer.start();

    }

    private void game_over() {
        trans=new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        System.out.println("hii");
        trans.setByY(-1000);


        trans.setCycleCount(1);
        //-1 for indefinite
        trans.setNode(game_over_pane);
        trans.play();
    }

    public Hero getHero() {return this.hero;}

    public ArrayList<Object> getGameObjects() {
        return this.obj;
    }

    public static void main(String[] args) {
        launch();
    }


    // Game Controller
    //@FXML
    //private Label location;

    @FXML
    private AnchorPane saveme_tab;

    @FXML
    private AnchorPane menu_settings;

    @FXML
    private AnchorPane menu;

    @FXML
    private AnchorPane bg;

    @FXML
    private AnchorPane save_progress_prompt;


    TranslateTransition trans= new TranslateTransition();

    @FXML
    private Button btn;

    //@FXML
    //Rectangle rect;
    @FXML
    AnchorPane name;

    private void move(Scene scene, Group objects) {
        final int[] count = {0};
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                TranslateTransition transition=new TranslateTransition();
                transition.setByX(-105);
                transition.setDuration(Duration.seconds(0.1));
                //transition.setCycleCount(Animation.INDEFINITE);
                transition.setNode(objects);
                transition.play();
                count[0]++;
                location.setText(Integer.toString(count[0]));
            }
        });
    }

    public void initialize(URL url, ResourceBundle rb){
        //code
        //rect.setX(50);
        //rect.setY(250);
        //ImageView I=new ImageView(new Image("C:\\Users\\dahuj\\IdeaProjects\\Will_Hero_118\\demo3\\src\\hero.gif",50,50,false,true));

        flag=2;
        System.out.println(flag);
        rect.setFill(new ImagePattern(new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("hero.gif"),50,50,false,true)));
    }



    private void translate(Rectangle r, boolean reverse, double duration,int count){

        trans.setDuration(Duration.seconds(duration));
        //System.out.println(rect.getX());
        trans.setToY(r.getX()-150);

        trans.setAutoReverse(reverse);
        trans.setCycleCount(count);
        //-1 for indefinite
        trans.setNode(r);
        trans.play();
    }



    @FXML
    Button save;

    @FXML
    Button sp;

    @FXML
    Button save_progress_btn;

    @FXML
    Button resume;

    @FXML
    Button quit;

    //if hero.getstatus==dead-> call saveme


    @FXML
    private void resurrect(){
        trans=new TranslateTransition();
        trans.setDuration(Duration.seconds(1));
        System.out.println("hii");
        trans.setByY(-700);


        trans.setCycleCount(1);
        //-1 for indefinite
        trans.setNode(saveme_ta);
        trans.play();

    }

    @FXML
    private void reset() {
        trans=new TranslateTransition();
        trans.setDuration(Duration.seconds(1));
        System.out.println("hii");
        trans.setByY(700);


        trans.setCycleCount(1);
        //-1 for indefinite
        trans.setNode(saveme_tab);
        trans.play();

        save.setScaleX(1.1);
    }


    @FXML
    private void saveme(){
        trans=new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        //System.out.println(rect.getX());
        trans.setToY(menu.getLayoutY()-450);


        trans.setCycleCount(1);
        //-1 for indefinite
        trans.setNode(saveme_tab);
        trans.play();


    }

    @FXML
    private void settings_menu(){
        trans=new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        System.out.println("settings");
        trans.setByY(-900);


        trans.setCycleCount(1);
        //-1 for indefinite
        trans.setNode(menu_settings);
        trans.play();

    }


    @FXML
    private void play(ActionEvent event){
        menu.setOpacity(0);
        btn.setOpacity(0);

        trans.setDuration(Duration.seconds(0.5));
        System.out.println(111);
        trans.setByY(500);
        //-1 for indefinite
        trans.setNode(menu);
        trans.play();

        playernameslide();
    }


    private void playernameslide() {


        trans=new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        System.out.println(111);
        trans.setByY(-500);
        //-1 for indefinite
        trans.setNode(name);
        trans.play();

    }

    @FXML
    private void startgame() {
        String player_name=namefield.getText();
        System.out.println(player_name);
        name.setOpacity(0);



    }

    @FXML
    private AnchorPane help;

    @FXML
    private void switch_to_help(ActionEvent event) throws IOException {

        trans=new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        trans.setByY(-1100);
        //-1 for indefinite
        trans.setNode(help);
        trans.play();
    }

    private void go_down(AnchorPane pane) {

        trans=new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        System.out.println(111);
        trans.setByY(1000);
        //-1 for indefinite
        trans.setNode(pane);
        trans.play();
    }

    @FXML
    private Button menu_settings_cross;

    @FXML
    private Button menu_settings_cross1;

    @FXML
    private Button menu_cross1;

    @FXML
    private void menu_down(ActionEvent event) {
        if(event.getSource()==menu_settings_cross)
        {
            go_down(menu_settings);
        }
        if(event.getSource()==menu_settings_cross1)
        {
            go_down(help);
        }
        if(event.getSource()==menu_cross1)
        {
            go_down(save_progress_prompt);
        }
        event.consume();
    }

    @FXML
    private void exit() {
        System.exit(0);
    }

    @FXML
    private void save_progress() throws IOException {
        System.out.println(obj);
        flag=3;
        sp.setScaleX(1.1);


        trans=new TranslateTransition();
        trans.setDuration(Duration.seconds(0.5));
        System.out.println(111);
        trans.setByY(1000);
        //-1 for indefinite
        trans.setNode(menu_settings);
        trans.play();
    }

    @FXML
    private void save_progress_menu() {

        TranslateTransition trans1 = new TranslateTransition();
        trans1.setDuration(Duration.seconds(0.5));
        System.out.println(111);
        trans1.setByY(-500);
        //-1 for indefinite
        trans1.setNode(save_progress_prompt);
        trans1.play();
        menu_settings.setOpacity(0);



    }


    @FXML
    private void resume_game() {
        resume.setScaleX(1.1);
    }

    public void Serialize() throws IOException {
        System.out.println(flag);
        obj=getGameObjects();
        ObjectOutputStream out = null;
        out =  new ObjectOutputStream(new FileOutputStream("out.txt"));
        try{
            Iterator<Object> i = obj.iterator();
            while(i.hasNext()) {
                try{
                    out.writeObject(i.next());
                    //System.out.println("yay");
                }
                catch(NotSerializableException e) {
                    System.out.println(i.next());
                    System.out.println("NOT SERIALIZABLE");
                }
                catch(NullPointerException e) {
                    System.out.println("OBJECT NOT INITIALIZED");
                }
            }
        }
        finally {
            out.close();
        }
    }

    public void SerializeHero() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("hero.txt"));
            try {
                out.writeObject(hero);
                //System.out.println(hero.get_coins());
            }
            catch (NullPointerException e) {
                System.out.println("PLAYER NOT INITIALIZED");
            }
        }finally {
            out.close();
        }
    }

}
