package com.papb.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint=new Paint();
    private Paint mPaintText=new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.purple_200,null));
        mPaintText.setTextSize(80);
    }

    public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.WHITE);
        mCanvas.drawText(getString(R.string.name),135,1200,mPaintText);

        mPaint.setColor(ContextCompat.getColor(this, R.color.teal_200));
        Rect mRect = new Rect();
        mRect.set(250, 620, 770, 950);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(ContextCompat.getColor(this, R.color.yellow));
        mRect.set(430, 750, 580, 950);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(ContextCompat.getColor(this, R.color.brown));
        Path path = new Path();
        path.moveTo(500, 410);
        path.lineTo(245, 625);
        path.lineTo(775, 625);
        path.lineTo(450, 375);
        path.close();
        mCanvas.drawPath(path, mPaint);

        mPaint.setColor(Color.LTGRAY);
        mCanvas.drawCircle(675, 800, 50, mPaint);

        mPaint.setColor(Color.LTGRAY);
        mCanvas.drawCircle(330, 800, 50, mPaint);


        view.invalidate();
    }
}