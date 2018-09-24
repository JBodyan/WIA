package weather_informer_application.bk.wia.custom_views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
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


    private Paint mPaint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float w = getWidth();
        float h = getHeight();

        canvas.drawPaint(mPaint);
        mPaint.setARGB(255,0,255,0);
        mPaint.setStrokeWidth(10);
        canvas.drawLine(0,h/2,w,h/2,mPaint);

    }
}
