package com.hayainote.ui.theme

import androidx.compose.ui.graphics.Color

data class TailwindColor (
    val primary: Color,
    private val swatch: Map<Int, Long>,
) {

    operator fun get(index: Int) = Color(swatch[index]!!)

    /**
     *  The lightest shade.
     */
    val shade50: Color = Color(swatch[50]!!)

    /**
     * The second lightest shade.
     */
    val shade100: Color = Color(swatch[100]!!)

    /**
     * The third lightest shade.
     */
    val shade200: Color = Color(swatch[200]!!)

    /**
     * The fourth lightest shade.
     */
    val shade300: Color = Color(swatch[300]!!)

    /**
     * The fifth lightest shade.
     */
    val shade400: Color = Color(swatch[400]!!)

    /**
     * The default shade.
     */
    val shade500: Color = Color(swatch[500]!!)

    /**
     * The fourth darkest shade.
     */
    val shade600: Color = Color(swatch[600]!!)

    /**
     * The third darkest shade.
     */
    val shade700: Color = Color(swatch[700]!!)

    /**
     * The second darkest shade.
     */
    val shade800: Color = Color(swatch[800]!!)

    /**
     * The darkest shade.
     */
    val shade900: Color = Color(swatch[900]!!)

    companion object {

        val Slate = TailwindColor(
            primary = Color(0xff64748b),
            swatch = mapOf(
                50 to 0xfff8fafc,
                100 to 0xfff1f5f9,
                200 to 0xffe2e8f0,
                300 to 0xffcbd5e1,
                400 to 0xff94a3b8,
                500 to 0xff64748b,
                600 to 0xff475569,
                700 to 0xff334155,
                800 to 0xff1e293b,
                900 to 0xff0f172a,
            )
        )

        val Gray = TailwindColor(
            primary = Color(0xff6b7280),
            swatch = mapOf(
                50 to 0xfff9fafb,
                100 to 0xfff3f4f6,
                200 to 0xffe5e7eb,
                300 to 0xffd1d5db,
                400 to 0xff9ca3af,
                500 to 0xff6b7280,
                600 to 0xff4b5563,
                700 to 0xff374151,
                800 to 0xff1f2937,
                900 to 0xff111827,
            )
        )

        val Zinc = TailwindColor(
            primary = Color(0xff71717a),
            swatch = mapOf(
                50 to 0xfffafafa,
                100 to 0xfff4f4f5,
                200 to 0xffe4e4e7,
                300 to 0xffd4d4d8,
                400 to 0xffa1a1aa,
                500 to 0xff71717a,
                600 to 0xff52525b,
                700 to 0xff3f3f46,
                800 to 0xff27272a,
                900 to 0xff18181b,
            )
        )

        val Neutral = TailwindColor(
            primary = Color(0xff737373),
            swatch = mapOf(
                50 to 0xfffafafa,
                100 to 0xfff5f5f5,
                200 to 0xffe5e5e5,
                300 to 0xffd4d4d4,
                400 to 0xffa3a3a3,
                500 to 0xff737373,
                600 to 0xff525252,
                700 to 0xff404040,
                800 to 0xff262626,
                900 to 0xff171717,
            )
        )

        val Stone = TailwindColor(
            primary = Color(0xff78716c),
            swatch = mapOf(
                50 to 0xfffafaf9,
                100 to 0xfff5f5f4,
                200 to 0xffe7e5e4,
                300 to 0xffd6d3d1,
                400 to 0xffa8a29e,
                500 to 0xff78716c,
                600 to 0xff57534e,
                700 to 0xff44403c,
                800 to 0xff292524,
                900 to 0xff1c1917,
            )
        )

        val Red = TailwindColor(
            primary = Color(0xffef4444),
            swatch = mapOf(
                50 to 0xfffef2f2,
                100 to 0xfffee2e2,
                200 to 0xfffecaca,
                300 to 0xfffca5a5,
                400 to 0xfff87171,
                500 to 0xffef4444,
                600 to 0xffdc2626,
                700 to 0xffb91c1c,
                800 to 0xff991b1b,
                900 to 0xff7f1d1d,
            )
        )

        val Orange = TailwindColor(
            primary = Color(0xfff97316),
            swatch = mapOf(
                50 to 0xfffff7ed,
                100 to 0xffffedd5,
                200 to 0xfffed7aa,
                300 to 0xfffdba74,
                400 to 0xfffb923c,
                500 to 0xfff97316,
                600 to 0xffea580c,
                700 to 0xffc2410c,
                800 to 0xff9a3412,
                900 to 0xff7c2d12,
            )
        )

        val Amber = TailwindColor(
            primary = Color(0xfff59e0b),
            swatch = mapOf(
                50 to 0xfffffbeb,
                100 to 0xfffef3c7,
                200 to 0xfffde68a,
                300 to 0xfffcd34d,
                400 to 0xfffbbf24,
                500 to 0xfff59e0b,
                600 to 0xffd97706,
                700 to 0xffb45309,
                800 to 0xff92400e,
                900 to 0xff78350f,
            )
        )

        val Yellow = TailwindColor(
            primary = Color(0xffeab308),
            swatch = mapOf(
                50 to 0xfffefce8,
                100 to 0xfffef9c3,
                200 to 0xfffef08a,
                300 to 0xfffde047,
                400 to 0xfffacc15,
                500 to 0xffeab308,
                600 to 0xffca8a04,
                700 to 0xffa16207,
                800 to 0xff854d0e,
                900 to 0xff713f12,
            )
        )

        val Lime = TailwindColor(
            primary = Color(0xff84cc16),
            swatch = mapOf(
                50 to 0xfff7fee7,
                100 to 0xffecfccb,
                200 to 0xffd9f99d,
                300 to 0xffbef264,
                400 to 0xffa3e635,
                500 to 0xff84cc16,
                600 to 0xff65a30d,
                700 to 0xff4d7c0f,
                800 to 0xff3f6212,
                900 to 0xff365314,
            )
        )

        val Green = TailwindColor(
            primary = Color(0xff22c55e),
            swatch = mapOf(
                50 to 0xfff0fdf4,
                100 to 0xffdcfce7,
                200 to 0xffbbf7d0,
                300 to 0xff86efac,
                400 to 0xff4ade80,
                500 to 0xff22c55e,
                600 to 0xff16a34a,
                700 to 0xff15803d,
                800 to 0xff166534,
                900 to 0xff14532d,
            )
        )

        val Emerald = TailwindColor(
            primary = Color(0xff10b981),
            swatch = mapOf(
                50 to 0xffecfdf5,
                100 to 0xffd1fae5,
                200 to 0xffa7f3d0,
                300 to 0xff6ee7b7,
                400 to 0xff34d399,
                500 to 0xff10b981,
                600 to 0xff059669,
                700 to 0xff047857,
                800 to 0xff065f46,
                900 to 0xff064e3b,
            )
        )

        val Teal = TailwindColor(
            primary = Color(0xff14b8a6),
            swatch = mapOf(
                50 to 0xfff0fdfa,
                100 to 0xffccfbf1,
                200 to 0xff99f6e4,
                300 to 0xff5eead4,
                400 to 0xff2dd4bf,
                500 to 0xff14b8a6,
                600 to 0xff0d9488,
                700 to 0xff0f766e,
                800 to 0xff115e59,
                900 to 0xff134e4a,
            )
        )

        val Cyan = TailwindColor(
            primary = Color(0xff06b6d4),
            swatch = mapOf(
                50 to 0xffecfeff,
                100 to 0xffcffafe,
                200 to 0xffa5f3fc,
                300 to 0xff67e8f9,
                400 to 0xff22d3ee,
                500 to 0xff06b6d4,
                600 to 0xff0891b2,
                700 to 0xff0e7490,
                800 to 0xff155e75,
                900 to 0xff164e63,
            )
        )

        val Sky = TailwindColor(
            primary = Color(0xff0ea5e9),
            swatch = mapOf(
                50 to 0xfff0f9ff,
                100 to 0xffe0f2fe,
                200 to 0xffbae6fd,
                300 to 0xff7dd3fc,
                400 to 0xff38bdf8,
                500 to 0xff0ea5e9,
                600 to 0xff0284c7,
                700 to 0xff0369a1,
                800 to 0xff075985,
                900 to 0xff0c4a6e,
            )
        )

        val Blue = TailwindColor(
            primary = Color(0xff3b82f6),
            swatch = mapOf(
                50 to 0xffeff6ff,
                100 to 0xffdbeafe,
                200 to 0xffbfdbfe,
                300 to 0xff93c5fd,
                400 to 0xff60a5fa,
                500 to 0xff3b82f6,
                600 to 0xff2563eb,
                700 to 0xff1d4ed8,
                800 to 0xff1e40af,
                900 to 0xff1e3a8a,
            )
        )

        val Indigo = TailwindColor(
            primary = Color(0xff6366f1),
            swatch = mapOf(
                50 to 0xffeef2ff,
                100 to 0xffe0e7ff,
                200 to 0xffc7d2fe,
                300 to 0xffa5b4fc,
                400 to 0xff818cf8,
                500 to 0xff6366f1,
                600 to 0xff4f46e5,
                700 to 0xff4338ca,
                800 to 0xff3730a3,
                900 to 0xff312e81,
            )
        )

        val Violet = TailwindColor(
            primary = Color(0xff8b5cf6),
            swatch = mapOf(
                50 to 0xfff5f3ff,
                100 to 0xffede9fe,
                200 to 0xffddd6fe,
                300 to 0xffc4b5fd,
                400 to 0xffa78bfa,
                500 to 0xff8b5cf6,
                600 to 0xff7c3aed,
                700 to 0xff6d28d9,
                800 to 0xff5b21b6,
                900 to 0xff4c1d95,
            )
        )

        val Purple = TailwindColor(
            primary = Color(0xffa855f7),
            swatch = mapOf(
                50 to 0xfffaf5ff,
                100 to 0xfff3e8ff,
                200 to 0xffe9d5ff,
                300 to 0xffd8b4fe,
                400 to 0xffc084fc,
                500 to 0xffa855f7,
                600 to 0xff9333ea,
                700 to 0xff7e22ce,
                800 to 0xff6b21a8,
                900 to 0xff581c87,
            )
        )

        val Fuchsia = TailwindColor(
            primary = Color(0xffd946ef),
            swatch = mapOf(
                50 to 0xfffdf4ff,
                100 to 0xfffae8ff,
                200 to 0xfff5d0fe,
                300 to 0xfff0abfc,
                400 to 0xffe879f9,
                500 to 0xffd946ef,
                600 to 0xffc026d3,
                700 to 0xffa21caf,
                800 to 0xff86198f,
                900 to 0xff701a75,
            )
        )

        val Pink = TailwindColor(
            primary = Color(0xffec4899),
            swatch = mapOf(
                50 to 0xfffdf2f8,
                100 to 0xfffce7f3,
                200 to 0xfffbcfe8,
                300 to 0xfff9a8d4,
                400 to 0xfff472b6,
                500 to 0xffec4899,
                600 to 0xffdb2777,
                700 to 0xffbe185d,
                800 to 0xff9d174d,
                900 to 0xff831843,
            )
        )

        val Rose = TailwindColor(
            primary = Color(0xfff43f5e),
            swatch = mapOf(
                50 to 0xfffff1f2,
                100 to 0xffffe4e6,
                200 to 0xfffecdd3,
                300 to 0xfffda4af,
                400 to 0xfffb7185,
                500 to 0xfff43f5e,
                600 to 0xffe11d48,
                700 to 0xffbe123c,
                800 to 0xff9f1239,
                900 to 0xff881337,
            )
        )

    }
}