package com.arjinmc.ratinglevelbar.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.arjinmc.ratinglevelbar.R;


/**
 * custom ratingbaar
 * Created by Eminem Lu on 11/3/16.
 * Email arjinmc@hotmail.com
 */
public class SRatingBar extends LinearLayout {

    public static final int START_COUNT_FIVE = 5;
    public static final int START_MAX_COUNT = 10;

    private final int DEFAULT_IMAGE_SIZE = 54;
    private final int DEFAULT_IMAGE_PADDING = 8;
    private final int DEFAULT_RATING = 0;
    private final int DEFAULT_STAR = R.drawable.ic_star;
    private final int DEFAULT_STAR_SELECTED = R.drawable.ic_star_s;

    private int numStar;
    private float imageSize;
    private float imagePadding;
    private int rating = 0;
    private int drawableNormal;
    private int drawableSelected;

    private Context mContext;
    private OnRatingChangeListener onRatingChangeListener;

    public SRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.mContext = context;

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SRatingBar);
        numStar = a.getInt(R.styleable.SRatingBar_numStars,START_COUNT_FIVE );
        imageSize = a.getDimension(R.styleable.SRatingBar_imageSize,DEFAULT_IMAGE_SIZE);
        imagePadding = a.getDimension(R.styleable.SRatingBar_imagePadding, DEFAULT_IMAGE_PADDING);
        drawableNormal = a.getResourceId(R.styleable.SRatingBar_drawableNormal,DEFAULT_STAR);
        drawableSelected = a.getResourceId(R.styleable.SRatingBar_drawableSelected,DEFAULT_STAR_SELECTED);
        rating = a.getInt(R.styleable.SRatingBar_rate,DEFAULT_RATING);

        setOrientation(LinearLayout.HORIZONTAL);
        iniView();
    }


    public SRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SRatingBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs);
    }


    public SRatingBar(Context context) {
        super(context);
    }

    private void iniView(){

        removeAllViews();
        for(int i=0;i<numStar;i++){
            addChild(i);
        }
        setRating(rating);
    }


    private void addChild(int position){

        ImageView imageView = new ImageView(mContext);
        LayoutParams params = new LayoutParams((int)imageSize,(int)imageSize);
        if(position!=numStar-1){
            params.rightMargin = (int)imagePadding;
        }
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(drawableNormal);
        imageView.setOnClickListener(new RatingClickListener(position));
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

    public void setRating(int rating){
        if(rating<0 || rating>numStar){
            this.rating = numStar;
        }else{
            this.rating = rating;
        }
        updateRating();

    }

    public int getRating(){
        return rating;
    }

    public void updateRating(){
        for(int i=0;i<numStar;i++){
            ((ImageView) getChildAt(i)).setImageResource(drawableNormal);
        }
        for(int i=0;i<rating;i++){
            ((ImageView) getChildAt(i)).setImageResource(drawableSelected);
        }
    }

    public void setOnRatngChangeListener(OnRatingChangeListener listener){
        this.onRatingChangeListener = listener;
    }

    public interface OnRatingChangeListener{

        public void onRatingChange(int position);

    }


    /**
     * callback for click the rating star
     */
    public class RatingClickListener implements OnClickListener{

        private int position;

        private RatingClickListener(int position){
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            if(isClickable()){
                setRating(position+1);
                if(onRatingChangeListener!=null){
                    onRatingChangeListener.onRatingChange(position);
                }
            }

        }
    }

}
