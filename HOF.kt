/**
 * Latihan 1 — Kalkulator Operasi (Higher-Order Function)
 * Materi: Kotlin Intro (HOF, Lambda, Null Safety)
 */

// 1. Data Class untuk menampung skenario uji 
data class Contoh(val a: Int, val b: Int, val op: (Int, Int) -> Int
)

// 2. Implementasi Fungsi applyOperation
// Fungsi ini menerima dua angka dan satu fungsi operasi
fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    // 3. Membuat 4 operasi menggunakan lambda
    val add: (Int, Int) -> Int = { x, y -> x + y }
    val sub: (Int, Int) -> Int = { x, y -> x - y }
    val mul: (Int, Int) -> Int = { x, y -> x * y }
    
    // Strategi Penanganan Pembagian Nol: Mengembalikan 0 
    val div: (Int, Int) -> Int = { x, y ->
        if (y == 0) 0 else x / y
    }

    // 4. Daftar Minimal 6 Uji Kasus 
    val tests = listOf(
        Contoh(10, 5, add),    // Operasi normal tambah 
        Contoh(10, 5, sub),    // Operasi normal kurang
        Contoh(10, 5, mul),    // Operasi normal kali
        Contoh(10, 5, div),    // Operasi normal bagi
        Contoh(10, 0, div),    // Pembagian dengan nol
        Contoh(-8, 2, div)    // Operasi dengan angka negatif 
    )

    // 5. Program Demo dan Output 
    println("=== Demo Kalkulator HOF ===")
    
    for (item in tests) {
        // Menentukan simbol operator untuk tampilan saja
        val simbol = when (item.op) {
            add -> "+"
            sub -> "-"
            mul -> "*"
            else -> "/"
        }

        // Eksekusi fungsi HOF
        val hasil = applyOperation(item.a, item.b, item.op)

        // Tampilan output 
        if (simbol == "/" && item.b == 0) {
            println("${item.a} / ${item.b} = ERROR (division by zero)")
        } else {
            println("${item.a} $simbol ${item.b} = $hasil")
        }
    }
}
