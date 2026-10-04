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
    val destaque: Boolean = true,
    val paginaFotos: String? = null
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

    // Fotos enviadas para o app (res/drawable-nodpi/foto_<id>.jpg), com o crédito da fonte de cada uma.
    val creditosFotosLocais: Map<String, String> = mapOf(
        "lagos-palomos" to "Prefeitura de Ouro Fino",
        "pedra-itaguacu" to "Drone Pieroni",
        "praca-berrante" to "Caminhos Me Levem",
        "boiadeiro" to "Diário de um Viajante BR",
        "santuario" to "autoria a confirmar",
        "boi-sem-coracao" to "autoria a confirmar"
    )

    // Ajuste vertical do recorte das fotos nos cartões (-1 = topo, 0 = centro, 1 = base).
    val enquadramentoFotos: Map<String, Float> = mapOf(
        "santuario" to -0.6f,
        "boiadeiro" to -0.2f
    )

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

    private val pontosBase: List<PontoTuristico> = listOf(
        PontoTuristico(
            id = "menino-porteira",
            nome = "Monumento Menino da Porteira",
            resumo = "O símbolo mais famoso da cidade, no trevo de entrada.",
            descricao = "Escultura em concreto com cerca de 10 metros de altura, instalada no trevo de acesso a Ouro Fino, na MG-290. " +
                "Homenageia a canção “O Menino da Porteira”, de Teddy Vieira e Luizinho, que cita a estrada de Ouro Fino e ficou " +
                "nacionalmente conhecida na voz de Sérgio Reis. O próprio cantor inaugurou o monumento em março de 2001. Também é um dos primeiros marcos que os peregrinos do Caminho da Fé encontram ao chegar à cidade.",
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
                "o único museu sacro do Sul de Minas. Os peregrinos do Caminho da Fé costumam passar pelo centro e pela matriz.",
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

    const val PAGINA_PREFEITURA = "https://www.ourofino.mg.gov.br/historia/"

    // A página de história da Prefeitura exibe fotos destes pontos. O app só abre o link; não copia as imagens.
    private val comFotosNaPrefeitura = setOf(
        "menino-porteira", "boi-sem-coracao", "santuario", "lagos-palomos", "gruta", "sao-benedito", "sao-judas"
    )

    val pontos: List<PontoTuristico> = pontosBase.map { p ->
        if (p.id in comFotosNaPrefeitura) p.copy(paginaFotos = PAGINA_PREFEITURA) else p
    }

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


data class FotoCaminho(val url: String, val legenda: String, val paginaOrigem: String)

data class EtapaCaminho(val nome: String, val nota: String?, val ateProxima: String?, val destaque: Boolean = false)

data class Dica(val titulo: String, val texto: String)

object CaminhoDaFe {

    const val SITE_OFICIAL = "https://caminhodafe.com.br/"

    val resumo: String =
        "O Caminho da Fé é uma rota de peregrinação inspirada no Caminho de Santiago de Compostela, na Espanha. " +
            "Foi criada para dar estrutura a quem já ia a pé ao Santuário Nacional de Nossa Senhora Aparecida, oferecendo pontos de apoio, " +
            "hospedagem e sinalização. A rota atravessa a Serra da Mantiqueira, entre Minas Gerais e São Paulo, por estradas rurais, trilhas, bosques e asfalto."

    val marcos: List<Evento> = listOf(
        Evento(
            "Antes de 2003", "A ideia vem da Espanha",
            "O empresário Almiro José Grings, de Águas da Prata (SP), conhece o Caminho de Santiago de Compostela e volta com o desejo de criar algo parecido no Brasil. " +
                "Ele reúne amigos, entre eles Clóvis Tavares de Lima e Iracema Tamashiro, e o trio dá início aos primeiros contatos e ao traçado."
        ),
        Evento(
            "O traçado", "Um caminho “sem interferência política”",
            "Com a ajuda de um mapa, a rota foi imaginada a partir de Águas da Prata até Aparecida, privilegiando o caminho mais lógico e adequado ao perfil de peregrino. " +
                "O nome “Caminho da Fé” e o termo “pousada”, usado para os locais de pernoite, foram escolhidos em assembleia."
        ),
        Evento(
            "11 fev 2003", "Inauguração",
            "O Caminho da Fé é inaugurado em Águas da Prata (SP). Com voluntários e moradores locais, são feitas as primeiras marcações das setas amarelas."
        ),
        Evento(
            "15 ago 2003", "Associação dos Amigos",
            "Meses depois da inauguração é criada a Associação dos Amigos do Caminho da Fé (AACF), responsável pela organização, pela sinalização e pelo desenvolvimento da rota."
        ),
        Evento(
            "2023", "20 anos de Caminho",
            "A rota completa duas décadas, com expedição comemorativa pelo ramal de Águas da Prata, o primeiro criado oficialmente."
        ),
        Evento(
            "Jul 2026", "Despedida do idealizador",
            "Almiro José Grings morre aos 85 anos. O Santuário Nacional de Aparecida lembrou que o legado dele segue vivo a cada peregrino que acompanha as setas amarelas."
        )
    )

    val ouroFinoNoCaminho: List<Dica> = listOf(
        Dica(
            "Onde Ouro Fino aparece",
            "Ouro Fino está no trajeto tradicional, o ramal de Águas da Prata. Depois de Andradas, a rota passa pela Serra dos Limas, pela comunidade da Barra e pelo distrito de Crisólia " +
                "(ambos no município) antes de chegar ao centro de Ouro Fino. Daqui, segue para Inconfidentes."
        ),
        Dica(
            "Quanto se caminha",
            "Relatos de peregrinos indicam cerca de 22 km de Andradas até a Barra e cerca de 30 km da Barra até Inconfidentes, passando por Crisólia e Ouro Fino. " +
                "De Crisólia ao centro são uns 6 a 8 km, e do centro até Inconfidentes, uns 8 a 10 km."
        ),
        Dica(
            "O que o peregrino encontra",
            "Ao entrar na cidade, o peregrino dá de cara com o Monumento Menino da Porteira, e há paradas para lanche bem ao lado, segundo relatos. " +
                "Depois, atravessa o centro, onde fica o Santuário de São Francisco de Paula e Nossa Senhora de Fátima, e segue pela Estrada dos Santos Negros em direção a Inconfidentes."
        ),
        Dica(
            "Um trecho exigente",
            "A etapa que antecede Ouro Fino é considerada bastante difícil por causa da subida da Serra dos Limas, com sol forte e descidas intensas."
        )
    )

    val etapas: List<EtapaCaminho> = listOf(
        EtapaCaminho("Águas da Prata (SP)", "Ponto de partida do trajeto tradicional", "≈ 32 km"),
        EtapaCaminho("Andradas", null, null),
        EtapaCaminho("Serra dos Limas", "Subida difícil", null),
        EtapaCaminho("Barra", "Comunidade de Ouro Fino", "≈ 14 km"),
        EtapaCaminho("Crisólia", "Distrito de Ouro Fino", "≈ 6 a 8 km"),
        EtapaCaminho("Ouro Fino", "Você está aqui: Menino da Porteira, centro e Santuário", "≈ 8 a 10 km", destaque = true),
        EtapaCaminho("Inconfidentes", null, "≈ 21 km"),
        EtapaCaminho("Borda da Mata", null, null),
        EtapaCaminho("Tocos do Moji", null, null),
        EtapaCaminho("Estiva", null, null),
        EtapaCaminho("Consolação", null, "≈ 22 km"),
        EtapaCaminho("Paraisópolis", "Última cidade que emite a credencial", "≈ 130 km até Aparecida"),
        EtapaCaminho("Luminosa", null, null),
        EtapaCaminho("Campos do Jordão (SP)", null, null),
        EtapaCaminho("Pedrinhas (SP)", null, null),
        EtapaCaminho("Aparecida (SP)", "Santuário Nacional de Nossa Senhora Aparecida", null)
    )

    val comoFazer: List<Dica> = listOf(
        Dica(
            "Sinalização",
            "O caminho é marcado por setas amarelas, pintadas em postes, mourões, pedras, muros, pistas e calçadas. Há também placas a cada 2 km com a distância que falta até a Basílica de Aparecida."
        ),
        Dica(
            "Credencial do peregrino",
            "É um documento retirado na cidade onde você começa. Ele é carimbado nas pousadas ao longo do trajeto e apresentado em Aparecida para receber o Certificado de Conclusão. " +
                "É preciso ter percorrido pelo menos os últimos 100 km. A última cidade que emite a credencial é Paraisópolis (MG). Quem viaja de moto ou de carro não recebe credencial."
        ),
        Dica(
            "Hospedagem e comida",
            "Os locais de pernoite são chamados de pousadas e podem ser casas de moradores, albergues ou hotéis simples. A lista fica no site oficial, e vale reservar antes."
        ),
        Dica(
            "Ritmo",
            "A rota tradicional, de cerca de 318 km, costuma ser feita a pé em 12 a 13 dias, com 20 a 25 km por dia depois de Andradas. Muitos peregrinos saem de madrugada para evitar o sol. " +
                "Também é possível fazer de bicicleta, em cerca de 5 a 6 dias."
        ),
        Dica(
            "Melhor época",
            "Entre maio e setembro o tempo é mais seco e as temperaturas são mais amenas. Evite o verão, por causa das chuvas. O movimento aumenta nos dias que antecedem o feriado de Nossa Senhora Aparecida, em 12 de outubro, e as festas juninas podem lotar a hospedagem em cidades mineiras."
        ),
        Dica(
            "Dificuldade",
            "É um caminho de nível médio a difícil, com subidas e descidas longas. A maior parte do trajeto é por estradas rurais. Prepare-se fisicamente e comece com um trecho curto se for sua primeira vez."
        )
    )

    val numeros: List<Pair<String, String>> = listOf(
        "≈ 318 km" to "de Águas da Prata a Aparecida",
        "2003" to "ano da inauguração",
        "12–13 dias" to "a pé, em média"
    )

    val fotos: List<FotoCaminho> = listOf(
        FotoCaminho(
            url = "https://commons.wikimedia.org/wiki/Special:FilePath/Caminho_da_F%C3%A9_(Vargem_Grande_do_Sul_e_%C3%81guas_Prata)_01.jpg?width=1200",
            legenda = "Trecho do Caminho da Fé entre Vargem Grande do Sul e Águas da Prata (SP)",
            paginaOrigem = "https://commons.wikimedia.org/wiki/File:Caminho_da_F%C3%A9_(Vargem_Grande_do_Sul_e_%C3%81guas_Prata)_01.jpg"
        ),
        FotoCaminho(
            url = "https://commons.wikimedia.org/wiki/Special:FilePath/Placa_do_Caminho_da_F%C3%A9_com_as_setas_amarelas_na_SP-253_-_S%C3%A3o_Sim%C3%A3o_-_panoramio.jpg?width=1200",
            legenda = "Placa com as setas amarelas do Caminho da Fé, na SP-253, em São Simão (SP)",
            paginaOrigem = "https://commons.wikimedia.org/wiki/File:Placa_do_Caminho_da_F%C3%A9_com_as_setas_amarelas_na_SP-253_-_S%C3%A3o_Sim%C3%A3o_-_panoramio.jpg"
        ),
        FotoCaminho(
            url = "https://commons.wikimedia.org/wiki/Special:FilePath/Portal_de_In%C3%ADcio_do_Caminho_da_F%C3%A9_em_Cravinhos_-_530_Kms_at%C3%A9_Aparecida_seguindo_as_setas_amarelas_no_caminho_(O_Caminho_de_Santiago_de_Compostela_Brasileiro)_-_panoramio.jpg?width=1200",
            legenda = "Portal de início do Caminho da Fé em Cravinhos (SP), outro ramal da rede",
            paginaOrigem = "https://commons.wikimedia.org/wiki/File:Portal_de_In%C3%ADcio_do_Caminho_da_F%C3%A9_em_Cravinhos_-_530_Kms_at%C3%A9_Aparecida_seguindo_as_setas_amarelas_no_caminho_(O_Caminho_de_Santiago_de_Compostela_Brasileiro)_-_panoramio.jpg"
        )
    )

    val fontes: List<Fonte> = listOf(
        Fonte("Associação dos Amigos do Caminho da Fé", "Site oficial e manual de normas e procedimentos (caminhodafe.com.br)"),
        Fonte("Santuário Nacional de Aparecida (A12)", "Notícia sobre a morte de Almiro José Grings e página Rotas da Devoção"),
        Fonte("Relatos de peregrinos", "Trechos por Ouro Fino, distâncias e paradas, conforme diários de quem fez o caminho"),
        Fonte("Prefeitura de Ouro Fino", "Crisólia como distrito do município")
    )
}

enum class TipoLocal(val rotulo: String) {
    RESTAURANTE("Restaurantes"),
    PIZZA_CHURRASCO("Pizza e churrasco"),
    LANCHES("Lanches e burgers"),
    CAFES("Pastéis, cafés e padarias"),
    BARES("Bares")
}

data class Estabelecimento(
    val nome: String,
    val tipo: TipoLocal,
    val descricao: String,
    val endereco: String? = null
) {
    val consultaMapa: String
        get() = nome + (if (endereco != null) ", $endereco" else "") + ", Ouro Fino, MG"
}

object Gastronomia {

    val introducao: String =
        "Ouro Fino tem bares, restaurantes, pizzarias, lanchonetes e cafés espalhados pela cidade, e a maior parte dos endereços fica no centro, " +
            "em especial na Rua Treze de Maio. Esta lista reúne os lugares mais citados em guias de viagem e avaliações públicas."

    val aviso: String =
        "A lista não é completa e não tem caráter publicitário: nenhum estabelecimento pagou para aparecer. " +
            "Horários, endereços e funcionamento mudam com frequência, então confirme no Google Maps antes de ir."

    val locais: List<Estabelecimento> = listOf(
        // Restaurantes
        Estabelecimento("Nikola's Restaurante", TipoLocal.RESTAURANTE, "Comida brasileira. Um dos restaurantes mais citados em guias de viagem da cidade."),
        Estabelecimento("Restaurante Delícia de Sabor", TipoLocal.RESTAURANTE, "Comida caseira com sabor mineiro.", "Rua Senador Miranda Júnior, 302"),
        Estabelecimento("Restaurante Porteira de Ouro", TipoLocal.RESTAURANTE, "Restaurante no centro, na Rua Treze de Maio.", "Rua Treze de Maio, 440, loja 2"),
        Estabelecimento("Bibas Restaurante", TipoLocal.RESTAURANTE, "Comida brasileira com preços acessíveis, segundo guias de viagem."),
        Estabelecimento("Restaurante Fogão a Lenha", TipoLocal.RESTAURANTE, "Aparece entre os restaurantes mais bem posicionados da cidade no Tripadvisor."),
        Estabelecimento("Franceli Restaurante", TipoLocal.RESTAURANTE, "Cozinha italiana, segundo o Tripadvisor."),
        Estabelecimento("Espaço Fit Gourmet", TipoLocal.RESTAURANTE, "Comida saudável, com serviço de entrega.", "Rua Doutor Silvano Brandão, 914"),
        // Pizza e churrasco
        Estabelecimento("Restaurante e Pizzaria Don Paolo", TipoLocal.PIZZA_CHURRASCO, "Pizzas e pratos da cozinha brasileira.", "Rua Major Sebastião Pires, 95"),
        Estabelecimento("Pizzaria Mona Lisa", TipoLocal.PIZZA_CHURRASCO, "Pizzaria bem avaliada por visitantes.", "Praça Paulino Paulini, 74"),
        Estabelecimento("PapaPizza", TipoLocal.PIZZA_CHURRASCO, "Pizzaria com serviço de entrega, na Rua Treze de Maio."),
        Estabelecimento("Pizzaria e Esfiharia Aladim", TipoLocal.PIZZA_CHURRASCO, "Pizzas e esfihas.", "Rua Treze de Maio, 1294"),
        Estabelecimento("Churrascaria Cantinho da Costela", TipoLocal.PIZZA_CHURRASCO, "Churrasco, com opção de almoço.", "Rua Antero Simões, 55"),
        // Lanches e burgers
        Estabelecimento("Coronel Burger", TipoLocal.LANCHES, "Hamburgueria no centro.", "Rua Treze de Maio, 1098, letra A"),
        Estabelecimento("Burger Artesanal Del Toro", TipoLocal.LANCHES, "Hambúrguer artesanal.", "Rua Prefeito José Serra, 163, fundos"),
        Estabelecimento("Capitol Hill Hamburgueria", TipoLocal.LANCHES, "Hamburgueria no centro.", "Avenida Cyro Gonçalves, 59"),
        Estabelecimento("Esquema Lanches", TipoLocal.LANCHES, "Macarrão na chapa, comida caseira, lanches, pizza, churrasco e massas, em ambiente familiar.", "Avenida Cyro Gonçalves, 120"),
        Estabelecimento("Parada da Manu", TipoLocal.LANCHES, "Lanches ao lado do Monumento Menino da Porteira, ponto de parada de peregrinos do Caminho da Fé."),
        // Pastéis, cafés e padarias
        Estabelecimento("Aroma Café", TipoLocal.CAFES, "Café no centro.", "Rua Treze de Maio, 589"),
        Estabelecimento("Café Caminho de Minas", TipoLocal.CAFES, "Em frente ao Monumento Menino da Porteira. Atendimento elogiado por peregrinos e aceita animais de estimação."),
        Estabelecimento("Pastelaria do Cesinha", TipoLocal.CAFES, "Pastelaria e lanchonete no centro.", "Rua Prefeito José Serra, 173, letra C"),
        Estabelecimento("Pão na Massa Padaria Artesanal", TipoLocal.CAFES, "Padaria artesanal bem avaliada no Tripadvisor."),
        Estabelecimento("Grano Empório & Café", TipoLocal.CAFES, "Café e empório de inspiração italiana.", "Avenida Cyro Gonçalves, 178, sala 1"),
        Estabelecimento("Sorveteria Adio", TipoLocal.CAFES, "Sorveteria citada em guias de viagem."),
        // Bares
        Estabelecimento("Bar Brasília", TipoLocal.BARES, "Bar e pastelaria, com pastéis elogiados por visitantes. Aparece como o bar mais bem avaliado da cidade no Tripadvisor.", "Rua Treze de Maio, 811"),
        Estabelecimento("Bar do Mussarela", TipoLocal.BARES, "Bar no centro, na Rua Treze de Maio.", "Rua Treze de Maio, 514"),
        Estabelecimento("Bar do Trevo", TipoLocal.BARES, "Bar e lanchonete no centro.", "Rua Coronel João Ribeiro, 134"),
        Estabelecimento("Bar do Osmar", TipoLocal.BARES, "Bar no centro.", "Rua Treze de Maio, 1338"),
        Estabelecimento("Bar Marinello", TipoLocal.BARES, "Bar no centro.", "Rua Américo Marinello, 194"),
        Estabelecimento("Bar do Guinho", TipoLocal.BARES, "Bar listado entre os mais citados da cidade."),
        Estabelecimento("Bar Ponte Preta", TipoLocal.BARES, "Bar listado entre os mais citados da cidade.")
    )

    val fontes: String =
        "Dados compilados em outubro de 2026 a partir de listagens públicas (Tripadvisor, Apontador, guias comerciais) e de relatos de visitantes."
}

object Privacidade {
    const val ATUALIZACAO = "Atualizado em outubro de 2026"

    val paragrafos: List<Pair<String, String>> = listOf(
        "Finalidade" to
            "Este aplicativo tem um único objetivo: apresentar a história e o turismo de Ouro Fino (MG). Ele funciona só com o que é necessário para mostrar esse conteúdo, em linha com os princípios de finalidade e necessidade da Lei Geral de Proteção de Dados (LGPD, Lei nº 13.709/2018).",
        "Nenhuma coleta de dados" to
            "O aplicativo não coleta, não armazena e não compartilha dados pessoais. Não há cadastro, login, formulários, anúncios, ferramentas de análise ou rastreamento.",
        "Permissões" to
            "O aplicativo não pede acesso à sua localização, contatos, câmera, microfone ou arquivos. A única permissão usada é a de internet, para carregar mapas e fotos.",
        "Serviços de terceiros" to
            "Para exibir o mapa e as fotos, o aplicativo se conecta ao OpenStreetMap e ao Wikimedia Commons. Como em qualquer acesso à internet, esses serviços podem registrar dados técnicos, como o endereço IP, conforme as próprias políticas deles. " +
            "Os botões Como chegar, Abrir no Maps e os links abrem aplicativos externos (como Google Maps, navegador e e-mail), que seguem as políticas de cada um.",
        "Armazenamento no aparelho" to
            "Mapas e imagens podem ficar guardados temporariamente no aparelho (cache) para o aplicativo carregar mais rápido. Esses arquivos não contêm dados pessoais e podem ser apagados em Configurações do Android, em Aplicativos, Armazenamento."
    )
}
