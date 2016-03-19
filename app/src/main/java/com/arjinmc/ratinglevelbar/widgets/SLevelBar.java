package com.arjinmc.ratinglevelbar.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.arjinmc.ratinglevelbar.R;


/**
 * custom ratingbaar
 * Created by Eminem Lu on 18/3/16.
 * Email arjinmc@hotmail.com
 */
public class SLevelBar extends LinearLayout {

    public static final int START_COUNT_FIVE = 5;
    public static final int START_MAX_COUNT = 10;

    private final int DEFAULT_IMAGE_SIZE = 54;
    private final int DEFAULT_IMAGE_PADDING = 8;
    private final int DEFAULT_STAR = R.drawable.ic_star_s;

    private int numStar;
    private float imageSize;
    private float imagePadding;
    private int drawableImage;

    private Context mContext;

    public SLevelBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.mContext = context;

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SLevelBar);
        numStar = a.getInt(R.styleable.SLevelBar_numStars,START_COUNT_FIVE );
        imageSize = a.getDimension(R.styleable.SLevelBar_imageSize,DEFAULT_IMAGE_SIZE);
        imagePadding = a.getDimension(R.styleable.SLevelBar_imagePadding, DEFAULT_IMAGE_PADDING);
        drawableImage = a.getResourceId(R.styleable.SLevelBar_image,DEFAULT_STAR);

        setOrientation(LinearLayout.HORIZONTAL);
        iniView();
    }


    public SLevelBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SLevelBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs);
    }


    public SLevelBar(Context context) {
        super(context);
    }

    private void iniView(){

        removeAllViews();
        for(int i=0;i<numStar;i++){
            addChild(i);
        }
    }


    private void addChild(int position){

        ImageView imageView = new ImageView(mContext);
        LayoutParams params = new LayoutParams((int)imageSize,(int)imageSize);
        if(position!=numStar-1){
            params.rightMargin = (int)imagePadding;
        }
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(drawableImage);
        addView(imageView);

    }

    public void setNumStar(int num){
        if(num<=0 || num> START_MAX_COUNT){
            numStar = START_COUNT_FIVE;
        }else{
            numStar = num;
        }
        iniView();
    }

    public int getNumStar(){
        return numStar;
    }

}
