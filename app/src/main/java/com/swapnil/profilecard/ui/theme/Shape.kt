package com.swapnil.profilecard.ui.theme

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = AbsoluteCutCornerShape(topRight = 16.dp),
    large = RoundedCornerShape(0.dp)
)