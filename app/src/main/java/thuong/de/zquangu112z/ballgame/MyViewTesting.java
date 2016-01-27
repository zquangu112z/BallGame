package thuong.de.zquangu112z.ballgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by ZQUANGU112Z on 27-Jan-16.
 */

public class MyViewTesting extends View {
    public MyViewTesting(Context context){
        super(context);
    }
    private float bx=300;
    private float by=300;
    private float speed=5;
    float a=0;
    float b=0;
    double t=1.0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);

        // Create paint for ball
        paint.setColor(Color.RED);
        canvas.drawCircle(bx, by, 30, paint);
        //canvas.drawCircle(300, 300, 10, paint);
        //canvas.drawLine(300,300,bx,by,paint);
        try {
            Thread.sleep(30);
//            bx+=speed;
//            by+=speed;
            t+=0.1;
            bx=300+200* (float)Math.cos(t);
            by=300+200* (float)Math.sin(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        invalidate();
    }
}
