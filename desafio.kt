enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val login: String, val senha: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel) {
    
    var mensagem = when(nivel){
	Nivel.BASICO -> "nivel basico"
	Nivel.INTERMEDIARIO -> "nivel intermediário"
	Nivel.AVANCADO -> "nivel avançado"
    }

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        
        inscritos.add(usuario)
        println("Aluno ${usuario.login} matriculado no curso de formação $nome de $mensagem!")
    }
}

fun main() {
    //Criando Conteudos
    val javaBasic = ConteudoEducacional("Instalando a IDE do java")
    val javaPOO = ConteudoEducacional("Programação Orientada a Objetos com Java")
    val javaCollections = ConteudoEducacional("Introdução ao Java Collections")
    
    //Criando curso de formações
    val curso1 = Formacao("\"Introdução ao Kotlin\"", listOf(javaBasic, javaPOO, javaCollections), Nivel.AVANCADO)
    val curso2 = Formacao("\"Introdução ao Java\"", listOf(javaBasic, javaPOO, javaCollections), Nivel.BASICO)
    
    //criando usuários
    val user = Usuario("Aleksander", "123")
    val user2 = Usuario("Gbraleksan", "147")
    
    //Adicionando usuarios aos cursos
    curso1.matricular(user)
    curso2.matricular(user2)

}