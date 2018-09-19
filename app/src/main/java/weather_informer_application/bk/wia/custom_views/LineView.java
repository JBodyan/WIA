package weather_informer_application.bk.wia.custom_views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import weather_informer_application.bk.wia.R;

public class LineView extends View {

    private Paint paint = new Paint();

    public LineView(Context context) {
        super(context);

    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px)
    {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width  = canvas.getWidth();
        float height = canvas.getHeight();
        paint.setColor(R.color.colorBackground);
        paint.setAlpha(1);
        paint.setStrokeWidth(dpToPx(20));
        canvas.drawPaint(paint);
        canvas.drawLine(0,height/2,width,height/2,paint);
    }
}
