enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Aluno(val nome: String)

data class ConteudoEducacional(var nome: String, var duracao: Int)

data class Curso(var nome: String, var duração: Int, var nivel: Nivel)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
    }
    
    fun resumo(): String {
        return "Aluno ${inscritos.last().nome} foi matriculado com sucesso no curso $nome"
    }
}

fun main() {
    val aluno = Aluno("Jansen")
    val conteudos = listOf(
        ConteudoEducacional("Introducao a Kotlin", 120), 
        ConteudoEducacional("Tipos de variaveis Kotlin", 40)
    )
    val formacao = Formacao("Curso básico de Kotlin", conteudos, Nivel.BASICO)
    formacao.matricular(aluno)
    
    println("${formacao.resumo()}")
}