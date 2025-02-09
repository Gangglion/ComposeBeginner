package com.glion.composebeginner.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

// Modifier 를 통해 Click 이벤트를 추가하고자 할때 사용할 수 있는 리플효과가 없는 클릭이벤트 확장함수
//  this 를 이용하여 리시버 Modifier 에 접근하고, then 함수를 사용하여 clickable 함수가 반환하는 새로운 Modifier 를 기존의 Modifier 에 연결해야 한다.
//  composed 함수 내에서 clickable Modifier 를 사용하고 있지만, clickable 은 그 자체로 새로운 Modifier 를 반환하기 떄문에 기존에 Modifier 에 연결되어 수정되는 것이 아닌
// 새로운 Modifier 로 대체되어 버리기 때문에 this 와 then 을 이용하여 대체해주어야 한다.
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    this.then(
        clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
            onClick()
        })
}