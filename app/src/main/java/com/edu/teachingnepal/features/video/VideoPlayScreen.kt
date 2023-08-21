package com.edu.teachingnepal.features.video

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.MimeTypes
import androidx.media3.exoplayer.analytics.AnalyticsListener
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.controller.VideoPlayerControllerConfig
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

@Composable
fun VideoPlayViewScreen() {
    val videoUri =
        "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8"
    VideoPlayers()
}


//@SuppressLint("OpaqueUnitKey")
//@Composable
//@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
fun VideoPlayers() {
    // https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8
    Column(modifier = Modifier.fillMaxWidth().height(300.dp)) {
        VideoPlayer(
            mediaItems = listOf(
                VideoPlayerMediaItem.NetworkMediaItem(
                    url = "https://storage.googleapis.com/wvmedia/cbcs/h264/tears/tears_aes_cbcs.mpd",
                    mediaMetadata = MediaMetadata.Builder().setTitle("Video")
                        .build(),
                    mimeType = MimeTypes.APPLICATION_MPD,
                    drmConfiguration = MediaItem.DrmConfiguration.Builder(C.WIDEVINE_UUID)
                        .setLicenseUri("https://proxy.uat.widevine.com/proxy?provider=widevine_test")
                        .build(),
                )
            ),
            handleLifecycle = true,
            autoPlay = true,
            usePlayerController = true,
            enablePip = true,
            handleAudioFocus = true,
            controllerConfig = VideoPlayerControllerConfig(
                showSpeedAndPitchOverlay = false,
                showSubtitleButton = false,
                showCurrentTimeAndTotalTime = true,
                showBufferingProgress = false,
                showForwardIncrementButton = true,
                showBackwardIncrementButton = true,
                showBackTrackButton = true,
                showNextTrackButton = true,
                showRepeatModeButton = true,
                showFullScreenButton = false,
                controllerShowTimeMilliSeconds = 5000,
                controllerAutoShow = true,
            ),
            volume = 0.5f,  // volume 0.0f to 1.0f
            repeatMode = RepeatMode.NONE, // or RepeatMode.ALL, RepeatMode.ONE
            onCurrentTimeChanged = {
                // long type, current player time (millisecond)
                Log.e("CurrentTime", it.toString())
            },
            // ExoPlayer instance (Experimental)
            playerInstance = {
                addAnalyticsListener(
                    object : AnalyticsListener {
                        // player logger
                    }
                )
            },
            modifier = Modifier.fillMaxSize(),
        )
    }
}

//    val uri = Uri.parse(videoUri)
//    val context = LocalContext.current
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context)
//            .build()
//            .apply {
//                val defaultDataSourceFactory = DefaultDataSource.Factory(context)
//                val dataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(
//                    context,
//                    defaultDataSourceFactory
//                )
//                val source = ProgressiveMediaSource.Factory(dataSourceFactory)
//                    .createMediaSource(MediaItem.fromUri(uri))
//                setMediaSource(source)
//                prepare()
//            }
//    }
//
//    exoPlayer.playWhenReady = true
//    exoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
//    exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
//
//    DisposableEffect(
//        AndroidView(
//            factory = {
//                PlayerView(context).apply {
//                    hideController()
//                    useController = false
//                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
//
//                    player = exoPlayer
//                    layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
//                }
//            }
//        )
//    ) {
//        onDispose { exoPlayer.release() }
//    }
//}

