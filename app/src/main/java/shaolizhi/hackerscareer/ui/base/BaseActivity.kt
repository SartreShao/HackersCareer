package shaolizhi.hackerscareer.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager
import shaolizhi.hackerscareer.R
import shaolizhi.hackerscareer.utils.showToast


/**
 * 由邵励治于2017/10/23创造.
 */

abstract class BaseActivity : AppCompatActivity() {


    @LayoutRes
    protected abstract fun layoutId(): Int

    protected abstract fun created(bundle: Bundle?)

    protected abstract fun resumed()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        setContentView(layoutId())
        created(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        resumed()
    }


    fun showToastForRequestResult(flag: String) {
        when (flag) {
            "203" -> toast203()
            "401" -> toast401()
            "402" -> toast402()
            "403" -> toast403()
            else -> {
            }
        }
    }


    private fun toast401() {
        showToast(getString(R.string.base_string1))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string3))
    }

    private fun toast402() {
        showToast(getString(R.string.base_string1))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string4))
    }

    private fun toast203() {
        showToast(getString(R.string.base_string1))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string5))
    }

    private fun toast403() {
        showToast(getString(R.string.base_string7))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string6))
    }
}
