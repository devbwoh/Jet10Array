package kr.ac.kumoh.ce.prof01.jet10array

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LottoViewModel : ViewModel() {
    // 6개 숫자. 1~45 저장
    private val _numbers = intArrayOf(0, 0, 0, 0, 0, 0)
    val numbers
        get() = _numbers

    // 번호 생성 함수 필요
    fun generate() {
        //for (i in 0..5) {
        //for (i in 0 until 6) {
        for (i in _numbers.indices) {
            _numbers[i] = Random.nextInt(1, 46)
        }
    }
}