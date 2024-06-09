package com.android.darknesshabittracker.feature_habit.presentation.habits.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.darknesshabittracker.R
import com.android.darknesshabittracker.feature_habit.domain.model.Habit
import com.android.darknesshabittracker.feature_habit.domain.model.HabitDifficulty
import com.android.darknesshabittracker.feature_habit.domain.model.HabitTag

@Composable
fun HabitItem(
    modifier: Modifier,
    habit: Habit,
    onPlusButtonClick: () -> Unit,
    onTitleButtonClick: () -> Unit,
    onMinusButtonClick: () -> Unit
) {
    val sideButtonWidth = 64.dp
    val itemHeight = 48.dp

    val plusButtonShape = RoundedCornerShape(
        topStart = 8.dp,
        topEnd = 0.dp,
        bottomStart = 8.dp,
        bottomEnd = 0.dp
    )

    val minusButtonShape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 8.dp,
        bottomStart = 0.dp,
        bottomEnd = 8.dp
    )

    Row(modifier
        .fillMaxWidth()
        .height(itemHeight)) {
        Button(
            modifier = modifier
                .width(sideButtonWidth)
                .fillMaxHeight(),
            onClick = { onPlusButtonClick },
            shape = plusButtonShape
        ) {
            Icon(painterResource(id = R.drawable.add), "")
        }

        TextButton(
            modifier = modifier
                .weight(1f)
                .fillMaxHeight(),
            onClick = { onTitleButtonClick }
        ) {
            Text(text = habit.title)
        }

        Button(
            modifier = modifier
                .width(sideButtonWidth)
                .fillMaxHeight(),
            onClick = { onMinusButtonClick },
            shape = minusButtonShape
        ) {
            Icon(painterResource(id = R.drawable.remove), "")
        }
    }
}

@Preview
@Composable
fun HabitItemPreview() {
    HabitItem(
        modifier = Modifier,
        habit = Habit(
            0,
            "Vaping",
            "",
            false,
            true,
            HabitDifficulty.Hard,
            123,
            HabitTag("nasty", true)
        ),
        {},
        {},
        {}
    )
}