package mustafaozhan.github.com.mycurrencies.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.crashlytics.android.Crashlytics
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.jaredrummler.materialspinner.MaterialSpinner
import mustafaozhan.github.com.mycurrencies.R
import java.io.FileNotFoundException

/**
 * Created by Mustafa Ozhan on 2018-07-20.
 */

fun ImageView.setBackgroundByName(name: String) =
    setImageResource(context.getImageResourceByName(name))

fun Context.getImageResourceByName(name: String): Int =
    try {
        resources.getIdentifier(
            name.toLowerCase().replace("try", "tryy"),
            "drawable",
            packageName
        )
    } catch (e: FileNotFoundException) {
        Crashlytics.logException(e)
        R.drawable.transparent
    }

@SuppressLint("SetTextI18n")
fun TextView.addText(str: String) {
    text = text.toString() + str
}

fun AdView.loadAd(id: Int) {
    MobileAds.initialize(context, resources.getString(id))
    val adRequest = AdRequest.Builder().build()
    loadAd(adRequest)
}

fun MaterialSpinner.tryToSelect(indexOf: Int) {
    selectedIndex = try {
        indexOf
    } catch (exception: IllegalArgumentException) {
        Crashlytics.logException(exception)
        0
    }
}
