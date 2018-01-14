package shaolizhi.hackerscareer.utils

import android.widget.Toast

/**
 * 由邵励治于2016/6/20创造.
 */
object ToastUtils {
    fun showToast(message: String) {
        Toast.makeText(App.mAppContext, message, Toast.LENGTH_SHORT).show()
    }
}
