package  com.beterasalut.exception

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.beterasalut.annotation.Constants

/**
 * This class method checked that internet connection available or not
 */
@Suppress(Constants.DEPRECATION)
class NetworkUtil {

    companion object {
        @JvmStatic
        fun isNetAvail(context: Context?): Boolean {

            var result = false
            val connectivityManager =
                context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }

            return result

        }


    }

}