package eu.giovannidefrancesco.overlayimageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Giovanni De Francesco on 31/01/16.
 */
public class OverlayImageView extends ImageView {

    public static final int DEFAULT_TINT_COLOR = Color.argb(128, 0, 0, 0);

    private int mTintColor;
    private Bitmap mImage;

    public OverlayImageView(Context context) {
        super(context);
    }

    public OverlayImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadAttributes(context, attrs, 0, 0);
    }

    public OverlayImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadAttributes(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public OverlayImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        loadAttributes(context, attrs, defStyleAttr, defStyleRes);
    }

    public int getTintColor() {
        return mTintColor;
    }

    public void setTintColor(int tintColor) {
        mTintColor = tintColor;
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getDrawable() != null) {
            if (mImage == null) {
                mImage = drawableToBitmap(getDrawable());
            }
            canvas.drawBitmap(mImage, 0, 0, null);
            canvas.drawColor(mTintColor);
        }
    }


    public Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        } else if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(
                0, 0,
                getWidth(),
                getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    private void loadAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.OverlayImageView,
                defStyleAttr,
                defStyleRes);
        try {
            mTintColor = typedArray.getColor(R.styleable.OverlayImageView_tintColor, DEFAULT_TINT_COLOR);
        } finally {
            typedArray.recycle();
        }
    }
}
