package com.willian.ourofino.data.repository

import com.willian.ourofino.R
import com.willian.ourofino.data.model.Categoria
import com.willian.ourofino.data.model.PontoTuristico

object LocalDataRepository {

    fun getPontosturisticos(): List<PontoTuristico> = listOf(
        // Monumentos culturais
        PontoTuristico(
            id = 1,
            nameRes = R.string.menino_porteira,
            descriptionRes = R.string.menino_porteira_desc,
            latitude = -22.2750,
            longitude = -46.3706,
            category = Categoria.CULTURAL,
            imageUrl = "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=400&h=300"
        ),
        PontoTuristico(
            id = 2,
            nameRes = R.string.boi_sem_coracao,
            descriptionRes = R.string.boi_sem_coracao_desc,
            latitude = -22.2748,
            longitude = -46.3708,
            category = Categoria.CULTURAL,
            imageUrl = "https://images.unsplash.com/photo-1621961155054-82a648f0f53a?w=400&h=300"
        ),
        PontoTuristico(
            id = 3,
            nameRes = R.string.cafe_com_leite,
            descriptionRes = R.string.cafe_com_leite_desc,
            latitude = -22.2760,
            longitude = -46.3710,
            category = Categoria.CULTURAL,
            imageUrl = "https://images.unsplash.com/photo-1605777141029-6b9a48dcd9d5?w=400&h=300"
        ),
        PontoTuristico(
            id = 4,
            nameRes = R.string.pavilhao_malhas,
            descriptionRes = R.string.pavilhao_malhas_desc,
            latitude = -22.2770,
            longitude = -46.3715,
            category = Categoria.CULTURAL,
            imageUrl = "https://images.unsplash.com/photo-1567521464027-f127ff144326?w=400&h=300"
        ),
        PontoTuristico(
            id = 5,
            nameRes = R.string.praca_berrante,
            descriptionRes = R.string.praca_berrante_desc,
            latitude = -22.2755,
            longitude = -46.3720,
            category = Categoria.CULTURAL,
            imageUrl = "https://images.unsplash.com/photo-1549451371-cafeb002cef6?w=400&h=300"
        ),
        PontoTuristico(
            id = 6,
            nameRes = R.string.estatua_luiz_gonzaga,
            descriptionRes = R.string.estatua_luiz_gonzaga_desc,
            latitude = -22.2765,
            longitude = -46.3725,
            category = Categoria.CULTURAL,
            imageUrl = "https://images.unsplash.com/photo-1552820728-8ac41f1ce891?w=400&h=300"
        ),
        PontoTuristico(
            id = 7,
            nameRes = R.string.cine_matilde,
            descriptionRes = R.string.cine_matilde_desc,
            latitude = -22.2750,
            longitude = -46.3730,
            category = Categoria.CULTURAL,
            imageUrl = "https://images.unsplash.com/photo-1489599849228-13e42f47b2ee?w=400&h=300"
        ),
        PontoTuristico(
            id = 8,
            nameRes = R.string.bateador,
            descriptionRes = R.string.bateador_desc,
            latitude = -22.2770,
            longitude = -46.3735,
            category = Categoria.CULTURAL,
            imageUrl = "https://images.unsplash.com/photo-1618895917637-f6ce150c6980?w=400&h=300"
        ),

        // Atrações naturais
        PontoTuristico(
            id = 9,
            nameRes = R.string.tabuao,
            descriptionRes = R.string.tabuao_desc,
            latitude = -22.2600,
            longitude = -46.3800,
            category = Categoria.NATURAL,
            imageUrl = "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300"
        ),
        PontoTuristico(
            id = 10,
            nameRes = R.string.pedra_itaguacu,
            descriptionRes = R.string.pedra_itaguacu_desc,
            latitude = -22.2620,
            longitude = -46.3750,
            category = Categoria.NATURAL,
            imageUrl = "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300"
        ),
        PontoTuristico(
            id = 11,
            nameRes = R.string.lagos_palomos,
            descriptionRes = R.string.lagos_palomos_desc,
            latitude = -22.2650,
            longitude = -46.3780,
            category = Categoria.NATURAL,
            imageUrl = "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300"
        ),
        PontoTuristico(
            id = 12,
            nameRes = R.string.jardim_municipal,
            descriptionRes = R.string.jardim_municipal_desc,
            latitude = -22.2755,
            longitude = -46.3722,
            category = Categoria.NATURAL,
            imageUrl = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=400&h=300"
        ),

        // Atrações religiosas
        PontoTuristico(
            id = 13,
            nameRes = R.string.santuario,
            descriptionRes = R.string.santuario_desc,
            latitude = -22.2758,
            longitude = -46.3712,
            category = Categoria.RELIGIOUS,
            imageUrl = "https://images.unsplash.com/photo-1459749411175-04bf5292ceea?w=400&h=300"
        ),
        PontoTuristico(
            id = 14,
            nameRes = R.string.santo_cruzeiro,
            descriptionRes = R.string.santo_cruzeiro_desc,
            latitude = -22.2745,
            longitude = -46.3705,
            category = Categoria.RELIGIOUS,
            imageUrl = "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?w=400&h=300"
        )
    )

