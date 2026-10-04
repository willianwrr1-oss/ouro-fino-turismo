package com.willian.ourofino.data

enum class Categoria(val rotulo: String) {
    MONUMENTO("Monumentos"),
    RELIGIOSO("Fé e história"),
    NATUREZA("Natureza")
}

data class Foto(
    val url: String,
    val autor: String,
    val licenca: String,
    val licencaUrl: String,
    val paginaOrigem: String
) {
    val legenda: String get() = "Foto: $autor · $licenca"
}

data class PontoTuristico(
    val id: String,
    val nome: String,
    val resumo: String,
    val descricao: String,
    val categoria: Categoria,
    val endereco: String?,
    val latitude: Double?,
    val longitude: Double?,
    val consultaMapa: String,
    val foto: Foto?,
    val destaque: Boolean = true
) {
    val temCoordenadas: Boolean get() = latitude != null && longitude != null
}

data class Evento(val data: String, val titulo: String, val texto: String)

data class Periodo(val titulo: String, val intervalo: String, val eventos: List<Evento>)

data class Fonte(val titulo: String, val detalhe: String)

object OuroFinoDados {

    const val CENTRO_LAT = -22.2800
    const val CENTRO_LON = -46.3715

    const val EMAIL_CONTATO = "willian.wrr1@gmail.com"
    const val CREDITO_FOTOS_PROPRIAS = "Willian R Rocha"

    val fotoMenino = Foto(
        url = "https://commons.wikimedia.org/wiki/Special:FilePath/Menino_da_Porteira.JPG?width=1200",
        autor = "Fabricio de Souza Menegildo / Wikimedia Commons",
        licenca = "CC BY-SA 3.0",
        licencaUrl = "https://creativecommons.org/licenses/by-sa/3.0/",
        paginaOrigem = "https://commons.wikimedia.org/wiki/File:Menino_da_Porteira.JPG"
    )

    val fotoCidade = Foto(
        url = "https://commons.wikimedia.org/wiki/Special:FilePath/Ouro_Fino_Minas_Gerais.jpg?width=1400",
        autor = "Ourofinomg / Wikimedia Commons",
        licenca = "CC BY-SA 4.0",
        licencaUrl = "https://creativecommons.org/licenses/by-sa/4.0/",
        paginaOrigem = "https://commons.wikimedia.org/wiki/File:Ouro_Fino_Minas_Gerais.jpg"
    )

