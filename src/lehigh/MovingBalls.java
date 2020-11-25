package lehigh;

import processing.core.PApplet;


public class MovingBalls extends PApplet{
int howManyBalls = 4;
float x [] = new float[howManyBalls];
float y [] = new float[howManyBalls];
float speedx [] = new float[howManyBalls];
float speedy [] = new float[howManyBalls];
float color [][] = new float[howManyBalls][3];
int radius = 10;

    public void settings() {
        size(500, 500);

        for (int i = 0; i < howManyBalls; i++) {
            x[i] = random(radius, width - radius);
            y[i] = random(radius, width - radius);
            speedx[i] = random(5);
            speedy[i] = random(5);
            color[i] = new float[]{random(255), random(255), random(255)};

        }
    }



    public void draw(){
        background(255);
        for ( int i = 0; i < howManyBalls; i++) {
            ellipse(x[i], y[i], 50, 50);
            x[i] += speedx[i];
            y[i] += speedy[i];
            fill(color[i][0], color[i][1], color[i][2]);
            for (int j = 0; j < howManyBalls; j++) {
                float X = Math.abs(x[i] - x[j]);
                float Y = Math.abs(y[i] - y[j]);

                if ((X <= 20) || Y<= 20)
                    line(x[i], y[i], x[j], y[j]);
            }

            if (x[i] > 500 || x[i] < 0) {
                speedx[i] *= -1;
            }
            if (y[i] > 500 || y[i] < 0) {
                speedy[i] *= -1;

            }





       }

    }



        public static void main (String[]args){
            String[] processingArgs = {"MovingBalls"};
            MovingBalls movingBalls = new MovingBalls();
            PApplet.runSketch(processingArgs, movingBalls);
        }
    }





