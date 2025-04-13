package imo.game_prototype1;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint;

public class GameView extends View{
    
    int currState = 0;
    
    GameView(Context mContext){
        super(mContext);
        init();
    }
    
    void init(){
        setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                currState++;
                if(currState >= 3) currState = 0;
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        
        float centerX = viewWidth / 2;
        float centerY = viewHeight / 2;
        
        float rectWidth = 0, rectHeight = 0;
        
        switch(currState){
            case 0:
                rectWidth = viewWidth * 1/2;
                rectHeight = viewHeight * 1/2;
                break;
            
            case 1:
                rectWidth = viewWidth * 1/3;
                rectHeight = viewHeight * 1/3;
                break;
                
            case 2:
                rectWidth = viewWidth * 1/4;
                rectHeight = viewHeight * 1/4;
        }
        
        RectF rectangle = new RectF();
        float left = centerX - (rectWidth/2);
        float top = centerY - (rectHeight/2);
        float right = centerX + (rectWidth/2);
        float bottom = centerY + (rectHeight/2);
        
        rectangle.set(left, top, right, bottom);
        canvas.drawRect(rectangle, new Paint());
    }
}