    val pontos: List<PontoTuristico> = listOf(
        PontoTuristico(
            id = "menino-porteira",
            nome = "Monumento Menino da Porteira",
            resumo = "O símbolo mais famoso da cidade, no trevo de entrada.",
            descricao = "Escultura em concreto com cerca de 10 metros de altura, instalada no trevo de acesso a Ouro Fino, na MG-290. " +
                "Homenageia a canção “O Menino da Porteira”, de Teddy Vieira e Luizinho, que cita a estrada de Ouro Fino e ficou " +
                "nacionalmente conhecida na voz de Sérgio Reis. O próprio cantor inaugurou o monumento em março de 2001.",
            categoria = Categoria.MONUMENTO,
            endereco = "Rodovia MG-290, km 60 (trevo de acesso à cidade)",
            latitude = -22.275578,
            longitude = -46.37259,
            consultaMapa = "Monumento Menino da Porteira, Ouro Fino, MG",
            foto = fotoMenino
        ),
        PontoTuristico(
            id = "boi-sem-coracao",
            nome = "Monumento Boi Sem Coração",
            resumo = "O boi da letra da música, bem no centro da cidade.",
            descricao = "Escultura que faz parte da série de monumentos inspirados em “O Menino da Porteira”. " +
                "Fica no centro, perto da rodoviária, e segundo guias de viagem tem cerca de 5 metros de altura por 9 de comprimento.",
            categoria = Categoria.MONUMENTO,
            endereco = "Rua Guarda-Mor Lustosa, 404 – Centro",
            latitude = -22.278734,
            longitude = -46.372543,
            consultaMapa = "Monumento Boi Sem Coração, Ouro Fino, MG",
            foto = null
        ),
        PontoTuristico(
            id = "santuario",
            nome = "Santuário São Francisco de Paula e Nossa Senhora de Fátima",
            resumo = "A matriz que nasceu da capela do arraial, em 1749.",
            descricao = "A paróquia de São Francisco de Paula foi criada em 1749, a partir da capela erguida pelo Guarda-Mor " +
                "Francisco Martins Lustosa. A igreja matriz tem o título de Santuário desde 2007 e guarda uma relíquia de " +
                "São Francisco de Paula, enviada pelo Papa Pio XII em 1957. Segundo a Prefeitura, abriga o Museu de Arte Sacra, " +
                "o único museu sacro do Sul de Minas.",
            categoria = Categoria.RELIGIOSO,
            endereco = "Praça Monsenhor Teófilo – Centro",
            latitude = -22.282938,
            longitude = -46.369438,
            consultaMapa = "Santuário São Francisco de Paula e Nossa Senhora de Fátima, Ouro Fino, MG",
            foto = null
        ),
        PontoTuristico(
            id = "praca-berrante",
            nome = "Praça do Berrante",
            resumo = "Escultura gigante de um berrante, no centro.",
            descricao = "Praça com a escultura de um berrante, instrumento símbolo dos boiadeiros e tema da canção que projetou a cidade. " +
                "Segundo guias de turismo, a peça tem 16 metros de comprimento. À noite, a praça costuma receber food trucks. Fica a uma curta caminhada dos demais monumentos do centro.",
            categoria = Categoria.MONUMENTO,
            endereco = "Centro",
            latitude = null,
            longitude = null,
            consultaMapa = "Praça do Berrante, Ouro Fino, MG",
            foto = null
        ),
        PontoTuristico(
            id = "boiadeiro",
            nome = "Monumento Boiadeiro",
            resumo = "A terceira estátua inspirada na música.",
            descricao = "Inaugurado depois do Menino da Porteira e do Boi Sem Coração, completa a trinca de esculturas ligadas à canção. " +
                "Fica na Praça da Baronesa, no centro.",
            categoria = Categoria.MONUMENTO,
            endereco = "Praça da Baronesa – Centro",
            latitude = null,
            longitude = null,
            consultaMapa = "Monumento Boiadeiro, Praça da Baronesa, Ouro Fino, MG",
            foto = null
        ),
        PontoTuristico(
            id = "pedra-itaguacu",
            nome = "Pedra do Itaguaçu",
            resumo = "Vista ampla da serra, a cerca de 15 km do centro.",
            descricao = "Imponente formação rochosa na área rural, a cerca de 15 km da área urbana. A Prefeitura a destaca entre os atrativos de " +
                "ecoturismo, com fauna e flora preservadas, trilhas e cavalgadas. Guias de turismo citam cerca de 1.500 m de altitude e vista para várias cidades vizinhas.",
            categoria = Categoria.NATUREZA,
            endereco = "Zona rural de Ouro Fino",
            latitude = null,
            longitude = null,
            consultaMapa = "Pedra do Itaguaçu, Ouro Fino, MG",
            foto = null
        ),
        PontoTuristico(
            id = "lagos-palomos",
            nome = "Lagos dos Palomos",
            resumo = "Lagos divulgados pela Prefeitura entre os atrativos da cidade.",
            descricao = "Um dos pontos turísticos apresentados no site oficial da Prefeitura. Em guias de viagem aparece também como " +
                "Lago dos Palomos ou Recanto dos Lagos.",
            categoria = Categoria.NATUREZA,
            endereco = null,
            latitude = null,
            longitude = null,
            consultaMapa = "Lagos dos Palomos, Ouro Fino, MG",
            foto = null
        ),
        PontoTuristico(
            id = "gruta",
            nome = "Gruta de Nossa Senhora Aparecida",
            resumo = "Ponto de devoção listado pela Prefeitura.",
            descricao = "Aparece entre os atrativos religiosos divulgados pela Prefeitura de Ouro Fino.",
            categoria = Categoria.RELIGIOSO,
            endereco = null,
            latitude = null,
            longitude = null,
            consultaMapa = "Gruta de Nossa Senhora Aparecida, Ouro Fino, MG",
            foto = null,
            destaque = false
        ),
        PontoTuristico(
            id = "sao-benedito",
            nome = "Igreja de São Benedito",
            resumo = "Igreja divulgada pela Prefeitura entre os atrativos religiosos.",
            descricao = "Aparece entre os atrativos religiosos divulgados pela Prefeitura de Ouro Fino.",
            categoria = Categoria.RELIGIOSO,
            endereco = null,
            latitude = null,
            longitude = null,
            consultaMapa = "Igreja de São Benedito, Ouro Fino, MG",
            foto = null,
            destaque = false
        ),
        PontoTuristico(
            id = "sao-judas",
            nome = "Igreja de São Judas Tadeu",
            resumo = "Igreja divulgada pela Prefeitura entre os atrativos religiosos.",
            descricao = "Aparece entre os atrativos religiosos divulgados pela Prefeitura de Ouro Fino.",
            categoria = Categoria.RELIGIOSO,
            endereco = null,
            latitude = null,
            longitude = null,
            consultaMapa = "Igreja de São Judas Tadeu, Ouro Fino, MG",
            foto = null,
            destaque = false
        )
    )

