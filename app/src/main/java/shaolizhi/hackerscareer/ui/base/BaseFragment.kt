package shaolizhi.hackerscareer.ui.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import butterknife.ButterKnife
import butterknife.Unbinder
import shaolizhi.hackerscareer.R
import shaolizhi.hackerscareer.utils.ToastUtils


/**
 * 由邵励治于2017/10/23创造.
 */

abstract class BaseFragment : Fragment() {

    private var unbinder: Unbinder? = null

    private lateinit var mActivity: Context

    @LayoutRes
    protected abstract fun layoutId(): Int

    protected abstract fun created(bundle: Bundle?)

    protected abstract fun resumed()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        unbinder = ButterKnife.bind(this, view)
        created(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        resumed()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (unbinder != null) {
            unbinder!!.unbind()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mActivity = context
    }

    protected fun toast401() {
        ToastUtils.showToast(getString(R.string.base_string1))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string3))
    }

    protected fun toast402() {
        ToastUtils.showToast(getString(R.string.base_string1))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string4))
    }

    protected fun toast203() {
        ToastUtils.showToast(getString(R.string.base_string1))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string5))
    }

    protected fun toast403() {
        ToastUtils.showToast(getString(R.string.base_string7))
        Log.i(this.javaClass.simpleName, getString(R.string.base_string6))
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
}
