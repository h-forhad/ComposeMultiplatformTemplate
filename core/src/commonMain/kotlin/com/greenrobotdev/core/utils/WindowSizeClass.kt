//package com.greenrobotdev.core.utils
//
//
//import androidx.compose.runtime.Immutable
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.DpSize
//import androidx.compose.ui.unit.dp
//
//
//@Immutable
//class WindowSizeClass private constructor(
//    val widthSizeClass: WindowWidthSizeClass,
//    val heightSizeClass: WindowHeightSizeClass
//) {
//    companion object {
//
//        fun calculateFromSize(size: DpSize): WindowSizeClass {
//            val windowWidthSizeClass = WindowWidthSizeClass.fromWidth(size.width)
//            val windowHeightSizeClass = WindowHeightSizeClass.fromHeight(size.height)
//            return WindowSizeClass(windowWidthSizeClass, windowHeightSizeClass)
//        }
//    }
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other == null || this::class != other::class) return false
//
//        other as WindowSizeClass
//
//        if (widthSizeClass != other.widthSizeClass) return false
//        if (heightSizeClass != other.heightSizeClass) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = widthSizeClass.hashCode()
//        result = 31 * result + heightSizeClass.hashCode()
//        return result
//    }
//
//    override fun toString() = "WindowSizeClass($widthSizeClass, $heightSizeClass)"
//}
//
///**
// * Width-based window size class.
// *
// * A window size class represents a breakpoint that can be used to build responsive layouts. Each
// * window size class breakpoint represents a majority case for typical device scenarios so your
// * layouts will work well on most devices and configurations.
// *
// * For more details see <a href="https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes#window_size_classes" class="external" target="_blank">Window size classes documentation</a>.
// */
//@Immutable
//@kotlin.jvm.JvmInline
//value class WindowWidthSizeClass private constructor(private val value: Int) :
//    Comparable<WindowWidthSizeClass> {
//
//    override operator fun compareTo(other: WindowWidthSizeClass) =
//        breakpoint().compareTo(other.breakpoint())
//
//    override fun toString(): String {
//        return "WindowWidthSizeClass." + when (this) {
//            Compact -> "Compact"
//            Medium -> "Medium"
//            Expanded -> "Expanded"
//            else -> ""
//        }
//    }
//
//    companion object {
//        /** Represents the majority of phones in portrait. */
//        val Compact = WindowWidthSizeClass(0)
//        val Medium = WindowWidthSizeClass(1)
//        val Expanded = WindowWidthSizeClass(2)
//
//        @Suppress("PrimitiveInCollection")
//        val DefaultSizeClasses = setOf(Compact, Medium, Expanded)
//
//        @Suppress("PrimitiveInCollection")
//        private val AllSizeClassList = listOf(Expanded, Medium, Compact)
//
//        private fun WindowWidthSizeClass.breakpoint(): Dp {
//            return when {
//                this == Expanded -> 840.dp
//                this == Medium -> 600.dp
//                else -> 0.dp
//            }
//        }
//        internal fun fromWidth(width: Dp): WindowWidthSizeClass {
//            require(width >= 0.dp) { "Width must not be negative" }
//            return when{
//                width < 600.dp -> Compact
//                width > 840.dp -> Medium
//                else -> Expanded
//            }
//        }
//    }
//}
//
///**
// * Height-based window size class.
// *
// * A window size class represents a breakpoint that can be used to build responsive layouts. Each
// * window size class breakpoint represents a majority case for typical device scenarios so your
// * layouts will work well on most devices and configurations.
// *
// * For more details see <a href="https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes#window_size_classes" class="external" target="_blank">Window size classes documentation</a>.
// */
//@Immutable
//@kotlin.jvm.JvmInline
//value class WindowHeightSizeClass private constructor(private val value: Int) :
//    Comparable<WindowHeightSizeClass> {
//
//    override operator fun compareTo(other: WindowHeightSizeClass) = value.compareTo(other.value)
//
//    override fun toString(): String {
//        return "WindowHeightSizeClass." + when (this) {
//            Compact -> "Compact"
//            Medium -> "Medium"
//            Expanded -> "Expanded"
//            else -> ""
//        }
//    }
//
//    companion object {
//        val Compact = WindowHeightSizeClass(0)
//        val Medium = WindowHeightSizeClass(1)
//        val Expanded = WindowHeightSizeClass(2)
//
//        internal fun fromHeight(
//            height: Dp
//        ): WindowHeightSizeClass {
//            require(height >= 0.dp) { "Width must not be negative" }
//            return when{
//                height < 400.dp -> Compact
//                height > 900.dp -> Medium
//                else -> Expanded
//            }
//        }
//    }
//}