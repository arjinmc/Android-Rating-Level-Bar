# Android-Rating-Level-Bar
customer rattingbars
  
![image](https://github.com/arjinmc/Android-Rating-Level-Bar/blob/master/device-2016-03-18-190752.png)  
 
## SRattingbar
1.in xml 
``` java
    <com.arjinmc.ratinglevelbar.widgets.SRatingBar
        android:id="@+id/ratingbar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:clickable="true"
        app:numStars="5"
        app:imageSize="30dp"
        app:imagePadding="8dp"
        app:rate="2"/>
``` 
2.in java
``` java 
   //set rating total star
   sRatingBar.setNumStar(6);
   //set rating score
   sRatingBar.setRating(3);

   sRatingBar.setOnRatngChangeListener(new SRatingBar.OnRatingChangeListener() {
    @Override
    public void onRatingChange(int position) {
      //callback for click the ratingbar
      Log.e("rating",position+"");
    }
  });
``` 

## SLevelBar
1.in xml 
``` java
    <com.arjinmc.ratinglevelbar.widgets.SLevelBar
        android:id="@+id/levelbar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:imageSize="10dp"
        app:imagePadding="2dp"
        app:image="@drawable/ic_star_s"
        app:numStars="3"/>
``` 
2.in java
``` java 
    sLevelBar.setNumStar(2);
    Log.e("levelStart count",sLevelBar.getNumStar()+"");
``` 

