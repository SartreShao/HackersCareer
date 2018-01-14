package shaolizhi.hackerscareer.utils

import android.app.Application
import android.content.Context

/**
 * 由邵励治于2017/10/23创造.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        mAppContext = this
    }

    companion object {
        lateinit var mAppContext: Context
    }
}
