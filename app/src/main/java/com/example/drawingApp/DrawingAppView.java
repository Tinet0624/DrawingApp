package com.example.drawingApp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawingAppView extends View {
    private static Path path = new Path();
    private static Paint ink;

    // Provides the ability for MainActivity to be able to access the paint properties.
    public static Paint getInk(){
        // Plans to later put these in an array so more than one line can be on the screen and maybe have access to an undo button! :D
        // * Path from android developers docs https://developer.android.com/reference/android/graphics/Path* methods for path used in onTouchEvent() can also be found here.
        path = new Path();
        return ink;
    }

    public DrawingAppView(Context context, AttributeSet attrs){
        super(context, attrs);
        paintParams();
    }

    private void paintParams(){
        // *from android developers docs https://developer.android.com/reference/android/graphics/Paint*
        ink = new Paint();

        // Set color of points
        ink.setColor(Color.BLACK);
        // Set size of points
        ink.setStrokeWidth(10);

        // Sets the shape of the point
        ink.setStrokeCap(Paint.Cap.ROUND);
        // Sets the point to not be a hollow circle. Otherwise it would look like an o.
        ink.setStyle(Paint.Style.FILL);
        // Makes it so the stroke you make is a line. Without this it would make filled in shapes according to your lines.
        ink.setStyle(Paint.Style.STROKE);
    }

    // "The most important step in drawing a custom view is to override the onDraw() method."
    // *from android developers docs https://developer.android.com/training/custom-views/custom-drawing*
    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, ink);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float pointX = event.getX();
        float pointY = event.getY();

        // Start of the event
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Starts a new line in the path
                path.moveTo(pointX, pointY);
                break;
            case MotionEvent.ACTION_MOVE:
                // Path lineTo draws a line between the points.
                path.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }
        postInvalidate();
        return true;
    }
}
