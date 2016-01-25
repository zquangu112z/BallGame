package thuong.de.zquangu112z.ballgame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.graphics.Color;

import java.util.Random;

import thuong.de.zquangu112z.ballgame.model.Ball;

/**
 * Created by Bluerain on 8/26/15.
 */
public class MyView extends View{


    //general variety
    int scr_w;
    int scr_h;

    //mảng Ball
    Ball[] mBalls;
    int numberBall = 3;                                         //so ball

    //mảng Color
    int[] mColors = {Color.RED, Color.YELLOW, Color.GREEN};

    //private int x1 = 100, y1 = 100, sx1 = 10, sy1 = 10;

    public MyView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub

        //Init mBalls
        mBalls = new Ball[numberBall];
        for (int i = 0; i < mBalls.length; i++) {
            //color
            mBalls[i] = new Ball();
            mBalls[i].setBall_color(getRandom(mColors));
            //first dimension
            mBalls[i].setBall_x(getRandom(150, 50));
            mBalls[i].setBall_y(getRandom(400, 300));
            //radius
            mBalls[i].setBall_radius(getRandom(30, 20));
            //speed
            mBalls[i].setBall_speed_x(getRandom(30, 5));
            mBalls[i].setBall_speed_y(mBalls[i].getBall_speed_x());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        //background
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);



//        Thay code int x = getWidth();
//        int y = getHeight();
//        int radius;
//        radius = 100;

        //draw balls
        for (int i = 0; i < mBalls.length; i++) {
            mBalls[i].paint(canvas,paint);

            //tong
            ballRun();

        }

        //Log.e("-----", canvas.getHeight() + " ++ " + canvas.getWidth());
        scr_w=canvas.getWidth();scr_h=canvas.getHeight();
        invalidate();

    }
    /**
     * hit
     */
    private void ballRun() {

        hitWall();

//        for (Ball mBall : mBalls) {
//            int x = mBall.getBall_x() + mBall.getBall_speed_x();
//            mBall.setBall_x(x);
//            int y = mBall.getBall_y() + mBall.getBall_speed_y();
//            mBall.setBall_y(y);
//        }

    }

    /**
     * ball hit wall
     */
    private void hitWall() {
        for (Ball mBall : mBalls) {
            int x = mBall.getBall_x();
            if (x >= scr_w - mBall.getBall_radius()|| x <= mBall.getBall_radius()) {
                mBall.setBall_speed_x(-mBall.getBall_speed_x());
            }

            //todo : remove y
            int y = mBall.getBall_y();
            if (y >= scr_h - mBall.getBall_radius()|| y <= mBall.getBall_radius()) {
                mBall.setBall_speed_y(-mBall.getBall_speed_y());
            }
        }
    }


    /**
     *
     * @param array
     * @return
     */
    public static int getRandom(int[] array) {
        int index = new Random().nextInt(array.length);
        return array[index];
    }

    /**
     * @param max
     * @param min
     * @return int
     */
    public static int getRandom(int max, int min) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
