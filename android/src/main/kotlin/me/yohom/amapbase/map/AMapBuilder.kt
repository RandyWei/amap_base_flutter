package me.yohom.amapbase.map

import android.content.Context
import com.amap.api.maps.AMapOptions
import com.amap.api.maps.model.CameraPosition
import io.flutter.plugin.common.PluginRegistry
import java.util.concurrent.atomic.AtomicInteger

class AMapBuilder : AMapOptionsSink {
    private val options = AMapOptions()
    private var trackCameraPosition = false

    fun build(
            id: Int,
            context: Context,
            state: AtomicInteger,
            registrar: PluginRegistry.Registrar
    ): AMapController {
        val controller = AMapController(id, registrar, state, context, options)
        controller.init()
        controller.setTrackCameraPosition(trackCameraPosition)
        return controller
    }

    override fun setCameraPosition(position: CameraPosition) {
        options.camera(position)
    }

    override fun setCompassEnabled(compassEnabled: Boolean) {
        options.compassEnabled(compassEnabled)
    }

    override fun setMapType(mapType: Int) {
        options.mapType(mapType)
    }

    override fun setMinMaxZoomPreference(min: Float?, max: Float?) {}

    override fun setTrackCameraPosition(trackCameraPosition: Boolean) {
        this.trackCameraPosition = trackCameraPosition
    }

    override fun setRotateGesturesEnabled(rotateGesturesEnabled: Boolean) {
        options.rotateGesturesEnabled(rotateGesturesEnabled)
    }

    override fun setScrollGesturesEnabled(scrollGesturesEnabled: Boolean) {
        options.scrollGesturesEnabled(scrollGesturesEnabled)
    }

    override fun setTiltGesturesEnabled(tiltGesturesEnabled: Boolean) {
        options.tiltGesturesEnabled(tiltGesturesEnabled)
    }

    override fun setZoomGesturesEnabled(zoomGesturesEnabled: Boolean) {
        options.zoomGesturesEnabled(zoomGesturesEnabled)
    }

    override fun setZoomControlEnabled(zoomControlEnabled: Boolean) {
        options.zoomControlsEnabled(zoomControlEnabled)
    }
}