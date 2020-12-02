package lehigh;



import processing.core.PApplet;

import java.util.ArrayList;


public class MovingBalls extends PApplet {
    class Ball {
        int x, y, radius;
        float speedx, speedy;
        float[] color;


        Ball() {
            radius = (int) random(20, 40);
            x = (int) random(radius, width - radius);
            y = (int) random(radius, width - radius);
            speedx = random((float) 0.8, 1.5f)  ;
            speedy = random((float) 0.8, 1.5f)  ;
            color = new float[]{random(255), random(255), random(255)};
        }


        public void move() {
            for (Ball ball : balls) {
                fill(ball.color[0], ball.color[1], ball.color[2]);
                ellipse(ball.x, ball.y, ball.radius, ball.radius);
                if (ball.x > (width - ball.radius) || ball.x < ball.radius){
                    ball.speedx = -ball.speedx;
                }

                if (ball.y > (height - ball.radius) || ball.y < ball.radius){
                    ball.speedy = -ball.speedy;
                }

                ball.x += ball.speedx;
                ball.y += ball.speedy;

            }


        }
    }


        ArrayList<Ball> balls;


        public void settings() {
            size(500, 500);
            balls = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                balls.add(new Ball());
            }
        }


        public void draw() {
            background(0);

            for (Ball ball : balls) {
                ball.move();
            }

        }

    public void mouseClicked() {
        for (int i = 0; i < 100; i++) {
            if (balls.get(i).x - balls.get(i).radius < mouseX && mouseX < balls.get(i).x + balls.get(i).radius
                    && balls.get(i).y - balls.get(i).radius < mouseY && mouseY < balls.get(i).y + balls.get(i).radius) {
                balls.get(i).speedx += 10;
                balls.get(i).speedy += 10;
            }
        }
    }


        public static void main(String[] args) {
            String[] processingArgs = {"MovingBalls"};
            MovingBalls movingBalls = new MovingBalls();
            PApplet.runSketch(processingArgs, movingBalls);
        }

    }