    val periodos: List<Periodo> = listOf(
        Periodo(
            titulo = "O ouro e o arraial",
            intervalo = "1746–1749",
            eventos = listOf(
                Evento(
                    "1746", "Bandeirantes no Vale do Sapucaí",
                    "Em busca de ouro, bandeirantes chegam ao Vale do Sapucaí. O sertanista Ângelo Batista, natural de Pindamonhangaba (SP), " +
                        "encontra ouro nos ribeirões Ouro Fino, Santa Isabel e São Paulo. Começa a disputa entre as capitanias de Minas e de São Paulo pela região."
                ),
                Evento(
                    "c. 1748", "O arraial e a capela",
                    "O Guarda-Mor Francisco Martins Lustosa, regente do Sapucaí, funda o arraial e ergue a capela de São Francisco de Paula. " +
                        "O nome vem do metal que aparecia nas bateias dos mineradores: ouro fino."
                ),
                Evento(
                    "8 mar 1749", "Capela elevada a paróquia",
                    "Por iniciativa do governador do Bispado de São Paulo, ao qual a região estava ligada, a capela é elevada a paróquia. " +
                        "É a primeira menção oficial a São Francisco de Paula de Ouro Fino."
                ),
                Evento(
                    "19 set 1749", "Ouro Fino passa a ser mineira",
                    "Depois da demarcação feita pelo desembargador Tomaz Rubim de Barros Barreto, a pedido do governador Gomes Freire de Andrade, " +
                        "o arraial fica em território de Minas Gerais. Lustosa se muda para Curitiba; suas cinzas voltariam a Ouro Fino em 1973."
                )
            )
        ),
        Periodo(
            titulo = "De arraial a cidade",
            intervalo = "1799–1890",
            eventos = listOf(
                Evento(
                    "1799", "Vila de Campanha",
                    "O arraial, antes ligado à vila de São João del-Rei, passa à jurisdição da vila de Campanha."
                ),
                Evento(
                    "1831", "Distrito de Pouso Alegre",
                    "Com a criação do município de Pouso Alegre, Ouro Fino torna-se um de seus distritos."
                ),
                Evento(
                    "22 jul 1868", "Elevada a vila",
                    "A Lei Provincial nº 1.570 eleva Ouro Fino à condição de vila, desmembrada de Pouso Alegre."
                ),
                Evento(
                    "4 nov 1880", "Elevada a cidade",
                    "A Lei Provincial nº 2.658 concede a Ouro Fino a categoria de cidade. Em 16 de março de 1881 é instalada a Câmara Municipal."
                ),
                Evento(
                    "26 set 1890", "Comarca instalada",
                    "A comarca, criada em 1888, é oficialmente instalada já no período republicano."
                )
            )
        ),
        Periodo(
            titulo = "Café e política",
            intervalo = "século XX",
            eventos = listOf(
                Evento(
                    "Séc. XX", "O ciclo do café",
                    "A cafeicultura provoca o primeiro grande salto econômico do município. Até hoje as montanhas de Ouro Fino exibem cafezais " +
                        "que sustentam empregos no campo."
                ),
                Evento(
                    "1913", "Pacto de Ouro Fino",
                    "Na cidade é selado o Pacto de Ouro Fino entre os governadores de São Paulo e de Minas Gerais, episódio ligado à chamada " +
                        "Política do Café com Leite. Em 2023, o projeto de lei 713/2023 propôs no Senado o título de Capital Nacional da Política do Café com Leite."
                ),
                Evento(
                    "1936–1962", "Cidade-mãe",
                    "Territórios de Ouro Fino deram origem a outros municípios: Monte Sião (1936), Bueno Brandão, antigo Campo Místico (1938) e Inconfidentes (1962)."
                ),
                Evento(
                    "18 jul 1957", "Relíquia de São Francisco de Paula",
                    "O Papa Pio XII envia ao santuário de Ouro Fino uma relíquia do santo padroeiro."
                )
            )
        ),
        Periodo(
            titulo = "Cidade histórica e turística",
            intervalo = "1991 em diante",
            eventos = listOf(
                Evento(
                    "1991", "Cidade histórica",
                    "A Lei nº 8.181, de 28 de março de 1991, considera Ouro Fino cidade histórica."
                ),
                Evento(
                    "1997 e 1999", "Selo da Embratur",
                    "A cidade recebe o selo de Município Prioritário ao Desenvolvimento do Turismo."
                ),
                Evento(
                    "Mar 2001", "Monumento ao Menino da Porteira",
                    "O cantor Sérgio Reis inaugura a escultura no trevo de entrada da cidade."
                ),
                Evento(
                    "2007", "Título de Santuário",
                    "A igreja matriz passa a se chamar Santuário de São Francisco de Paula e Nossa Senhora de Fátima."
                ),
                Evento(
                    "Hoje", "Circuito das Malhas",
                    "Ouro Fino integra o Circuito Turístico das Malhas e combina indústria de malhas, café, patrimônio histórico e ecoturismo."
                )
            )
        )
    )

    val simbolos: String =
        "A bandeira é amarela, com uma faixa vermelha horizontal. O amarelo lembra o ouro e o vermelho, o progresso e a cor do grão de café. " +
            "O brasão, aprovado em 1948, traz três bateias de ouro, que representam as lavras de Ouro Fino, São Pedro e Santa Isabel, " +
            "e a palavra latina CHARITAS, ligada ao padroeiro São Francisco de Paula."

    val fontes: List<Fonte> = listOf(
        Fonte("IBGE", "Enciclopédia dos Municípios Brasileiros, vol. XXVI (1959) – Histórico de Ouro Fino"),
        Fonte("Prefeitura Municipal de Ouro Fino", "Página “Nossa história, nosso maior tesouro”"),
        Fonte("Senado Federal", "Projeto de Lei nº 713/2023 – Pacto de Ouro Fino"),
        Fonte("Flags of the World", "Bandeira e brasão de Ouro Fino, com base no site oficial da Prefeitura")
    )
}