    fun getPontoById(id: Int): PontoTuristico? = getPontosturisticos().find { it.id == id }

    fun getHistoriaCompleta(): HistoriaCompleta = HistoriaCompleta(
        descoberta = HistoriaSection(
            titulo = "Descoberta do Ouro",
            conteudo = "Durante o final do século XVII, bandeirantes paulistas exploravam as montanhas de Minas Gerais em busca de metais preciosos. Entre 1693 e 1695, descobertas simultâneas de ouro marcaram diferentes regiões, incluindo o Rio das Velhas e áreas que viriam a formar a região de Ouro Fino. Estes depósitos auríferos despertaram grande interesse da Coroa Portuguesa e atraíram milhares de pessoas em busca de enriquecimento."
        ),
        fundacao = HistoriaSection(
            titulo = "Fundação do Arraial",
            conteudo = "O Arraial de Ouro Fino foi fundado oficialmente pelo Guarda-mor Francisco Martins Lustosa, figura portuguesa que construiu a Capela de São Francisco de Paula no local. Inicialmente, a região tornou-se motivo de disputa entre as Capitanias de São Paulo e Minas Gerais devido às riquezas encontradas. Foi apenas em setembro de 1708 que a jurisdição foi definitivamente atribuída a Minas Gerais, por ordem do Rei Dom João V, após solicitação do regente de Minas, Gomes Freire de Andrade."
        ),
        cicloOuro = HistoriaSection(
            titulo = "O Ciclo do Ouro",
            conteudo = "Durante o século XVIII, Ouro Fino integrou o grande movimento econômico do Ciclo do Ouro em Minas Gerais. A mineração, especialmente através de técnicas de bateia e canaletas, era a atividade principal. Portugal impunha pesados impostos, como o \"Quinto\" (20% de todo ouro extraído) e a \"Derrama\" (complemento para atingir 1.500 quilos anuais à Coroa). Apesar da riqueza inicial, o ouro foi se esgotando ao longo do século, alterando a economia regional."
        ),
        transformacao = HistoriaSection(
            titulo = "Transformação Moderna",
            conteudo = "A transição do século XIX para o XX marcou a transformação de Ouro Fino. A cidade evoluiu de um pequeno arraial minerador para um município com atividades diversificadas. A indústria têxtil ganhou importância crescente, consolidando Ouro Fino como parte do Circuito das Malhas do Sul de Minas. A canção \"Menino da Porteira\" (1955) elevou a cidade ao conhecimento nacional, tornando-a símbolo da cultura sertaneja mineira. Atualmente, Ouro Fino equilibra seu patrimônio histórico com desenvolvimento sustentável e turismo cultural."
        )
    )
}

data class HistoriaCompleta(
    val descoberta: HistoriaSection,
    val fundacao: HistoriaSection,
    val cicloOuro: HistoriaSection,
    val transformacao: HistoriaSection
)

data class HistoriaSection(
    val titulo: String,
    val conteudo: String
)
