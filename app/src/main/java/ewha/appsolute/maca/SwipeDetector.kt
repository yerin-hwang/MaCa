package ewha.appsolute.maca

import android.app.Notification
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

class SwipeDetector : View.OnTouchListener {
    val HORIZONRAL_MIN_DISTANCE = 60
//    val VERTICAL_MIN_DIATANCE = 80
    private var downX: Float = 0.toFloat()
//    private var downY: Float = 0.toFloat()
    private var upX: Float = 0.toFloat()
//    private var upY: Float = 0.toFloat()
    var action = Action.None
        private set

    enum class Action{
        LR,
        RL,
//        TB,
//        BT,
        None
    }
    fun swipeDetected() : Boolean{
        return action != Action.None
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        when (event.action){
            MotionEvent.ACTION_DOWN->{
                downX = event.x
//                downY = event.y
                action = Action.None
                return false
            }
            MotionEvent.ACTION_MOVE->{
                upX = event.x
//                upY = event.y

                val deltaX = downX-upX
//                val deltaY = downY-upY

                if (abs(deltaX) >HORIZONRAL_MIN_DISTANCE){
                    if(deltaX<0){
                        action = Action.LR
                        return true
                    }
                    if(deltaX>0){
                        action = Action.RL
                        return true
                    }
                }
            }
        }
        return false
    }

    companion object{
       private val MIN_DISTANCE = 100
    }

}