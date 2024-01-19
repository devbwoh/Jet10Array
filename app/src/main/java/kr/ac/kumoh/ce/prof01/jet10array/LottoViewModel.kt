package kr.ac.kumoh.ce.prof01.jet10array

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

class LottoViewModel : ViewModel() {
    private val _numbers = mutableStateListOf<Int>()
    val numbers: SnapshotStateList<Int>
        get() = _numbers

    init {
        generate()
    }

    fun generate() {
        _numbers.clear()
        repeat(6) {
            var num: Int
            do {
                num = (1..45).random()
            } while (_numbers.contains(num))
            _numbers.add(num)
        }
        _numbers.sort()
    }
}

//class LottoViewModelIntArray : ViewModel() {
//    // 6개 숫자. 1~45 저장
//    //private val _numbers = intArrayOf(0, 0, 0, 0, 0, 0)
//    //private val _numbers = Array<Int>(6) { 0 }
//    private val _numbers = IntArray(6) { 0 }
//    val numbers
//        get() = _numbers
//
//    // 번호 생성 함수 필요
//    fun generate() {
//        //for (i in 0..5) {
//        //for (i in 0 until 6) {
//        for (i in _numbers.indices) {
//            _numbers[i] = Random.nextInt(1, 46)
//        }
//    }
//}