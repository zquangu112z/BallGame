package thuong.de.zquangu112z.ballgame.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ZQUANGU112Z on 12-Jan-16.
 */
public class Ball {
    //tọa độ ban đầu

    private int ball_x;
    private int ball_y;
    //bán kính
    private int ball_radius;
    //speed
    private int ball_speed_x;
    private int ball_speed_y;
    //color
    private int ball_color;

    public int getBall_color() {
        return ball_color;
    }

    public void setBall_color(int ball_color) {
        this.ball_color = ball_color;
    }

    public int getBall_x() {
        return ball_x;
    }

    public void setBall_x(int ball_x) {
        this.ball_x = ball_x;
    }

    public int getBall_y() {
        return ball_y;
    }

    public void setBall_y(int ball_y) {
        this.ball_y = ball_y;
    }

    public int getBall_radius() {
        return ball_radius;
    }

    public void setBall_radius(int ball_radius) {
        this.ball_radius = ball_radius;
    }

    public int getBall_speed_x() {
        return ball_speed_x;
    }

    public void setBall_speed_x(int ball_speed_x) {
        this.ball_speed_x = ball_speed_x;
    }

    public int getBall_speed_y() {
        return ball_speed_y;
    }

    public void setBall_speed_y(int ball_speed_y) {
        this.ball_speed_y = ball_speed_y;
    }

    /**
     * Hàm vẽ ra đối tượng Ball với các thuộc tính của Ball là
     *
     */
    public void paint(Canvas canvas, Paint paint) {
        paint.setColor(getBall_color());
        canvas.drawCircle(getBall_x(),getBall_y(), getBall_radius(), paint);
    }
}
